package entity;

public abstract class Person {
    protected String name;
    
    protected String mail;
    
    public Person() {}

    public Person(String name,String mail) {
        this.name = name;
        this.mail = mail;
    }

    public abstract void displayRole();
}