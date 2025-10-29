package praktikum4.PRAK401_2410817210014_ZavierPutraNataGhani;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nama Hewan Peliharaan: ");
        String nama = sc.nextLine();

        System.out.print("Ras: ");
        String ras = sc.nextLine();

        HewanPeliharaan hp = new HewanPeliharaan(ras, nama);
        hp.display();

        sc.close();
    }
}