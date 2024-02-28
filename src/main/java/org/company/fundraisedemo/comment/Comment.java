package org.company.fundraisedemo.comment;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer donorId;

    private Integer postId;
    private String commentDescription;

    public Comment() {
    }

    public Comment(Integer id, Integer donorId, Integer postId, String commentDescription) {
        this.id = id;
        this.donorId = donorId;
        this.postId = postId;
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

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }


    //Hiiiii
}
