class n2767689 {
	@Override
	public void loadData() {
		try {
			String yzbyE30d = "http://ichart.finance.yahoo.com/table.csv?s=" + symbol
					+ "&a=00&b=2&c=1962&d=11&e=11&f=2099&g=d&ignore=.csv";
			URLConnection ZcVlm1C2 = (new URL(yzbyE30d)).openConnection();
			ZcVlm1C2.connect();
			BufferedReader DCE9VAiF = new BufferedReader(new InputStreamReader(ZcVlm1C2.getInputStream()));
			DCE9VAiF.readLine();
			String NoUnb7s2 = "";
			while ((NoUnb7s2 = DCE9VAiF.readLine()) != null) {
				final String[] iPFOX9qO = NoUnb7s2.split(",");
				final String mwYzZ5HT = iPFOX9qO[0];
				final double ZzFlxYML = Double.parseDouble(iPFOX9qO[1]);
				final double CltaV4OX = Double.parseDouble(iPFOX9qO[2]);
				final double RjblsNOY = Double.parseDouble(iPFOX9qO[3]);
				final double JlwZohn5 = Double.parseDouble(iPFOX9qO[4]);
				final int mELOMeeq = Integer.parseInt(iPFOX9qO[5]);
				final double LBWEWFha = Double.parseDouble(iPFOX9qO[6]);
				final HistoricalPrice wLQnTaF9 = new HistoricalPrice(mwYzZ5HT, ZzFlxYML, CltaV4OX, RjblsNOY, JlwZohn5,
						mELOMeeq, LBWEWFha);
				historicalPrices.add(wLQnTaF9);
			}
			DCE9VAiF.close();
			yzbyE30d = "http://ichart.finance.yahoo.com/table.csv?s=" + symbol
					+ "&a=00&b=2&c=1962&d=11&e=17&f=2008&g=v&ignore=.csv";
			ZcVlm1C2 = (new URL(yzbyE30d)).openConnection();
			ZcVlm1C2.connect();
			DCE9VAiF = new BufferedReader(new InputStreamReader(ZcVlm1C2.getInputStream()));
			DCE9VAiF.readLine();
			NoUnb7s2 = "";
			while ((NoUnb7s2 = DCE9VAiF.readLine()) != null) {
				final String[] DgsSfm9q = NoUnb7s2.split(",");
				final String GozNMlfy = DgsSfm9q[0];
				final double Fi3AEvQp = Double.parseDouble(DgsSfm9q[1]);
				final Dividend jPSVaDm7 = new Dividend(GozNMlfy, Fi3AEvQp);
				dividends.add(jPSVaDm7);
			}
			DCE9VAiF.close();
		} catch (final IOException U07yFH19) {
			logger.error("Error parsing historical prices for " + getSymbol(), U07yFH19);
		}
	}

}