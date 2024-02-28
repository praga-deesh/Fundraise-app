package org.company.fundraisedemo.post;

import org.company.fundraisedemo.donar.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositoryDao extends JpaRepository<Post,Integer> {

    Post findPostByDonationAccountId(String accountId);
}
