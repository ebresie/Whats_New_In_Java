package com.bresie.dev.java.whatsnew.java8.language.lambda;

/**
 * From https://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html
 *
 * (1) Lambda Expressions, a new language feature, has been introduced in this release.
 * They enable you to treat functionality as a method argument, or code as data.
 * Lambda expressions let you express instances of single-method interfaces
 * (referred to as functional interfaces) more compactly.
 *
 */
public class LambdaExpressions {
    public static void main(String[] args) {
        // some of these examples are taken from "Java 8 Lambdas" by Richard Warburton
        Runnable noArguments =  () -> System.out.println("Hello World");
        noArguments.run();
    }
}
