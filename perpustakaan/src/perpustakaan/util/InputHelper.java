package perpustakaan.util;
import java.util.Scanner;

public final class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    private InputHelper() {
        // Mencegah instansiasi kelas InputHelper atau Mencegah pembuatan objek dari kelas InputHelper
    }

    // Method Membaca input string dari pengguna
    public static String bacaString(String pesan) {
        System.out.print(pesan);
        return scanner.nextLine();
    }

    // Method Membaca Pilihan menu dari pengguna -> contohnya pilihan menu 1-6
    public static int bacaPilihan(int min, int max) {
        int angka = min - 1; 
        do {
           try {
            angka = Integer.parseInt(bacaString("Masukkan pilihan Anda (" + min + "-" + max + "): ").trim());

            if (angka < min || angka > max) {
                System.out.println("Pilihan tidak valid. Silakan masukkan angka antara " + min + " dan " + max + ".");
            }
           }catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Silakan masukkan angka.");
           }
        } while (angka < min || angka > max);
        return angka;
    }

    public static int bacaAngkaPositif(String pesan) {
        int angka = 0;

        do {
            try {
                angka = Integer.parseInt(bacaString(pesan).trim());

                if (angka <= 0) {   
                    System.out.println("Input tidak valid. Silakan masukkan angka positif.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Silakan masukkan angka.");
            }
        }while (angka <= 0);
        return angka;
    }
}

