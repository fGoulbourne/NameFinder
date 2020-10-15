import java.net.*;
import java.io.*;
import java.util.Scanner;



public class NameFinder{

    public static void main(String[] args) throws Exception {
        String URLRequest = URLInput();
        String data = "";
        int start = -1;
        int end = -1;
        String check ="";

        //Creates an URL object, then stores the lines in the BufferedReader.
        // The line with the name is then stored in data
        URL NamePage = new URL(URLRequest);
        BufferedReader in = new BufferedReader(new InputStreamReader(NamePage.openStream()));

        for(int i=0; i<85; i++) {
            data = in.readLine();

        }

        //Separating the different parts of the line so we only get the name out of the list
        start = data.indexOf("property=\"name\">");
        end = data.indexOf("<em property=\"honorificSuffix\"");

        //checking if the email was valid and a name can be found
        if(start == -1) {
            System.out.println("Name could not be found. Perhaps try a different email?");
        }
        else{
            System.out.println(data.substring(start+16, end));
        }

        in.close();
    }

    public static String URLInput(){
        //Collecting and processing the email address to use.
        Scanner emailURLCatch = new Scanner(System.in);
        System.out.println("Enter email address");

        String emailURL = emailURLCatch.nextLine();
        String[] emailSplit = emailURL.split("@");

        return "https://www.ecs.soton.ac.uk/people/" + emailSplit[0];
    }


}
