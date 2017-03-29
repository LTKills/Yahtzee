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


	public int rolar() {
		try {Thread.sleep(100);} catch(InterruptedException e) {}
		Random m = new Random();
		ultimo = m.getIntRand(lados);
        return ultimo;
	}

	public String[] toVecString() {
		String[] ret = new String[5];
        for(int i = 0; i < 5; i++) ret[i] = new String();

	    ret[0] = "+-----+";
	    ret[4] = "+-----+";

		if(ultimo == 0) ret[0] = "O dado nao foi rolado";
		else if(ultimo == 1) {
            ret[1] = "|     |";
            ret[2] = "|  *  |";
            ret[3] = "|     |";
		} else if(ultimo == 2) {
            ret[1] = "|*    |";
            ret[2] = "|     |";
            ret[3] = "|    *|";
		} else if(ultimo == 3) {
            ret[1] = "|*    |";
            ret[2] = "|  *  |";
            ret[3] = "|    *|";
		} else if(ultimo == 4) {
            ret[1] = "|*   *|";
            ret[2] = "|     |";
            ret[3] = "|*   *|";
		} else if(ultimo == 5) {
            ret[1] = "|*   *|";
            ret[2] = "|  *  |";
            ret[3] = "|*   *|";
		} else {
            ret[1] = "|*   *|";
            ret[2] = "|*   *|";
            ret[3] = "|*   *|";

		}
		return ret;
	}
}
