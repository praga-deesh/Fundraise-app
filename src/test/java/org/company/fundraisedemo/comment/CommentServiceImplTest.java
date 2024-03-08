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
import java.util.List;

@SpringBootTest

class CommentServiceImplTest {


    @Autowired
    private CommentRepositoryDao commentRepositoryDao;

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostRepositoryDao postRepositoryDao;


    @Autowired
    private FundraiserRepositoryDao fundraiserRepositoryDao;

    @Autowired
    private DonorRepositoryDao donorRepositoryDao;





    @Test
    void addComment()  {
        Post post;
        Donor donor;
        Fundraiser fundraiser;
        Donor donorVal = new Donor("Asmithaa","asmithaa@gmail.com","string@123");
        donor=donorRepositoryDao.save(donorVal);
        Fundraiser fundraiserVal = new Fundraiser("klay","klay@gmail..com","klay");
        fundraiser=fundraiserRepositoryDao.save(fundraiserVal);
        Post postVal = new Post("Poverty","Expenses for food and shelter for poors","poverty", LocalDate.of(2024, 02, 27),LocalDate.of(2024,04,20),200000.0,0.0,"incomplete",fundraiser);
        post=postRepositoryDao.save(postVal);
        Comment actualCommentVal = new Comment(donor.getId(), fundraiser.getId(), post.getId(),"This is a comment" );
        Comment actualComment = null;
        Comment expectedComment ;

        try {
            actualComment = commentService.addComment(actualCommentVal);
        } catch (CommentException e) {
            throw new RuntimeException(e);
        }

        expectedComment = commentRepositoryDao.findById(actualComment.getId()).get();
        Assertions.assertEquals(expectedComment.getId(), actualComment.getId());
        commentRepositoryDao.delete(actualComment);
        postRepositoryDao.delete(post);
        fundraiserRepositoryDao.delete(fundraiser);
        donorRepositoryDao.delete(donor);
    }

    @Test
    void deleteCommentByIdTest() {
        Post post;
        Donor donor;
        Fundraiser fundraiser;
        Donor donorVal = new Donor("Asmithaa","asmithaa@gmail.com","string@123");
        donor=donorRepositoryDao.save(donorVal);
        Fundraiser fundraiserVal = new Fundraiser("klay","klay@gmail..com","klay");
        fundraiser=fundraiserRepositoryDao.save(fundraiserVal);
        Post postVal = new Post("Poverty","Expenses for food and shelter for poors","poverty", LocalDate.of(2024, 02, 27),LocalDate.of(2024,04,20),200000.0,0.0,"incomplete",fundraiser);
        post=postRepositoryDao.save(postVal);
        Comment actualCommentVal = new Comment(donor.getId(), fundraiser.getId(), post.getId(),"This is a comment" );
        Comment actualComment = null;
        Comment deletedComment ;

        try {
            actualComment = commentService.addComment(actualCommentVal);
        } catch (CommentException e) {
            throw new RuntimeException(e);
        }

        try {
            deletedComment = commentService.deleteCommentById(actualComment.getId());
        } catch (CommentException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(actualComment.getId(), deletedComment.getId());
        postRepositoryDao.delete(post);
        fundraiserRepositoryDao.delete(fundraiser);
        donorRepositoryDao.delete(donor);


    }
    @Test
    void updateCommentTest() {
        Post post;
        Donor donor;
        Fundraiser fundraiser;
        Donor donorVal = new Donor("Asmithaa","asmithaa@gmail.com","string@123");
        donor=donorRepositoryDao.save(donorVal);
        Fundraiser fundraiserVal = new Fundraiser("klay","klay@gmail..com","klay");
        fundraiser=fundraiserRepositoryDao.save(fundraiserVal);
        Post postVal = new Post("Poverty","Expenses for food and shelter for poors","poverty", LocalDate.of(2024, 02, 27),LocalDate.of(2024,04,20),200000.0,0.0,"incomplete",fundraiser);
        post=postRepositoryDao.save(postVal);
        Comment actualCommentVal = new Comment(donor.getId(), fundraiser.getId(), post.getId(),"This is a comment" );
        Comment actualComment = null;
        Comment updatedCommentVal;
        Comment updatedComment ;

        try {
            actualComment = commentService.addComment(actualCommentVal);
        } catch (CommentException e) {
            throw new RuntimeException(e);
        }

        updatedCommentVal = new Comment(actualComment.getId(),donor.getId(), post.getId(),"This is a updated comment" );

        try {
            updatedComment=commentService.updateComment(updatedCommentVal);
        } catch (CommentException e) {
            throw new RuntimeException(e);
        }



        Assertions.assertEquals(actualComment.getId(), updatedComment.getId());
        Assertions.assertEquals(actualComment.getCommentDescription(), updatedComment.getCommentDescription());

        commentRepositoryDao.delete(actualComment);
        commentRepositoryDao.delete(updatedComment);
        postRepositoryDao.delete(post);
        fundraiserRepositoryDao.delete(fundraiser);
        donorRepositoryDao.delete(donor);


    }

    @Test
    void getCommentByIdTest() {
        Post post;
        Donor donor;
        Fundraiser fundraiser;
        Donor donorVal = new Donor("Asmithaa","asmithaa@gmail.com","string@123");
        donor=donorRepositoryDao.save(donorVal);
        Fundraiser fundraiserVal = new Fundraiser("klay","klay@gmail..com","klay");
        fundraiser=fundraiserRepositoryDao.save(fundraiserVal);
        Post postVal = new Post("Poverty","Expenses for food and shelter for poors","poverty", LocalDate.of(2024, 02, 27),LocalDate.of(2024,04,20),200000.0,0.0,"incomplete",fundraiser);
        post=postRepositoryDao.save(postVal);
        Comment actualCommentVal = new Comment(donor.getId(), fundraiser.getId(), post.getId(),"This is a comment" );
        Comment actualComment = null;
        Comment expectedComment ;

        try {
            actualComment = commentService.addComment(actualCommentVal);
        } catch (CommentException e) {
            throw new RuntimeException(e);
        }

        try {
            expectedComment = commentService.getCommentById(actualComment.getId());
        } catch (CommentException e) {
            throw new RuntimeException(e);
        }



        Assertions.assertEquals(actualComment.getId(), expectedComment.getId());

        commentRepositoryDao.delete(actualComment);
        postRepositoryDao.delete(post);
        fundraiserRepositoryDao.delete(fundraiser);
        donorRepositoryDao.delete(donor);
    }


//    @Test
//    public void testGetComments() {
//        Post post;
//        Donor donor;
//        Fundraiser fundraiser;
//        Donor donorVal = new Donor("Asmithaa","asmithaa@gmail.com","string@123");
//        donor=donorRepositoryDao.save(donorVal);
//        Fundraiser fundraiserVal = new Fundraiser("klay","klay@gmail..com","klay");
//        fundraiser=fundraiserRepositoryDao.save(fundraiserVal);
//        Post postVal = new Post("Poverty","Expenses for food and shelter for poors","poverty", LocalDate.of(2024, 02, 27),LocalDate.of(2024,04,20),200000.0,0.0,"incomplete",fundraiser);
//        post=postRepositoryDao.save(postVal);
//
//
//
//        Comment commentOne, commentTwo;
//
//        commentOne = new Comment(donor.getId(), fundraiser.getId(), post.getId(),"This is a comment" );
//        commentTwo=  new Comment(donor.getId(), fundraiser.getId(), post.getId(),"This is a second comment" );
//
//        try {
//            commentService.addComment(commentOne);
//            commentService.addComment(commentTwo);
//        } catch (CommentException e) {
//            throw new RuntimeException(e);
//        }
//
//        List<Comment> actualComments ;
//        try {
//            actualComments = commentService.getComments(post.getId());
//        } catch (CommentException e) {
//            throw new RuntimeException("Error while fetching comments for post");
//        }
//
////      Assertions.assertEquals(, actualComments.size());
////        Assertions.assertTrue(actualComments.contains(commentOne));
//        Assertions.assertTrue(actualComments.contains(commentTwo));
//
//        commentRepositoryDao.delete(commentOne);
//        commentRepositoryDao.delete(commentTwo);
//        postRepositoryDao.delete(post);
//        fundraiserRepositoryDao.delete(fundraiser);
//        donorRepositoryDao.delete(donor);
//    }

}
