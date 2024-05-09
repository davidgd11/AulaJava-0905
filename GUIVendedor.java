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

import br.com.fiap.bean.Vendedor;

@SuppressWarnings("serial")
public class GUIVendedor extends JPanel{

	private JLabel lbNome, lbValorHora, lbComissao, lbImagem;
    private JTextArea taResultados;
    private JTextField tfNome, tfValorHora, tfComissao;
    private JButton btCalcularSalario;
    private ImageIcon imagem1;
    
    public GUIVendedor() {
    	inicializarComponentes();
		definirEventos();
    }
    
    private void inicializarComponentes() {
    	setLayout(null);
        setBackground(Color.cyan);
        lbNome = new JLabel("Nome Completo:", JLabel.RIGHT);
        lbValorHora = new JLabel("Hora de Trabalho:", JLabel.RIGHT);
        lbComissao = new JLabel("Comissão:", JLabel.RIGHT);
        tfNome = new JTextField();
        tfValorHora = new JTextField();
        tfComissao = new JTextField();      
        taResultados = new JTextArea("Cálculo do Salário", 5, 250);
        taResultados.setFont(new Font("Verdana", Font.BOLD, 14));
        taResultados.setForeground(Color.blue);
        taResultados.setBackground(getBackground());
        taResultados.setEditable(false);
        imagem1 = new ImageIcon(getClass().getResource("images/vendedor.png"));
        lbImagem = new JLabel(imagem1);     
        btCalcularSalario = new JButton("Calcular Salário");        
        lbNome.setBounds(10, 30, 120, 25);
        tfNome.setBounds(140, 30, 120, 25);
        lbValorHora.setBounds(10, 65, 120, 25);
        tfValorHora.setBounds(140, 65, 120, 25);
        lbComissao.setBounds(10, 100, 120, 25);
        tfComissao.setBounds(140, 100, 120, 25);
        btCalcularSalario.setBounds(30, 250, 140, 30);
        lbImagem.setBounds(280, 30, 128, 128);
        taResultados.setBounds(280, 180, 250, 100);     
        add(lbNome);
        add(tfNome);
        add(lbValorHora);
        add(tfValorHora);
        add(lbComissao);
        add(tfComissao);
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
                            || tfComissao.getText().isBlank()) {
                        throw new Exception("Preencha todos os campos!");
                    } else {
                        Vendedor vend = new Vendedor();
                        vend.setNome(tfNome.getText());
                        vend.setValorHoraTrabalho(Float.parseFloat(tfValorHora.getText()));
                        vend.setComissao(Float.parseFloat(tfComissao.getText()));
                        String resultados = "Cálculo do Salário"
                                + "\nNome: " + vend.getNome()
                                + "\nSalário R$ " + vend.calcularSalario();
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
