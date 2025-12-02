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

            /**
             * Bagian ini memastikan agar input pilihan menu harus berupa angka.
             * Jika user memasukkan huruf, program tidak akan crash karena
             * Exception InputMismatchException ditangkap.
             */
            try {
                pilih = in.nextInt();  
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
            } finally {
                // Membersihkan buffer agar input selanjutnya tidak bermasalah
                in.nextLine();
            }

            // 1. MENAIKKAN PENUMPANG
            if (pilih == 1) {

                System.out.println("");

                // Input nama penumpang (boleh mengandung spasi)
                System.out.print("Nama    : ");
                String nama = in.nextLine();

                // Input umur, tetapi harus berupa angka → divalidasi
                System.out.print("Umur    : ");
                String umurStr = in.nextLine();
                int umur;

                /**
                 * Validasi umur.
                 * Jika umur bukan angka, program tidak crash.
                 * Program hanya menampilkan pesan error dan kembali ke menu.
                 */
                try {
                    umur = Integer.parseInt(umurStr);
                } catch (NumberFormatException ex) {
                    System.out.println("Umur tidak valid. Operasi dibatalkan.\n");
                    continue; // kembali ke menu
                }

                // Input status hamil → hanya menerima "y" atau "n"
                System.out.print("Hamil(y/n) : ");
                String hStr = in.nextLine().trim().toLowerCase();

                /**
                 * Validasi input status hamil.
                 * Jika selain "y" dan "n", maka dianggap invalid dan tidak diproses.
                 */
                if (!hStr.equals("y") && !hStr.equals("n")) {
                    System.out.println("Input hamil tidak valid. Harus y/n\n");
                    continue;
                }

                boolean hamil = hStr.equals("y");

                /**
                 * Membuat objek Penumpang baru.
                 * ID diambil berdasarkan jumlah penumpang saat ini + 1.
                 */
                Penumpang p = new Penumpang(
                    bus.getTotalPenumpang() + 1,
                    nama,
                    umur,
                    hamil
                );


