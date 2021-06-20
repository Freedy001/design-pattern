package com.freedy.behaviorPattern.interpreter;

/**
 * @author Freedy
 * @date 2021/6/19 21:29
 */
public class Test {
    public static void main(String[] args) {
        Context context = new Context();
        Variable a = new Variable("a");
        Variable b = new Variable("a");
        Variable c = new Variable("a");
        Variable d = new Variable("a");
        context.assign(a,1);
        context.assign(b,2);
        context.assign(c,3);
        context.assign(d,4);
        AbstractExpression expression=new Plus(new Minus(new Plus(a,b),c),d);
        AbstractExpression expression2=new Plus(a,b);
        int interpret = expression.interpret(context);
        System.out.println(interpret);
    }
}
