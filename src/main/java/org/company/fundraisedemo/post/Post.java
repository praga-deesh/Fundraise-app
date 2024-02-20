package org.company.fundraisedemo.post;

import jakarta.persistence.*;
import org.company.fundraisedemo.fundraiser.Fundraiser;
import org.company.fundraisedemo.payment.Payment;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    private String description;
    private String catergory;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double amountRequested;
    private Double amountCollected;
    private String status;

    @ManyToOne
    @JoinColumn
    private Fundraiser fundraiser;

    @OneToMany
    private List<Payment> donations;

    public Post() {
    }

    public Post(Integer id, String description,String category , LocalDate startDate, LocalDate endDate, Double amountRequested, Double amountCollected, String status, Fundraiser fundraiser, List<Payment> donations) {
        this.id = id;
        this.description = description;
        this.catergory = category;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amountRequested = amountRequested;
        this.amountCollected = amountCollected;
        this.status = status;
        this.fundraiser = fundraiser;
        this.donations = donations;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getAmountRequested() {
        return amountRequested;
    }

    public void setAmountRequested(Double amountRequested) {
        this.amountRequested = amountRequested;
    }

    public Double getAmountCollected() {
        return amountCollected;
    }

    public void setAmountCollected(Double amountCollected) {
        this.amountCollected = amountCollected;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Fundraiser getFundraiser() {
        return fundraiser;
    }

    public void setFundraiser(Fundraiser fundraiser) {
        this.fundraiser = fundraiser;
    }

    public List<Payment> getDonations() {
        return donations;
    }

    public void setDonations(List<Payment> donations) {
        this.donations = donations;
    }

    public String getCatergory() {
        return catergory;
    }

    public void setCatergory(String catergory) {
        this.catergory = catergory;
    }
}
