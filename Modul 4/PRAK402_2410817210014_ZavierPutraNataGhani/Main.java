package praktikum4.PRAK402_2410817210014_ZavierPutraNataGhani;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Pilih jenis hewan yang ingin diinputkan:");
        System.out.println("1 = Kucing");
        System.out.println("2 = Anjing");
        System.out.print("Masukkan pilihan: ");
        int pilih = sc.nextInt();
        sc.nextLine();

        System.out.print("Nama hewan peliharaan: ");
        String nama = sc.nextLine();
        System.out.print("Ras: ");
        String ras = sc.nextLine();
        System.out.print("Warna Bulu: ");
        String warna = sc.nextLine();

        if (pilih == 1){
            Kucing kc = new Kucing(ras, nama, warna);
            kc.displayDetailKucing();
        } 
        else if (pilih == 2){
            System.out.print("Kemampuan : ");
            String[] kemampuan = sc.nextLine().split(", ");
            Anjing aj = new Anjing(ras, nama, warna, kemampuan);
            aj.displayDetailAnjing();
        } 
        else {
            System.out.println("Input salah");
        }

        sc.close();
    }
}