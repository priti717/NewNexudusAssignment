package Utility;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utilityclass {

    //public static void main(String args[]) throws IOException {
        public Properties ReadFiledata() throws IOException {

      //  FileInputStream fn=new FileInputStream("C:\\Users\\welcome\\IdeaProjects\\Nexudus\\src\\test\\java\\Utility\\XpathCollection");
        FileReader file=new FileReader("C:\\Users\\welcome\\IdeaProjects\\Nexudus\\src\\test\\java\\Utility\\XpathCollection");
        Properties p=new Properties();
        p.load(file);
        return p;
    }


}