/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.tugaskelompok2no2group3;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
/**
 *
 * @author WINDOWS 10
 */
public class TugasKelompok2no2Group3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Meminta input posisi pekerjaan
        System.out.print("Masukkan posisi pekerjaan (staff/officer/supervisor/manager): ");
        String posisi = scanner.nextLine();

        // Meminta input tanggal lahir pelamar
        System.out.print("Masukkan tanggal lahir pelamar (YYYY-MM-DD): ");
        String tanggalLahir = scanner.nextLine();

        // Menghitung umur pelamar
        LocalDate tanggalLahirPelamar = LocalDate.parse(tanggalLahir);
        LocalDate today = LocalDate.now();
        Period period = Period.between(tanggalLahirPelamar, today);
        int umurPelamar = period.getYears();

        // Menampilkan umur pelamar
        System.out.println("Umur pelamar adalah " + umurPelamar + " tahun");

        // Menentukan kriteria umur sesuai posisi pekerjaan
        int maksUmur;
        switch (posisi.toLowerCase()) {
            case "staff":
                maksUmur = 25;
                break;
            case "officer":
                maksUmur = 30;
                break;
            case "supervisor":
                maksUmur = 35;
                break;
            case "manager":
                maksUmur = 40;
                break;
            default:
                System.out.println("Posisi pekerjaan tidak valid.");
                return;
        }

        // Menentukan apakah pelamar memenuhi kriteria umur
        if (umurPelamar > maksUmur) {
            System.out.println("Maaf, umur untuk posisi " + posisi + " melebihi batas.");
        } else {
            System.out.println("Selamat, pelamar memenuhi kriteria umur untuk posisi " + posisi + ".");
        }
    }
}