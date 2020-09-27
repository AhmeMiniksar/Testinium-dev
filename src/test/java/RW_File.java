import java.io.*;

public class RW_File {

    public static String loglar;


    public static void main(String[] args)  throws IOException{

        fileWrite();

    }

    public static void fileWrite()  throws IOException{

        //Create File In C: Driver.
        String TestFile = "C:\\temp.txt";
        File FC = new File(TestFile);//Created object of java File class.
        FC.createNewFile();//Create file.

        //Writing In to file.
        //Create Object of java FileWriter and BufferedWriter class.
        FileWriter FW = new FileWriter(TestFile);
        BufferedWriter BW = new BufferedWriter(FW);
        BW.write("Text Dosyasi olustruldu : "); //Writing In To File.
        BW.newLine();//To write next string on new line.
        BW.write(loglar); //Writing In To File.
        BW.close();

        //Reading from file.
        //Create Object of java FileReader and BufferedReader class.
        FileReader FR = new FileReader(TestFile);
        BufferedReader BR = new BufferedReader(FR);
        String Content = "";

        //Loop to read all lines one by one from file and print It.
        while((Content = BR.readLine())!= null){
            System.out.println(Content);
        }
    }
}