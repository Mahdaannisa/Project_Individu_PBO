/**
 * Class Penumpang mewakili satu individu dalam sistem bus.
 * Class ini menyimpan identitas dasar penumpang seperti ID, nama, umur,
 * status kehamilan, serta saldo untuk membayar ongkos bus.
 *
 * Menggunakan konsep ENCAPSULATION karena seluruh atribut dibuat private
 * dan diakses melalui getter.
 */
public class Penumpang {

    // ===== ATRIBUT IDENTITAS PENUMPANG =====
    private int id;          // ID internal penumpang
    private String nama;     // Nama penumpang
    private int umur;        // Umur penumpang
    private boolean hamil;   // True jika hamil, false jika tidak

    // Saldo penumpang digunakan untuk membayar ongkos bus
    private int saldo;

    /**
     * Constructor untuk membuat penumpang baru.
     * Saldo awal wajib Rp 10.000 sesuai instruksi modul.
     */
    public Penumpang(int id, String nama, int umur, boolean hamil) {
        this.id = id;
        this.nama = nama;
        this.umur = umur;
        this.hamil = hamil;
        this.saldo = 10000;  // saldo awal
    }

    // ===== GETTER UNTUK AKSES DATA =====
    public int getID() { return id; }
    public String getNama() { return nama; }
    public int getUmur() { return umur; }
    public boolean getHamil() { return hamil; }
    public int getSaldo() { return saldo; }

    /**
     * Menambah saldo penumpang.
     * Digunakan ketika penumpang ingin top up.
     */
    public void tambahSaldo(int jumlah) {
        if (jumlah > 0) saldo += jumlah;
    }

    /**
     * Memotong saldo ketika penumpang membayar ongkos bus.
     */
    public void kurangiSaldo(int ongkos) {
        saldo -= ongkos;
    }

    /**
     * Menentukan apakah penumpang termasuk kategori prioritas.
     * Prioritas: umur < 10, umur > 60, atau sedang hamil.
     */
    public boolean isPrioritas() {
        return umur < 10 || umur > 60 || hamil == true;
    }

    /**
     * Representasi penumpang saat diprint → hanya namanya.
     */
    @Override
    public String toString() {
        return nama;
    }
}
