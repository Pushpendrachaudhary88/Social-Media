package com.socialmedia.SocialMedia;

import com.socialmedia.SocialMedia.Model.Notification;
import com.socialmedia.SocialMedia.Model.Post;
import com.socialmedia.SocialMedia.Model.User;
import com.socialmedia.SocialMedia.Repository.NotificationRepository;
import com.socialmedia.SocialMedia.Repository.PostRepository;
import com.socialmedia.SocialMedia.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    NotificationRepository notificationRepository;


    public String addUser(User user) {
        userRepository.save(user);
        return "User added Successfully";
    }


    public String addPost(Post post, int userId) {
        User user = userRepository.findById(userId).get();
        user.getPostList().add(post);
        post.setUser(user);
        userRepository.save(user);
        return "Post Added Successfully";
    }

    public String likePost(int postId) {
       Post post = postRepository.findById(postId).get();
       post.setLikes(post.getLikes()+1);
       Notification notification = new Notification();
       notification.setId(post.getId());
       notification.setDate(post.getDate());
       postRepository.save(post);
       notificationRepository.save(notification);
       return "You like a post ";


    }

    public  int max(int userId) {
        List<Post> posters =postRepository.findAll();
        int ans=0;
        for(Post poster : posters){
            if(poster.getUser().getId()==userId){
                List<Notification> notificationList = notificationRepository.findAll();
                for(Notification notification :notificationList){
                    if(notification.getId()==poster.getId()){
                        ans++;
                    }

                }
            }
        }
        return ans;
    }
}
