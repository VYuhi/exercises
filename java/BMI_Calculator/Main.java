package BMI_Calculator;

import javax.swing.*;
import javax.swing.plaf.OptionPaneUI;

import java.awt.BoxLayout;

public class Main extends JFrame{
    
    JPanel mainPanel;
    JTextField massInput, heightInput;
    JButton calculatebt;
    float bmi;
    public static void main(String[] args){

        SwingUtilities.invokeLater(() -> new Main());
    }

    public Main(){
        
        configureMainPanel();
        configFrame();
        buttonActtion();
    }

    public void configFrame(){

        setTitle("BMI Calculator");
        setSize(300, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setVisible(true);
    }
    
    public void configureMainPanel(){

        mainPanel = new JPanel();

        JLabel heightlb = new JLabel("Height (m):");
        heightInput = new JTextField(25);
        mainPanel.add(heightlb);
        mainPanel.add(heightInput);

        JLabel masslb = new JLabel("Mass (kg):");
        massInput = new JTextField(25);
        mainPanel.add(masslb);
        mainPanel.add(massInput);
        
        calculatebt = new JButton("Calculate");
        mainPanel.add(calculatebt);

        add(mainPanel);
    }

    public void buttonActtion(){

        calculatebt.addActionListener(e -> {calculateBMI(); JOptionPane.showMessageDialog(this, "BMI: " + bmi);});
    }

    public void calculateBMI(){
        if(!heightInput.equals("")||!massInput.equals("")){
           
            float mass, height;
            mass = Float.parseFloat(massInput.getText());
            height = Float.parseFloat(heightInput.getText());

            bmi = mass/(height*height);
        }
    }
}