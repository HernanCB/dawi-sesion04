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
import java.util.List;
import java.awt.event.ActionEvent;

public class FrmCrudUsuario extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JTextField txtFchNac;
	private JTextField txtTipo;
	private JTextField txtClave;
	private JTextField txtEstado;
	private JButton btnRegistrar;
	private JButton btnConsultar;
	private JButton btnListado;
	private JScrollPane scrollPane;
	private JTextArea txtS;

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
		setBounds(100, 100, 624, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Código");
		lblNewLabel.setBounds(12, 33, 56, 16);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(12, 75, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(12, 118, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Usuario");
		lblNewLabel_3.setBounds(12, 160, 56, 16);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Fch Nac :");
		lblNewLabel_4.setBounds(12, 200, 56, 16);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Tipo");
		lblNewLabel_5.setBounds(12, 245, 56, 16);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Clave");
		lblNewLabel_6.setBounds(269, 160, 56, 16);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Estado");
		lblNewLabel_7.setBounds(269, 245, 56, 16);
		contentPane.add(lblNewLabel_7);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(80, 30, 259, 22);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(80, 72, 259, 22);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(80, 115, 259, 22);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(80, 157, 116, 22);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtFchNac = new JTextField();
		txtFchNac.setBounds(80, 197, 116, 22);
		contentPane.add(txtFchNac);
		txtFchNac.setColumns(10);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(80, 242, 116, 22);
		contentPane.add(txtTipo);
		txtTipo.setColumns(10);
		
		txtClave = new JTextField();
		txtClave.setBounds(320, 157, 116, 22);
		contentPane.add(txtClave);
		txtClave.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(320, 242, 116, 22);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(497, 44, 97, 25);
		contentPane.add(btnRegistrar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(497, 96, 97, 25);
		contentPane.add(btnConsultar);
		
		btnListado = new JButton("Listado");
		btnListado.addActionListener(this);
		btnListado.setBounds(497, 156, 97, 25);
		contentPane.add(btnListado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 283, 582, 204);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListado) {
			actionPerformedBtnListado(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		registro();
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		consultar();
	}
	protected void actionPerformedBtnListado(ActionEvent e) {
		listado();
	}
	
	void listado() {
		//Obtener listado usuarios de los usuarios
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		///TypedQuery<Usuario> consulta = em.createNamedQuery("Usuario.findAll",Usuario.class);
		//List<Usuario> listadoUsuarios = consulta.getResultList();
		
		List<Usuario> listadoUsuarios;
		
		if (txtTipo.getText().isEmpty()) {
			 listadoUsuarios = em.createNamedQuery("Usuario.findAll",Usuario.class).getResultList();
		}else {
			int tipo = Integer.parseInt(txtTipo.getText());
			 listadoUsuarios = em.createNamedQuery("Usuario.findAllxTipo",Usuario.class).setParameter
					("xtipo", tipo).getResultList();
		}
			
		//muestro el listado en el txt/pdf
		txtS.setText("Listado de Usuarios\n");
		for (Usuario u : listadoUsuarios) {
			txtS.append(u.getCodigo()+"\t" + u.getNombre() + "\t" + u.getApellido() + "\n");
		}
		
	}

	void consultar() {
		//obtener el codigo a buscar
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
