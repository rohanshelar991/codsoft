package com.codsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * CODSOFT Task 4: Currency Converter
 * 
 * Features:
 * 1. Currency selection (base and target)
 * 2. Real-time exchange rates from API
 * 3. Amount input and validation
 * 4. Currency conversion calculation
 * 5. Result display with currency symbols
 * 6. Multiple conversion support
 */
public class CurrencyConverter {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String API_BASE_URL = "https://api.exchangerate-api.com/v4/latest/";
    
    // Popular currencies with symbols
    private static final Map<String, CurrencyInfo> CURRENCIES = new HashMap<>();
    
    // Conversion tracking
    private int totalConversions = 0;
    private double totalAmountConverted = 0.0;
    private String mostPopularFromCurrency = "";
    private String mostPopularToCurrency = "";
    private Map<String, Integer> currencyUsage = new HashMap<>();
    private List<String> conversionHistory = new ArrayList<>();
    
    static {
        // Initialize supported currencies (50+ major world currencies)
        
        // Major Reserve Currencies
        CURRENCIES.put("USD", new CurrencyInfo("USD", "US Dollar", "$"));
        CURRENCIES.put("EUR", new CurrencyInfo("EUR", "Euro", "€"));
        CURRENCIES.put("GBP", new CurrencyInfo("GBP", "British Pound", "£"));
        CURRENCIES.put("JPY", new CurrencyInfo("JPY", "Japanese Yen", "¥"));
        CURRENCIES.put("CHF", new CurrencyInfo("CHF", "Swiss Franc", "CHF"));
        CURRENCIES.put("CNY", new CurrencyInfo("CNY", "Chinese Yuan", "¥"));
        
        // North America
        CURRENCIES.put("CAD", new CurrencyInfo("CAD", "Canadian Dollar", "C$"));
        CURRENCIES.put("MXN", new CurrencyInfo("MXN", "Mexican Peso", "$"));
        
        // South America
        CURRENCIES.put("BRL", new CurrencyInfo("BRL", "Brazilian Real", "R$"));
        CURRENCIES.put("ARS", new CurrencyInfo("ARS", "Argentine Peso", "$"));
        CURRENCIES.put("CLP", new CurrencyInfo("CLP", "Chilean Peso", "$"));
        CURRENCIES.put("COP", new CurrencyInfo("COP", "Colombian Peso", "$"));
        CURRENCIES.put("PEN", new CurrencyInfo("PEN", "Peruvian Sol", "S/"));
        CURRENCIES.put("UYU", new CurrencyInfo("UYU", "Uruguayan Peso", "$"));
        CURRENCIES.put("VEF", new CurrencyInfo("VEF", "Venezuelan Bolívar", "Bs"));
        
        // Europe
        CURRENCIES.put("SEK", new CurrencyInfo("SEK", "Swedish Krona", "kr"));
        CURRENCIES.put("NOK", new CurrencyInfo("NOK", "Norwegian Krone", "kr"));
        CURRENCIES.put("DKK", new CurrencyInfo("DKK", "Danish Krone", "kr"));
        CURRENCIES.put("PLN", new CurrencyInfo("PLN", "Polish Złoty", "zł"));
        CURRENCIES.put("CZK", new CurrencyInfo("CZK", "Czech Koruna", "Kč"));
        CURRENCIES.put("HUF", new CurrencyInfo("HUF", "Hungarian Forint", "Ft"));
        CURRENCIES.put("RON", new CurrencyInfo("RON", "Romanian Leu", "lei"));
        CURRENCIES.put("BGN", new CurrencyInfo("BGN", "Bulgarian Lev", "лв"));
        CURRENCIES.put("HRK", new CurrencyInfo("HRK", "Croatian Kuna", "kn"));
        CURRENCIES.put("RSD", new CurrencyInfo("RSD", "Serbian Dinar", "дин"));
        CURRENCIES.put("UAH", new CurrencyInfo("UAH", "Ukrainian Hryvnia", "₴"));
        CURRENCIES.put("BYN", new CurrencyInfo("BYN", "Belarusian Ruble", "Br"));
        CURRENCIES.put("ISK", new CurrencyInfo("ISK", "Icelandic Króna", "kr"));
        CURRENCIES.put("ALL", new CurrencyInfo("ALL", "Albanian Lek", "L"));
        CURRENCIES.put("MKD", new CurrencyInfo("MKD", "Macedonian Denar", "ден"));
        CURRENCIES.put("MDL", new CurrencyInfo("MDL", "Moldovan Leu", "L"));
        CURRENCIES.put("GEL", new CurrencyInfo("GEL", "Georgian Lari", "₾"));
        CURRENCIES.put("AMD", new CurrencyInfo("AMD", "Armenian Dram", "֏"));
        CURRENCIES.put("AZN", new CurrencyInfo("AZN", "Azerbaijani Manat", "₼"));
        
        // Asia
        CURRENCIES.put("INR", new CurrencyInfo("INR", "Indian Rupee", "₹"));
        CURRENCIES.put("KRW", new CurrencyInfo("KRW", "South Korean Won", "₩"));
        CURRENCIES.put("SGD", new CurrencyInfo("SGD", "Singapore Dollar", "S$"));
        CURRENCIES.put("HKD", new CurrencyInfo("HKD", "Hong Kong Dollar", "HK$"));
        CURRENCIES.put("TWD", new CurrencyInfo("TWD", "Taiwan Dollar", "NT$"));
        CURRENCIES.put("THB", new CurrencyInfo("THB", "Thai Baht", "฿"));
        CURRENCIES.put("MYR", new CurrencyInfo("MYR", "Malaysian Ringgit", "RM"));
        CURRENCIES.put("IDR", new CurrencyInfo("IDR", "Indonesian Rupiah", "Rp"));
        CURRENCIES.put("PHP", new CurrencyInfo("PHP", "Philippine Peso", "₱"));
        CURRENCIES.put("VND", new CurrencyInfo("VND", "Vietnamese Dong", "₫"));
        CURRENCIES.put("BDT", new CurrencyInfo("BDT", "Bangladeshi Taka", "৳"));
        CURRENCIES.put("PKR", new CurrencyInfo("PKR", "Pakistani Rupee", "₨"));
        CURRENCIES.put("LKR", new CurrencyInfo("LKR", "Sri Lankan Rupee", "Rs"));
        CURRENCIES.put("NPR", new CurrencyInfo("NPR", "Nepalese Rupee", "₨"));
        CURRENCIES.put("MMK", new CurrencyInfo("MMK", "Myanmar Kyat", "K"));
        CURRENCIES.put("KHR", new CurrencyInfo("KHR", "Cambodian Riel", "៛"));
        CURRENCIES.put("LAK", new CurrencyInfo("LAK", "Lao Kip", "₭"));
        CURRENCIES.put("MNT", new CurrencyInfo("MNT", "Mongolian Tögrög", "₮"));
        CURRENCIES.put("KZT", new CurrencyInfo("KZT", "Kazakhstani Tenge", "₸"));
        CURRENCIES.put("UZS", new CurrencyInfo("UZS", "Uzbekistani Som", "so'm"));
        CURRENCIES.put("TJS", new CurrencyInfo("TJS", "Tajikistani Somoni", "ЅМ"));
        CURRENCIES.put("KGS", new CurrencyInfo("KGS", "Kyrgyzstani Som", "с"));
        CURRENCIES.put("TMT", new CurrencyInfo("TMT", "Turkmenistan Manat", "T"));
        
        // Middle East
        CURRENCIES.put("AED", new CurrencyInfo("AED", "UAE Dirham", "د.إ"));
        CURRENCIES.put("SAR", new CurrencyInfo("SAR", "Saudi Riyal", "ر.س"));
        CURRENCIES.put("QAR", new CurrencyInfo("QAR", "Qatari Riyal", "ر.ق"));
        CURRENCIES.put("KWD", new CurrencyInfo("KWD", "Kuwaiti Dinar", "د.ك"));
        CURRENCIES.put("BHD", new CurrencyInfo("BHD", "Bahraini Dinar", ".د.ب"));
        CURRENCIES.put("OMR", new CurrencyInfo("OMR", "Omani Rial", "ر.ع."));
        CURRENCIES.put("JOD", new CurrencyInfo("JOD", "Jordanian Dinar", "د.ا"));
        CURRENCIES.put("LBP", new CurrencyInfo("LBP", "Lebanese Pound", "ل.ل"));
        CURRENCIES.put("ILS", new CurrencyInfo("ILS", "Israeli Shekel", "₪"));
        CURRENCIES.put("EGP", new CurrencyInfo("EGP", "Egyptian Pound", "£"));
        CURRENCIES.put("IRR", new CurrencyInfo("IRR", "Iranian Rial", "﷼"));
        CURRENCIES.put("IQD", new CurrencyInfo("IQD", "Iraqi Dinar", "ع.د"));
        CURRENCIES.put("YER", new CurrencyInfo("YER", "Yemeni Rial", "﷼"));
        CURRENCIES.put("SYP", new CurrencyInfo("SYP", "Syrian Pound", "£"));
        
        // Africa
        CURRENCIES.put("ZAR", new CurrencyInfo("ZAR", "South African Rand", "R"));
        CURRENCIES.put("NGN", new CurrencyInfo("NGN", "Nigerian Naira", "₦"));
        CURRENCIES.put("EGP", new CurrencyInfo("EGP", "Egyptian Pound", "£"));
        CURRENCIES.put("KES", new CurrencyInfo("KES", "Kenyan Shilling", "KSh"));
        CURRENCIES.put("GHS", new CurrencyInfo("GHS", "Ghanaian Cedi", "₵"));
        CURRENCIES.put("MAD", new CurrencyInfo("MAD", "Moroccan Dirham", "د.م."));
        CURRENCIES.put("TND", new CurrencyInfo("TND", "Tunisian Dinar", "د.ت"));
        CURRENCIES.put("DZD", new CurrencyInfo("DZD", "Algerian Dinar", "د.ج"));
        CURRENCIES.put("LYD", new CurrencyInfo("LYD", "Libyan Dinar", "ل.د"));
        CURRENCIES.put("SDG", new CurrencyInfo("SDG", "Sudanese Pound", "ج.س."));
        CURRENCIES.put("ETB", new CurrencyInfo("ETB", "Ethiopian Birr", "Br"));
        CURRENCIES.put("UGX", new CurrencyInfo("UGX", "Ugandan Shilling", "USh"));
        CURRENCIES.put("TZS", new CurrencyInfo("TZS", "Tanzanian Shilling", "TSh"));
        CURRENCIES.put("MWK", new CurrencyInfo("MWK", "Malawian Kwacha", "MK"));
        CURRENCIES.put("ZMW", new CurrencyInfo("ZMW", "Zambian Kwacha", "ZK"));
        CURRENCIES.put("BWP", new CurrencyInfo("BWP", "Botswana Pula", "P"));
        CURRENCIES.put("NAD", new CurrencyInfo("NAD", "Namibian Dollar", "N$"));
        CURRENCIES.put("MUR", new CurrencyInfo("MUR", "Mauritian Rupee", "₨"));
        CURRENCIES.put("SCR", new CurrencyInfo("SCR", "Seychellois Rupee", "₨"));
        CURRENCIES.put("CVE", new CurrencyInfo("CVE", "Cape Verdean Escudo", "$"));
        CURRENCIES.put("XOF", new CurrencyInfo("XOF", "West African CFA Franc", "CFA"));
        CURRENCIES.put("XAF", new CurrencyInfo("XAF", "Central African CFA Franc", "FCFA"));
        CURRENCIES.put("XPF", new CurrencyInfo("XPF", "CFP Franc", "₣"));
        
        // Oceania
        CURRENCIES.put("AUD", new CurrencyInfo("AUD", "Australian Dollar", "A$"));
        CURRENCIES.put("NZD", new CurrencyInfo("NZD", "New Zealand Dollar", "NZ$"));
        CURRENCIES.put("FJD", new CurrencyInfo("FJD", "Fijian Dollar", "FJ$"));
        CURRENCIES.put("PGK", new CurrencyInfo("PGK", "Papua New Guinean Kina", "K"));
        CURRENCIES.put("SBD", new CurrencyInfo("SBD", "Solomon Islands Dollar", "SI$"));
        CURRENCIES.put("VUV", new CurrencyInfo("VUV", "Vanuatu Vatu", "VT"));
        CURRENCIES.put("TOP", new CurrencyInfo("TOP", "Tongan Paʻanga", "T$"));
        CURRENCIES.put("WST", new CurrencyInfo("WST", "Samoan Tālā", "T"));
        CURRENCIES.put("KID", new CurrencyInfo("KID", "Kiribati Dollar", "$"));
        
        // Special Territories
        CURRENCIES.put("TRY", new CurrencyInfo("TRY", "Turkish Lira", "₺"));
        CURRENCIES.put("RUB", new CurrencyInfo("RUB", "Russian Ruble", "₽"));
        CURRENCIES.put("KWD", new CurrencyInfo("KWD", "Kuwaiti Dinar", "د.ك"));
        CURRENCIES.put("BND", new CurrencyInfo("BND", "Brunei Dollar", "B$"));
        CURRENCIES.put("MOP", new CurrencyInfo("MOP", "Macanese Pataca", "MOP$"));
        CURRENCIES.put("BMD", new CurrencyInfo("BMD", "Bermudian Dollar", "BD$"));
        CURRENCIES.put("KYD", new CurrencyInfo("KYD", "Cayman Islands Dollar", "CI$"));
        CURRENCIES.put("JMD", new CurrencyInfo("JMD", "Jamaican Dollar", "J$"));
        CURRENCIES.put("TTD", new CurrencyInfo("TTD", "Trinidad and Tobago Dollar", "TT$"));
        CURRENCIES.put("BBD", new CurrencyInfo("BBD", "Barbadian Dollar", "Bds$"));
        CURRENCIES.put("XCD", new CurrencyInfo("XCD", "East Caribbean Dollar", "EC$"));
        CURRENCIES.put("GYD", new CurrencyInfo("GYD", "Guyanese Dollar", "G$"));
        CURRENCIES.put("SRD", new CurrencyInfo("SRD", "Surinamese Dollar", "$"));
        CURRENCIES.put("BZD", new CurrencyInfo("BZD", "Belize Dollar", "BZ$"));
        CURRENCIES.put("GTQ", new CurrencyInfo("GTQ", "Guatemalan Quetzal", "Q"));
        CURRENCIES.put("HNL", new CurrencyInfo("HNL", "Honduran Lempira", "L"));
        CURRENCIES.put("NIO", new CurrencyInfo("NIO", "Nicaraguan Córdoba", "C$"));
        CURRENCIES.put("CRC", new CurrencyInfo("CRC", "Costa Rican Colón", "₡"));
        CURRENCIES.put("PAB", new CurrencyInfo("PAB", "Panamanian Balboa", "B/."));
        CURRENCIES.put("DOP", new CurrencyInfo("DOP", "Dominican Peso", "RD$"));
        CURRENCIES.put("HTG", new CurrencyInfo("HTG", "Haitian Gourde", "G"));
        CURRENCIES.put("CUP", new CurrencyInfo("CUP", "Cuban Peso", "$"));
        CURRENCIES.put("PYG", new CurrencyInfo("PYG", "Paraguayan Guaraní", "₲"));
        CURRENCIES.put("BOB", new CurrencyInfo("BOB", "Bolivian Boliviano", "Bs"));
    }
    
    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        converter.displayWelcomeMessage();
        
        boolean continueConverting = true;
        while (continueConverting) {
            try {
                converter.performConversion();
                continueConverting = converter.askToContinue();
            } catch (Exception e) {
                System.out.println("❌ An error occurred: " + e.getMessage());
                System.out.println("🔄 Please try again...\n");
            }
        }
        
        converter.displayConversionSummary();
        System.out.println("Thank you for using Currency Converter! 💱");
        System.out.println("#codsoft #internship #javadevelopment");
        scanner.close();
    }
    
    private void displayWelcomeMessage() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    CURRENCY CONVERTER                       ║");
        System.out.println("║                       CODSOFT Task 4                        ║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.println("║  Features:                                                   ║");
        System.out.println("║  • Real-time exchange rates from reliable API               ║");
        System.out.println("║  • Support for 20+ major world currencies                   ║");
        System.out.println("║  • Accurate conversion with current market rates            ║");
        System.out.println("║  • Beautiful display with currency symbols                  ║");
        System.out.println("║  • Multiple conversion support                              ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
    }
    
    private void performConversion() throws IOException {
        System.out.println("💱 CURRENCY CONVERSION");
        System.out.println("=" .repeat(50));
        
        // Display available currencies
        displayAvailableCurrencies();
        
        // Get user selections
        String baseCurrency = getCurrencySelection("base");
        String targetCurrency = getCurrencySelection("target");
        double amount = getAmount();
        
        // Fetch exchange rate and convert
        double exchangeRate = fetchExchangeRate(baseCurrency, targetCurrency);
        double convertedAmount = amount * exchangeRate;
        
        // Update conversion statistics
        updateConversionStats(baseCurrency, targetCurrency, amount, convertedAmount);
        
        // Display results
        displayConversionResult(baseCurrency, targetCurrency, amount, exchangeRate, convertedAmount);
    }
    
    private void displayAvailableCurrencies() {
        System.out.println("📋 Available Currencies (" + CURRENCIES.size() + " currencies):");
        System.out.println("-" .repeat(80));
        
        int count = 0;
        for (Map.Entry<String, CurrencyInfo> entry : CURRENCIES.entrySet()) {
            CurrencyInfo currency = entry.getValue();
            System.out.printf("   %-3s %-25s %s", 
                currency.getCode(), currency.getName(), currency.getSymbol());
            
            count++;
            if (count % 3 == 0) {
                System.out.println();
            }
        }
        if (count % 3 != 0) {
            System.out.println();
        }
        System.out.println();
        System.out.println("💡 Tip: You can search by currency code (e.g., USD, EUR, INR)");
        System.out.println();
    }
    
    private String getCurrencySelection(String type) {
        while (true) {
            System.out.print("💱 Enter " + type + " currency code (e.g., USD, EUR): ");
            String input = scanner.nextLine().trim().toUpperCase();
            
            if (CURRENCIES.containsKey(input)) {
                CurrencyInfo currency = CURRENCIES.get(input);
                System.out.println("   ✅ Selected: " + currency.getName() + " (" + currency.getSymbol() + ")");
                return input;
            } else {
                System.out.println("   ❌ Invalid currency code! Please choose from the available currencies.");
            }
        }
    }
    
    private double getAmount() {
        while (true) {
            System.out.print("💰 Enter amount to convert: ");
            try {
                double amount = Double.parseDouble(scanner.nextLine().trim());
                if (amount > 0) {
                    return amount;
                } else {
                    System.out.println("   ❌ Amount must be greater than 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("   ❌ Invalid amount! Please enter a valid number.");
            }
        }
    }
    
    private double fetchExchangeRate(String baseCurrency, String targetCurrency) throws IOException {
        System.out.println("\n🌐 Fetching real-time exchange rate...");
        
        String apiUrl = API_BASE_URL + baseCurrency;
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "CurrencyConverter/1.0");
        
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("API request failed with response code: " + responseCode);
        }
        
        // Read response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        
        // Parse JSON response (simplified parsing)
        String jsonResponse = response.toString();
        return parseExchangeRate(jsonResponse, targetCurrency);
    }
    
    private double parseExchangeRate(String jsonResponse, String targetCurrency) {
        try {
            // Simple JSON parsing for the exchange rate
            String searchPattern = "\"" + targetCurrency + "\":";
            int startIndex = jsonResponse.indexOf(searchPattern);
            if (startIndex == -1) {
                throw new IOException("Target currency not found in API response");
            }
            
            startIndex += searchPattern.length();
            int endIndex = jsonResponse.indexOf(",", startIndex);
            if (endIndex == -1) {
                endIndex = jsonResponse.indexOf("}", startIndex);
            }
            
            String rateString = jsonResponse.substring(startIndex, endIndex).trim();
            return Double.parseDouble(rateString);
            
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse exchange rate: " + e.getMessage());
        }
    }
    
    private void displayConversionResult(String baseCurrency, String targetCurrency, 
                                       double amount, double exchangeRate, double convertedAmount) {
        CurrencyInfo baseInfo = CURRENCIES.get(baseCurrency);
        CurrencyInfo targetInfo = CURRENCIES.get(targetCurrency);
        
        System.out.println("\n" + "=" .repeat(60));
        System.out.println("💱 CONVERSION RESULT");
        System.out.println("=" .repeat(60));
        
        System.out.println("📊 Conversion Details:");
        System.out.println("-" .repeat(40));
        System.out.printf("   From: %s %s (%s)%n", 
            baseInfo.getSymbol(), String.format("%.2f", amount), baseInfo.getName());
        System.out.printf("   To: %s %s (%s)%n", 
            targetInfo.getSymbol(), String.format("%.2f", convertedAmount), targetInfo.getName());
        System.out.printf("   Exchange Rate: 1 %s = %.6f %s%n", 
            baseCurrency, exchangeRate, targetCurrency);
        System.out.println();
        
        // Display formatted result
        System.out.println("🎯 RESULT:");
        System.out.println("-" .repeat(40));
        System.out.printf("   %s %.2f = %s %.2f%n", 
            baseInfo.getSymbol(), amount, targetInfo.getSymbol(), convertedAmount);
        
        // Add some fun facts
        displayFunFacts(baseCurrency, targetCurrency, amount, convertedAmount);
        
        System.out.println("=" .repeat(60));
    }
    
    private void displayFunFacts(String baseCurrency, String targetCurrency, 
                               double amount, double convertedAmount) {
        System.out.println();
        System.out.println("💡 INTERESTING FACTS:");
        System.out.println("-" .repeat(40));
        
        CurrencyInfo baseInfo = CURRENCIES.get(baseCurrency);
        CurrencyInfo targetInfo = CURRENCIES.get(targetCurrency);
        
        // Calculate some interesting comparisons
        if (baseCurrency.equals("USD")) {
            if (targetCurrency.equals("EUR")) {
                System.out.println("   💶 Euro is the second most traded currency globally");
            } else if (targetCurrency.equals("JPY")) {
                System.out.println("   🇯🇵 Japanese Yen is the third most traded currency");
            } else if (targetCurrency.equals("GBP")) {
                System.out.println("   🇬🇧 British Pound is one of the oldest currencies still in use");
            }
        } else if (baseCurrency.equals("EUR")) {
            if (targetCurrency.equals("USD")) {
                System.out.println("   🇺🇸 US Dollar is the world's primary reserve currency");
            }
        }
        
        // Show relative strength
        if (convertedAmount > amount) {
            System.out.printf("   📈 %s is stronger than %s%n", targetInfo.getName(), baseInfo.getName());
        } else if (convertedAmount < amount) {
            System.out.printf("   📉 %s is weaker than %s%n", targetInfo.getName(), baseInfo.getName());
        } else {
            System.out.println("   ⚖️  Both currencies have equal value");
        }
    }
    
    private boolean askToContinue() {
        while (true) {
            System.out.print("\n🔄 Convert another currency? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            
            if (response.equals("y") || response.equals("yes")) {
                System.out.println();
                return true;
            } else if (response.equals("n") || response.equals("no")) {
                return false;
            } else {
                System.out.println("❌ Please enter 'y' for yes or 'n' for no.");
            }
        }
    }
    
    // Inner class to store currency information
    private static class CurrencyInfo {
        private final String code;
        private final String name;
        private final String symbol;
        
        public CurrencyInfo(String code, String name, String symbol) {
            this.code = code;
            this.name = name;
            this.symbol = symbol;
        }
        
        public String getCode() { return code; }
        public String getName() { return name; }
        public String getSymbol() { return symbol; }
    }
    
    private void updateConversionStats(String baseCurrency, String targetCurrency, double amount, double convertedAmount) {
        totalConversions++;
        totalAmountConverted += amount;
        
        // Update currency usage
        currencyUsage.put(baseCurrency, currencyUsage.getOrDefault(baseCurrency, 0) + 1);
        currencyUsage.put(targetCurrency, currencyUsage.getOrDefault(targetCurrency, 0) + 1);
        
        // Update most popular currencies
        mostPopularFromCurrency = currencyUsage.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse("");
            
        mostPopularToCurrency = currencyUsage.entrySet().stream()
            .filter(entry -> !entry.getKey().equals(mostPopularFromCurrency))
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse("");
        
        // Add to conversion history
        String historyEntry = String.format("%s %.2f → %s %.2f", 
            CURRENCIES.get(baseCurrency).getSymbol(), amount,
            CURRENCIES.get(targetCurrency).getSymbol(), convertedAmount);
        conversionHistory.add(historyEntry);
    }
    
    private void displayConversionSummary() {
        if (totalConversions > 0) {
            System.out.println("\n📊 CONVERSION SUMMARY:");
            System.out.println("=" .repeat(50));
            System.out.println("Total Conversions: " + totalConversions);
            System.out.println("Total Amount Converted: " + String.format("%.2f", totalAmountConverted));
            System.out.println("Most Popular From Currency: " + mostPopularFromCurrency);
            System.out.println("Most Popular To Currency: " + mostPopularToCurrency);
            
            if (!conversionHistory.isEmpty()) {
                System.out.println("\n🕒 RECENT CONVERSIONS:");
                int startIndex = Math.max(0, conversionHistory.size() - 5);
                for (int i = startIndex; i < conversionHistory.size(); i++) {
                    System.out.println("   • " + conversionHistory.get(i));
                }
            }
            System.out.println("=" .repeat(50));
        }
    }
} 