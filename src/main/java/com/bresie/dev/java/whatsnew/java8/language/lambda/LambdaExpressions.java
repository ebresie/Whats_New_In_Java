package main.java.com.bresie.dev.java.whatsnew.java8.language.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

/**
 * From https://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html
 * <p>
 * (1) Lambda Expressions, a new language feature, has been introduced in this release.
 * They enable you to treat functionality as a method argument, or code as data.
 * Lambda expressions let you express instances of single-method interfaces
 * (referred to as functional interfaces) more compactly.
 * <p>
 * some of these examples are
 * basef on from "Java 8 Lambdas" by Richard Warburton - example 2-3.
 */
public class LambdaExpressions {
    public static void main(String[] args) {
        noArgumentExample();
        withArgumentExample();
    }

    /* this example defines a no argument lambda associated with a Runnable interface variable by
    which has a Runnable.run() interface which can be called to execute.
    */
    public static void noArgumentExample() {
        Runnable noArguments = () -> System.out.println("Hello World");
        noArguments.run();

        Runnable noArgumentsMultipleStatesments = () -> {
            System.out.println("Hello ");
            System.out.println("Multi-statement lambda ");
            System.out.println("World");
        };

        noArgumentsMultipleStatesments.run();
    }

    /* This example defines a lambda with arguments.  It also shows the BinaryOperator with a type defined
    which is similar to how Generics specify things.  This implies the return value expected as part of the
    operator.

    There are multiple examples one with no types associated with the parameter and in another with the parameter
    included.
    */
    public static void withArgumentExample() {
        BinaryOperator<Long> add = (x, y) -> x + y;
        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;

        System.out.println("Add=" + add.apply(1L, 2L));
        System.out.println("AddExplicit=" + addExplicit.apply(3L, 4L));
    }

    /**
     * This is an old way of using anonymous inner classes prior to lambdas
     */
    public static void oldWay() {
        final String name = getUserName();
        JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hi " +name);
            }
        });
    }
    /**
     * This is an old way of using anonymous classes prior to lambdas
     */
    public static void newWay() {
        // with java 8 it is less stringent on finalization of variables when being used in lambda contexts
        // compare to anonymous inner
        String name = getUserName();
        JButton button = new JButton();
        button.addActionListener(event -> {
            System.out.println("Hi " + name);
        });
    }

    private static String getUserName() {
        String userName = "John Doe";

        return userName;
    }
}
