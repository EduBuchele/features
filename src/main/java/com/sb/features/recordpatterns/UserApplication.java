package com.sb.features.recordpatterns;

public class UserApplication {
    public static void main(String[] args) {
        var obj = new User("eduardo", "123", 38, "edu@test.com");

        //Antes
        if (obj instanceof User user) {
            String username = user.username();
            String password = user.password();
            int age = user.age();
            String email = user.email();
            System.out.printf("JDK17 => username: %s, password %s, age %d, email %s%n", username, password, age, email);
        }

        //Depois Java21
        if (obj instanceof User(String username, String password, int age, String email)) {
            System.out.printf("JDK21 => username: %s, password %s, age %d, email %n", username, password, age, email);
        }
    }
}
