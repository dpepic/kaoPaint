package GUI;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import geometrija.Duz;
import geometrija.Figura;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.Insets;
import java.awt.GridLayout;

public class MainWindow {

	private JFrame frmKaoPaint;
	private GridBagConstraints c_1;
	private GridBagConstraints c_2;
	private GridBagConstraints c_3;
	private GridBagConstraints c_4;
	public JCheckBox chckbxPun = new JCheckBox("Pun");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		MainWindow window = new MainWindow();
		window.frmKaoPaint.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKaoPaint = new JFrame();
		frmKaoPaint.setTitle("kao Paint :)");
		frmKaoPaint.setBounds(100, 100, 637, 432);
		frmKaoPaint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frmKaoPaint.getContentPane().setLayout(new BorderLayout(0, 0));

		JLabel lblStatus = new JLabel("New label");
		frmKaoPaint.getContentPane().add(lblStatus, BorderLayout.SOUTH);

		JPanel pnlZaAlate = new JPanel();
		frmKaoPaint.getContentPane().add(pnlZaAlate, BorderLayout.WEST);


		GridBagLayout gbl = new GridBagLayout();
		gbl.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl.columnWeights = new double[]{1.0, 0.0, 0.0};
		pnlZaAlate.setLayout(gbl);
		
		JPanel jpOpcijeObjekat = new JPanel();
		jpOpcijeObjekat.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		GridBagConstraints gbc_jpOpcijeObjekat = new GridBagConstraints();
		gbc_jpOpcijeObjekat.insets = new Insets(0, 0, 5, 5);
		gbc_jpOpcijeObjekat.fill = GridBagConstraints.BOTH;
		gbc_jpOpcijeObjekat.gridwidth = 3;
		gbc_jpOpcijeObjekat.gridx = 0;
		gbc_jpOpcijeObjekat.gridy = 0;
		pnlZaAlate.add(jpOpcijeObjekat, gbc_jpOpcijeObjekat);
		jpOpcijeObjekat.setLayout(new GridLayout(2, 2, 5, 5));
		
		
		
		chckbxPun.setEnabled(false);
		jpOpcijeObjekat.add(chckbxPun);

		JToggleButton tglbtnSelekcija = new JToggleButton("Selekcija");
		tglbtnSelekcija.setActionCommand("selekcija");
		GridBagConstraints gbc_tglbtnSelekcija = new GridBagConstraints();
		gbc_tglbtnSelekcija.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnSelekcija.gridx = 0;
		gbc_tglbtnSelekcija.gridy = 2;
		pnlZaAlate.add(tglbtnSelekcija, gbc_tglbtnSelekcija);

		JLabel lblIspunjen = new JLabel("FILL");
		lblIspunjen.setHorizontalAlignment(SwingConstants.LEFT);
		lblIspunjen.setVerticalTextPosition(SwingConstants.TOP);
		lblIspunjen.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblIspunjen = new GridBagConstraints();
		gbc_lblIspunjen.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIspunjen.insets = new Insets(0, 0, 5, 5);
		gbc_lblIspunjen.gridx = 1;
		gbc_lblIspunjen.gridy = 2;
		pnlZaAlate.add(lblIspunjen, gbc_lblIspunjen);

		JLabel lblLock = new JLabel("LOCK");
		GridBagConstraints gbc_lblLock = new GridBagConstraints();
		gbc_lblLock.insets = new Insets(0, 0, 5, 0);
		gbc_lblLock.gridx = 2;
		gbc_lblLock.gridy = 2;
		pnlZaAlate.add(lblLock, gbc_lblLock);

		JCheckBox chckbxKrug = new JCheckBox("");
		chckbxKrug.setToolTipText("Da li je pravilan krug");
		chckbxKrug.setSelected(true);
		GridBagConstraints gbc_chckbxKrug = new GridBagConstraints();
		gbc_chckbxKrug.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxKrug.gridx = 2;
		gbc_chckbxKrug.gridy = 4;
		pnlZaAlate.add(chckbxKrug, gbc_chckbxKrug);

		JCheckBox chckbxIspunjenjKrug = new JCheckBox("");
		chckbxIspunjenjKrug.setToolTipText("Da li je ispunjen");
		GridBagConstraints gbc_chckbxIspunjenjKrug = new GridBagConstraints();
		gbc_chckbxIspunjenjKrug.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxIspunjenjKrug.gridx = 1;
		gbc_chckbxIspunjenjKrug.gridy = 4;
		pnlZaAlate.add(chckbxIspunjenjKrug, gbc_chckbxIspunjenjKrug);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 5, 5);


		JToggleButton tglbtnCrtajDuz = new JToggleButton("Crtanje duzi");
		tglbtnCrtajDuz.setSelected(true);
		c.gridx = 0;
		c.gridy = 3;
		tglbtnCrtajDuz.setActionCommand("duz");

		pnlZaAlate.add(tglbtnCrtajDuz, c);

		JToggleButton tglbtnCrtajKrug = new JToggleButton("Crtanje kruga");
		tglbtnCrtajKrug.setActionCommand("krug");
		c_1 = new GridBagConstraints();
		c_1.fill = GridBagConstraints.HORIZONTAL;
		c_1.insets = new Insets(0, 0, 5, 5);
		c_1.gridx = 0;
		c_1.gridy = 4;
		pnlZaAlate.add(tglbtnCrtajKrug, c_1);

		JToggleButton tglbtnCrtanjeKvadrata = new JToggleButton("Crtanje kvadrata");
		tglbtnCrtanjeKvadrata.setActionCommand("kvadrat");
		c_2 = new GridBagConstraints();
		c_2.fill = GridBagConstraints.HORIZONTAL;
		c_2.insets = new Insets(0, 0, 5, 5);
		c_2.gridx = 0;
		c_2.gridy = 5;
		pnlZaAlate.add(tglbtnCrtanjeKvadrata, c_2);

		PanelZaCrtanje pnlZaCrtanje = new PanelZaCrtanje();
		pnlZaCrtanje.setBackground(Color.WHITE);


		pnlZaCrtanje.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmKaoPaint.getContentPane().add(pnlZaCrtanje, BorderLayout.CENTER);

		ButtonGroup grupaZaCrtanje = new ButtonGroup();
		grupaZaCrtanje.add(tglbtnCrtajDuz);
		grupaZaCrtanje.add(tglbtnCrtajKrug);
		grupaZaCrtanje.add(tglbtnCrtanjeKvadrata);
		grupaZaCrtanje.add(tglbtnSelekcija);


		JCheckBox chckbxIspunjen = new JCheckBox("");
		chckbxIspunjen.setToolTipText("Da li je ispunjen");
		GridBagConstraints gbc_chckbxIspunjen = new GridBagConstraints();
		gbc_chckbxIspunjen.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxIspunjen.gridx = 1;
		gbc_chckbxIspunjen.gridy = 5;
		pnlZaAlate.add(chckbxIspunjen, gbc_chckbxIspunjen);

		JCheckBox chckbxKvadrat = new JCheckBox("");
		chckbxKvadrat.setToolTipText("Da li je pravilan");
		chckbxKvadrat.setSelected(true);
		GridBagConstraints gbc_chckbxKvadrat = new GridBagConstraints();
		gbc_chckbxKvadrat.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxKvadrat.gridx = 2;
		gbc_chckbxKvadrat.gridy = 5;
		pnlZaAlate.add(chckbxKvadrat, gbc_chckbxKvadrat);

		JComboBox cmbBoje = new JComboBox();
		cmbBoje.setModel(new DefaultComboBoxModel(new String[] {"Crna", "Zelena", "Crvena", "Siva", "Zuta", "Plava", "Pink"}));
		cmbBoje.setSelectedIndex(0);
		c_3 = new GridBagConstraints();
		c_3.insets = new Insets(0, 0, 5, 5);
		c_3.gridx = 0;
		c_3.anchor = GridBagConstraints.WEST;
		c_3.gridy = 6;
		pnlZaAlate.add(cmbBoje, c_3);

		JComboBox cmbDebljina = new JComboBox();
		cmbDebljina.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		c_4 = new GridBagConstraints();
		c_4.insets = new Insets(0, 0, 0, 5);
		c_4.gridx = 0;
		c_4.anchor = GridBagConstraints.WEST;
		c_4.gridy = 7;
		pnlZaAlate.add(cmbDebljina, c_4);

		pnlZaCrtanje.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent arg0) 
			{
				switch (cmbBoje.getSelectedItem().toString())
				{
				case "Crna":
					pnlZaCrtanje.bojaZaCrtanje = Color.BLACK;
					break;
				case "Zelena":
					pnlZaCrtanje.bojaZaCrtanje = Color.GREEN;
					break;
				case "Crvena":
					pnlZaCrtanje.bojaZaCrtanje = Color.RED;
					break;
				case "Siva":
					pnlZaCrtanje.bojaZaCrtanje = Color.GRAY;
					break;
				case "Zuta":
					pnlZaCrtanje.bojaZaCrtanje = Color.YELLOW;
					break;
				case "Plava":
					pnlZaCrtanje.bojaZaCrtanje = Color.BLUE;
					break;
				case "Pink":
					pnlZaCrtanje.bojaZaCrtanje = Color.PINK;
					break;

				}
				pnlZaCrtanje.debljinaLinije = Integer.parseInt(cmbDebljina.getSelectedItem().toString());
				switch (grupaZaCrtanje.getSelection().getActionCommand())
				{
				case "duz":
					lblStatus.setText(pnlZaCrtanje.crtajDuz(arg0.getX(), arg0.getY()));
					break;
				case "krug":
					pnlZaCrtanje.pun = chckbxIspunjenjKrug.isSelected();
					pnlZaCrtanje.lock = chckbxKrug.isSelected();
					lblStatus.setText(pnlZaCrtanje.crtajKrug(arg0.getX(), arg0.getY()));
					break;
				case "kvadrat":
					pnlZaCrtanje.pun = chckbxIspunjen.isSelected();
					pnlZaCrtanje.lock = chckbxKvadrat.isSelected();
					lblStatus.setText(pnlZaCrtanje.crtajKvad(arg0.getX(), arg0.getY()));
					break;
				case "selekcija":
					pnlZaCrtanje.selektuj(arg0.getX(), arg0.getY());
					break;
				}
				
				if (pnlZaCrtanje.postojiSelektovana)
				{
					chckbxPun.setEnabled(true);
					chckbxPun.setSelected(pnlZaCrtanje.stanjePunjenja);
				} else
				{
					chckbxPun.setEnabled(false);
					chckbxPun.setSelected(false);
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0) 
			{
				pnlZaCrtanje.crtanjeUtoku = false;
				pnlZaCrtanje.repaint();			
			}

		});


		JMenuBar menuBar = new JMenuBar();
		frmKaoPaint.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					JFileChooser odabir = new JFileChooser();
					odabir.showOpenDialog(frmKaoPaint);

					FileInputStream inFajl = new FileInputStream(odabir.getSelectedFile());
					ObjectInputStream inObj = new ObjectInputStream(inFajl);

					while (true)
					{
						Figura fig = (Figura)inObj.readObject();
						pnlZaCrtanje.figure.add(fig);
					}

				} catch (IOException | ClassNotFoundException e) 
				{
					pnlZaCrtanje.repaint();
				}
			}
		});
		mnFile.add(mntmOpen);

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					JFileChooser snimanje = new JFileChooser();
					snimanje.showSaveDialog(frmKaoPaint);
					FileOutputStream fajl = new FileOutputStream(snimanje.getSelectedFile());
					ObjectOutputStream oOut = new ObjectOutputStream(fajl);
					for (Figura fig: pnlZaCrtanje.figure)
					{
						oOut.writeObject(fig);
					}
					oOut.close();
					fajl.close();
				} catch (IOException e) {}
			}
		});
		mnFile.add(mntmSave);

		JMenuItem mntmOcistiCrtez = new JMenuItem("Ocisti crtez");
		mntmOcistiCrtez.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				pnlZaCrtanje.figure.clear();
				pnlZaCrtanje.repaint();
			}
		});

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		mnEdit.add(mntmOcistiCrtez);

		JMenuItem mntmObrisiFiguru = new JMenuItem("Obrisi figuru");
		mntmObrisiFiguru.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if (pnlZaCrtanje.postojiSelektovana)
				{
					pnlZaCrtanje.figure.remove(pnlZaCrtanje.selektovanaFig);
					pnlZaCrtanje.repaint();
					chckbxPun.setSelected(false);
					chckbxPun.setEnabled(false);
					pnlZaCrtanje.deselektuj();
				}
			}
		});
		mnEdit.add(mntmObrisiFiguru);


		pnlZaCrtanje.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) 
			{
				switch (grupaZaCrtanje.getSelection().getActionCommand())
				{
				case "duz":
					pnlZaCrtanje.figuraZaIscrtavanje = "duz";
					pnlZaCrtanje.iscrtavanje(arg0.getX(), arg0.getY());
					break;
				case "krug":
					pnlZaCrtanje.figuraZaIscrtavanje = "krug";
					pnlZaCrtanje.iscrtavanje(arg0.getX(), arg0.getY());
					break;
				case "kvadrat":
					pnlZaCrtanje.figuraZaIscrtavanje = "kvadrat";
					pnlZaCrtanje.iscrtavanje(arg0.getX(), arg0.getY());
					break;
				}
			}
		});


		ActionListener zaDeselekciju = new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if (pnlZaCrtanje.postojiSelektovana)
				{
					pnlZaCrtanje.deselektuj();
					pnlZaCrtanje.repaint();
				}
			}
		};	
		
		chckbxPun.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent arg0) 
			{
				pnlZaCrtanje.pun = !pnlZaCrtanje.pun;
				pnlZaCrtanje.podesiStatus();
			}
		});
		
		tglbtnCrtajKrug.addActionListener(zaDeselekciju);
		tglbtnCrtajDuz.addActionListener(zaDeselekciju);
		tglbtnCrtanjeKvadrata.addActionListener(zaDeselekciju);   
	}
}
