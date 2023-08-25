package miniProject;
import java.util.*;
// Tomas Albiol
// 28 / 11 / 2021
// Mini 7 Version 1
// For this project an algorith capable of folloing a natural conversation about countries visited by the subject was created.
public class chatBot6 {
    public static void main(String[] args) {
        partner information = obtainInfo();
        sortData(information);
        String name = getName(information);
        returnDataAndComments(information, name);
        System.exit(0);
    }

    public static partner obtainInfo() {
    //This method obtains all inputs of various types and places them in a record in an interactive manner.
        int count;
        String answer;
        String countryOrigin;
        final String name;
        int numberVisited;
        int whileCondition = 0;

        System.out.println("Hey there my name is Chatty.");
        name = inputs("What is your name? ");
        System.out.println(name + " what a beautiful name!");
        countryOrigin = inputs("Where are you from? ");
        System.out.println("Ah yes, I have heard that " + countryOrigin + " is amazing!");
        answer = inputs("How many countries have you visited? ");
        numberVisited = Integer.parseInt(answer);
        String[] countries = new String [numberVisited];
        int[] rating = new int [numberVisited];
        while (whileCondition < numberVisited) {
            count = whileCondition+1;
            countries[whileCondition] = inputs("What was country #" + count + "? ");
            answer = inputs("Rate " + countries[whileCondition] + "(1-10): ");
            rating[whileCondition] = Integer.parseInt(answer);
            whileCondition++;
        }
        partner information = partnerData(name, countryOrigin, numberVisited, countries, rating);
        return information;
    }

    public static String inputs(String question) {
    //Method that collects inputs as strings.
        String answer;
        Scanner input = new Scanner(System.in);
        System.out.print(question);
        answer = input.nextLine();
        return answer;
    }

    public static partner partnerData(String name, String origin, int number, String[] countries, int[] rating) {
    //This method imports information from another method and places it in the variable information of type partner.
        partner information = new partner();
        
        information.name = name;
        information.countryOrigin = origin;
        information.numberVisited = number;
        information.countries = countries;
        information.rating = rating;

        return information;
    }

    public static String getName(partner information) {
    //accessor method for the variable name in the record information of type partner
        return information.name;
    }

    public static partner sortData(partner information) {
    //Sorts rankings of countries from least to most favorite, function of the abstract data type partner.
        int temporalMinimum;
        String minimumName;

        for (int i = 0; i < information.numberVisited-1; i++) {
            for (int j = 0; j < information.numberVisited-1; j++) {
                if (information.rating[j] > information.rating[j+1]) {
                    temporalMinimum = information.rating[j];
                    minimumName = information.countries[j];
                    information.rating[j] = information.rating[j+1];
                    information.countries[j] = information.countries[j+1];
                    information.rating[j+1] = temporalMinimum;
                    information.countries[j+1] = minimumName;
                }
            }
        }
        return information;
    }
    
    public static void returnDataAndComments(partner information, String name) {
    //This method returns the organized infomration in order from least to most liked and then comments on the 
    //users inputs.
        System.out.println();
        System.out.println("Well " + name + "...");
        System.out.println();
        System.out.println("This is the organized data from least to most favorite country.");
        for (int i = 0; i < information.numberVisited; i++) {
            System.out.println(information.countries[i] + " recieved: " + information.rating[i] + ".");
            if (information.countries[i].equals("Spain") & information.rating[i] < 8) {
                System.out.println("I don't respect your opinion anymore");
            }
            else if (information.countries[i].equals("France") & information.rating[i] <= 2) {
                System.out.println("Okay... We have the same opinion. France is horrible!");
            }
        }
        System.out.println();
        if (information.numberVisited <= 2) {
            System.out.println("You should travel, I barely got enoufgh data to sort.");
        }
        else if (information.numberVisited > 2 & information.numberVisited < 4) {
            System.out.println("Wow you have done quite a bit of traveling!");
        }
        else {
            System.out.println("OMG you inputed so much data that I was barely able to sort it all!");
        }
    }
}

class partner {
//The class partner is a record that has various types included that are later used in the program.
// this class has the method sortData() making it an abstract data type.
    String name;
    String countryOrigin;
    int numberVisited;
    String[] countries;
    int[] rating;
}
