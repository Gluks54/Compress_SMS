import Compressor.NaiveCompressor;

import java.math.BigDecimal;
import java.util.Scanner;

import static junit.framework.Assert.assertEquals;

public class Main {

        public static void main(String args[]) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Type your massage");
            String massage = scanner.nextLine();
            OptimalCompressor optimalCompressor = new OptimalCompressor();
            NaiveCompressor naiveCompressor = new NaiveCompressor();

            System.out.println("Which method of compression you want use? o/n");
            String anwer ;

            String comressMassege = "";
            if (scanner.hasNext("o")){
               comressMassege = optimalCompressor.compress(massage);
            }

            if(scanner.hasNext("n")){
                 comressMassege = naiveCompressor.compress(massage);
            }

            Paginator paginator = new Paginator(3);
            String[] paginateString = paginator.paginate(comressMassege);

            CostCalculator costCalculator = new CostCalculator(new BigDecimal(3));
            BigDecimal price = costCalculator.calculate(paginateString.length);

            System.out.println(price);
        }

}
