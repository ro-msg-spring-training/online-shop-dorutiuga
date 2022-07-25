package ro.msg.learning.shop.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ro.msg.learning.shop.entity.Customer;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class CustomerDetails implements UserDetails {
    private Customer customer = null;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public CustomerDetails(Optional<Customer> optionalCustomer) {


        if (optionalCustomer.isPresent()) {
            this.customer = optionalCustomer.get();
            this.customer.setPassword(passwordEncoder.encode(this.customer.getPassword()));
        } else
            this.customer = null;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return this.customer.getPassword();
    }

    @Override
    public String getUsername() {
        return this.customer.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
