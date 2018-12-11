import geometrija.*;

public class start {

	public static void main(String[] args) 
	{
		Duz linija = new Duz(new Tacka(1,1), new Tacka(1,6));
		Duz linija2 = new Duz(new Tacka(1,1), new Tacka(1,4));
		
		System.out.println("Duzina stranice: " + linija.vratiDuzinu());
		
		Kvadrat neki = new Kvadrat(linija);
		
		System.out.println("Povrsina: " + neki.povrsina());
	    System.out.println("Obim: " + neki.obim());	
	    
		Pravougaonik neki2 = new Pravougaonik(linija, linija2);
		
		System.out.println("Povrsina: " + neki2.povrsina());
	    System.out.println("Obim: " + neki2.obim());	
	}

}
