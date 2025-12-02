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
