package isabela_hello_world;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConversorMoeda extends JFrame {

    private JTextField valorTextField;
    private JComboBox<String> moedaComboBox;
    private JLabel resultadoLabel;

    // Taxas de conversão
    private static final double DOLAR = 5.2;
    private static final double EURO = 6.0;
    private static final double LIBRA = 7.2;

    public ConversorMoeda() {
        setTitle("Conversor de Moeda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel para os componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        // Campo de texto para o valor em reais
        valorTextField = new JTextField(10);
        panel.add(new JLabel("Valor em Reais:"));
        panel.add(valorTextField);

        // ComboBox para selecionar a moeda
        moedaComboBox = new JComboBox<>();
        moedaComboBox.addItem("Dólar");
        moedaComboBox.addItem("Euro");
        moedaComboBox.addItem("Libra");
        panel.add(new JLabel("Selecione a Moeda:"));
        panel.add(moedaComboBox);

        // Botão para realizar a conversão
        JButton converterButton = new JButton("Converter");
        converterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                converterMoeda();
            }
        });
        panel.add(converterButton);

        // Rótulo para exibir o resultado
        resultadoLabel = new JLabel("");
        panel.add(resultadoLabel);

        add(panel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); // Centraliza a janela
    }

    private void converterMoeda() {
        try {
            double valorEmReais = Double.parseDouble(valorTextField.getText());
            String moedaSelecionada = (String) moedaComboBox.getSelectedItem();
            double resultado = 0;

            switch (moedaSelecionada) {
                case "Dólar":
                    resultado = valorEmReais / DOLAR;
                    break;
                case "Euro":
                    resultado = valorEmReais / EURO;
                    break;
                case "Libra":
                    resultado = valorEmReais / LIBRA;
                    break;
            }

            resultadoLabel.setText(String.format("%.2f %s", resultado,
moedaSelecionada));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um número válido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ConversorMoeda().setVisible(true);
            }
        });
    }
}