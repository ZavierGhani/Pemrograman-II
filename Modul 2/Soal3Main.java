package praktikum2.PRAK203_2410817210014_ZavierPutraNataGhani;


public class Soal3Main {
    public static void main(String[] args) {

        // Pada baris ini terjadi error karena nama class yang diinstansiasi adalah 'Pegawai'
        // tetapi di file Pegawai.java sebelumnya nama class-nya 'Employee'.
        // Setelah diperbaiki di file Pegawai.java, baris ini sudah benar.
        Pegawai p1 = new Pegawai();

        // Pada baris ini terjadi error karena kurang titik koma di akhir pernyataan
        // p1.nama = "Roi"
        p1.nama = "Roi";

        // Pada baris ini terjadi error karena tipe data 'asal' di class Pegawai awalnya char,
        // tapi diberikan nilai String. Setelah diperbaiki di Pegawai.java jadi String, baris ini jadi palid
        p1.asal = "Kingdom of Orvel";

        // Baris ini jadi benar, karena method setJabatan(String) sudah diperbaiki agar punya parameter
        p1.setJabatan("Assasin");

        System.out.println("Nama: " + p1.getNama());
        System.out.println("Asal: " + p1.getAsal());
        System.out.println("Jabatan: " + p1.jabatan);
        System.out.println("Umur: " + p1.umur + " tahun");
    }
}
