package com.udilov.it.data;

import com.github.javafaker.Faker;

public class TestDataForRegistrationTests {

    Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress(lastName.toLowerCase());
    public String gender = getGender();
    public String mobileNumber = faker.phoneNumber().subscriberNumber(10);
    public String birthYear = String.valueOf(faker.number().numberBetween(1900, 2023));
    public String birthMonth = getBirthMonth();
    public String birthDay = String.format("%02d", faker.number().numberBetween(1, 28));
    public String subjects = getSubjects();
    public String hobbies = getHobbies();
    public String picture = "picture.jpg";
    public String currentAddress = faker.address().fullAddress();
    public String state = getState();
    public String city = getCity(state);

    public String getGender() {

        return faker.options().option("Male", "Female", "Other");
    }

    public String getBirthMonth() {

        return faker.options().option("January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December");
    }

    public String getSubjects() {

        return faker.options().option("Arts", "Biology", "Commerce", "English", "History", "Maths", "Physics");
    }

    public String getHobbies() {

        return faker.options().option("Sports", "Reading", "Music");
    }

    public String getState() {

        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public String getCity(String state) {

        if (state.equals("NCR")) {
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        }

        if (state.equals("Uttar Pradesh")) {
            return faker.options().option("Agra", "Lucknow", "Merrut");
        }

        if (state.equals("Haryana")) {
            return faker.options().option("Karnal", "Panipat");
        }

        if (state.equals("Rajasthan")) {
            return faker.options().option("Jaipur", "Jaiselmer");
        }

        return null;
    }
}
