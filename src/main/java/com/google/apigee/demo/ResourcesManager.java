package com.google.apigee.demo;

import java.util.TreeSet;

public class ResourcesManager extends TreeSet<String> {
    public ResourcesManager() {
        super();
        this.add("Here");
        this.add("There");
        this.add("Not Here");
        this.add("Cancelled");
    }
}
