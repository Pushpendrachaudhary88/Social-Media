package com.socialmedia.SocialMedia.Repository;

import com.socialmedia.SocialMedia.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
}
