package com.company;

public class DayOfDog {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Activity activity = new Sleeping();
        dog.setActivity(activity);

        for (int i = 0; i < 10;i++ ){
            dog.toDo();
            dog.changeActivity();
        }

    }
}
