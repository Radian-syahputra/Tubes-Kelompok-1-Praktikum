package perpustakaan.service;
import perpustakaan.config.Konstanta;
import perpustakaan.data.DataPerpustakaan;
import perpustakaan.util.InputHelper;

public final class TransaksiService {
    private TransaksiService() {
        // Mencegah instansiasi kelas TransaksiService atau Mencegah pembuatan objek dari kelas TransaksiService
    };

    public static void prosesPinjam(){
        // Baca ID Anggota
        String idAngota = InputHelper.bacaString("Masukkan ID Anggota : ");
        int idxAnggota = AnggotaService.cariIndexAnggota(idAngota);

        if(idxAnggota == -1){
            System.out.println("Anggota tidak ditemukan.");
            return;
        }

        // Baca ID Buku
        String idBuku = InputHelper.bacaString("Masukkan ID Buku");
        int idxBuku = BukuService.cariIndexBuku(idBuku);

        if(idxBuku == -1){
            System.out.println("Buku tidak ditemukan.");
            return;
        }

        // Cek stok buku
        if(DataPerpustakaan.stockBuku[idxBuku] == 0){
            System.out.println("Stok buku habis.");
            return;
        };

        // Cek Batas Peminjaman Anggota
        if (DataPerpustakaan.jumlahPinjamanAnggota[idxAnggota] >= Konstanta.BATAS_PINJAM) {
            System.out.println("Anggota sudah mencapai batas maksimal peminjaman.");
            return;
        };

        // Cek Kapasitas Data Peminjaman
        if (DataPerpustakaan.jumlahPeminjaman >= Konstanta.MAKS_DATA_PEMINJAMAN) {
            System.out.println("Kapasitas data peminjaman sudah penuh.");
            return;
        }

        // Baca Hari Pinjam Buku
        int hariIni = InputHelper.bacaAngkaPositif("Masukkan Hari Keberapa Ini : ");

        // Simpan Transaksi Peminjaman
        DataPerpustakaan.dataPinjam[DataPerpustakaan.jumlahPeminjaman][0] = idxAnggota;
        DataPerpustakaan.dataPinjam[DataPerpustakaan.jumlahPeminjaman][1] = idxBuku;
        DataPerpustakaan.dataPinjam[DataPerpustakaan.jumlahPeminjaman][2] = hariIni;
        DataPerpustakaan.dataPinjam[DataPerpustakaan.jumlahPeminjaman][3] = hariIni + Konstanta.LAMA_PINJAM;
        DataPerpustakaan.dataPinjam[DataPerpustakaan.jumlahPeminjaman][4] = 1; // Status dipinjam


        // Update stok buku dan jumlah pinjaman anggota
        DataPerpustakaan.stockBuku[idxBuku]--;
        DataPerpustakaan.jumlahPinjamanAnggota[idxAnggota]++;

        // Cetak Hasil Transaksi Peminjaman
        System.out.println("========================== Transaksi Peminjaman Berhasil ==========================");
        System.out.println("ID Transaksi : " + DataPerpustakaan.jumlahPeminjaman);
        System.out.println("ID Buku : " + DataPerpustakaan.idBuku[idxBuku]);
        System.out.println("ID Anggota : " + DataPerpustakaan.idAnggota[idxAnggota]);
        System.out.println("Nama Anggota : " + DataPerpustakaan.namaAnggota[idxAnggota]);
        System.out.println("Jatuh Tempo : " +DataPerpustakaan.dataPinjam[DataPerpustakaan.jumlahPeminjaman][3]);
        System.out.println("==================================================================================");
        
        // Update jumlah peminjaman
        DataPerpustakaan.jumlahPeminjaman++;

    }
}
