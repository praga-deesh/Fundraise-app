package org.company.fundraisedemo.comment;


import org.company.fundraisedemo.donar.DonorService;
import org.company.fundraisedemo.payment.PaymentService;
import org.company.fundraisedemo.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController
{
    @Autowired
    private CommentService commentService;

    @PostMapping("donor/addComment")
    public Comment addComment(@RequestBody Comment comment) throws CommentException {
        return this.commentService.addComment(comment);
    }

    @DeleteMapping("donor/deleteComment/{commentId}")
    public Comment deleteCommentById(@PathVariable Integer commentId) throws CommentException {
        return this.commentService.deleteCommentById(commentId);
    }


    @PatchMapping("donor/updateComment/{commentId}")
    public Comment updateCommentById(@RequestBody Comment comment) throws CommentException {
        return this.commentService.updateComment(comment);
    }

    @GetMapping("donor/getCommentById/{commentId}")
    public Comment getCommentById(Integer id) throws CommentException {
        return this.commentService.getCommentById(id);
    }


    @GetMapping("donor/getComments/{postId}")
    public List<Comment> getComments(@PathVariable Integer postId) throws CommentException {
        return commentService.getComments(postId);
    }

}
