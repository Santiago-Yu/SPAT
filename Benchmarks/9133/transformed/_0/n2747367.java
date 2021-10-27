class n2747367 {
	private Document getOpenLinkResponse(String J3pKWDQb) throws IOException, UnvalidResponseException {
		URL v4gwkDnr = new URL(WS_URI);
		URLConnection XY5m3Dmd = v4gwkDnr.openConnection();
		logger.debug(".conn open");
		XY5m3Dmd.setDoOutput(true);
		XY5m3Dmd.setRequestProperty("Content-Type", "text/xml");
		OutputStreamWriter KMSmbdD9 = new OutputStreamWriter(XY5m3Dmd.getOutputStream());
		KMSmbdD9.write(J3pKWDQb);
		KMSmbdD9.flush();
		BufferedReader LWT2V5CL = new BufferedReader(new InputStreamReader(XY5m3Dmd.getInputStream()));
		logger.debug(".resp obtained");
		StringBuffer eLYEwlJM = new StringBuffer();
		String KdValldz;
		while ((KdValldz = LWT2V5CL.readLine()) != null) {
			eLYEwlJM.append(KdValldz);
			eLYEwlJM.append(NEWLINE);
		}
		KMSmbdD9.close();
		LWT2V5CL.close();
		logger.debug(".done");
		try {
			return documentParser.parse(eLYEwlJM.toString());
		} catch (SAXException NEEK1W1x) {
			throw new UnvalidResponseException("Response is not a valid XML file", NEEK1W1x);
		}
	}

}