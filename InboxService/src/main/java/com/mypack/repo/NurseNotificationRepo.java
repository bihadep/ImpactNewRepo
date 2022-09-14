package com.mypack.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypack.entity.NurseNotification;

@Repository
public interface NurseNotificationRepo extends JpaRepository<NurseNotification, Long>{

}
