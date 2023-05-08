package com.socialmedia.SocialMedia;

import com.socialmedia.SocialMedia.Model.Post;
import com.socialmedia.SocialMedia.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class Controller {

    @Autowired
    Service service;

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
        return service.addUser(user);

    }
    @PostMapping("/addPost/{userId}")
    public String addPost(@RequestBody Post post, @PathVariable int userId){
       return service.addPost(post,userId);
    }

   @PutMapping("/likePost/{postId}")
    public String likePost(@PathVariable int postId){
      return service.likePost(postId);
   }

   @GetMapping("/maximumnotification/{userId}")
    public int max(@PathVariable int userId) {
       return service.max(userId);
   }


}
