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
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reportes extends JFrame {
    private JTextArea textAreaBecados;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JCheckBox chckbxIngenieriaCivil;
    private JCheckBox chckbxIngenieriaElectrica;
    private JCheckBox chckbxIngenieriaIndustrial;
    private JCheckBox chckbxIngenieriaSistema;
    private JCheckBox chckbxIngenieriaMecanica;
    private JCheckBox chckbxIngenieriaMaritima;
    private JCheckBox chckbxHombre;
    private JCheckBox chckbxMujer;
    private JCheckBox chckbxIndefinido;
    private JCheckBox chckbxOtros;
    private Becas becas;

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
        textAreaBecados.setBounds(52, 152, 184, 220);
        contentPane.add(textAreaBecados);

        JLabel lblNewLabel_2 = new JLabel("Filtro por Facultad:");
        lblNewLabel_2.setBounds(246, 156, 113, 14);
        contentPane.add(lblNewLabel_2);

        chckbxIngenieriaCivil = new JCheckBox("Ingenieria Civil");
        chckbxIngenieriaCivil.setBounds(411, 177, 141, 23);
        contentPane.add(chckbxIngenieriaCivil);

        chckbxIngenieriaElectrica = new JCheckBox("Ingenieria Electrica");
        chckbxIngenieriaElectrica.setBounds(411, 206, 141, 23);
        contentPane.add(chckbxIngenieriaElectrica);

        chckbxIngenieriaIndustrial = new JCheckBox("Ingenieria Industrial");
        chckbxIngenieriaIndustrial.setBounds(411, 232, 141, 23);
        contentPane.add(chckbxIngenieriaIndustrial);

        chckbxIngenieriaSistema = new JCheckBox("Ingenieria en Sistema");
        chckbxIngenieriaSistema.setBounds(246, 177, 141, 23);
        contentPane.add(chckbxIngenieriaSistema);

        chckbxIngenieriaMecanica = new JCheckBox("Ingenieria Mecanica");
        chckbxIngenieriaMecanica.setBounds(246, 206, 141, 23);
        contentPane.add(chckbxIngenieriaMecanica);

        chckbxIngenieriaMaritima = new JCheckBox("Ingenieria Maritima");
        chckbxIngenieriaMaritima.setBounds(246, 232, 141, 23);
        contentPane.add(chckbxIngenieriaMaritima);

        JLabel lblNewLabel_2_1 = new JLabel("Filtro por Sexo:");
        lblNewLabel_2_1.setBounds(246, 273, 113, 14);
        contentPane.add(lblNewLabel_2_1);

        chckbxHombre = new JCheckBox("Hombre");
        chckbxHombre.setBounds(246, 294, 141, 23);
        contentPane.add(chckbxHombre);

        chckbxMujer = new JCheckBox("Mujer");
        chckbxMujer.setBounds(246, 325, 141, 23);
        contentPane.add(chckbxMujer);

        chckbxIndefinido = new JCheckBox("Indefinido");
        chckbxIndefinido.setBounds(411, 294, 141, 23);
        contentPane.add(chckbxIndefinido);

        chckbxOtros = new JCheckBox("Otros");
        chckbxOtros.setBounds(411, 325, 141, 23);
        contentPane.add(chckbxOtros);

        JButton btnFiltrar = new JButton("Filtrar");
        btnFiltrar.setBounds(411, 399, 89, 23);
        contentPane.add(btnFiltrar);

        btnFiltrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filtrarEstudiantes();
            }
        });
    }

    public void mostrarBecados(Becas becas) {
        this.becas = becas;
        filtrarEstudiantes();
    }

    private void filtrarEstudiantes() {
        List<String> facultadesSeleccionadas = new ArrayList<>();
        if (chckbxIngenieriaCivil.isSelected()) facultadesSeleccionadas.add("Ingeniería Civil");
        if (chckbxIngenieriaElectrica.isSelected()) facultadesSeleccionadas.add("Ingeniería Eléctrica");
        if (chckbxIngenieriaIndustrial.isSelected()) facultadesSeleccionadas.add("Ingeniería Industrial");
        if (chckbxIngenieriaSistema.isSelected()) facultadesSeleccionadas.add("Ingeniería en Sistemas");
        if (chckbxIngenieriaMecanica.isSelected()) facultadesSeleccionadas.add("Ingeniería Mecánica");
        if (chckbxIngenieriaMaritima.isSelected()) facultadesSeleccionadas.add("Ingeniería Marítima");

        List<String> sexosSeleccionados = new ArrayList<>();
        if (chckbxHombre.isSelected()) sexosSeleccionados.add("Hombre");
        if (chckbxMujer.isSelected()) sexosSeleccionados.add("Mujer");
        if (chckbxIndefinido.isSelected()) sexosSeleccionados.add("Indefinido");
        if (chckbxOtros.isSelected()) sexosSeleccionados.add("Otros");

        StringBuilder sb = new StringBuilder();
        sb.append("Nombres de los Estudiantes:\n");

        for (Estudiantes estudiante : becas.getEstudiantes()) {
            if (estudiante.getIndiceAcademico() >= 2.0) {
                boolean facultadCoincide = facultadesSeleccionadas.isEmpty() || facultadesSeleccionadas.contains(estudiante.getCarrera());
                boolean sexoCoincide = sexosSeleccionados.isEmpty() || sexosSeleccionados.contains(estudiante.getSexo());

                if (facultadCoincide && sexoCoincide) {
                    sb.append(estudiante.getNombre()).append("\n");
                }
            }
        }

        textAreaBecados.setText(sb.toString());
    }
}

