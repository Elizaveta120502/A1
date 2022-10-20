package com.A1.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class IPConvert {

    private static String IP_REGEX = "[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}";
    private static String INTEGER_REGEX = "[0-9]+";
    private static final int MAX_NUMBER_POWER = 3;
    private static final int SENIOR_RANK = 256;

    private static final Logger LOGGER = LogManager.getLogger(IPConvert.class);

    public static void main(String[] args) {

        String IpAdress;
        Scanner sc = new Scanner(System.in);
        LOGGER.info("Enter IP address(X.X.X.X) or integer number");
        int temp = 0;

        do {
            IpAdress = sc.nextLine();

            try {
                if (IpAdress.matches(IP_REGEX)) {
                    returnNumber(IpAdress);
                    temp =1;

                } else if (IpAdress.matches(INTEGER_REGEX) && (Integer.parseInt(IpAdress) <= Integer.MAX_VALUE)) {

                    returnIp(Integer.parseInt(IpAdress));
                    temp = 1;
                } else {
                    LOGGER.error("Invalid format.Try again");
                }
            } catch (NumberFormatException e) {
                LOGGER.error("Invalid format.");
            }
        }while (temp == 0);

    }


    private static int returnNumber(String IpAddress) {
        int number = 0;
        if (IpAddress.matches(IP_REGEX)) {
            String[] addrArray = IpAddress.split("\\.");


            for (int i = 0; i < addrArray.length; i++) {
                int power = MAX_NUMBER_POWER - i;
                number += ((Integer.parseInt(addrArray[i]) % SENIOR_RANK * Math.pow(SENIOR_RANK, power)));
            }

            LOGGER.info(number);

        }
        return number;
    }


    private static String returnIp(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.insert(0, Long.toString(number & 0xff));
            if (i < 3) {
                sb.insert(0, '.');
            }
            number = number >> 8;
        }
        LOGGER.info(sb.toString());
        return sb.toString();
    }


}


