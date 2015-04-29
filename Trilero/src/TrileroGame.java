import java.awt.BorderLayout;
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


public class TrileroGame extends JFrame {
	
	//Variables
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					TrileroGame frame = new TrileroGame();
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
	public TrileroGame() {
		setResizable(false);
		setTitle("Trilero Game v.1.0 Graphical Edition");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 237);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Instrucciones = new JTextField();
		Instrucciones.setHorizontalAlignment(SwingConstants.CENTER);
		Instrucciones.setEditable(false);
		Instrucciones.setBounds(146, 11, 146, 19);
		contentPane.add(Instrucciones);
		Instrucciones.setColumns(10);
		Instrucciones.setText("Elige un cubilete: A, B o C");
		
		// Botones para elegir cubiletes
		//Cada boton tiene 2 opciones acertar o fallar, en ambos casos se almacenan los resultados para que luego sean representados
		//Despues de cada resultado se hace un random nuevo con el metodo CubileteRandom()
		JButton CubilB = new JButton("B");
		CubilB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (result=="B"){
					WinOrLose.setText("Correcto, has acertado");
					intentos++;
					aciertos++;
					CubileteRandom();
					numIntentos.setText(""+intentos);
					numAciertos.setText(""+aciertos);
					numFallos.setText(""+fallos);
				}else{
					WinOrLose.setText("Error, has fallado");
					intentos++;
					fallos++;
					CubileteRandom();
					numIntentos.setText(""+intentos);
					numAciertos.setText(""+aciertos);
					numFallos.setText(""+fallos);
				}
			}
		});
		CubilB.setBounds(174, 163, 117, 25);
		contentPane.add(CubilB);
		
		JButton CubilC = new JButton("C");
		CubilC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (result=="C"){
					WinOrLose.setText("Correcto, has acertado");
					intentos++;
					aciertos++;
					CubileteRandom();
					numIntentos.setText(""+intentos);
					numAciertos.setText(""+aciertos);
					numFallos.setText(""+fallos);
				}else{
					WinOrLose.setText("Error, has fallado");
					intentos++;
					fallos++;
					CubileteRandom();
					numIntentos.setText(""+intentos);
					numAciertos.setText(""+aciertos);
					numFallos.setText(""+fallos);
				}
			}
		});
		CubilC.setBounds(293, 163, 117, 25);
		contentPane.add(CubilC);
		
		JButton CubilA = new JButton("A");
		CubilA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (result=="A"){
					WinOrLose.setText("Correcto, has acertado");
					intentos++;
					aciertos++;
					CubileteRandom();
					numIntentos.setText(""+intentos);
					numAciertos.setText(""+aciertos);
					numFallos.setText(""+fallos);
				}else{
					WinOrLose.setText("Error, has fallado");
					intentos++;
					fallos++;
					CubileteRandom();
					numIntentos.setText(""+intentos);
					numAciertos.setText(""+aciertos);
					numFallos.setText(""+fallos);
				}
			}
		});
		CubilA.setBounds(55, 163, 117, 25);
		contentPane.add(CubilA);

		
		//Aqui estan los campos de texto y etiquetas del programa con sus propiedades
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
		lblAciertos.setBounds(189, 41, 65, 14);
		contentPane.add(lblAciertos);
		
		lblFallos = new JLabel("Fallos");
		lblFallos.setHorizontalAlignment(SwingConstants.CENTER);
		lblFallos.setBounds(279, 41, 46, 14);
		contentPane.add(lblFallos);
		
		//Boton de reset, pone todos los datos a 0 o en el caso de Strings a ""
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
	}
	
	//Metodo para la eleccion aleatoria del cubilete
	//Saca un numero aleatorio entre 1 2 3, y segun el numero cambia la variable "resultado" a A B C
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
}