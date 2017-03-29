public class RolaDados {
    Dado[] dice;

    RolaDados(int n) {
        dice = new Dado[n];
        for(int i = 0; i < n; i++) dice[i] = new Dado();
    }

    public int[] rolar() {
        int[] ans = new int[dice.length];
        for(int i = 0; i < dice.length; i++) ans[i] = dice[i].rolar();
        return ans;
    }

    public int[] rolar(boolean[] quais) {
        int[] ans = new int[dice.length];
        for(int i = 0; i < dice.length; i++) {
            if(quais[i] == true)
                ans[i] = dice[i].rolar();
            else
                ans[i] = dice[i].getLado();
        }
        return ans;
    }

    public int[] rolar(String s) {
        String a;
        String[] which = s.split(" ");
        int val = 0;
        boolean[] quais = new boolean[dice.length];

        for(int i = 0; i < which.length; i++) {
            val = Integer.parseInt(which[i]);
            quais[val] = true;
        }

        return rolar(quais);
    }

    @Override
    public String toString() {
        String space = "     ";
        String ans = "";

        for(int i = 0; i < dice.length; i++) {
            ans += " " + i + "     " + space;
        }
        ans += "\n";

        for(int j = 0; j < 5; j++) {
            for(int i = 0; i < dice.length; i++) {
                ans += dice[i].toVecString()[0] + space;
            }
            ans += "\n";
        }

        return ans;
    }
}
