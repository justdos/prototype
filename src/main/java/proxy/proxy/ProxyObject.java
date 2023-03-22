package proxy.proxy;

import proxy.api.IPerson;

public class ProxyObject {
    IPerson iPerson;

    public ProxyObject(IPerson iPerson) {
        this.iPerson = iPerson;
    }

    public void sing() {
        System.out.println("准备唱歌，清嗓中");
        iPerson.sing();
        System.out.println("唱好了，鼓掌，啪啪啪啪啪");
    }
}
