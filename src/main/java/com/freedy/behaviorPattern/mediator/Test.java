package com.freedy.behaviorPattern.mediator;

/**
 * @author Freedy
 * @date 2021/6/19 17:38
 */
public class Test {
    public static void main(String[] args) {
        MediatorStructure structure = new MediatorStructure();
        Tenant tenant = new Tenant("李四",structure);
        HouseOwner houseOwner = new HouseOwner("张三",structure);
        structure.setHouseOwner(houseOwner);
        structure.setTenant(tenant);
        tenant.contact("哈哈哈哈");
        houseOwner.contact("aaaaaa哈哈哈哈");
    }
}
