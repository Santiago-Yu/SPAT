class n19180753 {
	public final void loadAllData(final String ticker, final File output, final CSVFormat outputFormat, final Date from,
			final Date to) {
		try {
			final URL url = buildURL(ticker, from, to);
			final InputStream is = url.openStream();
			final ReadCSV csv = new ReadCSV(is, true, CSVFormat.ENGLISH);
			final PrintWriter tw = new PrintWriter(new FileWriter(output));
			tw.println("date,time,open price,high price,low price," + "close price,volume,adjusted price");
			for (; csv.next() && !shouldStop();) {
				final Date date = csv.getDate("date");
				final double adjClose = csv.getDouble("adj close");
				final double open = csv.getDouble("open");
				final double close = csv.getDouble("close");
				final double high = csv.getDouble("high");
				final double low = csv.getDouble("low");
				final double volume = csv.getDouble("volume");
				final NumberFormat df = NumberFormat.getInstance();
				df.setGroupingUsed(false);
				final StringBuilder line = new StringBuilder();
				line.append(NumericDateUtil.date2Long(date));
				line.append(outputFormat.getSeparator());
				line.append(NumericDateUtil.time2Int(date));
				line.append(outputFormat.getSeparator());
				line.append(outputFormat.format(open, this.precision));
				line.append(outputFormat.getSeparator());
				line.append(outputFormat.format(high, this.precision));
				line.append(outputFormat.getSeparator());
				line.append(outputFormat.format(low, this.precision));
				line.append(outputFormat.getSeparator());
				line.append(outputFormat.format(close, this.precision));
				line.append(outputFormat.getSeparator());
				line.append(df.format(volume));
				line.append(outputFormat.getSeparator());
				line.append(outputFormat.format(adjClose, this.precision));
				tw.println(line.toString());
			}
			tw.close();
		} catch (final IOException ex) {
			throw new LoaderError(ex);
		}
	}

}