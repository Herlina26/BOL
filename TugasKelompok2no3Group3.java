/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tugaskelompok2no3group3;
import java.util.Scanner;
/**
 *
 * @author WINDOWS 10
 */
public class TugasKelompok2no3Group3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Meminta input angka biner
        System.out.print("Input angka biner: ");
        String biner = scanner.nextLine();

        // Menghitung angka desimal
        int panjang = biner.length();
        if (panjang > 8) {
            System.out.println("Digit kelebihan");
            return;
        }
        int desimal = 0;
        for (int i = 0; i < panjang; i++) {
            int digit = Character.getNumericValue(biner.charAt(i));
            if (digit != 0 && digit != 1) {
                System.out.println("Input tidak valid");
                return;
            }
            desimal += digit * Math.pow(2, panjang - i - 1);
        }

        // Menampilkan hasil
        System.out.println("Angka desimal dari biner " + biner + " adalah: " + desimal);
    }
}