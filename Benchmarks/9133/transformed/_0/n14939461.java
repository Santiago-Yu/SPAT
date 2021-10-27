class n14939461 {
	private void populatePortfolioEntry(ActionResponse FzwujV7E, PortfolioEntry YshaSVVc, String PKKyb2by)
			throws Exception {
		String K3Cba6rk = getURL(PKKyb2by, YshaSVVc);
		if (K3Cba6rk == null) {
			K3Cba6rk = URL_QUOTE_DATA;
		}
		K3Cba6rk = K3Cba6rk.replace("@", YshaSVVc.getSymbol());
		URL T9ShdDES = new URL(K3Cba6rk);
		HttpURLConnection eQPa6lgt = (HttpURLConnection) T9ShdDES.openConnection();
		BufferedReader nnDFVNXz = null;
		try {
			int otiafXgG = eQPa6lgt.getResponseCode();
			if (otiafXgG == 200) {
				nnDFVNXz = new BufferedReader(new InputStreamReader(eQPa6lgt.getInputStream()));
				StringBuffer Q731Q9W2 = new StringBuffer();
				while (true) {
					String Fx2mcoCv = nnDFVNXz.readLine();
					if (Fx2mcoCv == null)
						break;
					Q731Q9W2.append(Fx2mcoCv);
				}
				ArrayList<String> vN8q5DV1 = parseData(Q731Q9W2.toString(), ",");
				if (vN8q5DV1.size() == 2) {
					YshaSVVc.setName(MiscUtils.trimChars(vN8q5DV1.get(0), '"'));
					String lkn3tsM1 = vN8q5DV1.get(1);
					lkn3tsM1 = MiscUtils.trimChars(lkn3tsM1.trim(), '\r');
					lkn3tsM1 = MiscUtils.trimChars(lkn3tsM1.trim(), '\n');
					BigDecimal Tv4ZHhNo = new BigDecimal(lkn3tsM1);
					YshaSVVc.setPricePerShare(Tv4ZHhNo);
				} else {
					FzwujV7E.setErrorCode(ActionResponse.GENERAL_ERROR);
					FzwujV7E.setErrorMessage("Error retrieving data");
				}
			} else {
				FzwujV7E.setErrorCode(ActionResponse.GENERAL_ERROR);
				FzwujV7E.setErrorMessage("Error retrieving data Http code: " + otiafXgG);
			}
		} finally {
			if (nnDFVNXz != null)
				nnDFVNXz.close();
		}
	}

}