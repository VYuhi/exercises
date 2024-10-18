package Simple_ShopList;

import java.util.ArrayList;

public class List {
    
    static String title;
    static ArrayList<String> list = new ArrayList<String>();
    
    @SuppressWarnings("static-access")
    public List(String title){
        
        this.title = title;
    }

    public static String getTitle(){

        return title;
    }

    public static String getListItens(int index){

        return list.get(index);
    }
    public static void addListContent(String item){

        list.add(item);
    }   
}