package praktikum2.PRAK202_2410817210014_ZavierPutraNataGhani;

class Kopi {
    String namaKopi;
    String ukuran;
    double harga;
    private String pembeli;

    void info() {
        System.out.println("Nama Kopi: " + namaKopi);
        System.out.println("Ukuran: " + ukuran);
        System.out.println("Harga: Rp. " + harga);
    }

    // Setter nama pembeli
    void setPembeli(String pembeli) {
        this.pembeli = pembeli;
    }

    // Getter nama pembeli
    String getPembeli() {
        return pembeli;
    }

    // NGitung pajak 11%
    double getPajak() {
        return harga * 0.11;
    }
}
