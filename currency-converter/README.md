# Currency Converter Web Application

A modern, responsive currency converter web application built with HTML, CSS, and JavaScript. The application provides real-time currency conversion with a clean, user-friendly interface.

## Features

### ✅ Functional Requirements
- **Currency Selection**: Dropdowns for base and target currencies with names and symbols
- **Real-Time Exchange Rates**: Fetches live exchange rates from a reliable API
- **Amount Input**: Numeric input with validation for proper amounts
- **Currency Conversion**: Converts amounts using the latest exchange rates
- **Result Display**: Shows converted amount with currency symbols and last updated time

### 🎨 UI/UX Requirements
- Clean, modern card-based design
- Fully responsive for mobile and desktop
- Smooth animations and transitions
- Dark/light mode toggle
- Loading spinner during API calls
- Professional typography and spacing

### 🚀 Advanced Features
- Swap base and target currencies
- Conversion history (last 10 conversions)
- Offline fallback using cached rates
- Auto-detection of user's local currency
- Keyboard-friendly inputs

## How to Use

1. Open the `index.html` file in any modern web browser
2. Select your base currency from the first dropdown
3. Select your target currency from the second dropdown
4. Enter the amount you want to convert
5. The converted amount will appear automatically
6. Use the swap button to switch base and target currencies
7. Toggle between light and dark mode using the theme button

## Technical Details

- Built with vanilla HTML, CSS, and JavaScript (no frameworks)
- Uses the free ExchangeRate API (https://api.exchangerate.host)
- Implements caching with localStorage to reduce API calls
- Responsive design using CSS Flexbox
- Modern CSS features like CSS variables for theming
- Modular JavaScript with clear functions
- Well-commented code for maintainability

## API Usage

The application uses the free ExchangeRate API which provides:
- Real-time exchange rates for 170+ currencies
- No API key required for basic usage
- Rate caching to minimize requests
- Fallback to cached rates when offline

## Browser Compatibility

The application works in all modern browsers (Chrome, Firefox, Safari, Edge) that support:
- Fetch API
- localStorage
- CSS variables
- Flexbox layout

## Offline Functionality

When offline, the application will:
- Use cached exchange rates if available
- Display a warning message
- Allow users to access their conversion history