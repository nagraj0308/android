package com.example.draggerdemo;

import dagger.Component;

@Component (modules = {WheelModule.class,PetrolEngine.class,DieselEngine.class})
public interface CarComponent {
    Car getCar();
    void inject(MainActivity mainActivity);
}
