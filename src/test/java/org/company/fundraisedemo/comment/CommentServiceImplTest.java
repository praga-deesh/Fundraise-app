package org.company.fundraisedemo.comment;


import org.company.fundraisedemo.donar.Donor;
import org.company.fundraisedemo.donar.DonorExceptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.print.attribute.standard.DocumentName;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

public class CommentServiceImplTest {
  

  @Autowired
    private CommentRepositoryDao commentRepositoryDao;

    @Autowired
    private CommentService commentService;
     


    @Test
    void addComment(Comment comment)  {

      Comment actualComment=new Comment(1,3,5,"good");
      Comment expectedComment=null;

      try {
        actualComment = commentService.addComment(actualComment);
    } catch (CommentException e) {
        throw new RuntimeException(e);
    }

    expectedComment = commentRepositoryDao.findById(actualComment.getId()).get();
    Assertions.assertEquals(expectedComment.getId(), actualComment.getId());
    commentRepositoryDao.delete(actualComment);
    }



     
    


}
