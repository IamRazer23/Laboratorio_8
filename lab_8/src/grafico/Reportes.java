package grafico;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import logica.Becas;
import logica.Estudiantes;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reportes extends JFrame {
	private JTextArea textAreaBecados;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reportes frame = new Reportes();
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
	public Reportes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reportes");
		lblNewLabel.setBounds(238, 10, 149, 46);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Estudiantes Becados:");
		lblNewLabel_1.setBounds(52, 106, 221, 35);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_1);
		
		textAreaBecados = new JTextArea();
		textAreaBecados.setEditable(false);
		textAreaBecados.setBounds(52, 151, 184, 220);
		contentPane.add(textAreaBecados);
		
		JLabel lblNewLabel_2 = new JLabel("Filtro:");
		lblNewLabel_2.setBounds(246, 156, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Carreras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(256, 188, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
	void mostrarBecados(Becas becas) {
        System.out.println("Estudiantes becados obtenidos: " + becas.obtenerEstudiantesBecados().size());

        StringBuilder sb = new StringBuilder();
        sb.append("Nombres de los Estudiantes:\n");

        for (String nombre : becas.obtenerEstudiantesBecados()) {
            sb.append(nombre).append("\n");
        }

        textAreaBecados.setText(sb.toString());
    }
}
