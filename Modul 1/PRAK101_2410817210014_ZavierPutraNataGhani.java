import java.util.Scanner;

public class PRAK101_2410817210014_ZavierPutraNataGhani {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Nama Lengkap: ");
        String nama = input.nextLine();

        System.out.print("Masukkan Tempat Lahir: ");
        String tempat = input.nextLine();

        System.out.print("Masukkan Tanggal Lahir: ");
        int tanggal = input.nextInt();

        System.out.print("Masukkan Bulan Lahir: ");
        int bulan = input.nextInt();

        System.out.print("Masukkan Tahun Lahir: ");
        int tahun = input.nextInt();

        int tinggi;
        do {
            System.out.print("Masukkan Tinggi Badan: ");
            tinggi = input.nextInt();
            if (tinggi <= 0) {
                System.out.println("Tinggi tidak boleh 0 atau negatif, ulangi input!");
            }
        } while (tinggi <= 0);

        double berat;
        do {
            System.out.print("Masukkan Berat Badan: ");
            berat = input.nextDouble();
            if (berat <= 0) {
                System.out.println("Berat tidak boleh 0 atau negatif, ulangi input!");
            }
        } while (berat <= 0);

        String namaBulan = "";
        switch (bulan) {
            case 1: namaBulan = "Januari"; break;
            case 2: namaBulan = "Februari"; break;
            case 3: namaBulan = "Maret"; break;
            case 4: namaBulan = "April"; break;
            case 5: namaBulan = "Mei"; break;
            case 6: namaBulan = "Juni"; break;
            case 7: namaBulan = "Juli"; break;
            case 8: namaBulan = "Agustus"; break;
            case 9: namaBulan = "September"; break;
            case 10: namaBulan = "Oktober"; break;
            case 11: namaBulan = "November"; break;
            case 12: namaBulan = "Desember"; break;
            default: namaBulan = "Bulan Tidak Valid";
        }

        System.out.println("Nama Lengkap " + nama + ", Lahir di " + tempat +
                " pada Tanggal " + tanggal + " " + namaBulan + " " + tahun);
        System.out.println("Tinggi Badan " + tinggi + " cm dan Berat Badan " + berat + " kilogram");

        input.close();
    }
}
