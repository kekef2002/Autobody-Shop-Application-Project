package edu.farmingdale.autobodyshopapplicationproject.model;

import java.time.LocalDate;
import java.util.Date;

public class Person {

    private String firstName;
    private String middleInitial;
    private String lastName;
    private String address;
    private String aptUnit;  // Optional field
    private String city;
    private String state;   // 50 states dropdown
    private String zipCode;
    private String preferredContactMethod;  // Dropdown options of email, phone call, text
    private String email;
    private String telephone;
    private String licensePlate;
    private String licensePlateState;
    private int mileage;
    private int year;
    private String make;
    private String model;
    private String transportationNeeds;  // Options for selecting transportation needs
    private String serviceRequested;    // Options for selecting services
    private Date appointmentDate;
    private String appointmentTime;
    private String customerComments;
    private Date nextAppointmentDate;
    private String password;

    public Person() {
    }

    public Person(String firstName, String middleInitial, String lastName, String address, String aptUnit, String city, String state,
                  String zipCode, String preferredContactMethod, String email, String telephone, String licensePlate, String licensePlateState,
                  int mileage, int year, String make, String model, String transportationNeeds, String serviceRequested, Date appointmentDate,
                  String appointmentTime, String customerComments, Date nextAppointmentDate, String password) {
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.address = address;
        this.aptUnit = aptUnit;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.preferredContactMethod = preferredContactMethod;
        this.email = email;
        this.telephone = telephone;
        this.licensePlate = licensePlate;
        this.licensePlateState = licensePlateState;
        this.mileage = mileage;
        this.year = year;
        this.make = make;
        this.model = model;
        this.transportationNeeds = transportationNeeds;
        this.serviceRequested = serviceRequested;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.customerComments = customerComments;
        this.nextAppointmentDate = nextAppointmentDate;
        this.password = password;
    }

    // Getters and Setters for all fields
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAptUnit() {
        return aptUnit;
    }

    public void setAptUnit(String aptUnit) {
        this.aptUnit = aptUnit;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPreferredContactMethod() {
        return preferredContactMethod;
    }

    public void setPreferredContactMethod(String preferredContactMethod) {
        this.preferredContactMethod = preferredContactMethod;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlateState() {
        return licensePlateState;
    }

    public void setLicensePlateState(String licensePlateState) {
        this.licensePlateState = licensePlateState;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTransportationNeeds() {
        return transportationNeeds;
    }

    public void setTransportationNeeds(String transportationNeeds) {
        this.transportationNeeds = transportationNeeds;
    }

    public String getServiceRequested() {
        return serviceRequested;
    }

    public void setServiceRequested(String serviceRequested) {
        this.serviceRequested = serviceRequested;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getCustomerComments() {
        return customerComments;
    }

    public void setCustomerComments(String customerComments) {
        this.customerComments = customerComments;
    }

    public Date getNextAppointmentDate() {
        return nextAppointmentDate;
    }

    public void setNextAppointmentDate(Date nextAppointmentDate) {
        this.nextAppointmentDate = nextAppointmentDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                ", firstName = '" + firstName + '\'' +
                ", middleInitial = '" + middleInitial + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", address = '" + address + '\'' +
                ", aptUnit = '" + aptUnit + '\'' +
                ", city = '" + city + '\'' +
                ", state = '" + state + '\'' +
                ", zipCode = '" + zipCode + '\'' +
                ", preferredContactMethod = '" + preferredContactMethod + '\'' +
                ", email = '" + email + '\'' +
                ", telephone = '" + telephone + '\'' +
                ", licensePlate = '" + licensePlate + '\'' +
                ", licensePlateState = '" + licensePlateState + '\'' +
                ", mileage = '" + mileage + '\'' +
                ", year = '" + year + '\'' +
                ", make = '" + make + '\'' +
                ", model = '" + model + '\'' +
                ", transportationNeeds = '" + transportationNeeds + '\'' +
                ", serviceRequested = '" + serviceRequested + '\'' +
                ", appointmentDate = '" + appointmentDate + '\'' +
                ", appointmentTime = '" + appointmentTime + '\'' +
                ", customerComments = '" + customerComments + '\'' +
                ", nextAppointmentDate = '" + nextAppointmentDate + '\'' +
                ", password = '" + password + '\'' +
                '}';
    }
}
