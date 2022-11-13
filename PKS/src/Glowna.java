public class Glowna {
    static int ilosc_autobusow =100000;
    static int ilosc_miejsc_parkingowych =5;
    static Stacja_PKS stacjaPKS;
    public Glowna(){
    }
    public static void main(String[] args) {
        stacjaPKS =new Stacja_PKS(ilosc_miejsc_parkingowych, ilosc_autobusow);
        for(int i = 0; i< ilosc_autobusow; i++)
            new Autobus(i,2000, stacjaPKS).start();
    }

}