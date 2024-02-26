package org.company.fundraisedemo.donar;

import org.company.fundraisedemo.comment.CommentService;


import org.company.fundraisedemo.post.Post;
import org.company.fundraisedemo.post.PostExceptions;
import org.company.fundraisedemo.post.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DonorController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private DonorService donorService;

    @Autowired
    private PostService postService;


    @PostMapping("donor/createNewProfile")
    public Donor createDonor(@RequestBody Donor newDonor) throws DonorExceptions {
        return this.donorService.createDonorProfile(newDonor);
    }

    @PostMapping("donor/login")
    public Donor loginDonor(@RequestBody DonorLoginDto donorLoginDto) throws DonorExceptions {
        return this.donorService.loginDonorProfile(donorLoginDto.getEmail(), donorLoginDto.getPassword());
    }

    @GetMapping("donor")
    public Donor viewDonor(Integer id) throws DonorExceptions {
        return this.donorService.viewDonorById(id);
    }

    @PatchMapping("donor/updateName")
    public Donor updateDonorName(Integer id, String newName) throws DonorExceptions {
        return this.donorService.updateDonorNameById(id, newName);
    }

    @PatchMapping("donor/updateEmail")
    public Donor updateDonorEmail(Integer id, String newEmail) throws DonorExceptions {
        return this.donorService.updateDonorEmail(id, newEmail);
    }

    @PatchMapping("donor/updatePassword")
    public Donor updateDonorPassword(Integer id, @RequestBody DonorLoginDto donorLoginDto) throws DonorExceptions {
        return this.donorService.updateDonorPasswordById(id, donorLoginDto.getPassword());
    }

    @DeleteMapping("donor/delete")
    public String deleteDonor(Integer id) throws DonorExceptions {
        return this.donorService.deleteDonorById(id);
    }

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

}




//
//    }
//
//    @PostMapping("donor/donate")
//    public void donate()
//{
//
//}


/*@GetMapping("donar/completedPosts")
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

}*/

