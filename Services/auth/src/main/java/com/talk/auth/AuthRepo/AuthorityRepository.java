package com.talk.auth.AuthRepo;

import com.talk.auth.AuthticationEntities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findByRole(String role);
}