package com.project.thrifting.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "username")
            ,
			@UniqueConstraint(columnNames = "email")
        })

public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String username;

    private String email;

    
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @Size(max = 120)
    private String password;


    @Column(name = "telephone")
    private String telephone;


    @Column(name = "country")
    private String country;


    @Column(name = "region")
    private String region;

    @Column(name = "address")
    private String address;

    @Basic(optional = false)

    @Size(min = 1, max = 100)
    @Column(name = "photoUrl")
    private String photoUrl;


    @Column(name = "zip")
    private String zip;

    @Basic(optional = true)
    @Column(name = "userlongitude")
    private Double userlongitude;

    @Basic(optional = true)
    @Column(name = "userlatitude")
    private Double userlatitude;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList();

    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    public User() {
    }

    public User(Long user_id, String username, String email, String firstName, String lastName, String password, String telephone, String country, String region, String address, String photoUrl, String zip, Double userlongitude, Double userlatitude) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.telephone = telephone;
        this.country = country;
        this.region = region;
        this.address = address;
        this.photoUrl = photoUrl;
        this.zip = zip;
        this.userlongitude = userlongitude;
        this.userlatitude = userlatitude;
    }

    public User(Long user_id, String username, String email, String firstName, String lastName, String password, String telephone, String country, String region, String address, String photoUrl, String zip) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.telephone = telephone;
        this.country = country;
        this.region = region;
        this.address = address;
        this.photoUrl = photoUrl;
        this.zip = zip;
    }

    public static User build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
        user.setAuthorities(authorities);

        return user;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public Long getId() {
        return user_id;
    }

    
    public double getUserlongitude() {
        return userlongitude;
    }

    public void setUserlongitude(Double userlongitude) {
        this.userlongitude = userlongitude;
    }

    
    public Double getUserlatitude() {
        return userlatitude;
    }

    public void setUserlatitude(double userlatitude) {
        this.userlatitude = userlatitude;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setId(Long id) {
        this.user_id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
