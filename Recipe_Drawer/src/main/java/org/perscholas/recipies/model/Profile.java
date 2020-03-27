package org.perscholas.recipies.model;

import java.sql.Blob;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Profile {
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String bio;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dob;
    @Lob
    @Basic(fetch=FetchType.LAZY)
    private byte[] picture;
    @OneToOne
    private User user;

    public Profile() {
    }

    public Profile(Integer id, String name, String bio, Date dob, byte[] picture) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.dob = dob;
        this.picture = picture;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public byte[] getPicture() {
        return this.picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) o;
        return Objects.equals(id, profile.id) && Objects.equals(name, profile.name) && Objects.equals(bio, profile.bio) && Objects.equals(dob, profile.dob) && Objects.equals(picture, profile.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, bio, dob, picture);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", bio='" + getBio() + "'" +
            ", dob='" + getDob() + "'" +
            ", picture='" + getPicture() + "'" +
            "}";
    }
}