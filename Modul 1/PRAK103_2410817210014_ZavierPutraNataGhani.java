import java.util.Scanner;

public class PRAK103_2410817210014_ZavierPutraNataGhani {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan N dan bilangan awal: ");
        int N = scan.nextInt();
        int angka = scan.nextInt();

        int hitung = 0;
        do {
            if (angka % 2 != 0) { 
                System.out.print(angka);
                hitung++;

                if (hitung < N) {
                    System.out.print(",");
                }
            }
            angka++;
        } while (hitung < N);

        scan.close();
    }
}
