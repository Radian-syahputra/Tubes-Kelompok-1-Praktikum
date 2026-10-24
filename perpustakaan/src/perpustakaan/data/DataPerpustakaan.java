package perpustakaan.data;
import perpustakaan.config.Konstanta;

public class DataPerpustakaan {
    // Deklarasi DATA BUKU
    public static String[] idBuku = new String[Konstanta.MAKS_BUKU];
    public static String[] judulBuku = new String[Konstanta.MAKS_BUKU];
    public static int[] stockBuku = new int[Konstanta.MAKS_BUKU];
    public static int jumlahBuku = 0;

    // Deklarasi DATA ANGGOTA
    public static String[] idAnggota = new String[Konstanta.MAKS_ANGGOTA];
    public static String[] namaAnggota = new String[Konstanta.MAKS_ANGGOTA];
    public static int[] jumlahPinjamanAnggota = new int[Konstanta.MAKS_ANGGOTA];
    public static int jumlahAnggota = 0;

    // ===== DATA TRANSAKSI =====
    // Tiap baris = 1 transaksi
    // kolom 0 = indeks anggota
    // kolom 1 = indeks buku
    // kolom 2 = hari pinjam
    // kolom 3 = hari jatuh tempo
    // kolom 4 = status (1 = dipinjam, 0 = sudah kembali)

    // Deklarasi DATA PEMINJAMAN
     public static int[][] dataPinjam = new int[Konstanta.MAKS_DATA_PEMINJAMAN][5];
     public static int jumlahPeminjaman = 0;

    private DataPerpustakaan() {
        // Mencegah instansiasi kelas DataPerpustakaan atau Mencegah pembuatan objek dari kelas DataPerpustakaan
    }


    public static void isiDataAwal() {
        // Slot data awal untuk buku
        idBuku[0] = "B001";
        judulBuku[0] = "Pemrograman Java";
        stockBuku[0] = 5;

        idBuku[1] = "B002";
        judulBuku[1] = "Pemrograman Python";
        stockBuku[1] = 3;

        idBuku[2] = "B003";
        judulBuku[2] = "Pemrograman C++";
        stockBuku[2] = 4;

        jumlahBuku = 3;

        // Slot data awal untuk anggota
        idAnggota[0] = "A001";
        namaAnggota[0] = "Rudi";
        jumlahPinjamanAnggota[0] = 0;

        idAnggota[1] = "A002";
        namaAnggota[1] = "Siti";
        jumlahPinjamanAnggota[1] = 0;

        idAnggota[2] = "A003";
        namaAnggota[2] = "Budi";
        jumlahPinjamanAnggota[2] = 0;

        jumlahAnggota = 3;
    }
}
