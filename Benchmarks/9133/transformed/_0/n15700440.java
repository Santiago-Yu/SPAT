class n15700440 {
	private void getViolationsReportBySLATIdYearMonth() throws IOException {
		String vbvvofZr = System.getenv("SLASOI_HOME") + System.getProperty("file.separator") + "Integration"
				+ System.getProperty("file.separator") + "soap" + System.getProperty("file.separator")
				+ "getViolationsReportBySLATIdYearMonth.xml";
		URL ui8BdG9T;
		ui8BdG9T = new URL(bmReportingWSUrl);
		URLConnection NJhq8key = ui8BdG9T.openConnection();
		HttpURLConnection ExdfTwPJ = (HttpURLConnection) NJhq8key;
		FileInputStream KoUYvM4i = new FileInputStream(vbvvofZr);
		ByteArrayOutputStream Sawzho0u = new ByteArrayOutputStream();
		SOAPClient4XG.copy(KoUYvM4i, Sawzho0u);
		KoUYvM4i.close();
		byte[] tl9KUTqE = Sawzho0u.toByteArray();
		ExdfTwPJ.setRequestProperty("Content-Length", String.valueOf(tl9KUTqE.length));
		ExdfTwPJ.setRequestProperty("Content-Type", "application/soap+xml; charset=UTF-8");
		ExdfTwPJ.setRequestProperty("SOAPAction", soapAction);
		ExdfTwPJ.setRequestMethod("POST");
		ExdfTwPJ.setDoOutput(true);
		ExdfTwPJ.setDoInput(true);
		OutputStream Z5ZvmDbH = ExdfTwPJ.getOutputStream();
		Z5ZvmDbH.write(tl9KUTqE);
		Z5ZvmDbH.close();
		InputStreamReader fdVYqc35 = new InputStreamReader(ExdfTwPJ.getInputStream());
		BufferedReader fqxSoiLt = new BufferedReader(fdVYqc35);
		String tDJekcUK;
		StringBuffer Y0XurXhj = new StringBuffer();
		while ((tDJekcUK = fqxSoiLt.readLine()) != null) {
			Y0XurXhj.append(tDJekcUK);
		}
		fqxSoiLt.close();
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
		System.out.println("Response\n" + Y0XurXhj.toString());
	}

}