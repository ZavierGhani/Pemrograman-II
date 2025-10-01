import java.util.Scanner;

public class PRAK102_2410817210014_ZavierPutraNataGhani {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan angka awal: ");
        int angka = scan.nextInt();

        int hitung = 0;
        while (hitung <= 10) {
            if (angka % 5 == 0) {
                int hasil = (angka / 5) - 1;
                System.out.print(hasil);
            } else {
                System.out.print(angka);
            }

            if (hitung < 10) {
                System.out.print(",");
            }

            angka++;
            hitung++;
        }

        scan.close();
    }
}
