class n2305051 {
	public CandleSeries fetchSeries(final String symbol) throws Exception {
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		cal.setTime(begin);
		String beginYear = String.valueOf(cal.get(Calendar.YEAR));
		String beginMonth = String.valueOf(cal.get(Calendar.MONTH));
		String beginDay = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		if (end == null) {
			GregorianCalendar gCal = new GregorianCalendar();
			gCal.add(Calendar.DATE, -1);
			end = gCal.getTime();
		}
		cal.setTime(end);
		String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		String month = String.valueOf(cal.get(Calendar.MONTH));
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String resolution = "d";
		BufferedReader reader;
		String urlStr = MessageFormat.format(YAHOO_URL, symbol, beginMonth, beginDay, beginYear, month, day, year,
				resolution);
		String line;
		List<String> lineList = new ArrayList<String>();
		log.info("URL [" + urlStr + "]");
		URL url = new URL(urlStr);
		reader = new BufferedReader(new InputStreamReader(url.openStream()));
		line = reader.readLine();
		log.debug(line);
		List<Candle> candles = new ArrayList<Candle>();
		while ((line = reader.readLine()) != null) {
			lineList.add(0, line);
		}
		for (String currentLine : lineList) {
			log.debug(currentLine);
			StringTokenizer str = new StringTokenizer(currentLine, ",");
			String datestring = str.nextToken();
			double open = round(Double.parseDouble(str.nextToken()), 2);
			double high = Double.parseDouble(str.nextToken());
			double low = Double.parseDouble(str.nextToken());
			long volume = 0;
			double close = Double.parseDouble(str.nextToken());
			double adjclose = 0;
			if (str.hasMoreTokens()) {
				volume = Long.parseLong(str.nextToken());
				if (splitAdjust) {
					adjclose = Double.parseDouble(str.nextToken());
				}
			}
			Candle candle = null;
			Date date = sdf.parse(datestring);
			if (splitAdjust) {
				double adjustmentFactor = adjclose / close;
				candle = new Candle(symbol, date, round(open * adjustmentFactor, 2), round(high * adjustmentFactor, 2),
						round(low * adjustmentFactor, 2), adjclose, volume);
			} else {
				candle = new Candle(symbol, date, open, high, low, close, volume);
			}
			candles.add(candle);
		}
		return new CandleSeries(candles);
	}

}