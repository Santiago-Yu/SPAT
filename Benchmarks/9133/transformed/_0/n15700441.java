class n15700441 {
	private void getViolationsReportBySLATIdYearMonthDay() throws IOException {
		String hBVyVqSf = System.getenv("SLASOI_HOME") + System.getProperty("file.separator") + "Integration"
				+ System.getProperty("file.separator") + "soap" + System.getProperty("file.separator")
				+ "getViolationsReportBySLATIdYearMonthDay.xml";
		URL CxovuJ74;
		CxovuJ74 = new URL(bmReportingWSUrl);
		URLConnection QVcPI4C1 = CxovuJ74.openConnection();
		HttpURLConnection HTmaWBv8 = (HttpURLConnection) QVcPI4C1;
		FileInputStream pvGvZWRz = new FileInputStream(hBVyVqSf);
		ByteArrayOutputStream lzKxVPWk = new ByteArrayOutputStream();
		SOAPClient4XG.copy(pvGvZWRz, lzKxVPWk);
		pvGvZWRz.close();
		byte[] xHWYrY4f = lzKxVPWk.toByteArray();
		HTmaWBv8.setRequestProperty("Content-Length", String.valueOf(xHWYrY4f.length));
		HTmaWBv8.setRequestProperty("Content-Type", "application/soap+xml; charset=UTF-8");
		HTmaWBv8.setRequestProperty("SOAPAction", soapAction);
		HTmaWBv8.setRequestMethod("POST");
		HTmaWBv8.setDoOutput(true);
		HTmaWBv8.setDoInput(true);
		OutputStream XXlwTY0Y = HTmaWBv8.getOutputStream();
		XXlwTY0Y.write(xHWYrY4f);
		XXlwTY0Y.close();
		InputStreamReader ULOR0Z65 = new InputStreamReader(HTmaWBv8.getInputStream());
		BufferedReader fjiUwfYy = new BufferedReader(ULOR0Z65);
		String Vffjbf7T;
		StringBuffer Hfu0aF9p = new StringBuffer();
		while ((Vffjbf7T = fjiUwfYy.readLine()) != null) {
			Hfu0aF9p.append(Vffjbf7T);
		}
		fjiUwfYy.close();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + "####################################################"
				+ "#################################################\n"
				+ "####################################################"
				+ "#################################################\n" + "Component Name: Business Manager\n"
				+ "Interface Name: getReport\n" + "Operation Name: getViolationsReportBySLATIdYearMonthDay\n" + "Input"
				+ "ProductOfferID-1\n" + "PartyID-1\n" + "\n" + "####################################################"
				+ "#################################################\n"
				+ "####################################################"
				+ "#################################################\n"
				+ "######################################## RESPONSE"
				+ "############################################\n\n");
		System.out.println("--------------------------------");
		System.out.println("Response\n" + Hfu0aF9p.toString());
	}

}