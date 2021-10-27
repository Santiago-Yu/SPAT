class n15700439 {
	private void getViolationsReportByProductOfferIdYearMonthDay() throws IOException {
		String U2ETfsbJ = System.getenv("SLASOI_HOME") + System.getProperty("file.separator") + "Integration"
				+ System.getProperty("file.separator") + "soap" + System.getProperty("file.separator")
				+ "getViolationsReportByProductOfferIdYearMonthDay.xml";
		URL oQrbgp8U;
		oQrbgp8U = new URL(bmReportingWSUrl);
		URLConnection geFz9C4t = oQrbgp8U.openConnection();
		HttpURLConnection LsV05ghg = (HttpURLConnection) geFz9C4t;
		FileInputStream rpYSiDhH = new FileInputStream(U2ETfsbJ);
		ByteArrayOutputStream BcZyVe1F = new ByteArrayOutputStream();
		SOAPClient4XG.copy(rpYSiDhH, BcZyVe1F);
		rpYSiDhH.close();
		byte[] XBTnP5ku = BcZyVe1F.toByteArray();
		LsV05ghg.setRequestProperty("Content-Length", String.valueOf(XBTnP5ku.length));
		LsV05ghg.setRequestProperty("Content-Type", "application/soap+xml; charset=UTF-8");
		LsV05ghg.setRequestProperty("SOAPAction", soapAction);
		LsV05ghg.setRequestMethod("POST");
		LsV05ghg.setDoOutput(true);
		LsV05ghg.setDoInput(true);
		OutputStream XqlMUJRB = LsV05ghg.getOutputStream();
		XqlMUJRB.write(XBTnP5ku);
		XqlMUJRB.close();
		InputStreamReader lYBBqWbB = new InputStreamReader(LsV05ghg.getInputStream());
		BufferedReader QLTjT1AB = new BufferedReader(lYBBqWbB);
		String jmy0LCiI;
		StringBuffer fFWZvRV8 = new StringBuffer();
		while ((jmy0LCiI = QLTjT1AB.readLine()) != null) {
			fFWZvRV8.append(jmy0LCiI);
		}
		QLTjT1AB.close();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + "####################################################"
				+ "#################################################\n"
				+ "####################################################"
				+ "#################################################\n" + "Component Name: Business Manager\n"
				+ "Interface Name: getReport\n" + "Operation Name: "
				+ "getViolationsReportByProductOfferIdYearMonthDay\n" + "Input" + "ProductOfferID-1\n" + "PartyID-1\n"
				+ "\n" + "####################################################"
				+ "#################################################\n"
				+ "####################################################"
				+ "#################################################\n"
				+ "######################################## RESPONSE"
				+ "############################################\n\n");
		System.out.println("--------------------------------");
		System.out.println("Response\n" + fFWZvRV8.toString());
	}

}