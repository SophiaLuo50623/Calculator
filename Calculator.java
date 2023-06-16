import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Calculator implements ActionListener{
	JFrame frame;
	JTextField textField;
	JButton[] numberButtons = new JButton[10];
	JButton[] operatorButtons = new JButton[8];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton;
	JPanel panel;
	
	Font myFont = new Font("Ink Free", Font.BOLD, 30);
	
	double num1 = 0, num2 = 0, result = 0;
	String operator;
	
	
	Calculator(){
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(50, 25, 300, 50);
		textField.setFont(myFont);
		textField.setEditable(true);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		divButton = new JButton("\u00F7");
		mulButton = new JButton("\u00D7");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("<-");
		clrButton = new JButton("CLEAR");
		
		operatorButtons[0] = addButton;
		operatorButtons[1] = subButton;
		operatorButtons[2] = mulButton;
		operatorButtons[3] = divButton;
		operatorButtons[4] = decButton;
		operatorButtons[5] = equButton;
		operatorButtons[6] = delButton;
		operatorButtons[7] = clrButton;
		
		for(int i = 0; i < 8; i++) {
			operatorButtons[i].addActionListener(this);
			operatorButtons[i].setFont(myFont);
			operatorButtons[i].setFocusable(false);
		}
		
		for(int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		delButton.setBounds(50, 420, 145, 50); // x y width height
		clrButton.setBounds(205, 420, 145, 50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300); // ? not showing
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		panel.setBackground(Color.GRAY);
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(numberButtons[0]);
		panel.add(decButton);
		panel.add(divButton);
		panel.add(equButton);
		
		frame.add(panel);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textField);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource() == decButton) {
			textField.setText(textField.getText().concat("."));
		}
		
		
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = "+";
			textField.setText("");
		}
		
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = "-";
			textField.setText("");
		}
		
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = "\u00D7";
			textField.setText("");
		}
		
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = "\u00F7";
			textField.setText("");
		}
		
		if(e.getSource() == equButton) {
			num2 = Double.parseDouble(textField.getText());			
			
			switch(operator) {
			case "+":
				result = (int) num1 + num2;
				break;
				
			case "-":
				result = num1 - num2;
				break;
				
			case "\u00D7":
				result = num1 * num2;
				break;
			
			
			case "\u00F7":
				result = num1 / num2;
				break;
			
			}
			textField.setText(String.valueOf(result));
			num1 = result;
		}
		
		if (e.getSource() == clrButton) {
			textField.setText("");
		}
		
		if (e.getSource() == delButton) {
			String string = textField.getText();
			textField.setText("");
			for (int i = 0; i < string.length()-1;i++) {
				textField.setText(textField.getText() + string.charAt(i));
			}
		}
		
	
	}
}
