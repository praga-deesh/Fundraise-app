package org.company.fundraisedemo.comment;

import org.springframework.beans.factory.annotation.Autowired;

import javax.security.auth.login.AccountException;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Optional;

public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepositoryDao commentRepositoryDao;





    @Override
    public Comment addComment(Comment comment) {
        return commentRepositoryDao.save(comment);
    }

    @Override
    public Comment deleteComment(Integer commentId) throws CommentException{
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
    public Comment getComment(Integer commentId) throws  CommentException{
        Optional<Comment> commentOpt=this.commentRepositoryDao.findById(commentId);
        if(!commentOpt.isPresent())
            throw new CommentException("Comment doesn't exits:");


        return commentOpt.get();

    }

    @Override
    public List<String> getComments(Integer postId) {
        return null;
    }


}