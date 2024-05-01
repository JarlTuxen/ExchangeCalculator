import java.util.HashMap;

public class ExchangeCalculator {
    // Currency exchange rates (example rates)
    private HashMap<String, Double> exchangeRates;

    // Constructor to initialize exchange rates
    public ExchangeCalculator() {
        exchangeRates = new HashMap<>();
        // Add some example exchange rates (replace with actual rates)
        exchangeRates.put("USD", 0.1328);  // 1 DKK = 0.1328 USD
        exchangeRates.put("EUR", 0.1291); // 1 DKK = 0.1291 EUR
        exchangeRates.put("GBP", 0.1083); // 1 DKK = 0.1083 GBP
        exchangeRates.put("DKK", 1.00); // 1 DKK = 1 DKK
    }

    // Method to calculate exchange
    public double exchange(String fromCurrency, String toCurrency, double amount) {
        // Retrieve exchange rates for the currencies
        double fromRate = exchangeRates.getOrDefault(fromCurrency, 0.0);
        double toRate = exchangeRates.getOrDefault(toCurrency, 0.0);

        // Check if exchange rates for both currencies are available or else throw exception
        if (fromRate == 0.0) throw new IllegalArgumentException("Unknown Currency" + fromCurrency);
        if (toRate == 0.0) throw new IllegalArgumentException("Unknown Currency" + toCurrency);

        // Calculate the exchanged amount
        double exchangedAmount = amount * (toRate / fromRate);
        return exchangedAmount;
    }

    public static void main(String[] args) {
        ExchangeCalculator calculator = new ExchangeCalculator();

        try{
            String fromCurrency = "USD";
            String toCurrency = "DKK";
            double amount = 100.0;
            double exchangedAmount = calculator.exchange(fromCurrency, toCurrency, amount);
            System.out.println(amount + " " + fromCurrency + " is equivalent to " + exchangedAmount + " " + toCurrency);}
        catch (Exception exception)
        {
            System.out.println(exception);
        }

    }
}

