package Trader;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TraderUtils {
    public static List<Transaction> getTransactionsIn2011(List<Transaction> transactions) {
        return transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
    }

    public static Set<String> getUniqueCity(List<Trader> traders) {
        return traders.stream()
                .map(Trader::getCity)
                .collect(Collectors.toSet());
    }

    public static Set<Trader> tradersFromCambridge(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .collect(Collectors.toSet());
    }

    public static String getAllTradersNames(List<Trader> traders) {
        return traders.stream()
                .map(Trader::getName)
                .sorted()
                .collect(Collectors.joining(", "));
    }

    public static boolean isTraderFromMilan(List<Trader> traders) {
        return traders.stream()
                .anyMatch(trader -> trader.getCity().equals("Milan"));
    }

    public static String allTransactionsFromCambridge(List<Transaction> traders) {
        return traders.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(transaction -> String.valueOf(transaction.getValue()))
                .collect(Collectors.joining(", "));
    }

    public static int getMaxValueOfTransactions(List<Transaction> transactions) {
        return transactions.stream()
                .mapToInt(Transaction::getValue)
                .max()
                .getAsInt();
    }

    public static int getMinValueOfTransactions(List<Transaction> transactions){
        return transactions.stream()
                .mapToInt(Transaction::getValue)
                .min()
                .getAsInt();
    }
 }
