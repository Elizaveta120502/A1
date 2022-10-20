package com.A1.task2;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
/*                                 1!   2!   n!
                                   -- + -- + --
                                   n!   n!   n!
                   1!+2!+...+n!                       1
lim(n->infinity) = ----------- = ---------------- =  --- = 1
                       n!              n!             1
                                       --
                                       n!
(при n>1,значение функции будет > 1 и при увеличении n, значение функции будет стремится к 1)
 */

public class Factorial {
    private static final Logger LOGGER = LogManager.getLogger(Factorial.class);
    public static void main(String [] args){

        int number = 1;
        double un1 =1;
        double un2 =1;
        LOGGER.info("Enter n: ");

        Scanner sc = new Scanner(System.in);

             number = sc.nextInt();

        un1 = (factorial(number));
        LOGGER.info(String.format("%.6f",un1));
        for (int i = 2; i <= number; i++){
            un2 = un2 + factorial(i);
        }
        LOGGER.info(String.format("%.6f",un2));
        double un = 1/un1*un2;
        LOGGER.info(String.format("%.6f",un));



    }


    private static double factorial(int number){

        if (number < 1){
            return 1;
        }else{
            return number*factorial(number - 1);
        }

    }
}
