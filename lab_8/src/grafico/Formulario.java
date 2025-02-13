package grafico;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


//importar clases del paquete
import logica.Estudiantes;
import logica.Becas;

//Importar elementos de diseño 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
public class Formulario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textIndice;
	private JTextField textCedula;
	private JComboBox<String> comboBoxCarreras;
	private JComboBox<String> comboBoxsexo;
	
	 private ArrayList<Estudiantes> estudiantes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
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
	public Formulario() {
		 estudiantes = new ArrayList<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		JLabel lblNewLabel = new JLabel("Información de estudiantes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(277, 10, 271, 62);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(21, 97, 95, 22);
		contentPane.add(lblNewLabel_1);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textNombre.setBounds(141, 102, 153, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Indice:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(21, 311, 95, 22);
		contentPane.add(lblNewLabel_1_1);
		
		textIndice = new JTextField();
		textIndice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textIndice.setColumns(10);
		textIndice.setBounds(141, 312, 153, 19);
		contentPane.add(textIndice);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Cédula:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(21, 166, 95, 22);
		contentPane.add(lblNewLabel_1_1_1);
		
		textCedula = new JTextField();
		textCedula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textCedula.setColumns(10);
		textCedula.setBounds(141, 167, 153, 19);
		contentPane.add(textCedula);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Sexo:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2.setBounds(21, 239, 95, 22);
		contentPane.add(lblNewLabel_1_1_2);
		
		comboBoxsexo = new JComboBox<>();
        comboBoxsexo.setModel(new DefaultComboBoxModel<>(new String[]{"Hombre", "Mujer", "Indefinido", "Otros"}));
        comboBoxsexo.setBounds(141, 239, 153, 21);
        comboBoxsexo.setSelectedIndex(-1);
        contentPane.add(comboBoxsexo);

		
		JButton btnGuardar = new JButton("Guardar Datos");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGuardar.setBounds(460, 163, 184, 34);
		contentPane.add(btnGuardar);
		
		JButton btnReportes = new JButton("Mostrar Reportes");
		btnReportes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnReportes.setBounds(654, 361, 184, 34);
		contentPane.add(btnReportes);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Carrera:");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2_1.setBounds(21, 374, 95, 22);
		contentPane.add(lblNewLabel_1_1_2_1);
		
		 comboBoxCarreras = new JComboBox<>();
	        comboBoxCarreras.setModel(new DefaultComboBoxModel<>(new String[]{"Ingeniería Civil", "Ingeniería Eléctrica", "Ingeniería Industrial", "Ingeniería en Sistemas", "Ingeniería Mecánica", "Ingeniería Marítima"}));
	        comboBoxCarreras.setSelectedIndex(-1);
	        comboBoxCarreras.setBounds(141, 371, 153, 21);
	        contentPane.add(comboBoxCarreras);
	        
	        JLabel lblNewLabel_2 = new JLabel("Hecho por: Juan Botacio , Abigail Koo, Octavio Frauca y Maria Quiñones");
	        lblNewLabel_2.setBounds(254, 488, 385, 14);
	        contentPane.add(lblNewLabel_2);

		// Agregar ActionListener para el botón "Guardar Datos"
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para guardar la información
                guardarDatos();
            }
        });
        
        btnReportes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cierra la ventana actual
                dispose();
                // Crear una instancia de la clase Becas
                Becas becas = new Becas();

                // Agregar todos los estudiantes del formulario a la instancia de Becas
                for (Estudiantes estudiante : estudiantes) {
                    becas.agregarEstudiante(estudiante);
                }
                // Abre la ventana de reportes
                Reportes reportes = new Reportes();
                reportes.setVisible(true);
                reportes.mostrarBecados(becas);
            }
        });
	}
	
	 private void guardarDatos() {
		 try {
		        // Obtener los datos ingresados por el usuario
		        String nombre = textNombre.getText();
		        String cedula = textCedula.getText();
		        double indice = Double.parseDouble(textIndice.getText());
		        String carrera = (String) comboBoxCarreras.getSelectedItem();
		        String sexo = (String) comboBoxsexo.getSelectedItem();

		       
		        Estudiantes estudiante = new Estudiantes(nombre, cedula, carrera, indice, sexo);
		        // Impresión en consola
		        System.out.println("Información del estudiante guardada: " + estudiante.toString());
		        estudiantes.add(estudiante);
	           
		        // Mostrar un mensaje de confirmación al usuario final 
		        JOptionPane.showMessageDialog(this, "Información guardada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

		      
		        textNombre.setText("");
		        textCedula.setText("");
		        textIndice.setText("");
		        comboBoxCarreras.setSelectedIndex(-1);
		        comboBoxsexo.setSelectedIndex(-1);
		    } catch (NumberFormatException e) {
		     
		        JOptionPane.showMessageDialog(this, "Por favor, ingrese datos válidos para Índice.", "Error", JOptionPane.ERROR_MESSAGE);
		    } catch (IllegalArgumentException e) {
	            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
		 
		}
}
