# Currency Converter 💱

**CODSOFT Task 4: Java Development Internship**

A real-time currency conversion application that fetches live exchange rates from a reliable API and provides accurate currency conversions with beautiful formatting and educational insights.

## 🎯 Features

### Core Features
- **Real-time Exchange Rates**: Fetches current rates from ExchangeRate-API
- **Currency Selection**: Choose from 100+ major world currencies
- **Amount Input**: User-friendly amount input with validation
- **Accurate Conversion**: Precise calculations using live market rates
- **Currency Symbols**: Beautiful display with proper currency symbols
- **Multiple Conversions**: Convert multiple amounts in one session

### Advanced Features
- **Educational Content**: Fun facts about currencies and their relationships
- **Error Handling**: Robust error handling for API failures
- **Input Validation**: Comprehensive validation for all user inputs
- **Beautiful UI**: ASCII art borders and emojis for enhanced experience
- **Relative Strength**: Shows which currency is stronger/weaker

## 🚀 Installation & Setup

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher
- Internet connection (for API calls)

### Build Instructions

1. **Clone or download the project**
   ```bash
   cd currency-converter
   ```

2. **Compile the project**
   ```bash
   mvn clean compile
   ```

3. **Run the converter**
   ```bash
   mvn exec:java -Dexec.mainClass="com.codsoft.CurrencyConverter"
   ```

   Or build and run the JAR:
   ```bash
   mvn clean package
   java -jar target/currency-converter-1.0.0.jar
   ```

## 💱 Supported Currencies

The application supports **100+ major world currencies** including:

### Major Reserve Currencies
- **USD** - US Dollar ($)
- **EUR** - Euro (€)
- **GBP** - British Pound (£)
- **JPY** - Japanese Yen (¥)
- **CHF** - Swiss Franc (CHF)
- **CNY** - Chinese Yuan (¥)

### Regional Currencies by Continent

**North America**: CAD, MXN, BMD, KYD, JMD, TTD, BBD, XCD, BZD, GTQ, HNL, NIO, CRC, PAB, DOP, HTG, CUP

**South America**: BRL, ARS, CLP, COP, PEN, UYU, VEF, GYD, SRD, PYG, BOB

**Europe**: SEK, NOK, DKK, PLN, CZK, HUF, RON, BGN, HRK, RSD, UAH, BYN, ISK, ALL, MKD, MDL, GEL, AMD, AZN

**Asia**: INR, KRW, SGD, HKD, TWD, THB, MYR, IDR, PHP, VND, BDT, PKR, LKR, NPR, MMK, KHR, LAK, MNT, KZT, UZS, TJS, KGS, TMT, BND, MOP

**Middle East**: AED, SAR, QAR, KWD, BHD, OMR, JOD, LBP, ILS, EGP, IRR, IQD, YER, SYP

**Africa**: ZAR, NGN, KES, GHS, MAD, TND, DZD, LYD, SDG, ETB, UGX, TZS, MWK, ZMW, BWP, NAD, MUR, SCR, CVE, XOF, XAF, XPF

**Oceania**: AUD, NZD, FJD, PGK, SBD, VUV, TOP, WST, KID

**Special Territories**: TRY, RUB, BND, MOP, BMD, KYD, JMD, TTD, BBD, XCD

*Note: This is a comprehensive list covering major world currencies. The actual availability depends on the API's supported currencies.*

## 📊 How to Use

1. **Start the Application**: Run the program
2. **View Available Currencies**: See the list of supported currencies
3. **Select Base Currency**: Choose the currency you want to convert from
4. **Select Target Currency**: Choose the currency you want to convert to
5. **Enter Amount**: Input the amount you want to convert
6. **View Results**: See the conversion result with detailed information
7. **Continue**: Convert more amounts or exit

## 🌐 API Information

### ExchangeRate-API
- **Base URL**: `https://api.exchangerate-api.com/v4/latest/`
- **Rate Limits**: Free tier with generous limits
- **Data Source**: European Central Bank (ECB)
- **Update Frequency**: Daily updates
- **Reliability**: High accuracy and uptime

### API Response Format
```json
{
  "rates": {
    "USD": 1.0,
    "EUR": 0.85,
    "GBP": 0.73,
    "JPY": 110.25
  },
  "base": "USD",
  "date": "2024-01-15"
}
```

## 📋 Sample Output

```
╔══════════════════════════════════════════════════════════════╗
║                    CURRENCY CONVERTER                       ║
║                       CODSOFT Task 4                        ║
╠══════════════════════════════════════════════════════════════╣
║  Features:                                                   ║
║  • Real-time exchange rates from reliable API               ║
║  • Support for 100+ major world currencies                  ║
║  • Accurate conversion with current market rates            ║
║  • Beautiful display with currency symbols                  ║
║  • Multiple conversion support                              ║
╚══════════════════════════════════════════════════════════════╝

💱 CURRENCY CONVERSION
==================================================
📋 Available Currencies:
------------------------------------------------------------
   USD US Dollar           $   EUR Euro                  €
   GBP British Pound       £   JPY Japanese Yen          ¥
   CAD Canadian Dollar     C$  AUD Australian Dollar     A$
   CHF Swiss Franc         CHF CNY Chinese Yuan          ¥
   INR Indian Rupee        ₹   BRL Brazilian Real        R$
   MXN Mexican Peso        $   SGD Singapore Dollar      S$
   HKD Hong Kong Dollar    HK$ NZD New Zealand Dollar    NZ$
   SEK Swedish Krona       kr  KRW South Korean Won      ₩
   RUB Russian Ruble       ₽   ZAR South African Rand    R
   TRY Turkish Lira        ₺   AED UAE Dirham            د.إ

💱 Enter base currency code (e.g., USD, EUR): USD
   ✅ Selected: US Dollar ($)
💱 Enter target currency code (e.g., USD, EUR): EUR
   ✅ Selected: Euro (€)
💰 Enter amount to convert: 100

🌐 Fetching real-time exchange rate...

============================================================
💱 CONVERSION RESULT
============================================================
📊 Conversion Details:
----------------------------------------
   From: $ 100.00 (US Dollar)
   To: € 85.50 (Euro)
   Exchange Rate: 1 USD = 0.855000 EUR

🎯 RESULT:
----------------------------------------
   $ 100.00 = € 85.50

💡 INTERESTING FACTS:
----------------------------------------
   💶 Euro is the second most traded currency globally
   📉 Euro is weaker than US Dollar
============================================================
```

## 🛠️ Technical Details

### Project Structure
```
currency-converter/
├── pom.xml                          # Maven configuration
├── README.md                        # This file
└── src/
    └── main/
        └── java/
            └── com/
                └── codsoft/
                    └── CurrencyConverter.java  # Main converter class
```

### Key Classes
- **CurrencyConverter**: Main application logic and API integration
- **CurrencyInfo**: Inner class for currency data storage
- **HttpURLConnection**: Java networking for API calls

### Dependencies
- **Apache HttpClient**: HTTP client for API requests
- **Jackson**: JSON parsing library
- **JSON**: Alternative JSON parsing

### Design Patterns
- **Data Encapsulation**: Private fields with getter methods
- **Error Handling**: Comprehensive exception handling
- **Input Validation**: Robust validation for all inputs
- **Modular Methods**: Single responsibility principle

## 🎯 Learning Objectives

This project demonstrates:
- **Java Networking**: HTTP connections and API integration
- **JSON Parsing**: Handling API responses and data extraction
- **Exception Handling**: Robust error management
- **Data Structures**: Maps, HashMaps for currency storage
- **Input/Output**: Scanner class, formatted output
- **String Manipulation**: Parsing and formatting
- **Mathematical Operations**: Currency conversion calculations

## 🔧 API Integration

### HTTP Request Handling
- Uses `HttpURLConnection` for API calls
- Proper User-Agent headers for API compliance
- Response code validation
- BufferedReader for efficient response reading

### JSON Parsing
- Simple string-based JSON parsing
- Error handling for malformed responses
- Exchange rate extraction from API response

### Error Handling
- Network connectivity issues
- API rate limiting
- Invalid currency codes
- Malformed API responses

## 📝 CODSOFT Internship Requirements

✅ **Task Completion**: Complete currency converter with all required features  
✅ **API Integration**: Real-time exchange rate fetching  
✅ **Currency Selection**: Base and target currency selection  
✅ **Amount Input**: User input with validation  
✅ **Conversion Calculation**: Accurate currency conversion  
✅ **Result Display**: Clear and formatted output with symbols  
✅ **Advanced Features**: Multiple conversions and educational content  

## 🌍 Currency Information

### Major World Currencies
- **USD (US Dollar)**: World's primary reserve currency
- **EUR (Euro)**: Second most traded currency globally
- **GBP (British Pound)**: One of the oldest currencies still in use
- **JPY (Japanese Yen)**: Third most traded currency
- **CNY (Chinese Yuan)**: Growing international importance

### Currency Symbols
The application includes proper Unicode symbols for all supported currencies, providing a professional and authentic user experience.

## 🏷️ Tags

#codsoft #internship #javadevelopment #currencyconverter #api #forex

## 📞 Support

For questions or issues related to this CODSOFT task, please refer to the internship guidelines or contact your mentor.

---

**Developed for CODSOFT Java Development Internship**  
**Task 4: Currency Converter**  
**Author: [Your Name]**  
**Date: [Current Date]** 