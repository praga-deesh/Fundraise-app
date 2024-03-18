package org.company.fundraisedemo.fundraiser;

import org.company.fundraisedemo.donar.Donor;
import org.company.fundraisedemo.donar.DonorExceptions;
import org.company.fundraisedemo.donar.DonorLoginDto;
import org.company.fundraisedemo.donar.DonorService;
import org.company.fundraisedemo.post.Post;
import org.company.fundraisedemo.post.PostExceptions;
import org.company.fundraisedemo.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:4200")
@RestController
@CrossOrigin("http://localhost:4200/")
public class FundraiserController {

    @Autowired
    private FundraiserService fundraiserService;

//    @Autowired
//    private PostService postService;

    @PostMapping("fundraiser")
    public Fundraiser createFundraiserProfile(@RequestBody Fundraiser newFundraiser ) throws FundraiserExceptions {
        return this.fundraiserService.createFundraiserProfile(newFundraiser);
    }

    @PostMapping("fundraiser/login")
    public Fundraiser loginFundraiser(@RequestBody FundraiserLoginDto fundraiserLoginDto) throws FundraiserExceptions {
        return this.fundraiserService.loginFundraiserProfile(fundraiserLoginDto.getEmail(),fundraiserLoginDto.getPassword());
    }

    @GetMapping("fundraiser/{id}")
    public Fundraiser viewFundraiser(Integer id) throws FundraiserExceptions {
        return this.fundraiserService.viewFundraiserById(id);
    }


    @PatchMapping("fundraiser/name")
    public Fundraiser updateFundraiserName(Integer id,String newName) throws FundraiserExceptions {
        return this.fundraiserService.updateFundraiserNameById(id,newName);
    }

    @PatchMapping("fundraiser/email")
    public Fundraiser updateFundraiserEmail(Integer id,String newEmail) throws FundraiserExceptions {
        return this.fundraiserService.updateFundraiserEmail(id,newEmail);
    }

    @PatchMapping("fundraiser/password")
    public Fundraiser updateFundraiserPassword(Integer id,@RequestBody FundraiserLoginDto FundraiserLoginDto) throws FundraiserExceptions {
        return this.fundraiserService.updateFundraiserPasswordById(id,FundraiserLoginDto.getPassword());
    }

    @DeleteMapping("fundraiser")
    public String deleteFundraiser(Integer id) throws FundraiserExceptions {
        return this.fundraiserService.deleteFundraiserById(id);
    }

//    @PostMapping("fundraiser/addNewPost")
//    public Post addNewPost(@RequestBody Post newPost) throws PostExceptions {
//        return this.postService.addNewPost(newPost);
//    }
//
//    @PutMapping("fundraiser/updatePost")
//    public Post updatePost(@RequestBody Post updatePost) throws PostExceptions {
//        return this.postService.updatePost(updatePost);
//    }
//
//    @DeleteMapping("fundraiser/deletePost/{id}")
//    public Post deletePostById(Integer id) throws PostExceptions {
//        return this.postService.deletePostById(id);
//    }
//
//    @GetMapping("fundraiser/getPostByFundraiserId/{id}")
//    public List<Post> getPostsByFundraiserId(@PathVariable("id") Integer fundraiserId) throws PostExceptions {
//        return this.postService.getPostsByFundraiserId(fundraiserId);
//    }

}

