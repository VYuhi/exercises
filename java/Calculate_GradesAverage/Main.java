package Calculate_GradesAverage;

import java.util.Scanner;

public class Main {
    
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args){
        
        int totalGrades;
        double grades[], average = 0;
        String status = "yes";

        System.out.println("Enter with the number of students grades:");
        totalGrades = scn.nextInt();

        grades = new double[totalGrades];

        //add grades in array
        enterGrades(grades, totalGrades);
        
        //show informations for user
        showInformations(grades);

        cleanBuffer();
        System.out.println("Wrong enter? Press 'yes' to make changes:");
        status = scn.nextLine();

        while (status.equals("yes")){

            status = fixError(status, grades);
        }

        if(status.equals("no")) {
            average = calculateAverage(grades);
            System.out.println("Average: " + average);

        }
    }

    public static void enterGrades(double[] grades, int totalGrades){

        for(int i = 0; i<totalGrades; i++){

            System.out.println("Enter with the grade " + (i+1) + ":");
            grades[i] = scn.nextInt();
        }
    }

    public static void showInformations(double[] grades){

        for(int i = 0; i < grades.length; i++){

            System.out.println("Grade " + (i+1) + ":");
            System.out.println("     " + grades[i]);
        }
    }

    public static String fixError(String status, double[] grades){
        
        if(status.equals("yes")){

            System.out.println("Enter with number of the wrong grade:");
            int wrongNumberGrd = scn.nextInt() -1;

            cleanBuffer();
            System.out.println("Enter with the new grade value:");
            double newGradeNum = scn.nextDouble();

            grades[wrongNumberGrd] = newGradeNum;

            showInformations(grades);

            cleanBuffer();
            System.out.println("other problem? Press 'yes' to make change or 'no' to continue:");
            status = scn.nextLine();
        }

        return status;
    }

    public static double calculateAverage(double[] grades){

        double average = 0;

        for(int i = 0; i < grades.length; i++){

            average+=grades[i];
        }

        average/=grades.length;
        return average;
    } 

    public static void cleanBuffer(){

        scn.nextLine();
    }
}