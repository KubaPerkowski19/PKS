public class Stacja_PKS {
    static int AUTOBUS =1;
    static int WYJAZD =2;
    static int JAZDA =3;
    static int DOTARCIE_DO_CELU =4;
    static int WYPADEK_DROGOWY =5;
    int miejsca_parkingowe;
    int zajete_miejsca_parkingowe;
    int ilosc_autobusow;
    Stacja_PKS(int miejsca_parkingowe, int ilosc_autobusow){
        this.miejsca_parkingowe =miejsca_parkingowe;
        this.ilosc_autobusow =ilosc_autobusow;
        this.zajete_miejsca_parkingowe =0;
    }
    synchronized int start(int numer){
        zajete_miejsca_parkingowe--;
        System.out.println("Wyjazd autobusu z punktu "+numer);
        return WYJAZD;
    }
    synchronized int parkuj(){
        try{
            Thread.currentThread().sleep(1000);//sleep for 1000 ms
        }
        catch(Exception ie){
        }
        if(zajete_miejsca_parkingowe < miejsca_parkingowe){
            zajete_miejsca_parkingowe++;
            System.out.println("Powrut autobusu na punkt "+ zajete_miejsca_parkingowe);
            return AUTOBUS;
        }
        else
        {return DOTARCIE_DO_CELU;}
    }
    synchronized void zmniejsz(){
        ilosc_autobusow--;
        System.out.println("WYPADEK");
        if(ilosc_autobusow == miejsca_parkingowe) System.out.println("Tyle samo miejsc parkingowych co autobusow");
    }
}
