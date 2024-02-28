package org.company.fundraisedemo.payment;

import jakarta.persistence.*;
import org.company.fundraisedemo.donar.Donor;

import java.time.LocalDateTime;

@Entity
public class Payment {
    @Id
    @GeneratedValue
    private Integer id;

    private String fromAccountid;
    private String donatedAccountId;
    private Integer donatedPostId;
    private Double amount;
    private LocalDateTime paymentDateTime;
    private String status;

    @ManyToOne
    private Donor donors;


    public Payment() {
    }

    public Payment(Integer id, String fromAccountid, String donatedAccountId, Integer donatedPostId, Double amount, LocalDateTime paymentDateTime, String status, Donor donors) {
        this.id = id;
        this.fromAccountid = fromAccountid;
        this.donatedAccountId = donatedAccountId;
        this.donatedPostId = donatedPostId;
        this.amount = amount;
        this.paymentDateTime = paymentDateTime;
        this.status = status;
        this.donors = donors;
    }

    public Payment(String fromAccountid, String donatedAccountId, Integer donatedPostId, Double amount, LocalDateTime paymentDateTime, String status, Donor donors) {
        this.fromAccountid = fromAccountid;
        this.donatedAccountId = donatedAccountId;
        this.donatedPostId = donatedPostId;
        this.amount = amount;
        this.paymentDateTime = paymentDateTime;
        this.status = status;
        this.donors = donors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


    public LocalDateTime getPaymentDateTime() {
        return paymentDateTime;
    }

    public void setPaymentDateTime(LocalDateTime paymentDate) {
        this.paymentDateTime = paymentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Donor getDonors() {
        return donors;
    }

    public void setDonors(Donor donors) {
        this.donors = donors;
    }


}
