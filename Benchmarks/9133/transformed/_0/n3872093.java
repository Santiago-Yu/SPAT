class n3872093 {
	private ArrayList<Stock> fetchStockData(Stock[] Aa1wQuTg) throws IOException {
		Log.d(TAG, "Fetching stock data from Yahoo");
		ArrayList<Stock> iBiYX63r = new ArrayList<Stock>(Aa1wQuTg.length);
		if (Aa1wQuTg.length > 0) {
			StringBuilder VWj82ry3 = new StringBuilder();
			for (Stock hiYjuzwB : Aa1wQuTg) {
				VWj82ry3.append(hiYjuzwB.getSymbol());
				VWj82ry3.append('+');
			}
			VWj82ry3.deleteCharAt(VWj82ry3.length() - 1);
			String Hm13Swc0 = "http://finance.yahoo.com/d/quotes.csv?f=sb2n&s=" + VWj82ry3.toString();
			HttpClient jSnPEPK4 = new DefaultHttpClient();
			HttpGet cy9AuqJA = new HttpGet(Hm13Swc0.toString());
			HttpResponse fYx2znve = jSnPEPK4.execute(cy9AuqJA);
			BufferedReader LrK1Fsbd = new BufferedReader(new InputStreamReader(fYx2znve.getEntity().getContent()));
			String HG28ZYxr = LrK1Fsbd.readLine();
			int N4trvD0q = 0;
			Log.d(TAG, "Parsing stock data from Yahoo");
			while (HG28ZYxr != null) {
				Log.d(TAG, "Parsing: " + HG28ZYxr);
				String[] hsfTUF7X = HG28ZYxr.split(",");
				Stock nLXc7L8i = new Stock(Aa1wQuTg[N4trvD0q], Aa1wQuTg[N4trvD0q].getId());
				nLXc7L8i.setCurrentPrice(Double.parseDouble(hsfTUF7X[1]));
				nLXc7L8i.setName(hsfTUF7X[2]);
				Log.d(TAG, "Parsed Stock: " + nLXc7L8i);
				iBiYX63r.add(nLXc7L8i);
				HG28ZYxr = LrK1Fsbd.readLine();
				N4trvD0q++;
			}
		}
		return iBiYX63r;
	}

}