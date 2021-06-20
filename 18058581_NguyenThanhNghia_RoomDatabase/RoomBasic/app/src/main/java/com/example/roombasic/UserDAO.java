package com.example.roombasic;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void addUser(User user);
    @Query("Select * from user")
    List<User> getAllUser();
}
