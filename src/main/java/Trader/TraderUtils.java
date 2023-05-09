package Trader;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class TraderUtils {
    public static List<Transaction> getTransactionsIn2011(List<Transaction> transactions) {
        return transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
    }

    public static Set<String> getUniqueCity(List<Transaction> transactions) {
        return transactions.stream()
                .map(t -> t.getTrader().getCity())
                .collect(Collectors.toSet());
    }

    public static List<Trader> tradersFromCambridge(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .collect(Collectors.toList());
    }

    public static String getAllTradersNames(List<Transaction> transactions) {
        return transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
    }

    public static boolean isTraderFromMilan(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(trader -> trader.getCity().equals("Milan"));
    }

    public static String allTransactionsFromCambridge(List<Transaction> traders) {
        return traders.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(transaction -> String.valueOf(transaction.getValue()))
                .collect(Collectors.joining(", "));
    }

    public static Optional<Transaction> getMaxValueOfTransactions(List<Transaction> transactions) {
        return transactions.stream()
                .max(Comparator.comparing(Transaction::getValue));
    }

    public static Optional<Transaction> getMinValueOfTransactions(List<Transaction> transactions) {
        return transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
    }
}
