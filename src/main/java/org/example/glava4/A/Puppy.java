package org.example.glava4.A;

public class Puppy extends Dog {


    public Puppy(String name) {
        super(name);
    }


    public void whine() {
        System.out.println(getName() + " скулит.");
    }

    @Override
    public String toString() {
        return "Щенок{" + "имя='" + getName() + '\'' + '}';
    }
}

