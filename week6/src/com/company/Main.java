package com.company;

public class Main {

    public static void main(String[] args) {
	    if (args != null && args.length == 0)
        {
            args = new String[1];
            args[0] = new String();
            args[0] = "CCappucinnoooooooooo";
            char[] str = args[0].toCharArray();
            String result = "";

            for (int i = 0, len = args[0].length(); i < len;i++)
            {
                if (i < len - 1 && str[i] == str[i + 1])
                {
                    int count = 1;
                    while (i < len && str[i] == str[i + 1] && count < 9) {
                        count++;
                        i++;
                    }

                    result += str[i];
                    result += count;
                }
                else
                    result += str[i];
            }

            System.out.println(result);
        }

    }
}
