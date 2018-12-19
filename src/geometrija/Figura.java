package geometrija;

import java.awt.Graphics;
import java.io.Serializable;

abstract public class Figura implements Serializable 
{
	public String boja = "crna";
	public int debljina = 1;
	
	private static final long serialVersionUID = 7077851300107758074L;

	abstract public void iscrtajSe(Graphics povrsinaZaCrtanje);
}
