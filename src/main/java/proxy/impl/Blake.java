package proxy.impl;

import proxy.api.IPerson;

public class Blake implements IPerson {
    @Override
    public void sing() {
        System.out.println("Blake sing a song named '长恨歌'");
    }
}
