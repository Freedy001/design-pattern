package com.freedy.principles.lawofDemeter;

/**
 * @author Freedy
 * @date 2021/6/8 0:09
 */
public class Agent {
    private Star star;
    private Fans fans;
    private Company company;

    public Agent(Star star, Fans fans, Company company) {
        this.star = star;
        this.fans = fans;
        this.company = company;
    }

    public void meeting(){
        System.out.println(star.getName()+" meet with --> "+fans.getName());
    }

    public void business(){
        System.out.println(star.getName()+" negotiate with --> "+company.getName());
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public Fans getFans() {
        return fans;
    }

    public void setFans(Fans fans) {
        this.fans = fans;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
