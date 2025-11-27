/**
* Ad Soyad: [Binnur Aslan]
* Numara: [250541084]
* Proje: [RestoranSiparis]
* Tarih: [27/11/2025]
*/import java.util.Scanner;

public class RestoranSiparis {



    public static double getMainDishPrice(int secim) {
        switch (secim) {
            case 1: return 85;
            case 2: return 120;
            case 3: return 110;
            case 4: return 65;
            default: return 0;
        }
    }

    public static double getAppetizerPrice(int secim) {
        switch (secim) {
            case 1: return 25;
            case 2: return 45;
            case 3: return 55;
            default: return 0;
        }
    }

    public static double getDrinkPrice(int secim) {
        switch (secim) {
            case 1: return 15;
            case 2: return 12;
            case 3: return 35;
            case 4: return 25;
            default: return 0;
        }
    }

    public static double getDessertPrice(int secim) {
        switch (secim) {
            case 1: return 65;
            case 2: return 55;
            case 3: return 35;
            default: return 0;
        }
    }



    public static boolean isComboOrder(boolean ana, boolean ice, boolean tatli) {
        return ana && ice && tatli;
    }

    public static boolean isHappyHour(int saat) {
        return saat >= 14 && saat <= 17;
    }




    public static double calculateDiscount(double tutar,
                                           boolean combo,
                                           boolean ogrenci,
                                           int saat,
                                           int gun) {

        double toplamIndirim = 0;


        if (combo) {
            toplamIndirim += tutar * 0.15;
        }


        if (!combo && tutar >= 200) {
            toplamIndirim += tutar * 0.10;
        }


        if (ogrenci && gun >= 1 && gun <= 5) {

            toplamIndirim += tutar * 0.10;
        }

        return toplamIndirim;
    }



    public static double calculateServiceTip(double tutar) {
        return tutar * 0.10;
    }




    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== AKILLI RESTORAN SİPARİŞ SİSTEMİ ===");


        System.out.println("\nAna Yemekler:");
        System.out.println("1) Izgara Tavuk (85)");
        System.out.println("2) Adana Kebap (120)");
        System.out.println("3) Levrek (110)");
        System.out.println("4) Mantı (65)");
        System.out.print("Seçim (0=Yok): ");
        int ana = sc.nextInt();
        double anaFiyat = getMainDishPrice(ana);
        boolean anaVar = anaFiyat > 0;


        System.out.println("\nBaşlangıçlar:");
        System.out.println("1) Çorba (25)");
        System.out.println("2) Humus (45)");
        System.out.println("3) Sigara Böreği (55)");
        System.out.print("Seçim (0=Yok): ");
        int bas = sc.nextInt();
        double basFiyat = getAppetizerPrice(bas);


        System.out.println("\nİçecekler:");
        System.out.println("1) Kola (15)");
        System.out.println("2) Ayran (12)");
        System.out.println("3) Meyve Suyu (35)");
        System.out.println("4) Limonata (25)");
        System.out.print("Seçim (0=Yok): ");
        int ice = sc.nextInt();
        double iceFiyat = getDrinkPrice(ice);
        boolean iceVar = iceFiyat > 0;


        System.out.println("\nTatlılar:");
        System.out.println("1) Künefe (65)");
        System.out.println("2) Baklava (55)");
        System.out.println("3) Sütlaç (35)");
        System.out.print("Seçim (0=Yok): ");
        int tatli = sc.nextInt();
        double tatliFiyat = getDessertPrice(tatli);
        boolean tatliVar = tatliFiyat > 0;


        System.out.print("\nSaat (0-23): ");
        int saat = sc.nextInt();


        System.out.print("Öğrenci misiniz? (1=Evet, 0=Hayır): ");
        boolean ogrenci = sc.nextInt() == 1;


        System.out.println("\nGün Seçin:");
        System.out.println("1) Pazartesi");
        System.out.println("2) Salı");
        System.out.println("3) Çarşamba");
        System.out.println("4) Perşembe");
        System.out.println("5) Cuma");
        System.out.println("6) Cumartesi");
        System.out.println("7) Pazar");
        System.out.print("Seçim: ");
        int gun = sc.nextInt();



        double araToplam = anaFiyat + basFiyat + iceFiyat + tatliFiyat;


        System.out.printf("\nAra toplam: %.2f TL\n", araToplam);


        boolean combo = isComboOrder(anaVar, iceVar, tatliVar);


        double comboIndirim = 0;
        if (combo) {
            comboIndirim = araToplam * 0.15;
            System.out.printf("Combo indirimi: %%15 → -%.2f TL\n", comboIndirim);
            araToplam -= comboIndirim;
        }


        double happyIndirim = 0;
        if (isHappyHour(saat) && iceVar) {
            happyIndirim = iceFiyat * 0.20;
            System.out.printf("Happy hour (içecek): %%20 → -%.2f TL\n", happyIndirim);
            araToplam -= happyIndirim;
        }


        double digerIndirim = calculateDiscount(araToplam, combo, ogrenci, saat, gun);

        double digerIndirimEffective = calculateDiscount(araToplam, false, ogrenci, saat, gun);


        double ikiYuzIndirim = 0;
        double ogrenciIndirim = 0;


        if (!combo && araToplam >= 200) {
            ikiYuzIndirim = araToplam * 0.10;
        }
        if (ogrenci && gun >= 1 && gun <= 5) {
            ogrenciIndirim = araToplam * 0.10;
        }


        double toplamDiger = ikiYuzIndirim + ogrenciIndirim;

        if (ikiYuzIndirim > 0) {
            System.out.printf("200 TL üzeri indirim: %%10 → -%.2f TL\n", ikiYuzIndirim);
        }
        if (ogrenciIndirim > 0) {

            System.out.printf("Öğrenci indirimi: %%10 → -%.2f TL\n", ogrenciIndirim);
        }


        araToplam -= toplamDiger;


        System.out.printf("Toplam: %.2f TL\n", araToplam);

        double tip = calculateServiceTip(araToplam);
        System.out.printf("Bahşiş önerisi: %.2f TL (%%10)\n", tip);
    }
}
