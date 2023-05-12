package Trader;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
          new Transaction(brian, 2011, 300),
          new Transaction(raoul, 2012, 1000),
          new Transaction(raoul, 2011, 400),
          new Transaction(mario, 2012, 710),
          new Transaction(mario, 2012, 700),
          new Transaction(alan, 2012, 950)
        );

        List<Transaction> transactionsIn2011 = TraderUtils.getTransactionsIn2011(transactions);
        System.out.println(transactionsIn2011);
        Set<String> uniqueCityOfTraders = TraderUtils.getUniqueCity(transactions);
        System.out.println(uniqueCityOfTraders);
        List<Trader> tradersFromCambridge = TraderUtils.tradersFromCambridge(transactions);
        System.out.println(tradersFromCambridge);
        String allTradersNames = TraderUtils.getAllTradersNames(transactions);
        System.out.println(allTradersNames);
        boolean traderFromMilan = TraderUtils.isTraderFromMilan(transactions);
        System.out.println(traderFromMilan);
        String allTransactionsFromCambridge = TraderUtils.allTransactionsFromCambridge(transactions);
        System.out.println(allTransactionsFromCambridge);
        Optional<Transaction> maxValueOfTransactions = TraderUtils.getMaxValueOfTransactions(transactions);
        System.out.println(maxValueOfTransactions.get());
        Optional<Transaction> minValueOfTransactions = TraderUtils.getMinValueOfTransactions(transactions);
        System.out.println(minValueOfTransactions.get());
        System.out.println(TraderUtils.getSumOfTransactions(transactions));
    }
}
