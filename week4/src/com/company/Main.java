package com.company;

public class Main {

    public static void main(String[] args) {
        Command command = new Error();
        String[] arg = new String[1];

        arg[0] = "";

        if (arg != null) {
            if (arg.length == 1) {
                if (arg[0] == "help")
                    command = new Help();
                else if (arg[0] == "exit")
                    command = new Exit();
            }
            else if (args.length == 2) {
                if (arg[0] == "date" && arg[1] == "now")
                    command = new Date();
                else if (arg[0] == "echo")
                    command = new Echo(arg[1]);

            }
        }

        command.execute();
    }

}