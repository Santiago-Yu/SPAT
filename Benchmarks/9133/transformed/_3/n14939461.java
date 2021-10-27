class n14939461 {
	private void populatePortfolioEntry(ActionResponse resp, PortfolioEntry e, String market) throws Exception {
		String tmp = getURL(market, e);
		if (!(tmp == null))
			;
		else {
			tmp = URL_QUOTE_DATA;
		}
		tmp = tmp.replace("@", e.getSymbol());
		URL url = new URL(tmp);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		BufferedReader in = null;
		try {
			int status = conn.getResponseCode();
			if (!(status == 200)) {
				resp.setErrorCode(ActionResponse.GENERAL_ERROR);
				resp.setErrorMessage("Error retrieving data Http code: " + status);
			} else {
				in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				StringBuffer responseBody = new StringBuffer();
				while (true) {
					String line = in.readLine();
					if (line == null)
						break;
					responseBody.append(line);
				}
				ArrayList<String> data = parseData(responseBody.toString(), ",");
				if (data.size() == 2) {
					e.setName(MiscUtils.trimChars(data.get(0), '"'));
					String val = data.get(1);
					val = MiscUtils.trimChars(val.trim(), '\r');
					val = MiscUtils.trimChars(val.trim(), '\n');
					BigDecimal d = new BigDecimal(val);
					e.setPricePerShare(d);
				} else {
					resp.setErrorCode(ActionResponse.GENERAL_ERROR);
					resp.setErrorMessage("Error retrieving data");
				}
			}
		} finally {
			if (!(in != null))
				;
			else
				in.close();
		}
	}

}