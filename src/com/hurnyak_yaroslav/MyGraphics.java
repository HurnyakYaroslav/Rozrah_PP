package com.hurnyak_yaroslav;

import com.sun.xml.internal.ws.api.Component;
import sun.swing.DefaultLayoutStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

public class MyGraphics {
    static Toolkit toolkit = Toolkit.getDefaultToolkit();
    static Dimension dimention = toolkit.getScreenSize();
    static JFrame jFrame = getFrame();

    public static void draw(){
        JPanel jpanel = getPanel();
        jFrame.add(jpanel);
        jFrame.add(new MyComponent());



        jFrame.setVisible(true);
    }


    static class MyComponent extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(Color.blue);
            Font font = new Font("Arial",Font.CENTER_BASELINE+Font.ITALIC,20);
            g2.setFont(font);
            Image image = new ImageIcon("img/gaz.jpg").getImage();
          //  g2.drawImage(image,0,0, jFrame.getWidth(), jFrame.getHeight(), null);
            g2.drawString("TAKSOPARK", jFrame.getWidth()/2,30);
            jFrame.repaint();
          //  g2.drawString("MY TAKSOPARK: ", 0,20);
            g2.setFont(font);
          //  g2.drawString("Hello World", 10, 20);

        }

    }
        public static JFrame getFrame(){
          JFrame jFrame = new JFrame();

          jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
          //jFrame.setLayout(null);
            Image image = new ImageIcon("img/my_icon.jpg").getImage();
            jFrame.setIconImage(image);
          jFrame.setTitle("TAKSOPARK");
          jFrame.getContentPane().setBackground(Color.gray);

         // jFrame.setBounds(dimention.width/2-250, dimention.height/2-150, 500,300);
           Point p1 = new Point(dimention.width / 2 - 500, dimention.height / 2 - 250), p2 = new Point(500, 300);
           jFrame.setSize(1000, 500);
           jFrame.setLocation(p1);

            return jFrame;
        }

        public static JPanel getPanel(){
            JPanel jPanel = new JPanel();

            jPanel.setBounds(50,50,100,200);

            JButton jButton1 = new JButton("Read");
            //jButton1.setBounds();
            jButton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    OtherFunctions.fromTheFile();
                }
            });
            jPanel.add(jButton1);


            JButton jButton2 = new JButton("View");
            //jButton1.setBounds();
            jButton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                     ArrayList<Car> list = Main.taksopark.getList();
                    DefaultListModel allcarsmodel = new DefaultListModel();

                    for (int j = 0; j < list.size(); j++) {
                        System.out.println(list.get(j) + "\tid = " + j + "\n");
                        allcarsmodel.addElement("All cars in taksopark :");
                        allcarsmodel.addElement(list.get(j).toString());

                    }

                    JList<String> jList = new JList(allcarsmodel);
                    jList.setLocation(200,50);
                    jList.setSize(450,300);
                    //jList.setFont();
                    jFrame.add(jList);
                    jFrame.repaint();

                    jFrame.setLayout(null);
                    JButton jButtemp = new JButton("CLEAN");
                  //  jButtemp.setLocation(700,40);
                    jButtemp.setVisible(true);
                   // jFrame.repaint();
                    JPanel jptmp = new JPanel();
                    jptmp.setBackground(new Color(0,0,0,0));
                    jptmp.setBounds(400, 355, 50,30);

                   // jptmp.setBackground(Color.red);
                    jptmp.add(jButtemp);
                   // jptmp.setVisible(true);
                    //jptmp.repaint();
                    jFrame.add(jptmp);
                    //jButton1.setBounds();
                    jButtemp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jFrame.remove(jList);
                            jptmp.remove(jButtemp);
                            jFrame.remove(jptmp);
                            jFrame.repaint();
                        }
                    });
                    jptmp.add(jButtemp);
                    jFrame.repaint();
                    jFrame.setVisible(true);



                }
            });
            jPanel.add(jButton2);

            JButton jButton3 = new JButton("Sort");
            //jButton1.setBounds();
            jButton3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   Main.taksopark.sort1();
                }
            });
            jPanel.add(jButton3);

            JButton jButton4 = new JButton("Add");
            //jButton1.setBounds();
            jButton4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JPanel addPanel = new JPanel();
                    addPanel.setBounds(200,50,600,100);
                    jFrame.setLayout(null);
                    addPanel.setBackground(Color.green);
                    JLabel label = new JLabel("<name> <breakdown> <maxSpeed> <cost> <SEDAN|HATCHBAK|VERSATILE|PICKUP>");
                    label.setBounds(5, 10, 600, 10);
                    addPanel.add(label);
                    JTextField tf = new JTextField();
                    addPanel.setLayout(null);
                    tf.setBounds(5,30,250,20);
                    tf.setName("Place for string!");
                    addPanel.add(tf);

                    JButton enter = new JButton("Enter");
                    enter.setBounds(10,60,70,35);
                    addPanel.add(enter);
                    addPanel.setVisible(true);
                    addPanel.repaint();
                    jFrame.add(addPanel);
                    jFrame.repaint();
                    jFrame.setVisible(true);
                    enter.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Main.taksopark.newCar("addcar "+tf.getText());
                            jFrame.remove(addPanel);
                            jFrame.repaint();
                           // System.out.println(tf.getText());
                        }
                    });

                }

            });

            jPanel.add(jButton4);

            JButton jButton5 = new JButton("Save");
            //jButton1.setBounds();
            jButton5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    OtherFunctions.toTheFile();
                }
            });
            jPanel.add(jButton5);
            JButton exit_button = new JButton("Exit");
            exit_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                 System.exit(0);
                }
            });
            jPanel.add(exit_button);

            return jPanel;
        }
    }
