package org.company.fundraisedemo.post;

import org.company.fundraisedemo.donar.DonorRepositoryDao;
import org.company.fundraisedemo.donar.DonorService;
import org.company.fundraisedemo.fundraiser.Fundraiser;
import org.company.fundraisedemo.fundraiser.FundraiserExceptions;
import org.company.fundraisedemo.fundraiser.FundraiserRepositoryDao;
import org.company.fundraisedemo.fundraiser.FundraiserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

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
        Post postVal = new Post("Poverty Help","Expenses for food and shelter for poors","poverty", LocalDate.of(2024, 02, 27),LocalDate.of(2024,04,20),200000.0,0.0,"incomplete",fundraiser);
        try {
            post = postService.addNewPost(postVal);
        } catch (PostExceptions e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(postRepositoryDao.findById(post.getId()));

        postRepositoryDao.delete(post);
        fundraiserRepositoryDao.delete(fundraiser);

    }

    @Test
    void updatePostTest() {
        Post post,newPost;
        Fundraiser fundraiser = new Fundraiser("klay","klay@gmail.com","klay");
        try {
            fundraiserService.createFundraiserProfile(fundraiser);
        } catch (FundraiserExceptions e) {
            throw new RuntimeException(e);
        }
        Post postVal = new Post("Poverty","Expenses for food and shelter for poors","poverty", LocalDate.of(2024, 02, 27),LocalDate.of(2024,04,20),200000.0,0.0,"incomplete",fundraiser);
        try {
            newPost = postService.addNewPost(postVal);
        } catch (PostExceptions e) {
            throw new RuntimeException(e);
        }
        Post updatePost = new Post(newPost.getId(),"Poverty Help","Expenses for food,shelter,clothes,education for poor","poverty", LocalDate.of(2024, 02, 27),LocalDate.of(2024,04,20),200000.0,0.0,"incomplete",fundraiser);
        try {
            post = postService.updatePost(updatePost);
        } catch (PostExceptions e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals("Expenses for food,shelter,clothes,education for poor", post.getDescription());

        postRepositoryDao.delete(post);
        fundraiserRepositoryDao.delete(fundraiser);
    }
    @Test
    void deletePostByIdTest() {
        Post deletedPost,newPost;
        Fundraiser fundraiser = new Fundraiser("klay", "klay@gmail.com", "klay");
        //create fundraser part
        try {
            fundraiserService.createFundraiserProfile(fundraiser);
        } catch (FundraiserExceptions e) {
            throw new RuntimeException(e);
        }
        Post postVal = new Post("Poverty Help", "Expenses for food and shelter for poors", "poverty", LocalDate.of(2024, 02, 27), LocalDate.of(2024, 04, 20), 200000.0, 0.0, "incomplete", fundraiser);
        //create post part
        try {
            newPost = postService.addNewPost(postVal);
        } catch (PostExceptions e) {
            throw new RuntimeException(e);
        }
        //delete part
        try {
            deletedPost = postService.deletePostById(newPost.getId());
        } catch (PostExceptions e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(newPost.getId(), deletedPost.getId());

        fundraiserRepositoryDao.delete(fundraiser);

    }

    @Test
    void getPostByFundraiserIdTest() {
        Post newPost1,newPost2,newPost3;
        List<Post> postList;
        Fundraiser fundraiser1 = new Fundraiser("klay", "klay@gmail.com", "klay");
        Fundraiser fundraiser2 = new Fundraiser("grey","grey@gmail.com","grey");
        //create fundraser part
        try {
            fundraiserService.createFundraiserProfile(fundraiser1);
            fundraiserService.createFundraiserProfile(fundraiser2);
        } catch (FundraiserExceptions e) {
            throw new RuntimeException(e);
        }
        Post postVal1 = new Post("Poverty Help", "Expenses for food and shelter for poors", "poverty", LocalDate.of(2024, 02, 27), LocalDate.of(2024, 04, 20), 200000.0, 0.0, "incomplete", fundraiser1);
        Post postVal2 = new Post("Medical Help", "Sponser for heart surgery", "medical", LocalDate.of(2024, 02, 27), LocalDate.of(2024, 03, 20), 400000.0, 0.0, "incomplete", fundraiser1);
        Post postVal3 = new Post("Orphan Help", "Expenses for orphan education", "education", LocalDate.of(2024, 02, 27), LocalDate.of(2024, 05, 20), 600000.0, 0.0, "incomplete", fundraiser2);

        //create post part
        try {
            newPost1 = postService.addNewPost(postVal1);
            newPost2 = postService.addNewPost(postVal2);
            newPost3 = postService.addNewPost(postVal3);
        } catch (PostExceptions e) {
            throw new RuntimeException(e);
        }
        try {
            postList = postService.getPostsByFundraiserId(fundraiser1.getId());
        } catch (PostExceptions e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(postList.contains(newPost1));
        Assertions.assertNotNull(postList.contains(newPost2));
        Assertions.assertNotNull(!postList.contains(newPost3));

        postRepositoryDao.delete(newPost1);
        postRepositoryDao.delete(newPost2);
        postRepositoryDao.delete(newPost3);
        fundraiserRepositoryDao.delete(fundraiser1);
        fundraiserRepositoryDao.delete(fundraiser2);


    }










}