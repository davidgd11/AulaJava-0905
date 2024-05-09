package br.com.fiap.main;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class GUIPrincipal extends JFrame{
	
	private Container contentPane;
	private JMenuBar mnBarra;
	private JMenu mnArquivo, mnFuncionario;
	private JMenuItem miSair, miFreelancer, miVendedor, miVigiaNoturno;
	
	public GUIPrincipal(){
		inicializarComponentes();
		definirEventos();
	}
	
	private void inicializarComponentes() {
		setTitle("Janela Principal");
		setBounds(0, 0, 600, 400);
		contentPane = getContentPane();
		
		mnBarra = new JMenuBar();
		mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('A');
		mnFuncionario = new JMenu("Funcionario");
		mnFuncionario.setMnemonic('F');
		miSair = new JMenuItem("Sair", new ImageIcon(getClass().getResource("images/exit_icon.png")));
		miFreelancer = new JMenuItem("Freelancer");
		miVendedor = new JMenuItem("Vendedor");
		miVigiaNoturno =new JMenuItem("Vigia Noturno");
		
		setJMenuBar(mnBarra);
		mnBarra.add(mnArquivo);
		mnBarra.add(mnFuncionario);
		mnArquivo.add(miSair);
		mnFuncionario.add(miFreelancer);
		mnFuncionario.add(miVendedor);
		mnFuncionario.add(miVigiaNoturno);
		
	}
	
	private void definirEventos() {
		miSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		miFreelancer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//declarar e instanciar objeto de GUIFreelancer
				GUIFreelancer freela = new GUIFreelancer();	
				contentPane.removeAll();
				// adicionar objeto GUIFreelancer ao contentPane
				contentPane.add(freela);
				contentPane.validate();
				
			}
		});
		
		miVendedor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GUIVendedor vend = new GUIVendedor();
				contentPane.removeAll();
				contentPane.add(vend);
				contentPane.validate();
			}
		});
		
		miVigiaNoturno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GUIVigiaNoturno vigia = new GUIVigiaNoturno();
				contentPane.removeAll();
				contentPane.add(vigia);
				contentPane.validate();
			}
		});
	}
	
	public static void main(String[] args) {
		GUIPrincipal frame = new GUIPrincipal();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getWidth()) / 2, (tela.height - frame.getHeight())/2);
		frame.setVisible(true);
	}

}
