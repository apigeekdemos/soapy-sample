/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.google.apigee.demo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@WebService(serviceName = "SimpleService", targetNamespace = "http://soapy-sample.appspot.com/soapy")
public class SimpleService {
    private static final ResourcesManager resources = new ResourcesManager();

    private static final Set<ReservationDetails> reservations = new TreeSet<>();

    @WebMethod(operationName = "hello")
    public String helloService(@WebParam(name="name") String msg){
        return "Hello "+ msg;
    }

    @WebMethod(operationName = "GetResources")
    public Set<String> getResourcesService() { return resources; }

    @WebMethod(operationName = "GetResourceReservationsByName")
    public Collection<ReservationDetails> getResourceReservationsByName(String resourceOrAll) {
        if( resourceOrAll.equalsIgnoreCase("all")) {
            return reservations;
        }

        return reservations.stream().filter(p->p.getResource().equalsIgnoreCase(resourceOrAll))
                .sorted().collect(Collectors.toList());
    }

    @WebMethod(operationName = "ReserveResource")
    public ReservationDetails reserveResource(ReservationDetails reservationRequest) {
        reservations.add(reservationRequest);
        return reservationRequest;
    }
}
