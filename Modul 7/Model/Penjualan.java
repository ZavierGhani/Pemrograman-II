package Model;

public class Penjualan {

    private int id;
    private int pelangganId;
    private int bukuId;
    private int jumlah;
    private double total;

    public Penjualan() {
    }

    public Penjualan(int id, int pelangganId, int bukuId, int jumlah, double total) {
        this.id = id;
        this.pelangganId = pelangganId;
        this.bukuId = bukuId;
        this.jumlah = jumlah;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public int getPelangganId() {
        return pelangganId;
    }

    public int getBukuId() {
        return bukuId;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getTotal() {
        return total;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPelangganId(int pelangganId) {
        this.pelangganId = pelangganId;
    }

    public void setBukuId(int bukuId) {
        this.bukuId = bukuId;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
