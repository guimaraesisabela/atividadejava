
package isabela_hello_world;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora extends JFrame implements ActionListener {

    private JTextField display;
    private String operator;
    private double num1, num2, resultado;

    public Calculadora() {
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

      
        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

     
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

 
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(Integer.toString(i));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

       
        JButton zeroButton = new JButton("0");
        zeroButton.addActionListener(this);
        buttonPanel.add(zeroButton);

        
        String[] operators = {"+", "-", "*", "/"};
        for (String op : operators) {
            JButton button = new JButton(op);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

      
        JButton equalsButton = new JButton("=");
        equalsButton.addActionListener(this);
        buttonPanel.add(equalsButton);

        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

       
        if (Character.isDigit(command.charAt(0))) {
            display.setText(display.getText() + command);
        } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            
            num1 = Double.parseDouble(display.getText());
            operator = command;
            display.setText("");
        } else if (command.equals("=")) {
            
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "*":
                    resultado = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        resultado = Double.NaN; 

                    }
                    break;
            }
            display.setText(Double.toString(resultado));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculadora().setVisible(true);
            }
        });
    }
}

