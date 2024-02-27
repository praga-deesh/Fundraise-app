package org.company.fundraisedemo.post;

import org.company.fundraisedemo.fundraiser.FundraiserRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{
    //test1
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
    public List<Post> getAllPosts() throws PostExceptions{
        return this.postRepositoryDao.findAll();
    }

    @Override
    public List<Post> getPostsByFundraiserId(Integer fundraiserId) throws PostExceptions {
        List<Post> postList = postRepositoryDao.findAll();
        postList = postList.stream().filter((p)->p.getFundraiser().getId().equals(fundraiserId)).toList();
        if(postList.isEmpty())
            throw new PostExceptions("Post doesn't exists:"+fundraiserId);
        return postList;

    }

    @Override
    public List<Post> getCompletedPosts() throws PostExceptions {
        List<Post> postList=this.postRepositoryDao.findAll();
        postList = postList.stream().filter((p)->p.getStatus().equals("completed")).toList();
        if(postList.isEmpty())
            throw new PostExceptions("No Posts have Completed Status");
        return postList;
    }

    @Override
    public List<Post> getIncompletePosts() throws PostExceptions {
        List<Post> postList=this.postRepositoryDao.findAll();
        postList = postList.stream().filter((p)->p.getStatus().equals("incomplete")).toList();
        if(postList.isEmpty())
            throw new PostExceptions("No Posts have InCompleted Status");
        return postList;
    }

    @Override
    public List<Post> getPostsByCategory(String category) throws PostExceptions {
        List<Post> postList=this.postRepositoryDao.findAll();
        postList = postList.stream().filter((p)->p.getCategory().equals(category)).toList();
        if(postList.isEmpty())
            throw new PostExceptions("No Posts are in this Category");
        return postList;
    }

    @Override
    public List<Post> getPostsByTitle(String title) throws PostExceptions {
        List<Post> postList = postRepositoryDao.findAll();
        List<Post> filteredList = postList.stream().filter(post -> post.getTitle().equalsIgnoreCase(title)).toList();
        if (postList.isEmpty())
            throw new PostExceptions("No Posts found with title containing: " + title);
        return filteredList;
    }



    @Override
    public List<Post> getPostById(Integer postId) throws PostExceptions {
         List<Post> allPost=postRepositoryDao.findAll();
         List<Post> result=allPost.stream().filter(post->post.getId().equals(postId)).toList();
         if(result.isEmpty()){
             throw new PostExceptions("Post Not Found:"+postId);
         }
        return result;
    }

    @Override
    public List<Post> getPostsSortedByDate() throws PostExceptions {
        List<Post> sortedPosts=postRepositoryDao.findAll(Sort.by(Sort.Direction.DESC,"startDate"));
        if(sortedPosts.isEmpty()){
            throw new PostExceptions("No post found");
        }
        return sortedPosts;
    }


}
