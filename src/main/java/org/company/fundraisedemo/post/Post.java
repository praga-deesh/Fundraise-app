package org.company.fundraisedemo.post;

import jakarta.persistence.*;
import org.company.fundraisedemo.comment.Comment;
import org.company.fundraisedemo.fundraiser.Fundraiser;
import org.company.fundraisedemo.payment.Payment;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;
    private String description;
    private String category;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double amountRequested;

    @Column(nullable = true)
    private Double amountCollected;
    private String status;

    @ManyToOne
    @JoinColumn(name = "fundraiser_id", nullable = false)
    private Fundraiser fundraiser;

    @OneToMany
    @Column(nullable = true)
    private List<Payment> donations;

    @OneToMany
    @Column(nullable = true)
    private List<Comment> comments;

    public Post() {
    }

    public Post(String title, String description, String category, LocalDate startDate, LocalDate endDate, Double amountRequested, Double amountCollected, String status, Fundraiser fundraiser) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amountRequested = amountRequested;
        this.amountCollected = amountCollected;
        this.status = status;
        this.fundraiser = fundraiser;
    }
    public Post(Integer id,String title, String description, String category, LocalDate startDate, LocalDate endDate, Double amountRequested, Double amountCollected, String status, Fundraiser fundraiser) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amountRequested = amountRequested;
        this.amountCollected = amountCollected;
        this.status = status;
        this.fundraiser = fundraiser;
    }

    public Post(Integer id, String title, String description, String category, LocalDate startDate, LocalDate endDate, Double amountRequested, Double amountCollected, String status, Fundraiser fundraiser, List<Payment> donations, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amountRequested = amountRequested;
        this.amountCollected = amountCollected;
        this.status = status;
        this.fundraiser = fundraiser;
        this.donations = donations;
        this.comments = comments;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
