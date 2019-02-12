package com.google.apigee.demo;

import java.util.Calendar;

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
