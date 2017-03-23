
public class Dado {
	protected int lados, ultimo;
	
	
	Dado() {
		lados = 6;
		ultimo = 0;
	}
	
	Dado(int n) {
		lados = n;
		ultimo = 0;
	}
	
	public int getLado() {
		return ultimo;
	}
	
	
	public void rolar() {
		try {Thread.sleep(100);} catch(InterruptedException e) {}
		Random m = new Random();
		ultimo = m.getIntRand(lados);
	}
	
	@Override 
	public String toString() {
		String ret = new String();
		if(ultimo == 0) ret = "O dado não foi rolado";
		else if(ultimo == 1) {
			ret = "+-----+" + '\n' + "|     |" + '\n' +  
				   "|  *  |" + '\n' +  "|     |" + '\n' +  "+-----+"; 
		} else if(ultimo == 2) {
			ret = "+-----+" + '\n' + "|*    |" + '\n' +  
			"|     |" + '\n' +  "|    *|" + '\n' +  "+-----+";
		} else if(ultimo == 3) {
			ret = "+-----+" + '\n' + "|*    |" + '\n' +  
			"|  *  |" + '\n' +  "|    *|" + '\n' +  "+-----+";
		} else if(ultimo == 4) {
			ret = "+-----+" + '\n' + "|*   *|" + '\n' +  
			"|     |" + '\n' +  "|*   *|" + '\n' +  "+-----+";
		} else if(ultimo == 5) {
			ret = "+-----+" + '\n' + "|*   *|" + '\n' +  
			"|  *  |" + '\n' +  "|*   *|" + '\n' +  "+-----+";
		} else {
			ret = "+-----+" + '\n' + "|*   *|" + '\n' +  
			"|*   *|" + '\n' +  "|*   *|" + '\n' +  "+-----+";
		}
		return ret;
	}
}
