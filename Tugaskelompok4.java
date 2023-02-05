package com.mycompany.tugaskelompok4;
import java.util.Scanner;
import java.util.Random;

public class Tugaskelompok4 {
static Scanner input = new Scanner(System.in);
    static int[] data;

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Selamat Datang di Program Simulasi");
            System.out.println("Menu:");
            System.out.println("1. Random Data");
            System.out.println("2. Simulasi Bubble Sort - Ascending");
            System.out.println("3. Simulasi Selection Sort - Ascending");
            System.out.println("4. Simulasi Bubble Sort - Descending");
            System.out.println("5. Simulasi Selection Sort - Descending");
            System.out.println("6. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    randomData();
                    break;
                case 2:
                    bubbleSortAsc();
                    break;
                case 3:
                    selectionSortAsc();
                    break;
                case 4:
                    bubbleSortDesc();
                    break;
                case 5:
                    selectionSortDesc();
                    break;
                case 6:
                    System.out.println("Terima kasih sudah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan masukkan pilihan yang benar.");
            }
        } while (choice != 6);
    }

    private static void randomData() {
        System.out.print("Masukkan batas bawah: ");
        int min = input.nextInt();
        System.out.print("Masukkan batas atas: ");
        int max = input.nextInt();
        int amount = 5;        
        Random rand = new Random();
        data = new int[amount];
        for (int i = 0; i < amount; i++) {
            int randomNum = rand.nextInt((max - min) + 1) + min;
            System.out.print(randomNum + "   ");
            data[i] = randomNum;
          }
        System.out.println("Data acak sudah diterima.\n");
        
    }    
    
    private static void bubbleSortAsc() {
        System.out.println("Mulai proses Bubble Sort - Ascending.");        
        int[] tempBubbleAsc = data.clone();
        for (int i = 0; i < tempBubbleAsc.length - 1; i++) {
            for (int j = 0; j < tempBubbleAsc.length - 1 - i; j++) {
                if (tempBubbleAsc[j] > tempBubbleAsc[j + 1]) {
                    int temp = tempBubbleAsc[j];
                    tempBubbleAsc[j] = tempBubbleAsc[j + 1];
                    tempBubbleAsc[j + 1] = temp;
                }
            }
            System.out.println("Putaran ke-" + (i + 1) + ": " + toString(tempBubbleAsc));
        }
        System.out.println("Proses selesai.");
    }

    private static void selectionSortAsc() {
        System.out.println("Mulai proses Selection Sort - Ascending.");
        int[] tempSelectionAsc = data.clone();
        for (int i = 0; i < tempSelectionAsc.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < tempSelectionAsc.length; j++) {
                if (tempSelectionAsc[j] < tempSelectionAsc[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = tempSelectionAsc[i];
                tempSelectionAsc[i] = tempSelectionAsc[minIndex];
                tempSelectionAsc[minIndex] = temp;
            }
            System.out.println("Putaran ke-" + (i + 1) + ": " + toString(tempSelectionAsc));
        }
        System.out.println("Proses selesai.");
    }

    private static void bubbleSortDesc() {
        System.out.println("Mulai proses Bubble Sort - Descending.");
        int[] tempBubbleDesc = data.clone();
        for (int i = 0; i < tempBubbleDesc.length - 1; i++) {
            for (int j = 0; j < tempBubbleDesc.length - 1 - i; j++) {
                if (tempBubbleDesc[j] < tempBubbleDesc[j + 1]) {
                    int temp = tempBubbleDesc[j];
                    tempBubbleDesc[j] = tempBubbleDesc[j + 1];
                    tempBubbleDesc[j + 1] = temp;
                }
            }
            System.out.println("Putaran ke-" + (i + 1) + ": " + toString(tempBubbleDesc));
        }
        System.out.println("Proses selesai.");
    }

    private static void selectionSortDesc() {
        System.out.println("Mulai proses Selection Sort - Descending.");
        int[] tempSelectionDesc = data.clone();
        for (int i = 0; i < tempSelectionDesc.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < tempSelectionDesc.length; j++) {
                if (tempSelectionDesc[j] > tempSelectionDesc[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = tempSelectionDesc[i];
                tempSelectionDesc[i] = tempSelectionDesc[maxIndex];
                tempSelectionDesc[maxIndex] = temp;
            }
            System.out.println("Putaran ke-" + (i + 1) + ": " + toString(tempSelectionDesc));
        }
        System.out.println("Proses selesai.");
    }

    private static String toString(int[] data) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]);
            if (i < data.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
