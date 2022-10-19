package kr.ac.mjc.ict2018261031.signup.VO;

/**
 * This is Value Object for StudentAdapter to make RecyclerView
 */

public class Student {
    private String name;
    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
