import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;


public class Trilero extends JFrame {
	
	//Variables
	private static final long serialVersionUID = 3320166936822500448L;
	private int apuesta=10;
	private int dinero=100;
	private int intentos=0;
	private int aciertos=0;
	private int fallos=0;
	private String result;
	private JPanel contentPane;
	private JTextField Instrucciones;
	private JTextField WinOrLose;
	private JTextField numIntentos;
	private JTextField numAciertos;
	private JTextField numFallos;
	private JLabel lblIntentos;
	private JLabel lblAciertos;
	private JLabel lblFallos;
	private JButton btnReset;
	private JButton btnExit;
	private JTextField ApuestaActual;
	private JTextField DineroActual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Trilero frame = new Trilero();
					frame.setVisible(true);
					frame.CubileteRandom();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Trilero() {
		setResizable(false);
		setTitle("Trilero Game v.2.0 Graphical Edition");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Instrucciones = new JTextField();
		Instrucciones.setHorizontalAlignment(SwingConstants.CENTER);
		Instrucciones.setEditable(false);
		Instrucciones.setBounds(135, 11, 171, 19);
		contentPane.add(Instrucciones);
		Instrucciones.setColumns(10);
		Instrucciones.setText("Elige un cubilete: A, B o C");
		
		// Botones
		
		//Botones de apuestas

		JButton Apuesta10 = new JButton("10");
		Apuesta10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				apuesta=10;
				ApuestaActual.setText(""+apuesta);
				
			}
		});
		Apuesta10.setBounds(10, 213, 59, 25);
		contentPane.add(Apuesta10);
		
		JButton Apuesta20 = new JButton("20");
		Apuesta20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				apuesta=20;
				ApuestaActual.setText(""+apuesta);
			}
		});
		Apuesta20.setBounds(10, 240, 59, 25);
		contentPane.add(Apuesta20);
		
		JButton Apuesta30 = new JButton("30");
		Apuesta30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				apuesta=30;
				ApuestaActual.setText(""+apuesta);
			}
		});
		Apuesta30.setBounds(10, 267, 59, 25);
		contentPane.add(Apuesta30);
		
		//Botones de eleccion del cubilete
		JButton CubilB = new JButton("B");
		CubilB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (result=="B"){
					Acierto();
				}else{
					Fallo();
				}
			}
		});
		CubilB.setBounds(174, 163, 117, 25);
		contentPane.add(CubilB);
		
		JButton CubilC = new JButton("C");
		CubilC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (result=="C"){
					Acierto();
				}else{
					Fallo();
				}
			}
		});
		CubilC.setBounds(293, 163, 117, 25);
		contentPane.add(CubilC);
		
		JButton CubilA = new JButton("A");
		CubilA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (result=="A"){
					Acierto();
				}else{
					Fallo();
				}
			}
		});
		CubilA.setBounds(55, 163, 117, 25);
		contentPane.add(CubilA);
		
		//Boton de reset, pone todos los datos a 0 o en el caso de Strings a "", y el dinero y apuestas a su valor original
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApuestaActual.setText(""+10);
				apuesta=10;
				DineroActual.setText(""+100);
				dinero=100;
				intentos=0;
				fallos=0;
				aciertos=0;
				CubileteRandom();
				numIntentos.setText("");
				numAciertos.setText("");
				numFallos.setText("");
				WinOrLose.setText("");
			}
		});
		btnReset.setBounds(10, 59, 80, 23);
		contentPane.add(btnReset);
		
		//Boton de salir, simplemente termina la ejecucion del programa
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(346, 59, 80, 23);
		contentPane.add(btnExit);

		
		//Campos de texto y etiquetas del programa con sus propiedades
		WinOrLose = new JTextField();
		WinOrLose.setHorizontalAlignment(SwingConstants.CENTER);
		WinOrLose.setEditable(false);
		WinOrLose.setColumns(10);
		WinOrLose.setBounds(92, 111, 271, 25);
		contentPane.add(WinOrLose);
		
		numIntentos = new JTextField();
		numIntentos.setHorizontalAlignment(SwingConstants.CENTER);
		numIntentos.setEditable(false);
		numIntentos.setBounds(113, 60, 43, 20);
		contentPane.add(numIntentos);
		numIntentos.setColumns(10);
		
		numAciertos = new JTextField();
		numAciertos.setHorizontalAlignment(SwingConstants.CENTER);
		numAciertos.setEditable(false);
		numAciertos.setColumns(10);
		numAciertos.setBounds(199, 60, 43, 20);
		contentPane.add(numAciertos);
		
		numFallos = new JTextField();
		numFallos.setHorizontalAlignment(SwingConstants.CENTER);
		numFallos.setEditable(false);
		numFallos.setColumns(10);
		numFallos.setBounds(279, 60, 43, 20);
		contentPane.add(numFallos);
		
		lblIntentos = new JLabel("Intentos");
		lblIntentos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntentos.setBounds(102, 39, 65, 14);
		contentPane.add(lblIntentos);
		
		lblAciertos = new JLabel("Aciertos");
		lblAciertos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAciertos.setBounds(189, 39, 65, 14);
		contentPane.add(lblAciertos);
		
		lblFallos = new JLabel("Fallos");
		lblFallos.setHorizontalAlignment(SwingConstants.CENTER);
		lblFallos.setBounds(276, 39, 46, 14);
		contentPane.add(lblFallos);
		
		
		
		ApuestaActual = new JTextField();
		ApuestaActual.setHorizontalAlignment(SwingConstants.CENTER);
		ApuestaActual.setEditable(false);
		ApuestaActual.setColumns(10);
		ApuestaActual.setBounds(135, 217, 80, 71);
		contentPane.add(ApuestaActual);
		ApuestaActual.setText(""+apuesta);

		
		DineroActual = new JTextField();
		DineroActual.setHorizontalAlignment(SwingConstants.CENTER);
		DineroActual.setEditable(false);
		DineroActual.setColumns(10);
		DineroActual.setBounds(253, 217, 80, 71);
		contentPane.add(DineroActual);
		DineroActual.setText(""+dinero);
		
		JLabel lblApuesta = new JLabel("Apuesta $");
		lblApuesta.setHorizontalAlignment(SwingConstants.CENTER);
		lblApuesta.setBounds(135, 200, 80, 14);
		contentPane.add(lblApuesta);
		
		JLabel lblDinero = new JLabel("Dinero $");
		lblDinero.setHorizontalAlignment(SwingConstants.CENTER);
		lblDinero.setBounds(253, 200, 80, 14);
		contentPane.add(lblDinero);

	}
		

	

	/**
	 * Metodo para la eleccion aleatoria del cubilete. Saca un numero aleatorio entre 1 2 3, y segun el numero cambia la variable "resultado" a A B C
	 */
	public void CubileteRandom(){

		int a;
		a = (int)(Math.random()*3+1);
		switch(a){
		case 1: result="A";
		break;
		case 2: result="B";
		break;
		case 3: result="C";
		break;
		default: result="Error";
		break;
		
		}

	}

	/**
	 * Metodo para cuando aciertas
	 */
	public void Acierto(){
		WinOrLose.setText("Correcto, has acertado");
		aciertos++;
		AjustarResultados();
		SumarDinero();
	}
	/**
	 * Metodo para cuando fallas
	 */
	public void Fallo(){
		WinOrLose.setText("Error, has fallado");
		fallos++;
		AjustarResultados();
		RestarDinero();

		
	}
	

	/**
	 * Metodo para ajustar los resultados y preparar la siguiente ronda "CubileteRandom()"
	 */
	public void AjustarResultados(){
		intentos++;
		numIntentos.setText(""+intentos);
		numAciertos.setText(""+aciertos);
		numFallos.setText(""+fallos);
		CubileteRandom();
	}
	

	/**
	 * Metodo para ajustar el resultado del dinero actual en caso de acertar
	 */
	public void SumarDinero(){
		dinero = dinero + apuesta;
		DineroActual.setText(""+dinero);
	}
	

	/**
	 * Metodo para ajustar el resultado del dinero actual en caso de fallar
	 */
	public void RestarDinero(){
		dinero = dinero - apuesta;
		DineroActual.setText(""+dinero);
	}
}
