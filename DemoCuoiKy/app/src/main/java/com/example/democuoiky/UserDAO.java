package com.example.democuoiky;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void addName(User user);
    @Query("Select * from diachi")
    List<User> getAllUser();
    @Delete
    void deleteUser(User user);

    @Update
    void updateUser(User user);
}
