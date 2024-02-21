package org.company.fundraisedemo.donar;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DonorRepositoryDao extends JpaRepository<Donor,Integer>
{
    Optional<Donor> findByEmail(String email);

}
