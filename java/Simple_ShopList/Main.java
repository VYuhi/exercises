package Simple_ShopList;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        
        System.out.println("Shopping List");

        jumpConsoleLine();
        jumpConsoleLine();

        System.out.println("Enter with list name:");
        new List(scn.nextLine());

        System.out.println("Enter with the items name. Enter 'finish' to close the list.");
        
        int count = 0;
        boolean statusLoop = false;
        while (statusLoop == false){
            
            String item = scn.nextLine();
            if(item.toLowerCase().equals("finish")){
                statusLoop = true;

            } else{
                List.addListContent(item);
                System.out.println(Integer.toString(count+1) + "\n    --@" + List.getListItens(count));
                count++;
                jumpConsoleLine();

            }
        }
        
        jumpConsoleLine();
        System.out.println("List Name: " + List.getTitle());
        
        jumpConsoleLine();
        jumpConsoleLine();

        count = 0;
        while (count < List.list.size()) {
            
            System.out.println((count+1) + "-    " + List.getListItens(count));
            count++;
        }

        scn.close();
    }

    public static void clearBuffer(Scanner scn){

        scn.nextLine();
    }

    public static void jumpConsoleLine(){

        System.out.println("");
    }
}
