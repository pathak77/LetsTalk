package com.talk.auth.AuthRepo;

import com.talk.auth.AuthticationEntities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface UserDetailRepository extends JpaRepository<User, Long> {

    User findByEmail(String username);
}
