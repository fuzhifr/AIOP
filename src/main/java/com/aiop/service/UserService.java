package com.aiop.service;  
  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;  
import com.aiop.dao.UserDaoI;  
import com.aiop.model.User;  
@Service("userService")  
@Transactional  
public class UserService    
{     
    //userdao  
    @Autowired  
    private UserDaoI<User> userDao;  
      
    public void addUser(User user)  
    {  
        userDao.save(user);  
    }  
  
}  