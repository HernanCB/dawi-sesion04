package org.ciberfarma.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.ciberfarma.modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCrudUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JTextField txtFchNac;
	private JTextField txtTipo;
	private JTextField txtEstado;
	private JTextField txtClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrudUsuario frame = new FrmCrudUsuario();
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
	public FrmCrudUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo :");
		lblNewLabel.setBounds(12, 13, 56, 16);
		contentPane.add(lblNewLabel);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(92, 10, 116, 22);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblNombe = new JLabel("Nombe");
		lblNombe.setBounds(12, 48, 56, 16);
		contentPane.add(lblNombe);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(92, 45, 267, 22);
		contentPane.add(txtNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(12, 91, 56, 16);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(92, 88, 267, 22);
		contentPane.add(txtApellido);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(12, 123, 56, 16);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(92, 120, 116, 22);
		contentPane.add(txtUsuario);
		
		JLabel lblFchNac = new JLabel("Fch Nac");
		lblFchNac.setBounds(12, 155, 56, 16);
		contentPane.add(lblFchNac);
		
		txtFchNac = new JTextField();
		txtFchNac.setColumns(10);
		txtFchNac.setBounds(92, 152, 116, 22);
		contentPane.add(txtFchNac);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(12, 187, 56, 16);
		contentPane.add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(92, 184, 116, 22);
		contentPane.add(txtTipo);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(258, 184, 56, 16);
		contentPane.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(338, 181, 116, 22);
		contentPane.add(txtEstado);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setBounds(258, 123, 56, 16);
		contentPane.add(lblClave);
		
		txtClave = new JTextField();
		txtClave.setColumns(10);
		txtClave.setBounds(338, 120, 116, 22);
		contentPane.add(txtClave);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registro();
			}
		});
		btnRegistrar.setBounds(529, 44, 97, 25);
		contentPane.add(btnRegistrar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultar();
			}
		});
		btnConsultar.setBounds(529, 99, 97, 25);
		contentPane.add(btnConsultar);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(529, 151, 97, 25);
		contentPane.add(btnListado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 216, 629, 187);
		contentPane.add(scrollPane);
		
		JTextArea txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}

	void listado() {
		//Obtener listado usuarios de los usuarios
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		
		//muestro el listado en el txt/pdf
		
		
	}

	void consultar() {
		int codigo = Integer.parseInt(txtCodigo.getText());
		//buscar el codigo en los usuarios, si existe muestra los datos, sino avisa
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		Usuario u = em.find(Usuario.class, codigo);
		
		if(u == null) {
			JOptionPane.showMessageDialog(this,"Usuario NO Registrado");
		}else {
			txtNombre.setText(u.getNombre());
			txtApellido.setText(u.getApellido());
			txtUsuario.setText(u.getUsuario());
			txtClave.setText(u.getClave());
			txtFchNac.setText(u.getFnacim());
			txtTipo.setText(u.getTipo()+"");
			txtEstado.setText(u.getEstado()+"");
			
		}
	}

	void registro() {
		//Leer datos Entradas
		String nombre =txtNombre.getText();
		String apellido = txtApellido.getText();
		String usuario = txtUsuario.getText();
		String clave = txtClave.getText();
		String fecha = txtFchNac.getText();
		int tipo = Integer.parseInt(txtTipo.getText());
		int estado = Integer.parseInt(txtEstado.getText());
		
		Usuario u = new Usuario();
		u.setNombre(nombre);
		u.setApellido(apellido);
		u.setUsuario(usuario);
		u.setClave(clave);
		u.setFnacim(fecha);
		u.setTipo(tipo);
		u.setEstado(estado);
		
		//proceso
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			JOptionPane.showMessageDialog(this,"Usuario Registrado");
		} catch (Exception e) {
			JOptionPane.showInternalMessageDialog(this,"Error al registrar : "+e);
		}finally {
			em.close();
		}
	}
}
