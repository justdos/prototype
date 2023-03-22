package prototype;

import com.sun.xml.internal.ws.util.StringUtils;

public class Student implements Cloneable{
    private int age;
    private int sex;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        System.out.println("Age is :" + age + ",sex is :" + sex +"," + "name is " + name);
        return "";
    }
}
