package org.company.fundraisedemo.comment;

import org.company.fundraisedemo.post.Post;
import org.company.fundraisedemo.post.PostExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountException;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepositoryDao commentRepositoryDao;
    @Override
    public Comment addComment(Comment comment) throws CommentException{
        return commentRepositoryDao.save(comment);
    }

    @Override
    public Comment deleteCommentById(Integer commentId) throws CommentException{
        Optional<Comment> commentOpt=this.commentRepositoryDao.findById(commentId);
        if(!commentOpt.isPresent())
            throw new CommentException("Comment doesn't exits:");


        commentRepositoryDao.deleteById(commentId);
        return commentOpt.get();

    }

    @Override
    public Comment updateComment(Comment comment) throws CommentException{
        Optional<Comment> commentOpt=this.commentRepositoryDao.findById(comment.getId());
        if(!commentOpt.isPresent())
            throw new CommentException("Comment doesn't exits:");

        this.commentRepositoryDao.save(comment);
        return commentOpt.get();
    }

    @Override
    public Comment getCommentById(Integer commentId) throws  CommentException{
        Optional<Comment> commentOpt=this.commentRepositoryDao.findById(commentId);
        if(!commentOpt.isPresent())
            throw new CommentException("Comment doesn't exits:");


        return commentOpt.get();

    }

    @Override
    public List<Comment> getComments(Integer postId) throws CommentException {
        if (postId == null) {
            throw new CommentException("Post ID cannot be null");
        }
        List<Comment> commentList = this.commentRepositoryDao.findAll();

        commentList = commentList.stream().filter(p -> p.getPostId().equals(postId)).toList();

        if(commentList.isEmpty())
            throw new CommentException("Post doesn't exists:");
        return commentList;
    }

}