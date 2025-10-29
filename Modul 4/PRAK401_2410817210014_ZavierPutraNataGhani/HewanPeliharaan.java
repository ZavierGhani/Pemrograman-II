package praktikum4.PRAK401_2410817210014_ZavierPutraNataGhani;


public class HewanPeliharaan {
    private String nama;
    private String ras;

    public HewanPeliharaan(String r, String n) {
        setRas(r);
        setNama(n);
    }

    public void display() {
        System.out.println("Detail Hewan Peliharaan:");
        System.out.println("Nama hewan peliharaanku adalah : " + getNama());
        System.out.println("Dengan ras : " + getRas());
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRas() {
        return ras;
    }

    public void setRas(String ras) {
        this.ras = ras;
    }
}
