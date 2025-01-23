package com.tekarch.DataStoreMS.Repositories;
import com.tekarch.DataStoreMS.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}

