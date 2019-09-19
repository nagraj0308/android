package com.nagraj.roomdemo;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM Peoples")
    List<User> getAll();

    @Query("SELECT * FROM Peoples WHERE uid =:userIds")
    List<User> loadAllByIds(int userIds);

    @Query("SELECT * FROM Peoples WHERE first_name = :first AND " + "last_name =:last LIMIT 1")
    List<User> findByName(String first, String last);

    @Insert
    void insertAll(User... users);

    @Query("DELETE FROM Peoples WHERE uid = :userId")
    void delete(int userId);
}
