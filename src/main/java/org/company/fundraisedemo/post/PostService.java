package org.company.fundraisedemo.post;

import java.util.List;

public interface PostService {

    Post addNewPost(Post post)throws PostExceptions;

    Post updatePost(Post post) throws PostExceptions;

    Post deletePostById(Integer id)throws PostExceptions;
    List<Post> getAllPosts() throws PostExceptions;
    List<Post> getPostsByFundraiserId(Integer id) throws PostExceptions;
    List<Post> getCompletedPosts()throws PostExceptions;
    List<Post> getIncompletePosts()throws PostExceptions;

    List<Post> getPostsByCategory(String category)throws PostExceptions;

    List<Post> getPostsByTitle(String title) throws PostExceptions;

    List<Post> getPostById(Integer postId) throws PostExceptions;






}
