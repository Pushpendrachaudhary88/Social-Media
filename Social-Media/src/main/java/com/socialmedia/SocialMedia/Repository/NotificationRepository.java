package com.socialmedia.SocialMedia.Repository;

import com.socialmedia.SocialMedia.Model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Integer> {
}
