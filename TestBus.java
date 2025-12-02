import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class TestBus : class utama yang menjalankan program.
 * Class ini berfungsi sebagai antarmuka (interface) antara pengguna dan sistem Bus.
 *
 * Fungsinya:
 * - Menampilkan menu utama
 * - Menangani input dari user (nama, umur, status hamil)
 * - Melakukan validasi input agar program tidak crash
 * - Memanggil fungsi pada class Bus sesuai pilihan pengguna
 *
 * Prinsip yang digunakan:
 * - Exception Handling untuk input yang tidak valid
 * - Percabangan (if-else) untuk menjalankan menu
 */
public class TestBus {

    public static void main(String[] args) {

        // Objek Scanner digunakan untuk membaca input dari keyboard
        Scanner in = new Scanner(System.in);

        // Membuat objek Bus (satu bus yang digunakan sepanjang program)
        Bus bus = new Bus();

        System.out.println("===== BUS TRANS KOETARADJA =====");

        // Perulangan agar menu terus tampil sampai user memilih keluar
        while (true) {

            // Menampilkan daftar menu pilihan
            System.out.println("MENU:");
            System.out.println("1. Naikkan Penumpang");
            System.out.println("2. Turunkan Penumpang");
            System.out.println("3. Lihat Penumpang");
            System.out.println("4. Lihat Total Pendapatan");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");

            int pilih = -1;

