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

