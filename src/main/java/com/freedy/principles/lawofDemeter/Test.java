package com.freedy.principles.lawofDemeter;

/**
 * @author Freedy
 * @date 2021/6/8 0:12
 */
public class Test {
    public static void main(String[] args) {
        Star star = new Star("Freedy");
        Fans didi = new Fans("didi");
        Company haha = new Company("haha");
        Agent company = new Agent(star,didi,haha);
        company.meeting();
        company.business();
    }
}
