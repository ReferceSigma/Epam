package org.example.Glava1;

import java.util.Calendar;
import java.util.Date;

    public class zadA6{
        public static void main (String args []){

            String s = "Дансаранов";
            Date d = new Date();
            System.out.println("Получено задание, " + s + " " + d);

            Calendar c = Calendar.getInstance();
            c.set(Calendar.YEAR,2024);
            c.set(Calendar.MONTH,Calendar.DECEMBER);
            c.set(Calendar.DAY_OF_MONTH,3);

            System.out.println("Задание сдано, " + s + " " + c.getTime());
        }
    }
