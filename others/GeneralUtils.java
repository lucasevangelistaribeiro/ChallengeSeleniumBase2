package br.com.desafiobase2.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class GeneralUtils {

    public static String getNowDate(String mask){
        DateFormat dateFormat = new SimpleDateFormat(mask);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getFileContentAsString(String filePath) {
        BufferedReader br=null;
        StringBuilder sb=null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }

            br.close();

        }  catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static String getNowDateAddingDays(int days, String mask){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(mask);

        Date date = null;

        try {
            date = simpleDateFormat.parse(getNowDate(mask));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        date = c.getTime();

        String strDate = simpleDateFormat.format(date);
        return strDate;
    }

    public static String getRandonGUID(){
        return UUID.randomUUID().toString();
    }
}
