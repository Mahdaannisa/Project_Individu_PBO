import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class Bus bertugas mengelola seluruh penumpang di dalam bus.
 * Bus memiliki 3 jenis area duduk/berdiri:
 *
 * 1. Penumpang Prioritas  (maks 4 kursi)
 * 2. Penumpang Biasa      (maks 16 kursi)
 * 3. Penumpang Berdiri    (maks 20 orang)
 *
 * Total kapasitas bus adalah 40 orang.
 *
 * Selain mengatur penumpang, class ini juga mencatat:
 * - Total pendapatan bus (berasal dari pembayaran ongkos)
 * - Ongkos bus tetap (2000 rupiah)
 *
 * Class ini menjadi pusat logika sistem (business logic).
 */
public class Bus {

    //  ATRIBUT PENYIMPAN DATA

    /**
     * Menyimpan daftar penumpang prioritas.
     * Menggunakan ArrayList agar mudah menambah dan menghapus penumpang.
     */
    private ArrayList<Penumpang> penumpangPrioritas;

    /** 
     * Menyimpan daftar penumpang yang duduk di kursi biasa.
     */
    private ArrayList<Penumpang> penumpangBiasa;

    /**
     * Menyimpan daftar penumpang yang berdiri.
     */
    private ArrayList<Penumpang> penumpangBerdiri;

    /**
     * Ongkos bus telah ditetapkan secara tetap, yaitu Rp 2000.
     * Menggunakan 'final' agar nilainya tidak bisa diubah.
     */
    public static final int ONGKOS_BUS = 2000;

    /**
     * Menyimpan total pendapatan bus berdasarkan jumlah penumpang yang naik.
     */
    private int totalPendapatan;

    //  CONSTRUCTOR

    /**
     * Constructor Bus.
     * Menginisialisasi semua ArrayList agar siap digunakan.
     * Juga mengatur nilai pendapatan awal = 0.
     */
    public Bus() {
        penumpangPrioritas = new ArrayList<>();
        penumpangBiasa = new ArrayList<>();
        penumpangBerdiri = new ArrayList<>();
        totalPendapatan = 0;
    }

    //  METHOD GETTER INFORMASI JUMLAH

    /**
     * Mengembalikan jumlah penumpang pada kursi biasa.
     */
    public int getJumlahPenumpangBiasa() { 
        return penumpangBiasa.size(); 
    }

    /**
     * Mengembalikan jumlah penumpang pada kursi prioritas.
     */
    public int getJumlahPenumpangPrioritas() { 
        return penumpangPrioritas.size(); 
    }

    /**
     * Mengembalikan jumlah penumpang di area berdiri.
     */
    public int getJumlahPenumpangBerdiri() { 
        return penumpangBerdiri.size(); 
    }

    /**
     * Mengembalikan total seluruh penumpang yang ada di dalam bus.
     */
    public int getTotalPenumpang() {
        return getJumlahPenumpangPrioritas() +
               getJumlahPenumpangBiasa() +
               getJumlahPenumpangBerdiri();
    }

    /**
     * Mengembalikan total pendapatan bus.
     */
    public int getTotalPendapatan() {
        return totalPendapatan;
    }

    //  METHOD UNTUK MENAIKKAN PENUMPANG

    /**
     * Method ini bertanggung jawab untuk:
     * - Mengecek saldo penumpang
     * - Mengecek kapasitas bus
     * - Memotong saldo penumpang & menambah pendapatan bus
     * - Menentukan kategori tempat duduk (prioritas → biasa → berdiri)
     *
     * Mengembalikan true jika penumpang berhasil naik.
     * Mengembalikan false jika gagal.
     */
    public boolean naikkanPenumpang(Penumpang p) {

        // 1. Validasi saldo
        if (p.getSaldo() < ONGKOS_BUS) {
            System.out.println("Saldo tidak cukup!");
            return false;
        }

        // 2. Validasi kapasitas total bus
        if (getTotalPenumpang() >= 40) {
            System.out.println("Bus sudah penuh!");
            return false;
        }

        // 3. Potong saldo penumpang dan tambahkan ke pendapatan bus
        p.kurangiSaldo(ONGKOS_BUS);
        totalPendapatan += ONGKOS_BUS;

        // 4. Jika penumpang prioritas dan masih ada kursi prioritas
        if (p.isPrioritas() && penumpangPrioritas.size() < 4) {
            penumpangPrioritas.add(p);
            return true;
        }

        // 5. Jika kursi biasa masih tersedia
        if (penumpangBiasa.size() < 16) {
            penumpangBiasa.add(p);
            return true;
        }

        // 6. Jika kursi habis → masukkan ke area berdiri
        if (penumpangBerdiri.size() < 20) {
            penumpangBerdiri.add(p);
            return true;
        }

        // Tidak seharusnya terjadi karena kapasitas 40 sudah dicek di atas
        return false;
    }

    //  METHOD MENURUNKAN PENUMPANG

    /**
     * Menurunkan penumpang berdasarkan nama.
     *
     * Pencarian dilakukan pada:
     * - penumpang prioritas
     * - penumpang biasa
     * - penumpang berdiri
     *
     * Menggunakan Iterator agar aman saat menghapus objek dari ArrayList
     * ketika proses iterasi berlangsung (menghindari ConcurrentModificationException).
     */
    public boolean turunkanPenumpang(String nama) {

        // Cek kategori prioritas terlebih dahulu
        Iterator<Penumpang> it = penumpangPrioritas.iterator();
        while (it.hasNext()) {
            if (it.next().getNama().equalsIgnoreCase(nama)) {
                it.remove();
                return true;
            }
        }

        // Cek kategori penumpang biasa
        it = penumpangBiasa.iterator();
        while (it.hasNext()) {
            if (it.next().getNama().equalsIgnoreCase(nama)) {
                it.remove();
                return true;
            }
        }

        // Cek kategori penumpang berdiri
        it = penumpangBerdiri.iterator();
        while (it.hasNext()) {
            if (it.next().getNama().equalsIgnoreCase(nama)) {
                it.remove();
                return true;
            }
        }

        return false; // penumpang tidak ditemukan pada semua kategori
    }

    //  METHOD UNTUK MENAMPILKAN LIST PENUMPANG

    /**
     * Mengubah isi ArrayList penumpang menjadi sebuah string.
     * Jika list kosong, kembalikan "<kosong>".
     *
     * Digunakan untuk menampilkan laporan bus secara rapi.
     */
    public String listToString(ArrayList<Penumpang> list) {
        if (list.isEmpty()) return "<kosong>";

        StringBuilder sb = new StringBuilder();

        for (Penumpang p : list) {
            sb.append(p.getNama()).append(", ");
        }

        // Menghapus koma terakhir ", "
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }


