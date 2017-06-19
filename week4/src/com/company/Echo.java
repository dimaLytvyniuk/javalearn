package com.company;

/**
 * Created by dima on 04.04.17.
 */
public class Echo implements Command {
    @Override
    public void execute() {

    }

    public Echo(String data) {
        System.out.println(data);
    }
}
