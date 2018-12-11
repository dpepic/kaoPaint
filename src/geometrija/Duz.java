package geometrija;

public class Duz
{
	Tacka a;
	Tacka b;
	
	public Duz(Tacka prva, Tacka druga)
	{
		this.a = prva;
		this.b = druga;
	}
	
	public double vratiDuzinu()
	{
		return Math.sqrt((Math.pow((b.x - a.x), 2) + Math.pow((b.y - a.y), 2)));  
	}
}
