package org.company.fundraisedemo.fundraiser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FundraiserRepositoryDao extends JpaRepository<Fundraiser,Integer> {
    Optional<Fundraiser> findByEmail(String email);
    Optional<Fundraiser> findById(Integer id);

}
