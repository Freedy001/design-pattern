package com.freedy.structPattern.component;

/**
 * @author Freedy
 * @date 2021/6/18 12:45
 */
public class Test {
    public static void main(String[] args) {
        Menu menu1 = new Menu("菜单管理", 1);
        MenuItem item1 = new MenuItem("页面访问", 2);
        MenuItem item2 = new MenuItem("展开菜单", 2);
        MenuItem item3 = new MenuItem("编辑菜单", 2);
        MenuItem item4 = new MenuItem("新增菜单", 2);
        menu1.add(item1);
        menu1.add(item2);
        menu1.add(item3);
        menu1.add(item4);

        Menu menu2 = new Menu("权限管理", 1);
        MenuItem item2_1 = new MenuItem("页面访问", 2);
        MenuItem item2_2 = new MenuItem("提交保存", 2);
        menu2.add(item2_1);
        menu2.add(item2_2);

        Menu menu3 = new Menu("角色管理", 1);
        MenuItem item3_1 = new MenuItem("页面访问", 2);
        MenuItem item3_2 = new MenuItem("新增角色", 2);
        MenuItem item3_3 = new MenuItem("修改角色", 2);
        menu3.add(item3_1);
        menu3.add(item3_2);
        menu3.add(item3_3);

        Menu menu = new Menu("系统管理", 0);
        menu.add(menu1);
        menu.add(menu2);
        menu.add(menu3);

        menu.print();

    }
}
