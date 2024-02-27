package org.company.fundraisedemo.post;

import org.company.fundraisedemo.donar.DonorRepositoryDao;
import org.company.fundraisedemo.donar.DonorService;
import org.company.fundraisedemo.fundraiser.Fundraiser;
import org.company.fundraisedemo.fundraiser.FundraiserExceptions;
import org.company.fundraisedemo.fundraiser.FundraiserRepositoryDao;
import org.company.fundraisedemo.fundraiser.FundraiserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceImplTest {

    @Autowired
    PostRepositoryDao postRepositoryDao;
    @Autowired
    FundraiserRepositoryDao fundraiserRepositoryDao;
    @Autowired
    PostService postService;
    @Autowired
    FundraiserService fundraiserService;

    @Test
    void createNewPostTest() {
        Post post;
        Fundraiser fundraiser = new Fundraiser("klay","klay@gmail.com","klay");
        try {
            fundraiserService.createFundraiserProfile(fundraiser);
        } catch (FundraiserExceptions e) {
            throw new RuntimeException(e);
        }
        Post postVal = new Post("Poverty","Expenses for food and shelter for poors","poverty", LocalDate.of(2024, 02, 27),LocalDate.of(2024,04,20),200000.0,0.0,"incomplete",fundraiser);
        try {
            post = postService.addNewPost(postVal);
        } catch (PostExceptions e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(postRepositoryDao.findById(post.getId()));

    }
    @Test
    void updatePostTest() throws PostExceptions {

        Fundraiser fundraiser = new Fundraiser("john","dane@gmail.com","dami");
        try {
            fundraiserService.createFundraiserProfile(fundraiser);
        } catch (FundraiserExceptions e) {
            throw new RuntimeException(e);
        }
        Post post = new Post("Poverty", "Expenses for food and shelter for poors", "poverty", LocalDate.of(2024, 02, 27), LocalDate.of(2024, 04, 20), 200000.0, 0.0, "incomplete", fundraiser);
        postService.addNewPost(post);

        post.setTitle("Updated Title");
        post.setDescription("Updated Description");
        post.setAmountRequested(300000.0);
        try {
            Post updatedPost = postService.updatePost(post);
            assertNotNull(updatedPost);
            assertEquals("Updated Title", updatedPost.getTitle());
            assertEquals("Updated Description", updatedPost.getDescription());
            assertEquals(300000.0, updatedPost.getAmountRequested());
        } catch (PostExceptions e) {
            fail("Exception thrown while updating post: " + e.getMessage());
        }
    }
    @Test
    void deletePostByIdTest() throws PostExceptions {
        Fundraiser fundraiser = new Fundraiser("johny","dame@gmail.com","dames");
        try {
            fundraiserService.createFundraiserProfile(fundraiser);
        } catch (FundraiserExceptions e) {
            throw new RuntimeException(e);
        }
        Post post = new Post("Poverty", "Expenses for food and shelter for poors", "poverty", LocalDate.of(2024, 02, 27), LocalDate.of(2024, 04, 20), 200000.0, 0.0, "incomplete", fundraiser);
        postService.addNewPost(post);

        Integer postId = post.getId();
        try {
            Post deletedPost = postService.deletePostById(postId);
            assertNotNull(deletedPost);
            assertEquals(postId, deletedPost.getId());
        } catch (PostExceptions e) {
            fail("Exception thrown while deleting post by ID: " + e.getMessage());
        }

        assertFalse(postRepositoryDao.findById(postId).isPresent());
    }



}