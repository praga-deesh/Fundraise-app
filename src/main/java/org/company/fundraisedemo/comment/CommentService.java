package org.company.fundraisedemo.comment;

import java.util.List;

public interface CommentService {
    public Comment addComment(Comment comment);
    public Comment deleteComment(Integer commentId) throws CommentException;
    public Comment updateComment(Comment comment) throws CommentException;
    public Comment getComment(Integer commentId) throws CommentException;
    public List<String> getComments(Integer postId);





}
