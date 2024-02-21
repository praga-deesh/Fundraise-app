package org.company.fundraisedemo.comment;

import java.util.List;

public interface CommentService {
    public Comment addComment(Comment comment);
    public Comment deleteCommentById(Integer commentId) throws CommentException;
    public Comment updateComment(Comment comment) throws CommentException;
    public Comment getCommentById(Integer commentId) throws CommentException;
    public List<String> getComments(Integer postId) throws CommentException;





}
