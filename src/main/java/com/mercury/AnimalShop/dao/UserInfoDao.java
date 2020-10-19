package com.mercury.AnimalShop.dao;

import com.mercury.AnimalShop.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoDao extends JpaRepository<UserInfo, Long> {
    public UserInfo findByUserId(long id);
}
