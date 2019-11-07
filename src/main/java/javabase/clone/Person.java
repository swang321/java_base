package javabase.clone;

import java.io.Serializable;

/**
 * @Author whh
 */
public class Person implements Cloneable, Serializable {

    private static final long serialVersionUID = 253128624833938498L;
    private String name;

    private Email email;


    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Email email) {
        this.name = name;
        this.email = email;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

<<<<<<< HEAD
    static class Email implements Serializable {
=======
    static class Email implements Serializable{
>>>>>>> 61b50b7609c7b8eb97f29dbc145658e6bc2cb979
        private static final long serialVersionUID = -2775038899533500153L;
        String text;

        Email(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
