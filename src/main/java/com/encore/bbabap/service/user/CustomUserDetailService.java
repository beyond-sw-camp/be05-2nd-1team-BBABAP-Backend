package com.encore.bbabap.service.user;


import com.encore.bbabap.api.user.request.CustomUserDetails;
import com.encore.bbabap.domain.user.User;
import com.encore.bbabap.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User userData = userRepository.findByEmail(email);

        if (userData == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }


        return new CustomUserDetails(userData);
    }


}
