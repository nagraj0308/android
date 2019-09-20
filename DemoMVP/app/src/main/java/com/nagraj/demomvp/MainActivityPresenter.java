package com.nagraj.demomvp;

public class MainActivityPresenter {
    private User user;

    private View1 view1;

    public MainActivityPresenter(View1 view1) {
        this.user = new User();
        this.view1 = view1;
    }

    public void updateFullName(String fullName){
        user.setFullName(fullName);
        view1.updateUserInfoTextView(user.newString());

    }

    public void updateEmail(String email){
        user.setEmail(email);
        view1.updateUserInfoTextView(user.newString());

    }

    public interface View1{

        void updateUserInfoTextView(String info);

    }
}
