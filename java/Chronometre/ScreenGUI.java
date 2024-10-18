package Chronometre;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ScreenGUI extends JFrame{
    
    JPanel panelMain;
    JButton resetbt, startbt, pausebt;
    JLabel timerlb;

    Font timerFont;
    Timer time;

    int seconds, minutes, hour;
    
    public static void main(String[] args){
        
        SwingUtilities.invokeLater(() -> new ScreenGUI());
    }

    public ScreenGUI(){

        configureLabels();
        configureButtons();
        configurePanel();
        configureFrame();

        //actionButtons
        actionButtons();

        //declarate timer
        declareTimer();
    }

    public void configureFrame(){

        setTitle("Chronometre");
        setSize(350,200);

        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(panelMain);

        setVisible(true);
    }

    public void configurePanel(){

        panelMain = new JPanel();

        panelMain.add(resetbt);
        panelMain.add(startbt);
        panelMain.add(pausebt);

        panelMain.add(timerlb);
    }


    public void configureButtons(){

        resetbt = new JButton("Reset");
        startbt = new JButton("Start");
        pausebt = new JButton("Pause");
    }

    public void configureLabels(){

        timerFont = new Font("Arial" , Font.BOLD, 48);

        timerlb = new JLabel("00:00:00");
        timerlb.setFont(timerFont);
    }

    public void actionButtons(){

        resetbt.addActionListener(e -> { time.stop(); seconds=0; minutes=0; hour=0; showTime();});

        startbt.addActionListener(e -> { time.start();});

        pausebt.addActionListener(e -> { time.stop();});
    }

    public void showTime(){

        timerlb.setText(String.format(  "%02d:%02d:%02d", hour, minutes, seconds));
    }

    public void declareTimer(){

        time = new Timer(1000, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){
                
                seconds++;
                
                if(seconds>=60){
                    seconds=0;
                    minutes++;
        
                } 
                
                if(minutes>=60){
                    minutes=0;
                    hour++;
        
                }

                showTime();
            }           
        });
    }
}