package perpustakaan.config;

public class Konstanta{
    // KAPASITAS DATA 
    public static final int MAKS_BUKU = 20;
    public static final int MAKS_ANGGOTA = 20;
    public static final int MAKS_DATA_PEMINJAMAN = 100;

    // ATURAN PEMINJAMAN
    public static final int BATAS_PINJAM = 3;
    public static final int LAMA_PINJAM = 7;
    public static final int DENDA_PER_HARI = 1000;

    private Konstanta() {
        // Mencegah instansiasi kelas Konstanta atau Mencegah pembuatan objek dari kelas Konstanta
    }
}