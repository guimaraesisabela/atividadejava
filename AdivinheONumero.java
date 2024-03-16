package isabela_hello_world;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class AdivinheONumero extends JFrame {

    private JLabel mensagemLabel;
    private JTextField chuteTextField;
    private JButton novoJogoButton;
    private int numeroAdivinhar;
    private boolean jogoAtivo;

    public AdivinheONumero() {
        setTitle("Adivinhe o Número");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

       
        mensagemLabel = new JLabel("Eu tenho um número entre 1 e 100, você pode adivinhá-lo? Entre com seu chute.");
        add(mensagemLabel, BorderLayout.NORTH);

        
        chuteTextField = new JTextField(10);
        chuteTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verificarChute();
            }
        });
        add(chuteTextField, BorderLayout.CENTER);

        
        novoJogoButton = new JButton("Novo Jogo");
        novoJogoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarNovoJogo();
            }
        });
        add(novoJogoButton, BorderLayout.SOUTH);

        iniciarNovoJogo(); 

        pack();
        setLocationRelativeTo(null); 
    }

    private void iniciarNovoJogo() {
        Random random = new Random();
        numeroAdivinhar = random.nextInt(100) + 1;
        jogoAtivo = true;
        chuteTextField.setEditable(true);
        chuteTextField.setText("");
        mensagemLabel.setText("Eu tenho um número entre 1 e 100, você pode adivinhá-lo? Entre com seu chute.");
    }

    private void verificarChute() {
        if (jogoAtivo) {
            try {
                int chute = Integer.parseInt(chuteTextField.getText());
                if (chute < 1 || chute > 100) {
                    JOptionPane.showMessageDialog(this, "Por favor, insira um número entre 1 e 100.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (chute == numeroAdivinhar) {
                        mensagemLabel.setText("Correto!");
                        chuteTextField.setEditable(false);
                        jogoAtivo = false;
                    } else if (chute < numeroAdivinhar) {
                        mensagemLabel.setText("Tente um número maior. (" + (chute + 1) + " - 100)");
                    } else {
                        mensagemLabel.setText("Tente um número menor. (1 - " + (chute - 1) + ")");
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AdivinheONumero().setVisible(true);
            }
        });
    }
}

