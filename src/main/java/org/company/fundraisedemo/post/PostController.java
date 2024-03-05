package org.company.fundraisedemo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController
{
    @Autowired
    private PostService postService;

    @GetMapping("donar/getAllPosts")
    public List<Post> getAllPosts() throws PostExceptions {
        return postService.getAllPosts();
    }

    @GetMapping("donar/posts/{postId}")
    public List<Post> getPostById(@PathVariable Integer postId) throws PostExceptions {
        return postService.getPostById(postId);

    }

    @GetMapping("donor/postsByTitle/{title}")
    public List<Post> getPostsByTitle(@PathVariable String title) throws PostExceptions {
        return postService.getPostsByTitle(title);
    }

    @GetMapping("/donate/posts/sortedByDate")
    public List<Post> getPostsSortedByDate() throws PostExceptions {

        return postService.getPostsSortedByDate();
    }


    @GetMapping("donar/completedPosts")
    public List<Post> getCompletedPosts() throws PostExceptions {
        return postService.getCompletedPosts();
    }

    @GetMapping("donar/inCompletedPosts")
    public List<Post> getIncompletedPosts() throws PostExceptions {
        return postService.getIncompletePosts();
    }

    @GetMapping("donar/PostsByCategory/{category}")
    public List<Post> getPostsByCategory(@PathVariable String category) throws PostExceptions {
        return postService.getPostsByCategory(category);
    }
}
