package com.google.apigee.demo;
/*
        Copyright 2019 Google LLC

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        https://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Just a basic service to do a few uninteresting things - return lists of resources that are available for reservations
 * return existing reservations, and propose a new reservation.
 * All persistence is in memory only -- just restart and you have fresh data.
 */
@WebService(serviceName = "SimpleService", targetNamespace = "http://soapy-sample.appspot.com/soapy")
public class SimpleService {
    private static final ResourcesManager resources = new ResourcesManager();

    private static final Set<ReservationDetails> reservations = new TreeSet<>();

    private static final Random r = new Random();

    private static void delay(int minimum, int maximum) {
        // simulate a delay
        try {
            Thread.sleep(r.nextInt(maximum-minimum)+minimum);
        } catch( InterruptedException ie ) {
            // gulp
        }
    }

    @WebMethod(operationName = "hello")
    public String helloService(@WebParam(name="name") String msg){
        return "Hello "+ msg;
    }

    @WebMethod(operationName = "GetResources")
    public Set<String> getResourcesService() {
        delay(10,100);
        return resources;
    }

    @WebMethod(operationName = "AddResource")
    public String addResource(@WebParam(name="name") String name){
        delay(40,9000);
        resources.add(name);
        return name;
    }

    @WebMethod(operationName = "RemoveResource")
    public String removeResource(@WebParam(name="name") String name)
        throws ResourceNotFoundException {
        if( ! resources.contains(name)) {
            throw new ResourceNotFoundException(name);
        }
        resources.remove(name);
        return "Successful removal";
    }

    @WebMethod(operationName = "GetResourceReservationsByName")
    public Collection<ReservationDetails> getResourceReservationsByName(String resourceOrAll) throws
            DatabaseConnectionException {
        delay(20,5000);

        // simulate a database connection error occasionally
        if( r.nextInt(100) > 80) {
            throw new DatabaseConnectionException();
        }

        if( resourceOrAll.equalsIgnoreCase("all")) {
            return reservations;
        }

        return reservations.stream().filter(p->p.getResource().equalsIgnoreCase(resourceOrAll))
                .sorted().collect(Collectors.toList());
    }

    @WebMethod(operationName = "ReserveResource")
    public ReservationDetails reserveResource(@WebParam(name="reservationRequest") ReservationDetails reservationRequest) {
        delay(1000,8000);
        reservations.add(reservationRequest);
        return reservationRequest;
    }
}
