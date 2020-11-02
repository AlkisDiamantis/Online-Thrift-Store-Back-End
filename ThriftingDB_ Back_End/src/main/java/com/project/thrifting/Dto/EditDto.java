package com.project.thrifting.Dto;

import javax.persistence.Basic;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EditDto {

    private Long userid;

    @NotBlank(message = "User Name cannot be empty")
    @Size(min = 3, max = 20, message = "User Name should be between 3-20 letters")
    @Pattern(regexp = "^([ A-Za-z]+\\s)*[ A-Za-z]+$", message = "Username should contain only letters")
    private String username;

    @NotBlank(message = "Email cannot be empty")
    @Size(max = 50)
    @Email
    private String email;

    @Basic(optional = false)
    @NotNull(message = "First Name cannot be empty")
    @Size(min = 3, max = 45, message = "First Name should be between 3-40 letters")
    @Pattern(regexp = "^([ A-Za-z]+\\s)*[ A-Za-z]+$", message = "First Name should contain only letters")
    private String firstName;

    @Basic(optional = false)
    @NotNull(message = "Last name cannot be empty")
    @Size(min = 3, max = 45, message = "Last Name should be between 3-40 letters")
    @Pattern(regexp = "^([ A-Za-z]+\\s)*[ A-Za-z]+$", message = "Last Name should contain only letters")
    private String lastName;


    private String password;

    @NotBlank
    @Pattern(regexp = "\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{4})", message = "Not Valid Phone Number Enter a 10 digit number!")
    private String telephone;

    @NotBlank(message = "Enter a Country")

    private String country;

    @NotBlank(message = "Enter a Region")
    private String region;

    @NotBlank(message = "Enter an address")
    @Size(min = 3, max = 45, message = "Address should be between 3-40 characters ")
    private String address;

    @Pattern(regexp = "^([\\s\\d]+)$", message = "Zip field should contain only numbers")
    @Size(min = 3, max = 5, message = "Zip should be between 3-5 numbers ")
    private String zip;

    private String photoname;

    private String phototype;

    private String photosize;


    private String photoBase64;

    private double userslongitude;

    private double userslatitude;

    public EditDto() {
    }

    public EditDto(String username, String email, String firstName, String lastName, String password, String telephone, String country, String region, String address, String zip, String photoname, String phototype, String photosize, String photoBase64, double userslongitude, double userslatitude) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.telephone = telephone;
        this.country = country;
        this.region = region;
        this.address = address;
        this.zip = zip;
        this.photoname = photoname;
        this.phototype = phototype;
        this.photosize = photosize;
        this.photoBase64 = photoBase64;
        this.userslongitude = userslongitude;
        this.userslatitude = userslatitude;
    }

    public EditDto(Long userid, String username, String email, String firstName, String lastName, String password, String telephone, String country, String region, String address, String zip, String photoname, String phototype, String photosize, String photoBase64, double userslongitude, double userslatitude) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.telephone = telephone;
        this.country = country;
        this.region = region;
        this.address = address;
        this.zip = zip;
        this.photoname = photoname;
        this.phototype = phototype;
        this.photosize = photosize;
        this.photoBase64 = photoBase64;
        this.userslongitude = userslongitude;
        this.userslatitude = userslatitude;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public double getUserslongitude() {
        return userslongitude;
    }

    public void setUserslongitude(double userslongitude) {
        this.userslongitude = userslongitude;
    }

    public double getUserslatitude() {
        return userslatitude;
    }

    public void setUserslatitude(double userslatitude) {
        this.userslatitude = userslatitude;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhotoname() {
        return photoname;
    }

    public void setPhotoname(String photoname) {
        this.photoname = photoname;
    }

    public String getPhototype() {
        return phototype;
    }

    public void setPhototype(String phototype) {
        this.phototype = phototype;
    }

    public String getPhotosize() {
        return photosize;
    }

    public void setPhotosize(String photosize) {
        this.photosize = photosize;
    }

    public String getPhotoBase64() {
        return photoBase64;
    }

    public void setPhotoBase64(String photoBase64) {
        this.photoBase64 = photoBase64;
    }

}
