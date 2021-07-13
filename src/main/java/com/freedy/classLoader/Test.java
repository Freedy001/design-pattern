package com.freedy.classLoader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.function.BiConsumer;

/**
 * @author Freedy
 * @date 2021/7/1 0:40
 */
public class Test {
    public static void main(String[] args) throws Throwable {
        MyClassLoader loader = new MyClassLoader();
        Class<?> redBlackTree= loader.findClass("C:\\Users\\Freedy\\Desktop\\code\\DesignPatterns\\target\\classes\\com\\freedy\\tree\\RedBlackTree.class");
        Object instance = redBlackTree.getConstructor().newInstance();
        redBlackTree.getDeclaredMethod("put",Object.class,Object.class).invoke(instance,1,1);
        redBlackTree.getDeclaredMethod("put",Object.class,Object.class).invoke(instance,2,2);
        redBlackTree.getDeclaredMethod("put",Object.class,Object.class).invoke(instance,3,3);
        redBlackTree.getDeclaredMethod("put",Object.class,Object.class).invoke(instance,4,4);
        redBlackTree.getDeclaredMethod("forEach",BiConsumer.class).invoke(instance, (BiConsumer<Object,Object>) (a, b) -> System.out.println(a+"--"+b));
    }
}
class MyClassLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name){
        try {
            FileInputStream inputStream = new FileInputStream(name);
            byte[] allBytes = inputStream.readAllBytes();
            return defineClass("com.freedy.tree.RedBlackTree", allBytes,0,allBytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

interface App{

}