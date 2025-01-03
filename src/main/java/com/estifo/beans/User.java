package com.estifo.beans;

public class User {
    private int userId;
    private String firstName;
    private String LastName;
    private String userName;
    private String email;
    private String password;
    private Gender gender;


    public User(){
        super();
    }

    public User(String firstName, String lastName, String userName, String email, String password, Gender gender) {
        this.firstName = firstName;
        LastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.gender = gender;

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "User [userId=" + userId + ", firstName=" + firstName + ", LastName=" + LastName + ", userName="
                + userName + ", email=" + email + ", password=" + password + ", gender=" + gender + "]";
    }
    
    
    

}
