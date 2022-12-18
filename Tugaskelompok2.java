package com.mycompany.tugaskelompok2;
import java.util.Scanner;
public class Tugaskelompok2 {

    public static void main(String[] args) {
        String nama;
        String nim;
        String pilihan;
        int jumlahBil;
        boolean running = true;


        while (running){
            Scanner scan = new Scanner(System.in);
            System.out.print("Masukkan Nama : ");
            nama = scan.nextLine();
            if ((nama == "")&&(nama.length()> 25)){
                System.out.println("Nama Tidak boleh kosong & tidak boleh lebih dari 25 karakter");
            }

            System.out.print("Masukkan NIM : ");
            nim = scan.nextLine();
            if (nim.length() != 10){
                System.out.println("NIM Harus berjumlah 10 Karakter");
                continue;
            }

            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println();
            System.out.println("Registrasi Sukses..");
            System.out.println("Selamat Datang "+nama+"[Nim : "+nim+"].. ^^V");
            System.out.println("");
            System.out.println("Mari belajar macam-macam Bilangan deret..");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

            System.out.print("Masukkan Bilangan 5 sampai 20 : ");
            jumlahBil = scan.nextInt();
            if ((jumlahBil < 5) && (jumlahBil > 20)){
                System.out.println("Bilangan minimal harus 5 dan maksimal 20s");
            }
            System.out.println("");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("");
            System.out.println("Deret Bilangan  ");
            System.out.println("###############");

            System.out.println(jumlahBil+" Bilangan Genap");
            int hitungBilGenap = 0;
            int totalBilGenap = 0;
            for (int i = 0; i < jumlahBil; i++) {
                
                hitungBilGenap = hitungBilGenap + 2;
                System.out.print(hitungBilGenap + " ");
                totalBilGenap = totalBilGenap + hitungBilGenap;

            }
            System.out.println("");
            System.out.println("Hasil Penjumlahan : "+totalBilGenap);
            System.out.println("");

            System.out.println(jumlahBil+" Bilangan Ganjil");
            int hitungBilGanjil = 1;
            int totalBilGanjil = 0;
            for (int i = 0; i < jumlahBil; i++) {
                totalBilGanjil = totalBilGanjil + hitungBilGanjil;
                System.out.print(hitungBilGanjil + " ");
                hitungBilGanjil = hitungBilGanjil + 2;
            }
            System.out.println("");
            System.out.println("Hasil Penjumlahan : "+totalBilGanjil);
            System.out.println("");

            System.out.println(jumlahBil+" Bilangan Fibonacci : ");
            int bil2= 1;
            int bil1 = 1;
            int i = 0;

            while (i < jumlahBil) {
                   System.out.print(bil1 + " ");
                   int bil3 = bil2 + bil1;
                   bil1  = bil2;
                   bil2 = bil3;
                   i = i + 1;

                  
            }

            System.out.println("");
            System.out.print("Anda ingin mengulang [y/t]");

            Scanner inputPilihan = new Scanner(System.in);
            pilihan = inputPilihan.nextLine();
            if ("y".equals(pilihan)){
                running = true;
            } else if ("t".equals(pilihan)){
                break;
            }
        }
        }   
    }



