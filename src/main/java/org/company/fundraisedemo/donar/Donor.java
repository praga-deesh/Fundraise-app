package org.company.fundraisedemo.donar;

import jakarta.persistence.*;
import org.company.fundraisedemo.payment.Payment;

import java.util.List;


@Entity
public class  Donor {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String email;
    private String password;

    @OneToMany
    @Column(nullable = true)
    private List<Payment> donationHistory;

    public Donor(Integer id, String name, String email, String password, List<Payment> donationHistory) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.donationHistory = donationHistory;
    }

    public Donor(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Donor(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Donor() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Payment> getDonationHistory() {
        return donationHistory;
    }

    public void setDonationHistory(List<Payment> donationHistory) {
        this.donationHistory = donationHistory;
    }


}

