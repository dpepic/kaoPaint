package GUI;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import geometrija.Duz;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.BoxLayout;

public class MainWindow {

	private JFrame frmKaoPaint;

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
		frmKaoPaint.setBounds(100, 100, 450, 300);
		frmKaoPaint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmKaoPaint.setJMenuBar(menuBar);
		frmKaoPaint.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblStatus = new JLabel("New label");
		frmKaoPaint.getContentPane().add(lblStatus, BorderLayout.SOUTH);
		
		JPanel pnlZaAlate = new JPanel();
		frmKaoPaint.getContentPane().add(pnlZaAlate, BorderLayout.WEST);
		

		
		PanelZaCrtanje pnlZaCrtanje = new PanelZaCrtanje();
		pnlZaCrtanje.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) 
			{
				pnlZaCrtanje.iscrtavanje(arg0.getX(), arg0.getY());
			}
		});
		pnlZaCrtanje.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent arg0) 
			{
				lblStatus.setText(pnlZaCrtanje.crtajDuz(arg0.getX(), arg0.getY()));
			}
		});
		pnlZaCrtanje.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmKaoPaint.getContentPane().add(pnlZaCrtanje, BorderLayout.CENTER);
		
		JButton btnTest = new JButton("Proba");
		btnTest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					FileOutputStream fajl = new FileOutputStream("test.obj");
					ObjectOutputStream oOut = new ObjectOutputStream(fajl);
					for (Duz linija: pnlZaCrtanje.duzi)
					{
						oOut.writeObject(linija);
					}
					oOut.close();
					fajl.close();
					pnlZaCrtanje.duzi.clear();
					pnlZaCrtanje.repaint();
				} catch (IOException e) 
				{
					
					e.printStackTrace();
				}
			}
		});
		pnlZaAlate.setLayout(new BoxLayout(pnlZaAlate, BoxLayout.Y_AXIS));
		
		JButton btnLoad = new JButton("Ucitaj");
		btnLoad.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					FileInputStream inFajl = new FileInputStream("test.obj");
					ObjectInputStream inObj = new ObjectInputStream(inFajl);
					
					while (true)
					{
						Duz nova = (Duz) inObj.readObject();
						pnlZaCrtanje.duzi.add(nova);
					}
					
				} catch (IOException | ClassNotFoundException e) 
				{
					pnlZaCrtanje.repaint();
				}
				
			}
		});
		pnlZaAlate.add(btnLoad);
		pnlZaAlate.add(btnTest);
	}

}
