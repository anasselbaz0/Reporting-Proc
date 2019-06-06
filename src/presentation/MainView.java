package presentation;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controlleur cont;
	
	 public Controlleur getCont() {
		return cont;
	}
	
	public void setCont(Controlleur cont) {
		this.cont = cont;
	}

	public MainView(HashMap<String, Integer> statistiquesDemandes) {
		setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 703);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBorder(new LineBorder(new Color(0, 153, 255), 4, true));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		tabbedPane.addTab("Demandes", null, p1, null);
		p1.setLayout(new BorderLayout(20, 20));
		
		JPanel demandes_p = new JPanel();
		demandes_p.setBorder(new EmptyBorder(100, 100, 100, 100));
		demandes_p.setBackground(Color.WHITE);
		p1.add(demandes_p, BorderLayout.CENTER);
		demandes_p.setLayout(new GridLayout(0, 2, 100, 50));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		p1.add(panel, BorderLayout.NORTH);
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualiser();
			}
		});
		btnActualiser.setForeground(Color.WHITE);
		btnActualiser.setBackground(new Color(0, 153, 255));
		panel.add(btnActualiser);
		
		JPanel employes_p = new JPanel();
		employes_p.setBackground(Color.WHITE);
		tabbedPane.addTab("Employes", null, employes_p, null);
		
		JPanel titles = new JPanel();
		contentPane.add(titles, BorderLayout.NORTH);
		titles.setLayout(new BorderLayout(0, 0));
		
		JPanel statis = new JPanel();
		statis.setBorder(new EmptyBorder(50, 50, 50, 50));
		statis.setBackground(Color.WHITE);
		titles.add(statis);
		
		JLabel lblStatistiques = new JLabel("Statistiques");
		lblStatistiques.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		statis.add(lblStatistiques);
		
		JPanel admin = new JPanel();
		admin.setBackground(Color.WHITE);
		titles.add(admin, BorderLayout.EAST);
		admin.setLayout(new BorderLayout(0, 0));
		
		JLabel lblAdministrateur = new JLabel("Administrateur");
		lblAdministrateur.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministrateur.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		admin.add(lblAdministrateur);
		
		for (Entry<String, Integer> entry : statistiquesDemandes.entrySet()) {
		    demandes_p.add(new JLabel(entry.getKey()));
		    demandes_p.add(new JLabel(entry.getValue().toString()));
		}
		
	}

	protected void actualiser() {
		getCont().actualiser();
		this.dispose();
		MainView frame = new MainView(getCont().getStatistiquesDemandes());
		getCont().setView(frame);
		frame.setCont(cont);
		frame.setVisible(true);
	}

}
