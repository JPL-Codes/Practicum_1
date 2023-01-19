import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
//        ArrayList<String> PersonOData = new ArrayList<>();

        ArrayList<String> personCSVData = new ArrayList<>();

        String ID = "";
        String FName = "";
        String LName = "";
        String Title = "";
        String CSVPersonRecord = "";
        int Yob = 0;

        boolean again = false;

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\personTestData.txt");






        // for(int i = 0; i < ID.length; i++);

        do{
            ID = SafeInput.getNonZeroLenString(in,"Enter the ID as 6 digits");
            FName = SafeInput.getNonZeroLenString(in,"Enter the first name");
            LName = SafeInput.getNonZeroLenString(in,"Enter the last name");
            Title = SafeInput.getNonZeroLenString(in,"Enter the title");
            Yob = SafeInput.getRangedInt(in,"Enter the year of birth as 4 digits", 1000, 9999);

            CSVPersonRecord = (ID + ","+ FName + "," + LName+ "," +Title+ "," +Yob);
            personCSVData.add(CSVPersonRecord);
            //personOData.add(new Person(ID, FName, LName, Title, Yob));

            again = SafeInput.getYNConfirm(in,"Are you done entering prompts?");


        }while(!again);

        for(String p:personCSVData)

        System.out.println(p);
        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(String rec : personCSVData)
            {
                writer.write(rec, 0, rec.length());
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }





    }
}
