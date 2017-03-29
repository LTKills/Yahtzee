public class Dado {
	protected int lados, ultimo;
	
	/**
	 * 
	 * Classe onde é implementada a aleatorização do dado e a conversão da representação numérica da face
	 * para o formato texto 
	 * 
	 * */

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

	/**
	 *  Gerar o array de strings pois temos que imprimir linha a linha, não é possível
	 *  imprimir todo o dado de uma só vez pois os demais dados devem ficar adjacentes a este na tela
	 *  @return Array de Strings para que seja possível imprimir uma linha de cada vez
	 */
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
