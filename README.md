# **PROJECT INDIVIDU PBO**

**Nama  : Mahda Annisa**

**NPM   : 2408107010036** 

# **Sistem Manajemen Penumpang Bus Trans Koetaradja**
**Deskripsi Proyek**
Program ini merupakan simulasi Sistem Manajemen Penumpang Bus yang dibuat menggunakan bahasa pemrograman Java, sebagai pemenuhan tugas proyek individu.
Aplikasi ini mensimulasikan proses:
- Naik penumpang
- Turun penumpang
- Pengecekan jumlah penumpang
- Pencatatan pendapatan bus
Program mematuhi aturan tempat duduk Bus Trans Koetaradja:
- Penumpang Prioritas	4 kursi
- Penumpang Biasa	16 kursi
- Penumpang Berdiri	20 orang
- Total kapasitas	40 orang
Setiap penumpang wajib membayar ongkos bus Rp 2000, dan saldo awal setiap penumpang adalah Rp 10.000.

**Struktur Program**
Program terdiri dari 3 class utama
1. Penumpang.java
Representasi satu individu penumpang dengan atribut:
- id
- nama
- umur
- hamil (boolean)
- saldo
Class ini menerapkan konsep Encapsulation untuk menjaga data tetap aman.

2. Bus.java
Class inti yang mengatur seluruh logika sistem:
- Menyimpan daftar penumpang dalam 3 kategori (prioritas, biasa, berdiri)
- Mengecek kapasitas
- Menaikkan penumpang dengan aturan tertentu
- Menurunkan penumpang
- Mengatur pendapatan bus
- Menampilkan kondisi bus
Class ini menggunakan:
- ArrayList untuk menyimpan data penumpang
- Iterator untuk operasi penghapusan data
- Abstraction untuk menyembunyikan detail logika penempatan penumpang

3. TestBus.java
Program utama (main program) berbasis menu, yang berfungsi untuk:
- Membaca input pengguna
- Menampilkan menu interaktif
- Menaikkan/turunkan penumpang
- Menampilkan daftar penumpang
- Menampilkan total pendapatan
- Melakukan validasi input (Exception Handling)

Konsep OOP yang Digunakan
Program ini menerapkan sedikitnya 9 konsep OOP, yaitu:
- Class	Penumpang, Bus, TestBus
- Object	p = new Penumpang(), bus = new Bus()
- Encapsulation	Atribut private, akses via getter
- Abstraction	Bus menyembunyikan detail aturan tempat duduk
- Method	Berbagai method di 3 class
- Constructor	Membuat penumpang & bus
- Exception Handling	Menangani input salah (angka/huruf)
- Collection	Menggunakan ArrayList
- Modularization	Pembagian kode ke 3 class berbeda
Program ini sudah melebihi minimal syarat “6 konsep OOP”.

Aturan Penempatan Penumpang
- Ketika penumpang naik ke bus:
- Dicek apakah saldo cukup
- Dicek apakah bus penuh
- Saldo dipotong Rp 2000
- Pendapatan bus bertambah
Penempatan posisi:
Prioritas jika:
- umur < 10
- umur > 60
- hamil = true
  dan kursi prioritas masih tersedia
- Jika tidak → kursi biasa
- Jika kursi penuh → berdiri

**Perhitungan Pendapatan**
Pendapatan bus dihitung secara otomatis:
totalPendapatan += 2000
Setiap kali penumpang naik.
Menu khusus “Lihat Total Pendapatan” disediakan di TestBus.

**Cara Menjalankan Program**
- Menggunakan VS Code
- Pastikan Java JDK terinstall
- Buka folder proyek di VS Code
- Jalankan file TestBus.java
- Pilih menu yang tersedia
