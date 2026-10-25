package perpustakaan.service;
import perpustakaan.config.Konstanta;
import perpustakaan.data.DataPerpustakaan;
import perpustakaan.util.InputHelper;


public final class BukuService {
    private BukuService() {
        // Mencegah instansiasi kelas BukuService atau Mencegah pembuatan objek dari kelas BukuService
    }

    public static int cariIndexBuku(String id) {
        for (int i = 0; i < DataPerpustakaan.jumlahBuku; i++) {
            if (DataPerpustakaan.idBuku[i].equals(id)) {
                return i;
            }
        }
        return -1; // Buku tidak ditemukan
    }

    // Method untuk menampilkan daftar buku
    public static void tampilDaftarBuku() {
        if (DataPerpustakaan.jumlahBuku == 0) {
            System.out.println("Belum ada buku yang terdaftar.");
        }else {
            for(int i = 0; i < DataPerpustakaan.jumlahBuku; i++) {
                System.out.println("ID Buku: " + DataPerpustakaan.idBuku[i]);
                System.out.println("Judul Buku: " + DataPerpustakaan.judulBuku[i]);
                System.out.println("Stok: " + DataPerpustakaan.stockBuku[i]);
                System.out.println("---------------------------");
            }
        }
    }

    public static void tambahBuku() {
        if (DataPerpustakaan.jumlahBuku >= Konstanta.MAKS_BUKU) {
            System.out.println("Kapasitas buku sudah penuh.");
            return;
        }

        String id = InputHelper.bacaString("Masukkan ID Buku: ");
        if(cariIndexBuku(id) != -1) {
            System.out.println("Buku dengan ID tersebut sudah ada.");
            return;
        }

        String judul = InputHelper.bacaString("Masukkan Judul Buku : ");
        int stock = InputHelper.bacaAngkaPositif("Masukkan Stock Buku : ");


        // Menambahkan data buku baru ke DataPerpustakaan 
        DataPerpustakaan.idBuku[DataPerpustakaan.jumlahBuku] = id;
        DataPerpustakaan.judulBuku[DataPerpustakaan.jumlahBuku] = judul;
        DataPerpustakaan.stockBuku[DataPerpustakaan.jumlahBuku] = stock;
        DataPerpustakaan.jumlahBuku++;

        System.out.println("Buku berhasil ditambahkan.");
    }
}
