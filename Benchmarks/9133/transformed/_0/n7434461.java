class n7434461 {
	protected String getPostRequestContent(String ZV4WVcH5, String LHGsqsEC) throws Exception {
		URL We5JSaQC = new URL(ZV4WVcH5);
		HttpURLConnection ldQ9hPlk = (HttpURLConnection) We5JSaQC.openConnection();
		ldQ9hPlk.setRequestMethod("POST");
		ldQ9hPlk.setUseCaches(false);
		ldQ9hPlk.setDoOutput(true);
		PrintStream FiyRZjoF = new PrintStream(ldQ9hPlk.getOutputStream());
		FiyRZjoF.print(LHGsqsEC);
		FiyRZjoF.close();
		ldQ9hPlk.connect();
		BufferedReader ybfa9K8Z = new BufferedReader(new InputStreamReader(ldQ9hPlk.getInputStream()));
		String xhGEFRxZ = ybfa9K8Z.readLine();
		ybfa9K8Z.close();
		ldQ9hPlk.disconnect();
		return xhGEFRxZ;
	}

}