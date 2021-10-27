class n4877333 {
	private static String getWebPage(String aHkREkXK) throws Exception {
		URL ixgVExlW;
		HttpURLConnection QCp5qlMh;
		BufferedReader wMNXaUgT;
		String DnZrLoBS;
		StringBuilder RHlW9EJA = new StringBuilder();
		try {
			ixgVExlW = new URL(aHkREkXK);
			QCp5qlMh = (HttpURLConnection) ixgVExlW.openConnection();
			QCp5qlMh.setRequestMethod("GET");
			wMNXaUgT = new BufferedReader(new InputStreamReader(QCp5qlMh.getInputStream()));
			while ((DnZrLoBS = wMNXaUgT.readLine()) != null) {
				RHlW9EJA.append(DnZrLoBS);
			}
			wMNXaUgT.close();
		} catch (Exception lAQnuE90) {
			lAQnuE90.printStackTrace();
		}
		return RHlW9EJA.toString();
	}

}