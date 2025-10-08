package praktikum2.PRAK201_2410817210014_ZavierPutraNataGhani;;

class Buah {
    String nama;
    double berat;
    double harga;
    double jumlahBeli;
    double hargaSebelumDiskon;
    double totalDiskon;
    double hargaSetelahDiskon;
    Buah(String namaBuah, double beratBuah, double hargaBuah, double jumlahBeliKg) {
        this.nama = namaBuah;
        this.berat = beratBuah;
        this.harga = hargaBuah;
        this.jumlahBeli = jumlahBeliKg;

        // harga sebelum diskon
        this.hargaSebelumDiskon = harga * (jumlahBeli / beratBuah);

        // total diskon (2% per 4kg)
        this.totalDiskon = (int)(jumlahBeli / 4) * (4 * harga) * 0.02;

        // harga setelah diskon
        this.hargaSetelahDiskon = hargaSebelumDiskon - totalDiskon;
    }

    void tampilkanInfo() {
        System.out.println("Nama Buah: " + nama);
        System.out.println("Berat: " + berat);
        System.out.println("Harga: " + harga);
        System.out.println("Jumlah Beli: " + jumlahBeli + "kg");
        System.out.println("Harga Sebelum Diskon: Rp" + String.format("%.2f", hargaSebelumDiskon));
        System.out.println("Total Diskon: Rp" + String.format("%.2f", totalDiskon));
        System.out.println("Harga Setelah Diskon: Rp" + String.format("%.2f", hargaSetelahDiskon));
        System.out.println();
    }
}
