/**
 * Ad Soyad: [Binnur Aslan]
 * Öğrenci No: [250541084]
 * Proje: [Sinema Bileti]
 * Tarih: [27/11/2025]
 */
import java.util.Scanner;

public class SinemaBileti {


    public static boolean isWeekend(int gun) {
        return gun == 6 || gun == 7;
    }


    public static boolean isMatinee(int saat) {
        return saat < 12;
    }


    public static double calculateBasePrice(int gun, int saat) {
        boolean weekend = isWeekend(gun);
        boolean matinee = isMatinee(saat);

        if (!weekend && matinee) return 45;
        if (!weekend) return 65;
        if (weekend && matinee) return 55;
        return 85;
    }


    public static double calculateDiscount(int yas, int meslek, int gun) {
        double indirim = 0.0;


        if (yas >= 65) return 0.30;
        if (yas < 12) return 0.25;


        switch (meslek) {
            case 1:
                if (gun >= 1 && gun <= 4) indirim = 0.20;
                else indirim = 0.15;
                break;

            case 2:
                if (gun == 3) indirim = 0.35;
                break;

            case 3:
                indirim = 0.0;
                break;
        }

        return indirim;
    }


    public static double getFormatExtra(int filmTuru) {
        switch (filmTuru) {
            case 1: return 0;
            case 2: return 25;
            case 3: return 35;
            case 4: return 50;
            default: return 0;
        }
    }


    public static double calculateFinalPrice(double base, double extra, double discountRate) {
        double indirim = base * discountRate;
        double finalPrice = base - indirim + extra;
        return finalPrice;
    }




    public static void generateTicketInfo(double base, double extra, double discountRate, double finalPrice) {
        System.out.println("\n=== BILET OZETI ===");
        System.out.println("Temel Fiyat : " + base + " TL");
        System.out.println("Format Ekstrasi : " + extra + " TL");
        System.out.println("Indirim Orani : %" + (discountRate * 100));
        System.out.println("------------------------------");
        System.out.println("Odenecek Tutar : " + String.format("%.2f", finalPrice) + " TL");
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1=Pzt  2=Salı  3=Çarş  4=Perş  5=Cuma  6=Cts  7=Pazar");
        System.out.print("Günü seçin (1-7): ");
        int gun = sc.nextInt();

        System.out.print("Saat (0-23): ");
        int saat = sc.nextInt();

        System.out.print("Yaş: ");
        int yas = sc.nextInt();

        System.out.println("Meslek: 1=Öğrenci, 2=Öğretmen, 3=Diğer");
        System.out.print("Seçim: ");
        int meslek = sc.nextInt();

        System.out.println("Film Türü: 1=2D  2=3D  3=IMAX  4=4DX");
        System.out.print("Seçim: ");
        int filmTuru = sc.nextInt();


        double base = calculateBasePrice(gun, saat);
        double extra = getFormatExtra(filmTuru);
        double discount = calculateDiscount(yas, meslek, gun);
        double finalPrice = calculateFinalPrice(base, extra, discount);


        generateTicketInfo(base, extra, discount, finalPrice);

        sc.close();
    }
}

