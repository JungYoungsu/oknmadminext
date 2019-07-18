package com.kcb.oknmadminext.security.jwt;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.kcb.oknmadminext.biz.user.User;
import com.kcb.oknmadminext.biz.user.UserRepository;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) {
        logger.info("load user...");
        Optional<User> user = Optional.ofNullable(userRepository.findOne(userId));
        if (user.isPresent()) {
            logger.info("user:: {}", user.get().getId());
            return getJwtUser(user.get());
        } else {
            logger.info("user not found");
            //throw new UsernameNotFoundException(String.format("User not found with username '%s'.", username));
            return null;
        }
    }


    public JwtUser getJwtUser(User user) {
    	List<SimpleGrantedAuthority> list = new ArrayList<>();
    	list.add(new SimpleGrantedAuthority(user.getRole()));
    	
        return new JwtUser(
        		user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                list,
                true,
                null
        );
    }
}
