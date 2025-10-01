import java.util.Scanner;

public class PRAK105_2410817210014_ZavierPutraNataGhani {
    public static void main(String[] args) {
        final double PHI = 3.14;
        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan jari-jari: ");
        double r = scan.nextDouble();

        System.out.print("Masukkan tinggi: ");
        double t = scan.nextDouble();

        double volume = PHI * r * r * t;

        System.out.printf("Volume tabung dengan jari-jari %.1f cm dan%ntinggi %.1f cm adalah %.3f m3%n", r, t, volume);

        scan.close();
    }
}
