class n3872093 {
	private ArrayList<Stock> fetchStockData(Stock[] stocks) throws IOException {
		Log.d(TAG, "Fetching stock data from Yahoo");
		ArrayList<Stock> newStocks = new ArrayList<Stock>(stocks.length);
		if (stocks.length > 0) {
			StringBuilder sb = new StringBuilder();
			for (Stock stock : stocks) {
				sb.append(stock.getSymbol());
				sb.append('+');
			}
			sb.deleteCharAt(sb.length() - 1);
			HttpClient client = new DefaultHttpClient();
			String urlStr = "http://finance.yahoo.com/d/quotes.csv?f=sb2n&s=" + sb.toString();
			HttpGet request = new HttpGet(urlStr.toString());
			HttpResponse response = client.execute(request);
			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			int i = 0;
			String line = reader.readLine();
			Log.d(TAG, "Parsing stock data from Yahoo");
			while (line != null) {
				Log.d(TAG, "Parsing: " + line);
				Stock stock = new Stock(stocks[i], stocks[i].getId());
				String[] values = line.split(",");
				stock.setCurrentPrice(Double.parseDouble(values[1]));
				stock.setName(values[2]);
				Log.d(TAG, "Parsed Stock: " + stock);
				newStocks.add(stock);
				i++;
				line = reader.readLine();
			}
		}
		return newStocks;
	}

}