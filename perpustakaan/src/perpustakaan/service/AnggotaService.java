package perpustakaan.service;
import perpustakaan.config.Konstanta;
import perpustakaan.data.DataPerpustakaan;
import perpustakaan.util.InputHelper;


public final class AnggotaService {
    private AnggotaService() {
        // Mencegah instansiasi kelas AnggotaService atau Mencegah pembuatan objek dari kelas AnggotaService
    }

    public static int cariIndexAnggota(String id) {
        for (int i  = 0; i < DataPerpustakaan.jumlahAnggota; i++) {
            if (DataPerpustakaan.idAnggota[i].equals(id)) {
                return i;
            }
        }
        return -1; // Anggota tidak ditemukan
    }

    public static void tambahAnggota() {
        if (DataPerpustakaan.jumlahAnggota >= Konstanta.MAKS_ANGGOTA) {
            System.out.println("Kapasitas anggota sudah penuh.");
            return;
        }

        String id = InputHelper.bacaString("Masukkan ID Anggota: ");
        if(cariIndexAnggota(id) != -1) {
            System.out.println("Anggota dengan ID tersebut sudah ada.");
            return;
        }

        String nama = InputHelper.bacaString("Masukkan Nama Anggota: ");

        // Simpan data anggota baru ke DataPerpustakaan
        DataPerpustakaan.idAnggota[DataPerpustakaan.jumlahAnggota] = id;
        DataPerpustakaan.namaAnggota[DataPerpustakaan.jumlahAnggota] = nama;
        DataPerpustakaan.jumlahPinjamanAnggota[DataPerpustakaan.jumlahAnggota] = 0; // Inisialisasi jumlah pinjaman anggota baru
        DataPerpustakaan.jumlahAnggota++;

        System.out.println("Anggota berhasil ditambahkan.");
    }
}
