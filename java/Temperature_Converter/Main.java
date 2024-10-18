package Temperature_Converter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
    
        Scanner scn = new Scanner(System.in);

        double temperature, newTemperature;
        String scale, converterScale;

        System.out.println("Temperature Converter");

        System.out.println("Use this abbreviations:\n  c = Celsius\n  k- Kelvin\n  f- Fahrenheit");
        
        
        //enter temperature scale
        System.out.println("Enter with temperature scale:");
        scale = scn.nextLine().toLowerCase();

        //enter temperature
        System.out.println("Enter with the temperature value:");
        temperature = scn.nextDouble();

        //clear buffer
        scn.nextLine();
        
        //enter temperature scale converter
        System.out.println("Enter with scale to converter:");
        converterScale = scn.nextLine().toLowerCase();

        newTemperature = ConverterTemperature(temperature, scale, converterScale);
        System.out.println("the old temperature is: " + Double.toString(temperature));
        System.out.println("the new temperature is: " + Double.toString(newTemperature));
        
        scn.close();
    }

    public static double ConverterTemperature(double temperature, String scale, String converterScale){

        //converte a temperatura para celcius
        switch (scale) {
            case "k":
                
                temperature -= 273;
                break;
            
            case "f":

                temperature = (temperature-32)/1.8;
                break;
            
            case "c":

                break;
            default:

                System.out.println(error());
                break;
        }

        //converte a temperatura em celsius para a escolhida
        switch (converterScale) {
            case "k":
            
                temperature += 273;
                break;
            
            case "f":
            
                temperature = temperature*1.8+32; 
                break;

            case "c":

                break;
            default:

                System.out.println(error());
                break;
        }

        return temperature;
    }

    public static String error(){

        return "Invalid enter, try use k, f or c";
    }
}