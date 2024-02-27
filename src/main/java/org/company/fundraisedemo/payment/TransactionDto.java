package org.company.fundraisedemo.payment;

public class TransactionDto {
    private Integer id;
    private Integer donorId;
    private Integer postId;
    private Integer amount;
    private Integer fromDonorId;
    private Integer toFundRaiserId;


    public TransactionDto(Integer id, Integer donorId, Integer postId, Integer amount, Integer fromDonorId, Integer toFundRaiserId) {
        this.id = id;
        this.donorId = donorId;
        this.postId = postId;
        this.amount = amount;
        this.fromDonorId = fromDonorId;
        this.toFundRaiserId = toFundRaiserId;
    }

    public TransactionDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDonorId() {
        return donorId;
    }

    public void setDonorId(Integer donorId) {
        this.donorId = donorId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getFromDonorId() {
        return fromDonorId;
    }

    public void setFromDonorId(Integer fromDonorId) {
        this.fromDonorId = fromDonorId;
    }

    public Integer getToFundRaiserId() {
        return toFundRaiserId;
    }

    public void setToFundRaiserId(Integer toFundRaiserId) {
        this.toFundRaiserId = toFundRaiserId;
    }
}
