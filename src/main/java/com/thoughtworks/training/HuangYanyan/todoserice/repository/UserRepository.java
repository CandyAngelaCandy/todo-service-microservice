package com.thoughtworks.training.HuangYanyan.todoserice.repository;

import com.thoughtworks.training.HuangYanyan.todoserice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
