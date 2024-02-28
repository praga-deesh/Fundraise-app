package org.company.fundraisedemo.payment;

import jakarta.persistence.*;
import org.company.fundraisedemo.donar.Donor;

import java.time.LocalDateTime;
import java.util.List;

    @Entity
    public class Payment {
        @Id
        @GeneratedValue
        private Integer id;

        private Double amount;
        private String paymentMethod;
        private LocalDateTime paymentDate;
        private String status;

        private String comment;


        //hello hiiiii

        @ManyToOne
        private Donor donors;


        public Payment() {
        }

        public Payment(Integer id, Double amount, String paymentMethod, LocalDateTime paymentDate, String status, String comment, Donor donors) {
            this.id = id;
            this.amount = amount;
            this.paymentMethod = paymentMethod;
            this.paymentDate = paymentDate;
            this.status = status;
            this.comment = comment;
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

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public LocalDateTime getPaymentDate() {
            return paymentDate;
        }

        public void setPaymentDate(LocalDateTime paymentDate) {
            this.paymentDate = paymentDate;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public Donor getDonors() {
            return donors;
        }

        public void setDonors(Donor donors) {
            this.donors = donors;
        }
    }



