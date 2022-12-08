
package com.mycompany.tugask;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Tugask {

    public static void main(String[] args) {
    String namaPemesan;
        int jumlahOrang, jumlahPesanan;
        DecimalFormat df = new DecimalFormat("#.##");
        
        System.out.println("Selamat siang...");
        System.out.print("Pesan untuk berapa orang : ");
        Scanner input = new Scanner(System.in);
        jumlahOrang = input.nextInt();
        System.out.print("Pesan atas nama          : ");
        Scanner input2 = new Scanner(System.in);
        namaPemesan = input2.nextLine();
        
        System.out.println("\n");
        System.out.println("Menu Spesial hari ini");
        System.out.println("=====================");
        System.out.println("1. Nasi Goreng Spesial          @ Rp. 9999.99");
        System.out.println("2. Ayam Bakar Spesial           @ Rp. 12345.67");
        System.out.println("3. Steak Sirloin Spesial        @ Rp. 21108.40");
        System.out.println("4. Kwetiaw Siram Spesial        @ Rp. 13579.13");
        System.out.println("5. Kambing Guling Spesial       @ Rp. 98765.43");
       
        System.out.println("\n");
        System.out.println("Pesanan Anda [atas pesanan 0-10 po]");
        System.out.print("Nasi Goreng Spesial      = ");
        Scanner inputPesanan = new Scanner(System.in);
        int pesanan1 = inputPesanan.nextInt();
        System.out.print("Ayam Bakar Spesial       = ");
        int pesanan2 = inputPesanan.nextInt();
        System.out.print("Steak Sirloin Spesial    = ");
        int pesanan3 = inputPesanan.nextInt();
        System.out.print("Kwetiaw Siram Spesial    = ");
        int pesanan4 = inputPesanan.nextInt();
        System.out.print("Kambing Guling Spesial   = ");
        int pesanan5 = inputPesanan.nextInt();
        
        System.out.println("\n");
        System.out.println("Selamat menikmati makanan anda...");
        System.out.println("Pembelian : ");
        System.out.println("Nasi Goreng Spesial       "+pesanan1+ " porsi * Rp.9999.99  = Rp.       "+pesanan1 * 9999.99);
        System.out.println("Ayam Bakar Spesial        "+pesanan2+ " porsi * Rp.12345.67 = Rp.       "+pesanan2 * 12345.67);
        System.out.println("Ayam Bakar Spesial        "+pesanan3+ " porsi * Rp.21108.40 = Rp.       "+df.format(pesanan3 * 21108.40));
        System.out.println("Kwetiaw Siram Spesial     "+pesanan4+ " porsi * Rp.13579.13 = Rp.       "+pesanan4 * 13579.13);
        System.out.println("Kambing Guling Spesial    "+pesanan5+ " porsi * Rp.98765.43 = Rp.       "+df.format(pesanan5 * 98765.43)+" +");
        System.out.println("=========================================================================");
        
        double total = (pesanan1 * 9999.99)+(pesanan2 * 12345.67)+(pesanan3 * 21108.40)+(pesanan4 * 13579.13)+(pesanan5 * 98765.43);
        double disc = total * 10/100;
        double totalHarga = total - disc;
        System.out.println("Total Pembelian                                 = Rp.       " +df.format(total));
        System.out.println("\n");
        System.out.println("DIsc 10% <Masa Promosi>                        = Rp.       " +df.format(total * 10/100) +" -");
        System.out.println("==========================================================================");
        System.out.println("Total Pembelian setelah disc 10%                = Rp.       " +df.format(total - disc));
        System.out.println("Pembelian per orang                             = Rp.       " +df.format(totalHarga / jumlahOrang));
        System.out.println("\n");
        System.out.println("                   Terima kasih atas kunjungan anda...");
        System.out.println("                   ...tekan ENTER untuk keluar...");    
    }
}
