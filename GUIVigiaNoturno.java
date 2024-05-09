package br.com.fiap.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.fiap.bean.VigiaNoturno;

@SuppressWarnings("serial")
public class GUIVigiaNoturno extends JPanel{

	private JLabel lbNome, lbValorHora, lbAdicionalNoturno, lbImagem;
    private JTextArea taResultados;
    private JTextField tfNome, tfValorHora, tfAdicionalNoturno;
    private JButton btCalcularSalario;
    private ImageIcon imagem1;
    
    public GUIVigiaNoturno() {
    	inicializarComponentes();
		definirEventos();
    }
    
    private void inicializarComponentes() {
    	setLayout(null);
        setBackground(Color.green);
        lbNome = new JLabel("Nome Completo:", JLabel.RIGHT);
        lbValorHora = new JLabel("Hora de Trabalho:", JLabel.RIGHT);
        lbAdicionalNoturno = new JLabel("Adicional noturno:", JLabel.RIGHT);
        tfNome = new JTextField();
        tfValorHora = new JTextField();
        tfAdicionalNoturno = new JTextField();      
        taResultados = new JTextArea("Cálculo do Salário", 5, 250);
        taResultados.setFont(new Font("Verdana", Font.BOLD, 14));
        taResultados.setForeground(Color.blue);
        taResultados.setBackground(getBackground());
        taResultados.setEditable(false);
        imagem1 = new ImageIcon(getClass().getResource("images/vigia_noturno.png"));
        lbImagem = new JLabel(imagem1);     
        btCalcularSalario = new JButton("Calcular Salário");        
        lbNome.setBounds(10, 30, 120, 25);
        tfNome.setBounds(140, 30, 120, 25);
        lbValorHora.setBounds(10, 65, 120, 25);
        tfValorHora.setBounds(140, 65, 120, 25);
        lbAdicionalNoturno.setBounds(10, 100, 120, 25);
        tfAdicionalNoturno.setBounds(140, 100, 120, 25);
        btCalcularSalario.setBounds(30, 250, 140, 30);
        lbImagem.setBounds(280, 30, 128, 128);
        taResultados.setBounds(280, 180, 250, 100);     
        add(lbNome);
        add(tfNome);
        add(lbValorHora);
        add(tfValorHora);
        add(lbAdicionalNoturno);
        add(tfAdicionalNoturno);
        add(btCalcularSalario);
        add(lbImagem);
        add(taResultados);
    }
    
    private void definirEventos(){
    	btCalcularSalario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
                    if (tfNome.getText().isBlank() || tfValorHora.getText().isBlank()
                            || tfAdicionalNoturno.getText().isBlank()) {
                        throw new Exception("Preencha todos os campos!");
                    } else {
                    	VigiaNoturno vigia = new VigiaNoturno();
                    	vigia.setNome(tfNome.getText());
                    	vigia.setValorHoraTrabalho(Float.parseFloat(tfValorHora.getText()));
                    	vigia.setAdicionalNoturno(Float.parseFloat(tfAdicionalNoturno.getText()));
                        String resultados = "Cálculo do Salário"
                                + "\nNome: " + vigia.getNome()
                                + "\nSalário R$ " + vigia.calcularSalario();
                        taResultados.setText(resultados);
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, e2.getMessage(), 
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
			}
		});
    }
	
}
