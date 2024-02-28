package org.company.fundraisedemo.comment;


import org.company.fundraisedemo.donar.Donor;
import org.company.fundraisedemo.donar.DonorExceptions;
import org.company.fundraisedemo.fundraiser.Fundraiser;
import org.company.fundraisedemo.post.Post;
import org.company.fundraisedemo.post.PostService;
import org.company.fundraisedemo.post.PostServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.print.attribute.standard.DocumentName;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

public class CommentServiceImplTest {
  

  @Autowired
    private CommentRepositoryDao commentRepositoryDao;

    @Autowired
    private CommentService commentService;
     

    @Autowired
    private PostService postService;
    @Test
    void addComment(Comment comment)  {

      Comment actualComment=new Comment(1,3,5,"good");
      Comment expectedComment=null;

      try {
        actualComment = commentService.addComment(actualComment);
    } catch (CommentException e) {
        throw new RuntimeException(e);
    }

    expectedComment = commentRepositoryDao.findById(actualComment.getId()).get();
    Assertions.assertEquals(expectedComment.getId(), actualComment.getId());
    commentRepositoryDao.delete(actualComment);
    }

  @Test
  void deleteCommentByIdTest() {
    Comment comment, deletedComment;
    Donor donor = new Donor("Asmithaa","asmithaa@gmail.com","string@123");
    Fundraiser fundraiser = new Fundraiser("klay","klay@gmail..com","klay");
    Post post = new Post("Poverty","Expenses for food and shelter for poors","poverty", LocalDate.of(2024, 02, 27),LocalDate.of(2024,04,20),200000.0,0.0,"incomplete",fundraiser);
    comment = new Comment(donor.getId(), fundraiser.getId(), post.getId(),"This is a comment" );

    // Save the comment
    try {
      comment = commentService.addComment(comment);
    } catch (CommentException e) {
      throw new RuntimeException(e);
    }

    // Delete the comment
    try {
      deletedComment = commentService.deleteCommentById(comment.getId());
    } catch (CommentException e) {
      throw new RuntimeException(e);
    }

    // Assert that the deleted comment is the one we created
    Assertions.assertEquals(comment.getId(), deletedComment.getId());

    // Assert that the comment no longer exists
    try {
      commentService.getCommentById(comment.getId());
      Assertions.fail("Expected CommentException");
    } catch (CommentException e) {
      // Expected exception
    }



  }

  @Test
  void updateCommentTest() {
    Comment comment, newComment, updatedComment;
    Donor donor = new Donor("Asmithaa","asmithaa@gmail.com","string@123");
    Fundraiser fundraiser = new Fundraiser("klay","klay@gmail..com","klay");
    Post post = new Post("Poverty","Expenses for food and shelter for poors","poverty", LocalDate.of(2024, 02, 27),LocalDate.of(2024,04,20),200000.0,0.0,"incomplete",fundraiser);
    comment = new Comment(1,donor.getId(), post.getId(),"This is a comment" );

    // Save the comment
    try {
      comment = commentService.addComment(comment);
    } catch (CommentException e) {
      throw new RuntimeException(e);
    }

    // Update the comment
    newComment = new Comment(comment.getId(),donor.getId(), post.getId(),"This is a updated comment" );

    try {
      updatedComment = commentService.updateComment(newComment);
    } catch (CommentException e) {
      throw new RuntimeException(e);
    }

    // Assert that the updated comment is the one we created
    Assertions.assertEquals(comment.getId(), updatedComment.getId());
    Assertions.assertEquals("This is an updated comment", updatedComment.getContent());

    // Clean up
    try {
      commentService.deleteCommentById(comment.getId());
    } catch (CommentException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  void getCommentByIdTest() {
    Comment comment, fetchedComment;
    Donor donor = new Donor("Asmithaa","asmithaa@gmail.com","string@123");
    Fundraiser fundraiser = new Fundraiser("klay","klay@gmail..com","klay");
    Post post = new Post("Poverty","Expenses for food and shelter for poors","poverty", LocalDate.of(2024, 02, 27),LocalDate.of(2024,04,20),200000.0,0.0,"incomplete",fundraiser);
    comment = new Comment(donor.getId(), fundraiser.getId(), post.getId(),"This is a comment" );

    // Save the comment
    try {
      comment = commentService.addComment(comment);
    } catch (CommentException e) {
      throw new RuntimeException(e);
    }

    // Fetch the comment
    try {
      fetchedComment = commentService.getCommentById(comment.getId());
    } catch (CommentException e) {
      throw new RuntimeException(e);
    }

    // Assert that the fetched comment is the one we created
    Assertions.assertEquals(comment.getId(), fetchedComment.getId());

    // Clean up
    try {
      commentService.deleteCommentById(comment.getId());
    } catch (CommentException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void testGetComments() throws CommentException {

    Donor donor = new Donor("Asmithaa","asmithaa@gmail.com","string@123");
    Fundraiser fundraiser = new Fundraiser("klay","klay@gmail..com","klay");
    Post post = new Post("Poverty","Expenses for food and shelter for poors","poverty", LocalDate.of(2024, 02, 27),LocalDate.of(2024,04,20),200000.0,0.0,"incomplete",fundraiser);
    post = postService.addNewPost(post); // Assuming you have a PostRepositoryDao autowired in your test class


    Comment comment = new Comment(donor.getId(), post.getId(), 1, "Test Comment");
    comment = commentRepositoryDao.save(comment);

    Integer postId = post.getId();


    List<Comment> actualComments = commentService.getComments(postId);


    Assertions.assertFalse(actualComments.isEmpty());

    for (Comment actualComment : actualComments) {
      Assertions.assertEquals(postId, actualComment.getPostId());
    }

    Assertions.assertFalse(actualComments.contains(null));

    int expectedSize = 1;
    Assertions.assertEquals(expectedSize, actualComments.size());

    // Clean up
    postService.deletePostById(post.getId());
    commentService.deleteCommentById(comment.getId());
  }

     
    


}
