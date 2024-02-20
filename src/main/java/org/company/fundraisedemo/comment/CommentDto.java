package org.company.fundraisedemo.comment;

public class CommentDto {
    private Integer id;
    private Integer donorId;

    private String commentDescription;

    public CommentDto() {
    }

    public CommentDto(Integer id, Integer donorId, String commentDescription) {
        this.id = id;
        this.donorId = donorId;
        this.commentDescription = commentDescription;
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

    public String getCommentDescription() {
        return commentDescription;
    }

    public void setCommentDescription(String commentDescription) {
        this.commentDescription = commentDescription;
    }
}
