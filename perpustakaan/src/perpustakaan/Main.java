package perpustakaan;

import perpustakaan.data.DataPerpustakaan;
import perpustakaan.service.AnggotaService;
import perpustakaan.service.BukuService;
import perpustakaan.service.TransaksiService;
import perpustakaan.ui.Menu;
import perpustakaan.util.InputHelper;

public class Main {
    public static void main(String[] args) {
        DataPerpustakaan.isiDataAwal();
        int pilihan = 0;

        do {
            Menu.tampilMenu();
            pilihan = InputHelper.bacaPilihan(1, 6);

            switch (pilihan) {
                case 1:
                    BukuService.tampilDaftarBuku();
                    break;
                case 2:
                    BukuService.tambahBuku();
                    break;
                case 3:
                    AnggotaService.tambahAnggota();
                    break;
                case 4:
                    TransaksiService.prosesPinjam();
                    break;
                case 5:
                    TransaksiService.prosesKembaliBuku();
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan aplikasi perpustakaan.");
                    break;
            }
        } while (pilihan != 6);
    }
}
