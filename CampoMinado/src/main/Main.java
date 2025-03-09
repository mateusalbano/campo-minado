package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.border.MatteBorder;

import gui.EscolherDificuldade;
import gui.Jogo;
import gui.MenuPrincipal;
import gui.Personalizado;

import java.awt.Color;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MenuPrincipal menuPrincipal;
	private EscolherDificuldade escolherDificuldade;
	private Personalizado personalizado;
	public static boolean gameOn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("Campo minado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		menuPrincipal = new MenuPrincipal();
		menuPrincipal.setBorder(new MatteBorder(5, 5, 5, 5, (Color) null));
		escolherDificuldade = new EscolherDificuldade();
		escolherDificuldade.setBorder(new MatteBorder(5, 5, 5, 5, (Color) null));
		personalizado = new Personalizado();
		personalizado.setBorder(new MatteBorder(5, 5, 5, 5, (Color) null));
		setContentPane(menuPrincipal);
		menuPrincipal.btnIniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setContentPane(escolherDificuldade);
				revalidate();
			}
		});
		
		menuPrincipal.btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		escolherDificuldade.btnFacil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (gameOn) {
					return;
				}
				JFrame jogo = new Jogo("Fácil", 7, 7, 0.05);
				jogo.setVisible(true);
				gameOn = true;
			}
		});
		
		escolherDificuldade.btnMedio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (gameOn) {
					return;
				}
				JFrame jogo = new Jogo("Médio", 10, 10, 0.1);
				jogo.setVisible(true);
				gameOn = true;
			}
		});
		
		escolherDificuldade.btnDificil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (gameOn) {
					return;
				}
				JFrame jogo = new Jogo("Difícil", 15, 15, 0.15);
				jogo.setVisible(true);
				gameOn = true;
			}
		});
		
		escolherDificuldade.btnRetornar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setContentPane(menuPrincipal);
				revalidate();
			}
		});
		
		escolherDificuldade.btnPersonalizado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setContentPane(personalizado);
				revalidate();
			}
		});
		
		personalizado.btnRetornar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setContentPane(escolherDificuldade);
				revalidate();
			}
		});
		
		personalizado.btnJogar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (gameOn) {
					return;
				}
				JFrame jogo = new Jogo("Personalizado", personalizado.getColunas(), personalizado.getLinhas(), (double)personalizado.getBombRate() / 100);
				jogo.setVisible(true);
				gameOn = true;
			}
		});
	}
}
