class n15700440 {
	private void getViolationsReportBySLATIdYearMonth() throws IOException {
		String xmlFile10Send = System.getenv("SLASOI_HOME") + System.getProperty("file.separator") + "Integration"
				+ System.getProperty("file.separator") + "soap" + System.getProperty("file.separator")
				+ "getViolationsReportBySLATIdYearMonth.xml";
		URL url10;
		url10 = new URL(bmReportingWSUrl);
		URLConnection connection10 = url10.openConnection();
		HttpURLConnection httpConn10 = (HttpURLConnection) connection10;
		FileInputStream fin10 = new FileInputStream(xmlFile10Send);
		ByteArrayOutputStream bout10 = new ByteArrayOutputStream();
		SOAPClient4XG.copy(fin10, bout10);
		fin10.close();
		byte[] b10 = bout10.toByteArray();
		httpConn10.setRequestProperty("Content-Length", String.valueOf(b10.length));
		httpConn10.setRequestProperty("Content-Type", "application/soap+xml; charset=UTF-8");
		httpConn10.setRequestProperty("SOAPAction", soapAction);
		httpConn10.setRequestMethod("POST");
		httpConn10.setDoOutput(true);
		httpConn10.setDoInput(true);
		OutputStream out10 = httpConn10.getOutputStream();
		out10.write(b10);
		out10.close();
		InputStreamReader isr10 = new InputStreamReader(httpConn10.getInputStream());
		BufferedReader in10 = new BufferedReader(isr10);
		String inputLine10;
		StringBuffer response10 = new StringBuffer();
		for (; (inputLine10 = in10.readLine()) != null;) {
			response10.append(inputLine10);
		}
		in10.close();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + "####################################################"
				+ "#################################################\n"
				+ "####################################################"
				+ "#################################################\n" + "Component Name: Business Manager\n"
				+ "Interface Name: getReport\n" + "Operation Name: getViolationsReportBySLATIdYearMonth\n" + "Input"
				+ "ProductOfferID-1\n" + "PartyID-1\n" + "\n" + "####################################################"
				+ "#################################################\n"
				+ "####################################################"
				+ "#################################################\n"
				+ "######################################## RESPONSE"
				+ "############################################\n\n");
		System.out.println("--------------------------------");
		System.out.println("Response\n" + response10.toString());
	}

}