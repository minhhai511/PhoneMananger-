/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author SƠNPC
 */
public class Validation {

    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static int getInt(String msg, String err, int min, int max) {
        while (true) {
            try {
                System.out.println(msg);
                int num;
                num = Integer.parseInt(in.readLine());
                if (min <= num && num <= max) {
                    return num;
                } else {
                    System.out.println("Number inrange [" + min + " - " + max + "]");
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println(err);
            }
        }
    }

    public static double getDouble(String msg, String err, double min, double max) {
        while (true) {
            try {
                System.out.println(msg);
                double num;
                num = Double.parseDouble(in.readLine());
                if (min <= num && num <= max) {
                    return num;
                } else {
                    System.out.println("Number inrange [" + min + " - " + max + "]");
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println(err);
            }
        }
    }

    public static String getString(String msg, String err, String regex) {
        while (true) {
            try {
                System.out.println(msg);
                String str = in.readLine();
                if (str.matches(regex)) {
                    return str;
                }
            } catch (IOException ex) {
                System.out.println("IOException");
            }
            System.out.println(err);
        }
    }

    public static Date getDate(String msg, String err, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        while (true) {
            try {
                System.out.println(msg);
                Date date = sdf.parse(in.readLine());
                return date;
            } catch (Exception ex) {
                System.out.println(err);
            }
        }
    }

    public static Date toDate(String str, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(str);
            return date;
        } catch (Exception e) {
            System.out.println("Date format invalid");
        }
        return null;
    }

    public static String toString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

}
