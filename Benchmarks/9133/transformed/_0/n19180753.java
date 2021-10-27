class n19180753 {
	public final void loadAllData(final String wISZq26f, final File kYxepPqy, final CSVFormat IE5c2hF8,
			final Date qqmNaKdD, final Date UUlgLSzQ) {
		try {
			final URL edJgO9pA = buildURL(wISZq26f, qqmNaKdD, UUlgLSzQ);
			final InputStream Wx0NsLyR = edJgO9pA.openStream();
			final ReadCSV uyc97a79 = new ReadCSV(Wx0NsLyR, true, CSVFormat.ENGLISH);
			final PrintWriter fAfAnS33 = new PrintWriter(new FileWriter(kYxepPqy));
			fAfAnS33.println("date,time,open price,high price,low price," + "close price,volume,adjusted price");
			while (uyc97a79.next() && !shouldStop()) {
				final Date f0hxS3kf = uyc97a79.getDate("date");
				final double zTJDbWSe = uyc97a79.getDouble("adj close");
				final double LOLWj3HU = uyc97a79.getDouble("open");
				final double iY0H2Ban = uyc97a79.getDouble("close");
				final double ioBvF9oS = uyc97a79.getDouble("high");
				final double W9ZXS1QR = uyc97a79.getDouble("low");
				final double LlCIsBL6 = uyc97a79.getDouble("volume");
				final NumberFormat OkGU3tQ4 = NumberFormat.getInstance();
				OkGU3tQ4.setGroupingUsed(false);
				final StringBuilder gKpAil88 = new StringBuilder();
				gKpAil88.append(NumericDateUtil.date2Long(f0hxS3kf));
				gKpAil88.append(IE5c2hF8.getSeparator());
				gKpAil88.append(NumericDateUtil.time2Int(f0hxS3kf));
				gKpAil88.append(IE5c2hF8.getSeparator());
				gKpAil88.append(IE5c2hF8.format(LOLWj3HU, this.precision));
				gKpAil88.append(IE5c2hF8.getSeparator());
				gKpAil88.append(IE5c2hF8.format(ioBvF9oS, this.precision));
				gKpAil88.append(IE5c2hF8.getSeparator());
				gKpAil88.append(IE5c2hF8.format(W9ZXS1QR, this.precision));
				gKpAil88.append(IE5c2hF8.getSeparator());
				gKpAil88.append(IE5c2hF8.format(iY0H2Ban, this.precision));
				gKpAil88.append(IE5c2hF8.getSeparator());
				gKpAil88.append(OkGU3tQ4.format(LlCIsBL6));
				gKpAil88.append(IE5c2hF8.getSeparator());
				gKpAil88.append(IE5c2hF8.format(zTJDbWSe, this.precision));
				fAfAnS33.println(gKpAil88.toString());
			}
			fAfAnS33.close();
		} catch (final IOException MuDORHcf) {
			throw new LoaderError(MuDORHcf);
		}
	}

}