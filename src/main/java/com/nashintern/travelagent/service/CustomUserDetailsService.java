package com.nashintern.travelagent.service;

import com.nashintern.travelagent.model.CustomUserDetails;
import com.nashintern.travelagent.model.User;
import com.nashintern.travelagent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
//        UserDetails userDetails = User.withUsername(user.getEmail())
//                                    .password(user.getPassword())
//                                    .authorities("USER").build();

        return new CustomUserDetails(user);
    }

    public User get(int id){
        return repository.findById((long) id).get();
    }

    public void save(User user){
        repository.save(user);
    }

}
