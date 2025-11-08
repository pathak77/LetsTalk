package com.talk.auth.AuthticationEntities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;


@Table(name = "Authority")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue
    private long authorityId;

    @Column(nullable = false)
    private String role;


    @Override
    public String getAuthority() {
        return role;
    }
}