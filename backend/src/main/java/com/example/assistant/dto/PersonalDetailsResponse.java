package com.example.assistant.dto;

public class PersonalDetailsResponse {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public PersonalDetailsResponse(String firstName,
                                   String lastName,
                                   String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
//    public PersonalDetailsResponse(String firstName,String lastName)

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
