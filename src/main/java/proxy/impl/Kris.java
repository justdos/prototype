package proxy.impl;

import proxy.api.IPerson;

public class Kris implements IPerson {
    public Kris(String sex) {

    }
    @Override
    public void sing() {
        System.out.println("sing a song named '明天会更好'");
    }


}
