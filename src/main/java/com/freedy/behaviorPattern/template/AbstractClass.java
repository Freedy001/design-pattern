package com.freedy.behaviorPattern.template;

/**
 * @author Freedy
 * @date 2021/6/18 22:09
 */
public abstract class AbstractClass {
    public final void cook() { //模板方法
        //第一步：倒油
        pourOil();
        //第二步：热油
        heatOil();
        //第三步：倒蔬菜
        pourVegetable();
        //第四步：倒调味料
        pourSauce();
        //第五步：翻炒
        fry();
    }
    public void pourOil() {
        System.out.println("倒油");
    }
    public void heatOil() {
        System.out.println("热油");
    }
    public abstract void pourVegetable();
    public abstract void pourSauce();
    public void fry(){
        System.out.println("炒啊炒啊炒到熟啊");
    }
}
