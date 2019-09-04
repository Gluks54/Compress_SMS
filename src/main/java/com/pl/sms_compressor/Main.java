package com.pl.sms_compressor;

import com.pl.sms_compressor.Compressors.NaiveCompressor;
import com.pl.sms_compressor.Compressors.OptimalCompressor;
import com.pl.sms_compressor.Paginator.Paginator;
import com.pl.sms_compressor.calculator.CostCalculator;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type your massage");
        String massage = scanner.nextLine();
        OptimalCompressor optimalCompressor = new OptimalCompressor();
        NaiveCompressor naiveCompressor = new NaiveCompressor();

        System.out.println("Which method of compression you want to use? o/n");

        String comressMassege = "";
        if (scanner.hasNext("o")) {
            comressMassege = optimalCompressor.compress(massage);
        }

        if (scanner.hasNext("n")) {
            comressMassege = naiveCompressor.compress(massage);
        }

        Paginator paginator = new Paginator(3);
        String[] paginateString = paginator.paginate(comressMassege);

        CostCalculator costCalculator = new CostCalculator(new BigDecimal(3));
        BigDecimal price = costCalculator.calculate(paginateString.length);

        System.out.println(price);
    }
}
