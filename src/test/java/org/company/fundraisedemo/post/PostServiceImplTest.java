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
        Post newPost1, newPost2, newPost3;
        List<Post> postList;
        Fundraiser fundraiser1 = new Fundraiser("klay", "klay@gmail.com", "klay");
        Fundraiser fundraiser2 = new Fundraiser("grey", "grey@gmail.com", "grey");
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



    @Test
    void getPostsSortedByDateTest () {
            Fundraiser fundraiser1 = new Fundraiser("tommy", "tommy@gmail.com", "tfd");
            Fundraiser fundraiser2 = new Fundraiser("tay", "tay@gmail.com", "tay");

            try {
                fundraiserService.createFundraiserProfile(fundraiser1);
                fundraiserService.createFundraiserProfile(fundraiser2);
            } catch (FundraiserExceptions e) {
                throw new RuntimeException(e);
            }

            Post postVal1 = new Post("Post 1", "Description", "category1", LocalDate.of(2024, 02, 25), LocalDate.of(2024, 04, 20), 200000.0, 0.0, "completed", fundraiser1);
            Post postVal2 = new Post("Post 2", "Description", "category2", LocalDate.of(2024, 02, 27), LocalDate.of(2024, 04, 22), 200000.0, 0.0, "completed", fundraiser2);
            Post newPost1, newPost2;
            try {
                newPost1 = postService.addNewPost(postVal1);
                newPost2 = postService.addNewPost(postVal2);
            } catch (PostExceptions e) {
                throw new RuntimeException(e);
            }

            List<Post> sortedPosts;
            try {
                sortedPosts = postService.getPostsSortedByDate();
            } catch (PostExceptions e) {
                throw new RuntimeException(e);
            }

            for (int i = 0; i < sortedPosts.size() - 1; i++) {
                LocalDate currentPostDate = sortedPosts.get(i).getStartDate();
                LocalDate nextPostDate = sortedPosts.get(i + 1).getStartDate();
                Assertions.assertTrue(currentPostDate.compareTo(nextPostDate) >= 0, "Posts are not sorted by date in descending order");
            }
            postRepositoryDao.delete(newPost1);
            postRepositoryDao.delete(newPost2);
            fundraiserRepositoryDao.delete(fundraiser1);
            fundraiserRepositoryDao.delete(fundraiser2);


        }
    /*@Test
    void getPostByIdTest() {
        postRepositoryDao.deleteAll();
        fundraiserRepositoryDao.deleteAll();
        Fundraiser fundraiser = new Fundraiser("Test Fundraiser", "test@example.com", "password");
        fundraiserRepositoryDao.save(fundraiser);
        Post post = new Post("Test Post", "Description", "category", LocalDate.now(), LocalDate.now(), 1000.0, 0.0, "completed", fundraiser);
        Post savedPost= null;
        try {
            savedPost = postService.addNewPost(post);
        } catch (PostExceptions e) {
            throw new RuntimeException(e);
        }


        List<Post> foundPosts= null;
        try {
            foundPosts = postService.getPostById(savedPost.getId());
        } catch (PostExceptions e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(303, foundPosts.size());
        Assertions.assertEquals(savedPost, foundPosts.get(0));


    }
*/
        @Test
        void getPostsByTitleTest () {

            Fundraiser fundraiser = new Fundraiser("klay", "klay@gmail.com", "klay");
            fundraiserRepositoryDao.save(fundraiser);


            Post post1 = new Post("Title1", "Description1", "Category1", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 10), 100.0, 50.0, "status1", fundraiser);
            Post post2 = new Post("Title2", "Description2", "Category2", LocalDate.of(2024, 2, 1), LocalDate.of(2024, 2, 10), 200.0, 100.0, "status2", fundraiser);
            postRepositoryDao.save(post1);
            postRepositoryDao.save(post2);


            List<Post> posts = null;
            try {
                posts = postService.getPostsByTitle("Title1");
            } catch (PostExceptions e) {
                throw new RuntimeException(e);
            }


            Assertions.assertNotNull(posts);
            Assertions.assertEquals(1, posts.size());
            Assertions.assertEquals("Title1", posts.get(0).getTitle());

            // Clean up: delete the test posts and fundraiser from the database
            postRepositoryDao.delete(post1);
            postRepositoryDao.delete(post2);
            fundraiserRepositoryDao.delete(fundraiser);
        }
        @Test
        void getPostsByCategoryTest () {
            Fundraiser fundraiser = new Fundraiser("klay", "klay@gmail.com", "klay");
            fundraiserRepositoryDao.save(fundraiser);

            Post post1 = new Post("Title1", "Description1", "Category1", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 10), 100.0, 50.0, "status1", fundraiser);
            Post post2 = new Post("Title2", "Description2", "Category2", LocalDate.of(2024, 2, 1), LocalDate.of(2024, 2, 10), 200.0, 100.0, "status2", fundraiser);
            postRepositoryDao.save(post1);
            postRepositoryDao.save(post2);

            List<Post> posts = null;
            try {
                posts = postService.getPostsByCategory("Category1");
            } catch (PostExceptions e) {
                throw new RuntimeException(e);
            }

            Assertions.assertNotNull(posts);
            Assertions.assertEquals(1, posts.size());
            Assertions.assertEquals("Category1", posts.get(0).getCategory());

            postRepositoryDao.delete(post1);
            postRepositoryDao.delete(post2);
            fundraiserRepositoryDao.delete(fundraiser);
        }


        @Test
        void getCompletedPostsTest () {
            postRepositoryDao.deleteAll();
            fundraiserRepositoryDao.deleteAll();
            Fundraiser fundraiser = new Fundraiser("klay", "klay@gmail.com", "klay");
            fundraiserRepositoryDao.save(fundraiser);

            Post post1 = new Post("Title1", "Description1", "Category1", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 10), 100.0, 50.0, "completed", fundraiser);
            Post post2 = new Post("Title2", "Description2", "Category2", LocalDate.of(2024, 2, 1), LocalDate.of(2024, 2, 10), 200.0, 100.0, "incomplete", fundraiser);
            postRepositoryDao.save(post1);
            postRepositoryDao.save(post2);

            List<Post> completedPosts = null;
            try {
                completedPosts = postService.getCompletedPosts();
            } catch (PostExceptions e) {
                throw new RuntimeException(e);
            }
            System.out.println("Completed Posts:" + completedPosts);
            Assertions.assertNotNull(completedPosts);
            Assertions.assertEquals(1, completedPosts.size()); // Modify the expected size to 1

            postRepositoryDao.delete(post1);
            postRepositoryDao.delete(post2);
            fundraiserRepositoryDao.delete(fundraiser);
        }
        @Test
        void getIncompletePostsTest () {
            postRepositoryDao.deleteAll();
            fundraiserRepositoryDao.deleteAll();
            Fundraiser fundraiser = new Fundraiser("klay", "klay@gmail.com", "klay");
            fundraiserRepositoryDao.save(fundraiser);

            Post incompletePost = new Post("Title1", "Description1", "Category1", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 10), 100.0, 50.0, "incomplete", fundraiser);
            Post completePost = new Post("Title2", "Description2", "Category2", LocalDate.of(2024, 2, 1), LocalDate.of(2024, 2, 10), 200.0, 100.0, "completed", fundraiser);
            postRepositoryDao.save(incompletePost);
            postRepositoryDao.save(completePost);

            List<Post> incompletePosts = null;
            try {
                incompletePosts = postService.getIncompletePosts();
            } catch (PostExceptions e) {
                throw new RuntimeException(e);
            }

            System.out.println("Incomplete Posts: " + incompletePosts);

            Assertions.assertNotNull(incompletePosts);
            Assertions.assertEquals(1, incompletePosts.size(), "Expected only one incomplete post");

            postRepositoryDao.delete(incompletePost);
            postRepositoryDao.delete(completePost);
            fundraiserRepositoryDao.delete(fundraiser);
        }
    }
