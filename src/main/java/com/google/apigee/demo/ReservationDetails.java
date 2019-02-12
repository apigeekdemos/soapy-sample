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
import java.util.Calendar;

/**
 * container for some details about the registration of a resource.
 */
public class ReservationDetails implements Comparable<ReservationDetails> {
    private String resource;
    private String description;
    private Calendar startTime;
    private Integer slots;

    @Override
    public int compareTo(ReservationDetails o) {
        if( ! this.resource.equals(o.resource)) {
            return this.resource.compareTo(o.resource);
        }
        return startTime.compareTo(o.startTime);
    }

    @Override
    public boolean equals(Object obj) {
        if( ! (obj instanceof ReservationDetails)) {
            return false;
        }
        ReservationDetails other = (ReservationDetails) obj;
        return this.resource.equals(other.resource) && this.startTime.equals(other.startTime)
                && this.slots.equals(other.slots);
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public Integer getSlots() {
        return slots;
    }

    public void setSlots(Integer slots) {
        this.slots = slots;
    }
}
