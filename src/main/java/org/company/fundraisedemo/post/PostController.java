package org.company.fundraisedemo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:4200/")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("post")
    public Post addNewPost(@RequestBody Post newPost) throws PostExceptions {
        return this.postService.addNewPost(newPost);
    }

    @PutMapping("post")
    public Post updatePost(@RequestBody Post updatePost) throws PostExceptions {
        return this.postService.updatePost(updatePost);
    }

    @DeleteMapping("post/{id}")
    public Post deletePostById(Integer id) throws PostExceptions {
        return this.postService.deletePostById(id);
    }

    @GetMapping("post/donationAccountId")
    public Post getPostByAccountId(String accountId) throws PostExceptions {
        return this.postService.getPostByAccountId(accountId);
    }

    @GetMapping("post/fundraiser/{id}")
    public List<Post> getPostsByFundraiserId(@PathVariable("id") Integer fundraiserId) throws PostExceptions {
        return this.postService.getPostsByFundraiserId(fundraiserId);
    }

        @GetMapping("AllPosts")
        public List<Post> getAllPosts () throws PostExceptions {
            return postService.getAllPosts();
        }

        @GetMapping("post/{postId}")
        public Post getPostById (@PathVariable Integer postId) throws PostExceptions {
            return postService.getPostById(postId);

        }

        @GetMapping("postByTitle/{title}")
        public List<Post> getPostsByTitle (@PathVariable String title) throws PostExceptions {
            return postService.getPostsByTitle(title);
        }

        @GetMapping("posts/newestFirst") //sortedByDate
        public List<Post> getPostsSortedByDate () throws PostExceptions {

            return postService.getPostsSortedByDate();
        }


        @GetMapping("posts/complete")
        public List<Post> getCompletedPosts () throws PostExceptions {
            return postService.getCompletedPosts();
        }

        @GetMapping("posts/incomplete")
        public List<Post> getIncompletedPosts () throws PostExceptions {
            return postService.getIncompletePosts();
        }

        @GetMapping("posts/{category}")
        public List<Post> getPostsByCategory (@PathVariable String category) throws PostExceptions {
            return postService.getPostsByCategory(category);
        }
}
