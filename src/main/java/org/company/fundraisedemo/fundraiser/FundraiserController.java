package org.company.fundraisedemo.fundraiser;

import org.company.fundraisedemo.donar.Donor;
import org.company.fundraisedemo.donar.DonorService;
import org.company.fundraisedemo.post.Post;
import org.company.fundraisedemo.post.PostExceptions;
import org.company.fundraisedemo.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FundraiserController {

    @Autowired
    private FundraiserService fundraiserService;

    @Autowired
    private PostService postService;

    @PostMapping("fundraisers")
    public Fundraiser createFundraiser(@RequestBody Fundraiser newFundraiser ) {
        return this.fundraiserService.createFunraiser(newFundraiser);
    }

    @PostMapping("fundraiser/addNewPost")
    public Post addNewPost(@RequestBody Post newPost) throws PostExceptions {
        return this.postService.addNewPost(newPost);
    }

    @PutMapping("fundraiser/updatePost")
    public Post updatePost(@RequestBody Post updatePost) throws PostExceptions {
        return this.postService.updatePost(updatePost);
    }

    @DeleteMapping("fundraiser/deletePost/{id}")
    public Post deletePostById(Integer id) throws PostExceptions {
        return this.postService.deletePostById(id);
    }

    @GetMapping("fundraiser/getPostByFundraiserId/{id}")
    public List<Post> getPostsByFundraiserId(@PathVariable("id") Integer fundraiserId) throws PostExceptions {
        return this.postService.getPostsByFundraiserId(fundraiserId);
    }

}
