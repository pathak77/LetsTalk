package com.talk.auth.Services;

import com.talk.auth.AuthRepo.UserDetailRepository;
import com.talk.auth.AuthticationEntities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    private final UserDetailRepository userDetailRepository;

    @Autowired
    UserDetailService(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user= userDetailRepository.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("User Not Found -- "+username);
        }
        return user;
    }
}
