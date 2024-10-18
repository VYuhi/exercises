package Password_Generator;

import java.util.Scanner;
import java.util.Random;

public class Main {
    
    static String information = "";
    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);
        Random ramdom = new Random();

        String[] caractersNum = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}, 
        caractersLetter = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "z", "y", "z"};
        
        String password = "";
        int caractersNumber;
    
        System.out.println("Password Generator");

        System.out.println("Enter with the number of caracters:");
        caractersNumber = scn.nextInt();

        int count = 0;
        while (count<caractersNumber){
            password = password.concat(sortCaracter(ramdom, caractersNum, caractersLetter));
            //System.out.println(information);
            count++;
        }

        System.out.println("Password is:\n  " + password);

        scn.close();
    }

    public static String sortCaracter(Random ramdom, String[] caractersNum, String[] caractersLetters){
        String password;
        int typeCaracter = ramdom.nextInt(0, 2);
        information = Integer.toString(typeCaracter);
        
        if (typeCaracter == 1){
            typeCaracter = ramdom.nextInt(0, 9);
            password = caractersNum[typeCaracter];

        } else{
            typeCaracter = ramdom.nextInt(0, 25);
            
            if(ramdom.nextBoolean() == true){
                password = caractersLetters[typeCaracter].toUpperCase();

            } else {
                password = caractersLetters[typeCaracter];

            }

        }
        
        return password;
    }
}