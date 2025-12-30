package com.airtribe.learntrack.entity;

public class Student extends Person{
    //id, firstName, lastName, email, batch, active (boolean)

    private String batch;
    private boolean active;

    public Student(int id, String lastName, String firstName, String email, String batch, boolean active) {
      super(firstName,lastName,email,id);
        this.batch = batch;
        this.active = active;
    }

    public String getDisplayName() {
        String displayName = super.getDisplayName();
        return displayName;
    }


    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
