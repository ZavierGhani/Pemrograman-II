import java.util.Scanner;

public class PRAK104_2410817210014_ZavierPutraNataGhani {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Tangan Abu: ");
        String abu = scan.nextLine(); 
        System.out.print("Tangan Bagas: ");
        String bagas = scan.nextLine(); 

        String[] tanganAbu = abu.split(" ");
        String[] tanganBagas = bagas.split(" ");

        int poinAbu = 0, poinBagas = 0;

        for (int i = 0; i < 3; i++) {
            String a = tanganAbu[i];
            String b = tanganBagas[i];

            if (a.equals(b)) {
                // seri, tidak nambah poin
            } else if ((a.equals("B") && b.equals("G")) ||
                       (a.equals("G") && b.equals("K")) ||
                       (a.equals("K") && b.equals("B"))) {
                poinAbu++;
            } else {
                poinBagas++;
            }
        }

        if (poinAbu > poinBagas) {
            System.out.println("Abu");
        } else if (poinBagas > poinAbu) {
            System.out.println("Bagas");
        } else {
            System.out.println("Seri");
        }

        scan.close();
    }
}
