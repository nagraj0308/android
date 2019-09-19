package com.nagraj.roomdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button insert, selectAll, delete, selectById, selectByName;
    EditText firstName, lastName, id, age;
    RecyclerView recyclerView;
    User[] users = null;

    public static UserDatabase userDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert = findViewById(R.id.insert);
        selectAll = findViewById(R.id.selectAll);
        delete = findViewById(R.id.delete);
        selectById = findViewById(R.id.selectById);
        selectByName = findViewById(R.id.selectByName);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        id = findViewById(R.id.id);
        age = findViewById(R.id.age);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        userDatabase = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "Peoples").allowMainThreadQueries().build();

        insertSection();
        selectAllSection();
        deleteSection();
        selectByNameSection();
        selectByIdSection();
        reload();
    }

    public void insertSection() {
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    User user1 = new User();
                    user1.setFirstName(firstName.getText().toString());
                    user1.setLastName(lastName.getText().toString());
                    user1.setUid(Integer.parseInt(id.getText().toString()));
                    user1.setAge(Integer.parseInt(age.getText().toString()));
                    MainActivity.userDatabase.userDao().insertAll(user1);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Not Inserted", Toast.LENGTH_LONG).show();

                } finally {
                    reload();

                }

            }
        });


    }

    public void selectAllSection() {
        selectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reload();

            }
        });
    }

    public void deleteSection() {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    MainActivity.userDatabase.userDao().delete(Integer.parseInt(id.getText().toString()));
                    reload();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Not Deleted", Toast.LENGTH_LONG);
                }

            }
        });

    }

    public void selectByNameSection() {
        selectByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    List<User> user1 = MainActivity.userDatabase.userDao().findByName(firstName.getText().toString(), lastName.getText().toString());
                    User[] user2 = user1.toArray(new User[user1.size()]);
                    recyclerView.setAdapter(new Recycle(user2));
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Not Inserted", Toast.LENGTH_LONG).show();

                } finally {

                }

            }
        });

    }

    public void selectByIdSection() {
        selectById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    List<User> user1 = MainActivity.userDatabase.userDao().loadAllByIds(Integer.parseInt(id.getText().toString()));
                    User[] user2 = user1.toArray(new User[user1.size()]);
                    recyclerView.setAdapter(new Recycle(user2));

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Not Inserted", Toast.LENGTH_LONG).show();

                } finally {

                }
            }
        });


    }

    public void reload() {
        List<User> user = MainActivity.userDatabase.userDao().getAll();
        users = user.toArray(new User[user.size()]);
        recyclerView.setAdapter(new Recycle(users));
    }

}
