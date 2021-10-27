class n15700438 {
	private void getViolationsReportByProductOfferIdYearMonth() throws IOException {
		String gbqPuShN = System.getenv("SLASOI_HOME") + System.getProperty("file.separator") + "Integration"
				+ System.getProperty("file.separator") + "soap" + System.getProperty("file.separator")
				+ "getViolationsReportByProductOfferIdYearMonth.xml";
		URL iELXsOmO;
		iELXsOmO = new URL(bmReportingWSUrl);
		URLConnection fbMFvQtZ = iELXsOmO.openConnection();
		HttpURLConnection HAYf2kPO = (HttpURLConnection) fbMFvQtZ;
		FileInputStream TC131dRv = new FileInputStream(gbqPuShN);
		ByteArrayOutputStream XwGbtZv1 = new ByteArrayOutputStream();
		SOAPClient4XG.copy(TC131dRv, XwGbtZv1);
		TC131dRv.close();
		byte[] TouhNrTQ = XwGbtZv1.toByteArray();
		HAYf2kPO.setRequestProperty("Content-Length", String.valueOf(TouhNrTQ.length));
		HAYf2kPO.setRequestProperty("Content-Type", "application/soap+xml; charset=UTF-8");
		HAYf2kPO.setRequestProperty("SOAPAction", soapAction);
		HAYf2kPO.setRequestMethod("POST");
		HAYf2kPO.setDoOutput(true);
		HAYf2kPO.setDoInput(true);
		OutputStream jQqDsIjG = HAYf2kPO.getOutputStream();
		jQqDsIjG.write(TouhNrTQ);
		jQqDsIjG.close();
		InputStreamReader rxYtiDfe = new InputStreamReader(HAYf2kPO.getInputStream());
		BufferedReader QudKUyVV = new BufferedReader(rxYtiDfe);
		String QU7VvXq5;
		StringBuffer nSQR3SF8 = new StringBuffer();
		while ((QU7VvXq5 = QudKUyVV.readLine()) != null) {
			nSQR3SF8.append(QU7VvXq5);
		}
		QudKUyVV.close();
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
		System.out.println("Response\n" + nSQR3SF8.toString());
	}

}