package isabela_hello_world;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculoPoupanca extends JFrame {

    private JTextField valorTextField;
    private JTextField jurosTextField;
    private JTextField mesesTextField;
    private JLabel totalPoupadoLabel;
    private JButton calcularButton;

    public CalculoPoupanca() {
        setTitle("Cálculo da Poupança");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        
        add(new JLabel("Valor Mensal de Contribuição (R$):"));
        valorTextField = new JTextField(10);
        add(valorTextField);

        add(new JLabel("Percentual de Juros (%):"));
        jurosTextField = new JTextField(10);
        add(jurosTextField);

        add(new JLabel("Número de Meses de Contribuição:"));
        mesesTextField = new JTextField(10);
        add(mesesTextField);

        add(new JLabel("Total Poupado (R$):"));
        totalPoupadoLabel = new JLabel("");
        add(totalPoupadoLabel);

        
        calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularTotalPoupado();
            }
        });
        add(calcularButton);

        pack();
        setLocationRelativeTo(null); 
    }

    private void calcularTotalPoupado() {
        try {
            double valor = Double.parseDouble(valorTextField.getText());
            double juros =Double.parseDouble(jurosTextField.getText()) / 100.0; 
            int meses = Integer.parseInt(mesesTextField.getText());

            double totalPoupado = 0;
            for (int i = 0; i < meses; i++) {
                totalPoupado += valor;
                totalPoupado *= (1 + juros);
            }

            totalPoupadoLabel.setText(String.format("%.2f", totalPoupado));
        } catch (NumberFormatException ex) {
        	JOptionPane.showMessageDialog(this, "Por favor,insira valores numéricos válidos.", "Erro", JOptionPane.ERROR_MESSAGE);

        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculoPoupanca().setVisible(true);
            }
        });
    }
}