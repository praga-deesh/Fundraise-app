package org.company.fundraisedemo.donar;

import org.company.fundraisedemo.comment.Comment;
import org.company.fundraisedemo.comment.CommentDto;
import org.company.fundraisedemo.comment.CommentException;
import org.company.fundraisedemo.comment.CommentService;


import org.company.fundraisedemo.fundraiser.Fundraiser;
import org.company.fundraisedemo.fundraiser.FundraiserService;
import org.company.fundraisedemo.payment.PaymentExceptions;
import org.company.fundraisedemo.payment.PaymentService;
import org.company.fundraisedemo.payment.TransactionDto;
import org.company.fundraisedemo.post.Post;
import org.company.fundraisedemo.post.PostExceptions;
import org.company.fundraisedemo.post.PostService;

import org.hibernate.annotations.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
public class DonorController {

    @Autowired
    private DonorService donorService;


//    @Autowired
//    private CommentService commentService;

//    @Autowired
//    private PostService postService;
//
//    @Autowired
//    private PaymentService paymentService;



    @PostMapping("donor")
    public Donor createDonor(@RequestBody Donor newDonor) throws DonorExceptions {
        return this.donorService.createDonorProfile(newDonor);
    }


    @PostMapping("donor/login")
    public Donor loginDonor(@RequestBody DonorLoginDto donorLoginDto) throws DonorExceptions {
        return this.donorService.loginDonorProfile(donorLoginDto.getEmail(), donorLoginDto.getPassword());
    }

//    @PostMapping("donor/bankdets/{id}")
//    public Donor updateDonorBankDets(@PathVariable Integer id, String accountId, Double balance) throws DonorExceptions {
//        return this.donorService.updateDonorBankDets(id, accountId, balance);
//    }

    @GetMapping("donor/{id}")
    public Donor viewDonor(Integer id) throws DonorExceptions {
        return this.donorService.viewDonorById(id);
    }

    @PatchMapping("donor/name")
    public Donor updateDonorName(Integer id, String newName) throws DonorExceptions {
        return this.donorService.updateDonorNameById(id, newName);
    }

    @PatchMapping("donor/email")
    public Donor updateDonorEmail(Integer id, String newEmail) throws DonorExceptions {
        return this.donorService.updateDonorEmailById(id, newEmail);
    }

    @PatchMapping("donor/password")
    public Donor updateDonorPassword(Integer id, @RequestBody DonorLoginDto donorLoginDto) throws DonorExceptions {
        return this.donorService.updateDonorPasswordById(id, donorLoginDto.getPassword());
    }

    @DeleteMapping("donor")
    public String deleteDonor(Integer id) throws DonorExceptions {
        return this.donorService.deleteDonorById(id);
    }
//
//    @GetMapping("donar/getAllPosts")
//    public List<Post> getAllPosts() throws PostExceptions {
//        return postService.getAllPosts();
//    }
//
//    @GetMapping("donar/posts/{postId}")
//    public List<Post> getPostById(@PathVariable Integer postId) throws PostExceptions {
//        return postService.getPostById(postId);
//
//    }
//
//    @GetMapping("donor/postsByTitle/{title}")
//    public List<Post> getPostsByTitle(@PathVariable String title) throws PostExceptions {
//        return postService.getPostsByTitle(title);
//    }
//
//    @GetMapping("/donate/posts/sortedByDate")
//    public List<Post> getPostsSortedByDate() throws PostExceptions {
//
//        return postService.getPostsSortedByDate();
//    }
//
//
//    @GetMapping("donar/completedPosts")
//    public List<Post> getCompletedPosts() throws PostExceptions {
//        return postService.getCompletedPosts();
//    }
//
//    @GetMapping("donar/inCompletedPosts")
//    public List<Post> getIncompletedPosts() throws PostExceptions {
//        return postService.getIncompletePosts();
//    }
//
//    @GetMapping("donar/PostsByCategory/{category}")
//    public List<Post> getPostsByCategory(@PathVariable String category) throws PostExceptions {
//        return postService.getPostsByCategory(category);
//    }
//
//    @PatchMapping("payment")
//    public String makePayment(@RequestBody TransactionDto transaction) throws PostExceptions, DonorExceptions, PaymentExceptions {
//        return paymentService.transaction(transaction);
//    }
//
//    @PostMapping("donor/addComment")
//    public Comment addComment(@RequestBody Comment comment) throws CommentException {
//        return commentService.addComment(comment);
//    }
//
//    @DeleteMapping("donor/deleteComment/{commentId}")
//    public Comment deleteCommentById(@PathVariable Integer commentId) throws CommentException {
//        return commentService.deleteCommentById(commentId);
//    }
//
//
//    @PatchMapping("donor/updateComment/{commentId}")
//    public Comment updateCommentById(@RequestBody Comment comment) throws CommentException {
//        return commentService.updateComment(comment);
//    }
//
//    @GetMapping("donor/getCommentById/{commentId}")
//    public Comment getCommentById(Integer id) throws CommentException {
//        return commentService.getCommentById(id);
//    }
//
//
//    @GetMapping("donor/getComments/{postId}")
//    public List<Comment> getComments(@PathVariable Integer postId) throws CommentException {
//        return commentService.getComments(postId);
//    }
}

