package praktikum4.PRAK402_2410817210014_ZavierPutraNataGhani;

public class Anjing extends HewanPeliharaan {
    private String warnaBulu;
    private String[] kemampuan;

    public Anjing(String r, String n, String w, String[] k){
        super(r, n);
        this.warnaBulu = w;
        this.kemampuan = k;
    }

    public void displayDetailAnjing(){
        super.display();
        System.out.println("Memiliki warna bulu : " + warnaBulu);
        System.out.print("Memiliki kemampuan : ");

        for (int i = 0; i < kemampuan.length; i++){
            System.out.print(kemampuan[i].trim());
            if (i < kemampuan.length - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
