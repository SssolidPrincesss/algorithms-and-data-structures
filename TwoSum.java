import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Kalkulator implements ActionListener{

	JFrame frame;
	JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bDelete, bDark, bPlus, bMinus, bMyltiply, bDivide, bEquals;
	JLabel label;
	JPanel panel;
	double var1, var2, c;
	double result;
	

	
	public static void main(String[] args) {
		Kalkulator gui = new Kalkulator();
		gui.go();
	}
	
	
	public void go() {
		
		
		frame = new JFrame("GIGA_CALCULATOR");
		
		
		
		panel = new JPanel();
		panel.setBounds(0, 0 , 390, 350);
		panel.setBackground(Color.gray);
		panel.setLayout(null);
		
		label = new JLabel();
		label.setOpaque(true);
		label.setBounds(30, 20 , 310, 30);
		label.setBackground(Color.CYAN);
		panel.add(label);
		

		bPlus = new JButton("+");
		bPlus.setBounds(260, 80 , 80, 40);
		bPlus.setFocusPainted(false);
		bPlus.addActionListener(this);
		
		
		bMinus = new JButton("-");
		bMinus.setBounds(260, 130 , 80, 40);
		bMinus.setFocusPainted(false);
		bMinus.addActionListener(this);
		

		bMyltiply = new JButton("*");
		bMyltiply.setBounds(260, 180 , 80, 40);
		bMyltiply.setFocusPainted(false);
		bMyltiply.addActionListener(this);
		
		
		bDivide = new JButton("/");
		bDivide.setBounds(260, 230 , 80, 40);
		bDivide.setFocusPainted(false);
		bDivide.addActionListener(this);
		
		
		bEquals = new JButton("=");
		bEquals.setBounds(30, 240 , 200, 30);
		bEquals.setFocusPainted(false);
		bEquals.setBackground(Color.ORANGE);
		bEquals.addActionListener(this);
		
		
		
		bDark = new JButton(".");
		bDark.setBounds(30, 200 , 60, 30);
		bDark.setFocusPainted(false);
		bDark.addActionListener(this);
		
		
		bDelete = new JButton("C");
		bDelete.setBounds(170, 200 , 60, 30);
		bDelete.setFocusPainted(false);
		bDelete.addActionListener(this);
		
		
		frame.add(panel);
		
		panel.add(bMyltiply);
		panel.add(bDivide);
		panel.add(bMinus);
		panel.add(bPlus);
		panel.add(bDelete);
		panel.add(bDark);
		panel.add(bEquals);
		

		
		b1 = new JButton("1");
		b1.setBounds(30, 80 , 60, 30);
		b1.setFocusPainted(false);
		b1.addActionListener(this);
		
		
		
		b2 = new JButton("2");
		b2.setBounds(100, 80 , 60, 30);
		b2.setFocusPainted(false);
		b2.addActionListener(this);
		
		
		b3 = new JButton("3");
		b3.setBounds(170, 80 , 60, 30);
		b3.setFocusPainted(false);
		b3.addActionListener(this);
		
		
		b4 = new JButton("4");
		b4.setBounds(30, 120 , 60, 30);
		b4.setFocusPainted(false);
		b4.addActionListener(this);
		
		
		b5 = new JButton("5");
		b5.setBounds(100, 120 , 60, 30);
		b5.setFocusPainted(false);
		b5.addActionListener(this);
		
		
		b6 = new JButton("6");
		b6.setBounds(170, 120 , 60, 30);
		b6.setFocusPainted(false);
		b6.addActionListener(this);
		
		
		b7 = new JButton("7");
		b7.setBounds(30, 160 , 60, 30);
		b7.setFocusPainted(false);
		b7.addActionListener(this);
		
		
		b8 = new JButton("8");
		b8.setBounds(100, 160 , 60, 30);
		b8.setFocusPainted(false);
		b8.addActionListener(this);
		
		
		b9 = new JButton("9");
		b9.setBounds(170, 160 , 60, 30);
		b9.setFocusPainted(false);
		b9.addActionListener(this);
		
		
		b0 = new JButton("0");
		b0.setBounds(100, 200 , 60, 30);
		b0.setFocusPainted(false);
		b0.addActionListener(this);
		
		
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		panel.add(b7);
		panel.add(b8);
		panel.add(b9);
		panel.add(b0);
	
		
		
		


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setSize(390, 350);
	
		frame.setBackground(Color.GRAY);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
	
		String currentText = label.getText();
		
		 
		if (e.getSource() == b1) {
	            label.setText(currentText + "1");
	        } else if (e.getSource() == b2) {
	            label.setText(currentText + "2");
	        } else if (e.getSource() == b3) {
	            label.setText(currentText + "3");
	        } else if (e.getSource() == b4) {
	            label.setText(currentText + "4");
	        } else if (e.getSource() == b5) {
	            label.setText(currentText + "5");
	        } else if (e.getSource() == b6) {
	            label.setText(currentText + "6");
	        } else if (e.getSource() == b7) {
	            label.setText(currentText + "7");
	        } else if (e.getSource() == b8) {
	            label.setText(currentText + "8");
	        } else if (e.getSource() == b9) {
	            label.setText(currentText + "9");
	        } else if (e.getSource() == b0) {
	           label.setText(currentText + "0");
	        } else if (e.getSource() == bDark) {
	            label.setText(currentText + bDark.getLabel());
	        } 
	        
	        
	        
	        else if (e.getSource() == bPlus) {
	            try {
	                var1 = Double.parseDouble(label.getText());
	            } catch (NumberFormatException f) {
	                label.setText("По-моему ты что-то препутал");
	                return;
	            }
	            
	            c = 1;
	            label.setText("");
	            
	        } else if (e.getSource() == bMinus) {
	            try {
	                var1 = Double.parseDouble(label.getText());
	            } catch (NumberFormatException f) {
	                label.setText("По-моему ты что-то препутал");
	                return;
	            }
	           currentText = "-";
	            label.setText("");
	            c=2;
	        } else if (e.getSource() == bMyltiply) {
	            try {
	                var1 = Double.parseDouble(label.getText());
	            } catch (NumberFormatException f) {
	                label.setText("По-моему ты что-то препутал");
	                return;
	            }
	            currentText = "*";
	            label.setText("");
	            c=3;
	        } else if (e.getSource() == bDivide) {
	            try {
	                var1 = Double.parseDouble(label.getText());
	            } catch (NumberFormatException f) {
	                label.setText("По-моему ты что-то препутал");
	                return;
	            }
	            currentText = "/";
	            label.setText("");
	            c=4;
	        }
	        else if (e.getSource() == bEquals) {
	            try {
	                var2 = Double.parseDouble(label.getText());
	                System.out.println(var2);
	            } catch (NumberFormatException f) {
	                label.setText("По-моему ты что-то перепутал");
	                return;
	                
	            }
	            
	            System.out.println(var1);
	            System.out.println(var2);
	            if (c == 1) {
	                result = var1 + var2;
	            }
	            if (c==2) {
	                result = var1 - var2;
	            }
	            if (c==3) {
	                result = var1 * var2;
	            }
	            if (c==4) {
	                result = var1 / var2;
	            }
	            System.out.print(result);

	            label.setText(String.valueOf(result));
	            
	            var1 = result; 
	            currentText = "";
	            
	            if (e.getSource() == bDelete) {
		            label.setText("");
		        }
	        }
	}
}

