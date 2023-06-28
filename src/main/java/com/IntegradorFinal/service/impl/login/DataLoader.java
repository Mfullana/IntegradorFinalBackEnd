package com.IntegradorFinal.service.impl.login;


import com.IntegradorFinal.persistence.entities.login.AppRoles;
import com.IntegradorFinal.persistence.entities.login.AppUser;
import com.IntegradorFinal.persistence.repository.login.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("admin"); //Genera el password encriptado
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashedPassword2 = passwordEncoder2.encode("user");
        userRepository.save(new AppUser("Administrador", "admin", "admin@digital.com", hashedPassword, AppRoles.ADMIN));
        userRepository.save(new AppUser("Usuario", "user", "user@digital.com", hashedPassword2, AppRoles.USER));
    }
}
