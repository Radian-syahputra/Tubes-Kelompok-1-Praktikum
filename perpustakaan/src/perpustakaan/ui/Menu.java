package perpustakaan.ui;

public final class Menu {
    private Menu() {

    }

    public static void tampilMenu() {
        System.out.println("=== Menu Perpustakaan ===");
        System.out.println("1. Lihat Daftar Buku");
        System.out.println("2. Tambah Buku");
        System.out.println("3. Tambah Anggota");
        System.out.println("4. Pinjam Buku");
        System.out.println("5. Pengembalian Buku");    
        System.out.println("6. Keluar");    
    }
}
