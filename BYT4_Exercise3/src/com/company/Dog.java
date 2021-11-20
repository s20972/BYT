package com.company;

public class Dog {
    Activity activity;

    public void setActivity(Activity activity){
        this.activity = activity;
    }
    public void changeActivity() {
        if (activity instanceof Sleeping) {
            setActivity(new Eating());
        }
        else if (activity instanceof Eating) {
            setActivity(new Playing());
        }
        else if (activity instanceof Playing) {
            setActivity(new Barking());
        }
        else if (activity instanceof Barking) {
            setActivity(new Sleeping());
        }
    }
public void toDo(){
            activity.toDo();
        }
    }

