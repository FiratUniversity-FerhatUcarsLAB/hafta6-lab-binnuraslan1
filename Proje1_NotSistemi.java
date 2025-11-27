import java.util.Scanner;

public class NotSistemi {


    public static double calculateAverage(double vize, double fin, double odev) {
        return vize * 0.30 + fin * 0.40 + odev * 0.30;
    }


    public static boolean isPassingGrade(double ort) {
        return ort >= 50;
    }


    public static String getLetterGrade(double ort) {
        if (ort >= 90) return "A";
        else if (ort >= 80) return "B";
        else if (ort >= 70) return "C";
        else if (ort >= 60) return "D";
        else return "F";
    }


    public static boolean isHonorList(double ort, double v, double f, double o) {
        return ort >= 85 && v >= 70 && f >= 70 && o >= 70;
    }


    public static boolean hasRetakeRight(double ort) {
        return ort >= 40 && ort < 50;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Vize: ");
        double vize = scanner.nextDouble();

        System.out.print("Final: ");
        double fin = scanner.nextDouble();

        System.out.print("Ödev: ");
        double odev = scanner.nextDouble();


        double ort = calculateAverage(vize, fin, odev);
        String letter = getLetterGrade(ort);
        boolean passed = isPassingGrade(ort);
        boolean honor = isHonorList(ort, vize, fin, odev);
        boolean retake = hasRetakeRight(ort);


        System.out.println("\n=== OGRENCI NOT RAPORU ===");
        System.out.println("Vize Notu : " + vize);
        System.out.println("Final Notu : " + fin);
        System.out.println("Odev Notu : " + odev);
        System.out.println("------------------------------");
        System.out.println("Ortalama : " + String.format("%.1f", ort));
        System.out.println("Harf Notu : " + letter);
        System.out.println("Durum : " + (passed ? "GECTI" : "KALDI"));
        System.out.println("Onur Listesi : " + (honor ? "EVET" : "HAYIR"));
        System.out.println("Butunleme : " + (retake ? "VAR" : "YOK"));

        scanner.close();
    }
}

