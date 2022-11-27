import java.util.Random;

public class Autobus extends Thread {
    static int AUTOBUS = 1;
    static int WYJAZD = 2;
    static int JAZDA = 3;
    static int DOTARCIE_DO_CELU = 4;
    static int WYPADEK_DROGOWY = 5;
    static int PRZERWA_NA_STACJI = 6;
    static int TANKUJ = 1000;
    static int REZERWA = 500;
    int numer;
    int paliwo;
    int stan;
    Stacja_PKS l;
    Random rand;

    public Autobus(int numer, int paliwo, Stacja_PKS l) {
        this.numer = numer;
        this.paliwo = paliwo;
        this.stan = JAZDA;
        this.l = l;
        rand = new Random();
    }

    public void run() {
        while (true) {
            if (stan == AUTOBUS) {
                if (rand.nextInt(2) == 1) {
                    stan = WYJAZD;
                    paliwo = TANKUJ;
                    System.out.println("prosze o zgode na wyjazd (autobus: " + numer+")");
                    stan = l.start(numer);
                } else {
                    System.out.println("Czekam");
                }
            } else if (stan == WYJAZD) {
                System.out.println("Wyruszam " + numer);
                stan = JAZDA;
            } else if (stan == JAZDA) {
                paliwo -= rand.nextInt(500);
                if (paliwo <= REZERWA) {
                    stan = DOTARCIE_DO_CELU;
                } else try {
                    sleep(rand.nextInt(1000));
                } catch (Exception e) {
                }
            } else if (stan == DOTARCIE_DO_CELU) {
                System.out.println("Wracam na stacje " + numer + " ilosc paliwa " + paliwo);
                stan = l.parkuj();
                if (stan == DOTARCIE_DO_CELU) {
                    paliwo -= rand.nextInt(500);
                    System.out.println("REZERWA " + paliwo);
                    if (paliwo <= 0) stan = WYPADEK_DROGOWY;
                }
            } else if (stan == WYPADEK_DROGOWY) {
                System.out.println("Wypadek autobusu: " + numer);
                l.zmniejsz();
            } else if(stan == PRZERWA_NA_STACJI){
                System.out.println("Autobus nr: " + numer+"Ma przerwe na stacji+");
            }
        }
    }
}
