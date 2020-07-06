package com.sample.restdocsdemo.model;

import java.util.Objects;

public class Greeting {

    private String greetingMessage;

    public Greeting() {
    }

    public Greeting(String str) {
        this.greetingMessage = str;
    }

    public String getGreetingMessage() {
        return greetingMessage;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Greeting greeting = (Greeting) o;
        return Objects.equals(greetingMessage, greeting.greetingMessage);
    }

    @Override
    public int hashCode() {

        return Objects.hash(greetingMessage);
    }

    @Override
    public String toString() {
        return "Greeting{" +
                   "greetingMessage='" + greetingMessage + '\'' +
                   '}';
    }
}
