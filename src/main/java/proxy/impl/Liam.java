package proxy.impl;

import proxy.api.IPerson;

public class Liam implements IPerson {
    @Override
    public void sing() {
        System.out.println("Liam sing a song named '酒醉的蝴蝶'");
    }
}
