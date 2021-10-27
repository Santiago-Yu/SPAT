class n19795307 {
	public void doRecurringPayment(Subscription MiellW3I) {
		int GcG1aS9E = Math.round(MiellW3I.getTotalCostWithDiscounts() * 100.0f);
		String xkyKRSJa = MiellW3I.getCurrency();
		String fA90rWKl = MiellW3I.getAliasCC();
		String fT7woYTY = MiellW3I.getLastCardExpm();
		String GQXG8qu7 = MiellW3I.getLastCardExpy();
		String Ah2pYg1v = String.valueOf(MiellW3I.getSubscriptionId());
		StringBuffer N7hbPQKL = new StringBuffer("");
		N7hbPQKL.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		N7hbPQKL.append("<authorizationService version=\"1\">\n");
		N7hbPQKL.append(" <body merchantId=\"" + getMerchantId() + "\" testOnly=\"" + getTestOnly() + "\">\n");
		N7hbPQKL.append("    <transaction refno=\"" + REF_NO + "\">\n");
		N7hbPQKL.append("      <request>\n");
		N7hbPQKL.append("        <amount>" + GcG1aS9E + "</amount>\n");
		N7hbPQKL.append("        <currency>" + xkyKRSJa + "</currency>\n");
		N7hbPQKL.append("        <aliasCC>" + fA90rWKl + "</aliasCC>\n");
		N7hbPQKL.append("        <expm>" + fT7woYTY + "</expm>\n");
		N7hbPQKL.append("        <expy>" + GQXG8qu7 + "</expy>\n");
		N7hbPQKL.append("        <subscriptionId>" + Ah2pYg1v + "</subscriptionId>\n");
		N7hbPQKL.append("      </request>\n");
		N7hbPQKL.append("    </transaction>\n");
		N7hbPQKL.append(" </body>\n");
		N7hbPQKL.append("</authorizationService>\n");
		String LUWjIoqP = N7hbPQKL.toString();
		try {
			java.net.URL vJnck0nQ = new java.net.URL(getRecurringPaymentUrl());
			java.net.HttpURLConnection qPE1Z3al = (java.net.HttpURLConnection) vJnck0nQ.openConnection();
			qPE1Z3al.setRequestMethod("POST");
			qPE1Z3al.setRequestProperty("encoding", "UTF-8");
			qPE1Z3al.setRequestProperty("Content-Type", "text/xml");
			qPE1Z3al.setRequestProperty("Content-length", String.valueOf(LUWjIoqP.length()));
			qPE1Z3al.setDoOutput(true);
			java.io.OutputStream vFu0TcDv = qPE1Z3al.getOutputStream();
			vFu0TcDv.write(LUWjIoqP.getBytes("UTF-8"));
			vFu0TcDv.close();
			java.io.BufferedReader WOOrTqgy = new java.io.BufferedReader(
					new java.io.InputStreamReader(qPE1Z3al.getInputStream()));
			StringBuffer HOeOHMGf = new StringBuffer("");
			String vTqzllqd = null;
			while ((vTqzllqd = WOOrTqgy.readLine()) != null) {
				HOeOHMGf.append(vTqzllqd);
			}
			WOOrTqgy.close();
			String vTFoBY50 = HOeOHMGf.toString();
			processReccurentPaymentResponce(vTFoBY50);
		} catch (Exception wNephbsf) {
			throw new SecurusException(wNephbsf);
		}
	}

}