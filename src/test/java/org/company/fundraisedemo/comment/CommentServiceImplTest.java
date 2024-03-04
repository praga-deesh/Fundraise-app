package org.company.fundraisedemo.comment;


import org.company.fundraisedemo.donar.Donor;
import org.company.fundraisedemo.donar.DonorRepositoryDao;
import org.company.fundraisedemo.fundraiser.Fundraiser;
import org.company.fundraisedemo.fundraiser.FundraiserRepositoryDao;
import org.company.fundraisedemo.post.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;

@SpringBootTest

class CommentServiceImplTest {


    @Autowired
    private CommentRepositoryDao commentRepositoryDao;

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostRepositoryDao postRepositoryDao;

    @Autowired
    private PostService postService;

    @Autowired
    private FundraiserRepositoryDao fundraiserRepositoryDao;

    @Autowired
    private DonorRepositoryDao donorRepositoryDao;





    @Test
    void addComment()  {
        Comment actualComment = new Comment(1, 3, 5, "good");
        Comment expectedComment = null;

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

        try {
            comment = commentService.addComment(comment);
        } catch (CommentException e) {
            throw new RuntimeException(e);
        }

        try {
            deletedComment = commentService.deleteCommentById(comment.getId());
        } catch (CommentException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(comment.getId(), deletedComment.getId());
        fundraiserRepositoryDao.delete(fundraiser);
        postRepositoryDao.delete(post);
        donorRepositoryDao.delete(donor);


    }


    @Test
    void updateCommentTest() {
        Comment comment, newComment, updatedComment;
        Donor donor = new Donor("Asmithaa","asmithaa@gmail.com","string@123");
        Fundraiser fundraiser = new Fundraiser("klay","klay@gmail..com","klay");
        Post post = new Post("Poverty","Expenses for food and shelter for poors","poverty", LocalDate.of(2024, 02, 27),LocalDate.of(2024,04,20),200000.0,0.0,"incomplete",fundraiser);
        comment = new Comment(1,donor.getId(), post.getId(),"This is a comment" );

        try {
            comment = commentService.addComment(comment);
        } catch (CommentException e) {
            throw new RuntimeException(e);
        }

        newComment = new Comment(comment.getId(),donor.getId(), post.getId(),"This is a updated comment" );

        try {
            commentService.updateComment(newComment);
        } catch (CommentException e) {
            throw new RuntimeException(e);
        }

        try {
            updatedComment = commentService.getCommentById(comment.getId());
        } catch (CommentException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(newComment.getId(), updatedComment.getId());
        Assertions.assertEquals(newComment.getCommentDescription(), updatedComment.getCommentDescription());

        try {
            commentService.deleteCommentById(comment.getId());
        } catch (CommentException e) {
            throw new RuntimeException(e);
        }

        fundraiserRepositoryDao.delete(fundraiser);
        postRepositoryDao.delete(post);
        donorRepositoryDao.delete(donor);

    }

    @Test
    void getCommentByIdTest() {
        Comment comment = new Comment(1, 3, 5, "good");
        Comment savedComment = null;
        Comment fetchedComment = null;

        try {
            savedComment = commentService.addComment(comment);
        } catch (CommentException e) {
            throw new RuntimeException(e);
        }

        try {

            fetchedComment = commentService.getCommentById(savedComment.getId());
        } catch (CommentException e) {
            throw new RuntimeException(e);
        }


        Assertions.assertNotNull(fetchedComment, "Fetched comment should not be null");
        Assertions.assertEquals(savedComment.getId(), fetchedComment.getId(), "Fetched comment ID should match saved comment ID");

        commentRepositoryDao.delete(savedComment);
    }




//    @Test
//    public void testGetComments() {
//        Comment commentOne, commentTwo;
//
//        Donor donor = new Donor("Asmithaa","asmithaa@gmail.com","string@123");
//        donorRepositoryDao.save(donor);
//
//        Fundraiser fundraiser = new Fundraiser("klay", "klay@gmail.com", "klay");
//        fundraiserRepositoryDao.save(fundraiser);
//
//
//        Post post = new Post("Title1", "Description1", "Category1", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 10), 100.0, 50.0, "incomplete", fundraiser);
//        postRepositoryDao.save(post);
//
//        commentOne = new Comment(donor.getId(), fundraiser.getId(), post.getId(),"This is a comment" );
//        commentTwo=  new Comment(donor.getId(), fundraiser.getId(), post.getId(),"This is a second comment" );
//
//       commentRepositoryDao.save(commentOne);
//       commentRepositoryDao.save(commentTwo);
//
//
//        List<Comment> actualComments ;
//        try {
//            actualComments = commentService.getComments(post.getId());
//        } catch (CommentException e) {
//            throw new RuntimeException("Error while fetching comments for post", e);
//        }
//
////      Assertions.assertEquals(, actualComments.size());
//        Assertions.assertTrue(actualComments.contains(commentOne));
//        Assertions.assertTrue(actualComments.contains(commentTwo));
//
//        commentRepositoryDao.delete(commentOne);
//        commentRepositoryDao.delete(commentTwo);
//    }

}

