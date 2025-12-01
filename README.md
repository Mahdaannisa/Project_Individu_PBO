# **PROJECT INDIVIDU PBO**

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
