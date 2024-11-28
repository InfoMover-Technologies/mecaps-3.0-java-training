package com.im.trainings.java.model;



public class Customer implements Comparable {

    private int id;
    private String name;


    /**
     * Setter and Getter Methods
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object obj) {
        Customer compareWith = (Customer) obj;
        return this.id == compareWith.id;
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(this.id);
    }

    @Override
    public String toString() {
        return this.id + " -- " + this.name;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.id, ((Customer) o).id);
    }
}
