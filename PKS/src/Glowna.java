public class Glowna {
    static int ilosc_autobusow =100;
    static int ilosc_miejsc_parkingowych =5;
    static int ilosc_kierowcow = 100;
    static Stacja_PKS stacjaPKS;
    public Glowna(){
    }
    public static void main(String[] args) {
        stacjaPKS =new Stacja_PKS(ilosc_miejsc_parkingowych, ilosc_autobusow, ilosc_kierowcow);
        for(int i = 0; i< ilosc_autobusow; i++)
            new Autobus(i,2000, stacjaPKS).start();
    }

}
