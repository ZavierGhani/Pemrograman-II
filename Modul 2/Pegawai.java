package praktikum2.PRAK203_2410817210014_ZavierPutraNataGhani;

//Pada baris ini terjadi error karena nama class tidak sesuai dengan nama file
//Nama file adalah Pegawai.java, jadi nama class harus Pegawai, bukan Employee
//awalnya public class Employee{  jadinya, public class Pegawai{
public class Pegawai {
 public String nama;

 // Pada baris ini terjadi error karena tipe data 'asal' seharusnya String, bukan char
 // public char asal;
 public String asal;

 public String jabatan;
 public int umur = 17; // ditambahin nilai default agar bisa sesuai output

 public String getNama() {
     return nama;
 }

 // Pada baris ini terjadi error karena tipe kembalian String, tapi 'asal' bertipe char di kode asli
 // Selain itu, 'return asal' harus sesuai tipe data atributnya
 // public String getAsal() {
 //     return asal;
 // }
 public String getAsal() {
     return asal;
 }

 // Pada baris ini terjadi error karena parameter 'j' tidak dideklarasikan.
 // public void setJabatan() {
 //     this.jabatan = j;
 // }
 // Solusi, tambahkan parameter bertipe String dan gunakan nilainya untuk mengisi atribut jabatan
 public void setJabatan(String j) {
     this.jabatan = j;
 }
}
