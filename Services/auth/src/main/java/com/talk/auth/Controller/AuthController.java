package com.talk.auth.Controller;

import com.talk.auth.AuthRepo.UserDetailRepository;
import com.talk.auth.AuthticationEntities.User;
import com.talk.auth.Dto.LoginRequest;
import com.talk.auth.Dto.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller("/auth")
class AuthController{

    @Autowired
    private UserDetailRepository userDetailRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PutMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {

        Authentication UserNamePasswordAuthentication =
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword());

        Authentication authenticationRequest = this.authenticationManager.authenticate(UserNamePasswordAuthentication);

        if(authenticationRequest.isAuthenticated()) {
            User user = (User) authenticationRequest.getPrincipal();

            if(!user.isEnabled()){
                return new ResponseEntity<>("Authentication Failed- account deactivated", HttpStatus.UNAUTHORIZED);
            }
            return new ResponseEntity<>("Authentication Successful", HttpStatus.OK);
        }

        return new ResponseEntity<>("Authentication Failed", HttpStatus.UNAUTHORIZED);
    }

    @PutMapping("/register")
    private ResponseEntity<String> register(@RequestBody RegistrationRequest registrationRequest) {

    }
}