<h1 align="center">Aplikasi Manajemen Tugas</h1>
<p align="center"><img src="src\main\resources\com\example\taskmanagement\Image\logo.png"/></p>

---

## Table of Contents

- [Screenshot Program](#screenshot-program)
- [Video Penjelasan](#video-penjelasan)
- [Deskripsi Projek](#deskripsi-projek)
- [Petunjuk Instalasi](#petunjuk-instalasi)
- [Cara Penggunaan](#cara-penggunaan)
- [Nama Anggota Kelompok](#nama-anggota-kelompok)

---

## Screenshot Program

### Tampilan Program

1. Login

<img align="left" src="https://github.com/RioOctaviannusLoka/UAS_PBO_Pengejar_Deadline/assets/114414891/4ab2c724-2569-46f7-bdf0-a7d5bc5b642c" height="350" width="450">
<img align="left" src="https://github.com/RioOctaviannusLoka/UAS_PBO_Pengejar_Deadline/assets/114414891/379b47cf-72f4-4100-bd74-3a2e8cca4561" height="350" width="450">

<br clear="left"/>

2. Register

<img src="https://github.com/RioOctaviannusLoka/UAS_PBO_Pengejar_Deadline/assets/114414891/82217469-21ab-4976-b3a1-5530eb52e6a8" height="380" width="480">

3. Home

<img src="https://github.com/RioOctaviannusLoka/UAS_PBO_Pengejar_Deadline/assets/114414891/4a5e0e9b-d763-45ff-ab2e-9b4595b63aa1" height="380" width="700">

4. Tampilan Awal MyPlans

<img src="https://github.com/RioOctaviannusLoka/UAS_PBO_Pengejar_Deadline/assets/114414891/050ab570-be30-4237-8ed1-53f0ef7b6f69" height="380" width="700">

5. Add, Update, Delete Data di MyPlans
- Add Plan
<img src="https://github.com/RioOctaviannusLoka/UAS_PBO_Pengejar_Deadline/assets/114414891/0c2e989d-3a87-43e3-8fe8-d33e97444fbb" height="380" width="700">

- Update Plan
<img src="https://github.com/RioOctaviannusLoka/UAS_PBO_Pengejar_Deadline/assets/114414891/4878618b-8f9a-4d52-9166-71d98f66c1b4" height="380" width="700">

- Delete Plan
<img src="https://github.com/RioOctaviannusLoka/UAS_PBO_Pengejar_Deadline/assets/114414891/8a5d548e-365d-4c64-9498-091f148890ec" height="380" width="700">

6. Tampilan Awal Filter Plans

<img src="https://github.com/RioOctaviannusLoka/UAS_PBO_Pengejar_Deadline/assets/114414891/4a001a39-e870-4e06-ada8-518890077857" height="380" width="700">

7. Search pada Filter Plans

<img src="https://github.com/RioOctaviannusLoka/UAS_PBO_Pengejar_Deadline/assets/114414891/ba768f0f-aff5-415e-b941-bb9d7bf1cdaf" height="380" width="700">

8. Penfilter dengan status pada Filter Plans

<img src="https://github.com/RioOctaviannusLoka/UAS_PBO_Pengejar_Deadline/assets/114414891/2627bd89-7c82-4a2e-a26f-6dfab282a9e0" height="380" width="700">

9. Sign Out

<img src="https://github.com/RioOctaviannusLoka/UAS_PBO_Pengejar_Deadline/assets/114414891/8c05f03e-1349-4b89-874f-7de7b2df8965" height="380" width="700">

### Exception Handling

1. Login
- Ketika ada textbox yang tidak diisi (kosong)
<img src="https://github.com/RioOctaviannusLoka/UAS_PBO_Pengejar_Deadline/assets/114414891/4fc8a338-2d40-47bc-9f20-c30427860764" height="380" width="480">

2. Register
- Ketika ada textbox yang tidak diisi (kosong)
<img src="https://github.com/RioOctaviannusLoka/UAS_PBO_Pengejar_Deadline/assets/114414891/2b2c86a0-0855-4ed7-8294-ff9d10767ee1" height="380" width="480">

- Ketika menggunakan username yang pernah dipakai sebelumnya
<img src="https://github.com/RioOctaviannusLoka/UAS_PBO_Pengejar_Deadline/assets/114414891/e1dff2e1-4978-4469-bbb6-5c54182c99c2" height="380" width="480">

4. My Plans
- Ketika ada textbox yang tidak diisi (kosong) saat add data
<img src="https://github.com/RioOctaviannusLoka/UAS_PBO_Pengejar_Deadline/assets/114414891/f9825dd3-16b2-481a-b370-ecfe2632ea1d" height="380" width="700">

- Ketika ada textbox yang tidak diisi (kosong) saat update data
<img src="https://github.com/RioOctaviannusLoka/UAS_PBO_Pengejar_Deadline/assets/114414891/b3f76d3d-f3b6-4ae6-8a8a-c545680be7d3" height="380" width="700">

<br>
<br>

## Video Penjelasan

Link Video: <a href="https://youtu.be/2hLeGAkrDlk">Video</a>

<br>

## Deskripsi Projek
Aplikasi dekstop ini merupakan aplikasi manajemen plan/tugas yang dirancang untuk membantu pengguna meningkatkan produktivitas mereka dengan memastikan bahwa pengguna dapat mengelola tugas-tugas harian dengan efisien dan mudah diakses. Aplikasi ini menyediakan antarmuka pengguna yang intuitif dan mudah digunakan, memungkinkan pengguna untuk mendaftar dan masuk ke akun mereka, serta mengelola tugas-tugas harian mereka dengan mudah. Aplikasi ini dikembangkan dalam bahasa Java serta menggunakan Framework Javafx dan aplikasi Scene Builder dalam mengembangkan tampilan aplikasi ini.

Dengan fokus pada kemudahan penggunaan dan kinerja, aplikasi ini mengelola data tugas secara efisien tanpa menggunakan multithreading. Hal ini bertujuan untuk mengurangi kompleksitas dan menghindari risiko deadlock dan race condition yang sering terjadi pada aplikasi multithreading, sehingga aplikasi menjadi lebih stabil dan handal. Selain itu, aplikasi ini dirancang untuk kebutuhan yang tidak memerlukan operasi paralel atau pemrosesan tugas yang berat. Operasi CRUD pada tugas cukup ringan dan dapat ditangani dengan baik oleh thread tunggal. Supaya program dapat menjaga kinerjanya dengan baik, aplikasi ini sebisa mungkin mengurangi pengaksesan ke database yang dapat mengakibatkan delay pada aplikasi.

### Fitur
#### 1. User Authentication
- Login: Pengguna dapat masuk menggunakan akun yang telah terdaftar.
- SignUp: Pengguna baru dapat mendaftar untuk membuat akun.
#### 2. Dashboard
- Berisi daftar tugas yang statusnya belum selesai dan sedang dikerjakan.
- Tampilan yang intuitif dan mudah digunakan.
#### 3. Manajemen Tugas
- Create: Tambah tugas baru yang memiliki data berupa nama tugas, deskripsi, tanggal pembuatan, tenggat waktu, tipe, dan status (belum selesai, sedang dikerjakan, selesai).
- Read: Lihat daftar tugas yang sudah ada.
- Update: Edit tugas yang sudah ada.
- Delete: Hapus tugas yang sudah tidak diperlukan.
#### 4. Penfilteran dan Pencarian:
- Penfilteran berdasarkan status tugas (Belum Selesai, Sedang Dikerjakan, Selesai).
- Fitur pencarian berdasarkan nama tugas untuk memudahkan menemukan tugas tertentu.
<br>

## Petunjuk Instalasi

1.  Clone Repositori ini
    ```bash
    git clone https://github.com/RioOctaviannusLoka/UAS_PBO_Pengejar_Deadline.git
    ```
2. Modifikasi Project Structure, tambah semua file jar di folder lib ke modules pada Project Structure
   <img src="https://github.com/RioOctaviannusLoka/UAS_PBO_Pengejar_Deadline/assets/114504295/2e61a27d-5ea4-475c-bc90-ef3539a60054" height="380" width="700">
   <p>Hasilnya akan menjadi seperti ini:</p>
   <img src="https://github.com/RioOctaviannusLoka/UAS_PBO_Pengejar_Deadline/assets/114504295/1c5c543a-4877-498b-9998-6946508dc574" height="380" width="700">
   <p>Tekan tombol 'Apply' Lalu tekan tombol 'OK'</p>
3. Buka MySQL Workbench, lalu jalankan kueri pada file query.sql untuk membuat sebuah database baru bernama task_management disertai dengan tabel tabelnya
   <br>
4. Ubah user dan password pada file database.java di folder src\main\java\com\example\taskmanagement
   ```bash
   Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/task_management",
                    "root",""
            );
   ```
   Pada contoh diatas, user adalah root, sedangkan password adalah kosong.
<br>

## Cara Penggunaan
1. Buka file taskApplication.java pada folder src\main\java\com\example\taskmanagement, lalu tekan tombol 'Run'.
2. Bila sudah memiliki akun, masukkan username dan password, lalu tekan tombol login. <br>
   Jika belum, tekan tombol 'Create an account', lalu masukkan username dan password untuk pembuatan akun baru.
3. Untuk berpindah halaman Menu, tekan tombol 'Home', 'My Plans', dan 'Filter Plans' pada sidebar.
4. Pada Menu Home, akan ditampilkan Jumlah plans yang statusnya Unfinished or In Progress dan Jumlah plan yang statusnya Completed.
5. Pada Menu My Plans, silahkan masukkan plan, description (opsional), date created dan due date(dengan menekan ikon kalender, lalu memilih tanggal), type (opsional), dan status (pilih salah satu item pada combobox). Setelah itu, tekan tombol 'Add' untuk menambahkan plan. Apabila ingin menghapus seluruh data yang telah diisi sebelumnya, tekan tombol clear.
6. Untuk memperbarui plan, pilih salah satu cell pada tabel yang tersedia di My Plans. Data yang terpilih secara otomatis akan terisi pada text field masing-masing. Ubah data yang ingin diubah, lalu tekan tombol 'Update'.
7. Untuk menghapus plan, pilih salah satu cell pada tabel yang tersedia di My Plans. Lalu tekan tombol 'Delete'. Setelah itu, akan muncul sebuah pop up yang berisi pesan berupa "Anda yakin ingin menghapus data ini?". Tekan tombol 'OK' apabila ingin menghapus pesan. Tekan tombol 'Cancel' apabila ingin membatalkannya.
8. Pada menu Filter Plans, ketik kata kunci yang ingin dicari pada search bar. Data yang ingin dicari secara otomatis akan difilter berdasarkan nama plan pada tabel Filter Plans.
9. Pilih status plan yang di inginkan dan tekan tombol 'Filter' untuk menfilter data berdasarkan status dari plan tersebut.
10. Tekan tombol 'Sign out' pada sidebar dan klik 'OK' pada pop up yang muncul untuk keluar dari akun.
11. Tekan tombol X untuk menutup aplikasi.
   

<br>

## Nama Anggota Kelompok dan Job Description
- Rio Octaviannus Loka (221401032) - Membuat logika dari menu Home dan menu My Plans untuk Add dan Update data
- Frederick Godiva (221401038) - Membuat logika dari menu Filter Plans
- Rivaldo Dominggos Pardede (2214101060) - Membuat logika dari menu My Plans untuk tombol clear dan Delete data
- Dhea Tania Salsabilah Harahap (221401092) - Membuat Tampilan UI aplikasi serta membuat Logika menu Login dan Register
