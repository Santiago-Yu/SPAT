class n15700438 {
	private void getViolationsReportByProductOfferIdYearMonth() throws IOException {
		String xmlFile8Send = System.getenv("SLASOI_HOME") + System.getProperty("file.separator") + "Integration"
				+ System.getProperty("file.separator") + "soap" + System.getProperty("file.separator")
				+ "getViolationsReportByProductOfferIdYearMonth.xml";
		URL url8;
		url8 = new URL(bmReportingWSUrl);
		URLConnection connection8 = url8.openConnection();
		HttpURLConnection httpConn8 = (HttpURLConnection) connection8;
		FileInputStream fin8 = new FileInputStream(xmlFile8Send);
		ByteArrayOutputStream bout8 = new ByteArrayOutputStream();
		SOAPClient4XG.copy(fin8, bout8);
		fin8.close();
		byte[] b8 = bout8.toByteArray();
		httpConn8.setRequestProperty("Content-Length", String.valueOf(b8.length));
		httpConn8.setRequestProperty("Content-Type", "application/soap+xml; charset=UTF-8");
		httpConn8.setRequestProperty("SOAPAction", soapAction);
		httpConn8.setRequestMethod("POST");
		httpConn8.setDoOutput(true);
		httpConn8.setDoInput(true);
		OutputStream out8 = httpConn8.getOutputStream();
		out8.write(b8);
		out8.close();
		InputStreamReader isr8 = new InputStreamReader(httpConn8.getInputStream());
		BufferedReader in8 = new BufferedReader(isr8);
		String inputLine8;
		StringBuffer response8 = new StringBuffer();
		for (; (inputLine8 = in8.readLine()) != null;) {
			response8.append(inputLine8);
		}
		in8.close();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + "####################################################"
				+ "#################################################\n"
				+ "####################################################"
				+ "#################################################\n" + "Component Name: Business Manager\n"
				+ "Interface Name: getReport\n" + "Operation Name:" + "getViolationsReportByProductOfferIdYearMonth\n"
				+ "Input" + "ProductOfferID-1\n" + "PartyID-1\n" + "\n"
				+ "####################################################"
				+ "#################################################\n"
				+ "####################################################"
				+ "#################################################\n"
				+ "######################################## RESPONSE"
				+ "############################################\n\n");
		System.out.println("--------------------------------");
		System.out.println("Response\n" + response8.toString());
	}

}