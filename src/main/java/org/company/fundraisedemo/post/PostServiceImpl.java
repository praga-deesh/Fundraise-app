package org.company.fundraisedemo.post;

import org.company.fundraisedemo.fundraiser.FundraiserRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepositoryDao postRepositoryDao;

    @Autowired
    private FundraiserRepositoryDao fundraiserRepositoryDao;

    @Override
    public Post addNewPost(Post post) {
        return this.postRepositoryDao.save(post);
    }

    @Override
    public Post updatePost(Post updatePost) throws PostExceptions{
        Optional<Post> postOpt=this.postRepositoryDao.findById(updatePost.getId());
        if(!postOpt.isPresent())
            throw new PostExceptions("Post doesn't exits:"+updatePost.getId());
        this.postRepositoryDao.save(updatePost);
        return updatePost;
    }

    @Override
    public Post deletePostById(Integer id) throws PostExceptions  {
        Optional<Post> postOpt=this.postRepositoryDao.findById(id);
        if(!postOpt.isPresent())
            throw new PostExceptions("Post doesn't exists:"+id);
        this.postRepositoryDao.deleteById(id);
        return postOpt.get();
    }

    @Override
    public List<Post> getAllPosts() {
        return this.postRepositoryDao.findAll();
    }

    @Override
    public List<Post> getPostsByFundraiserId(Integer fundraiserId) throws PostExceptions {
//        List<Post> postList=this.postRepositoryDao.findAll();
//        postList = (List<Post>) postList.stream().map((p)->p.getFundraiser().getId().equals(fundraiserId));
//        if(postList.isEmpty())
//            throw new PostExceptions("Post doesn't exists:"+fundraiserId);
//        return postList;
        List<Post> postList = postRepositoryDao.findAll();
        postList = postList.stream().filter((p)->p.getFundraiser().getId().equals(fundraiserId)).toList();
        return postList;

    }

    @Override
    public List<Post> getCompletedPosts() throws PostExceptions {
        List<Post> postList=this.postRepositoryDao.findAll();
        postList = (List<Post>) postList.stream().filter((p)->p.getStatus().equals("completed"));
        if(postList.isEmpty())
            throw new PostExceptions("No Posts have Completed Status");
        return postList;
    }

    @Override
    public List<Post> getIncompletePosts() throws PostExceptions {
        List<Post> postList=this.postRepositoryDao.findAll();
        postList = (List<Post>) postList.stream().filter((p)->p.getStatus().equals("incomplete"));
        if(postList.isEmpty())
            throw new PostExceptions("No Posts have InCompleted Status");
        return postList;
    }

    @Override
    public List<Post> getPostsByCategory(String category) throws PostExceptions {
        List<Post> postList=this.postRepositoryDao.findAll();
        postList = (List<Post>) postList.stream().filter((p)->p.getCategory().equals(category));
        if(postList.isEmpty())
            throw new PostExceptions("No Posts are in this Category");
        return postList;
    }
}
