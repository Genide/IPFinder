package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws UnknownHostException, MalformedURLException {
	// write your code here
        String url;
        InetAddress address;
        String ip;
        Path file = Paths.get("C:\\Users\\Daniel\\Dropbox\\COSC 4335 (Data Mining)\\Assignment 3\\safepages.txt");
        int i=0;

        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(file,charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                url="http://www."+line;
                try{
                    address = InetAddress.getByName(new URL(url).getHost());
                    ip = address.getHostAddress();
                    i++;
                    //System.out.print(i+" ");
                    System.out.println(formatIP(ip));
                }
                catch(UnknownHostException e){
                    //System.out.println("Delete "+i);
                    i++;
                }

            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }


    }

    public static String formatIP(String ip){
        String formattedIP = "";
        for(int i=0;i<ip.length();i++){
            if(ip.charAt(i)=='.')
                formattedIP+=" ";
            else
                formattedIP+=ip.charAt(i);
        }
        formattedIP+=" 1";
        return formattedIP;
    }
}
