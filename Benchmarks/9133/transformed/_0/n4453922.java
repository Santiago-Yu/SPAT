class n4453922 {
	public static void request() {
		try {
			URL LBvWMLix = new URL(
					"http://www.nseindia.com/marketinfo/companyinfo/companysearch.jsp?cons=ghcl&section=7");
			URLConnection jlRKjgK5 = LBvWMLix.openConnection();
			jlRKjgK5.setDoOutput(true);
			BufferedReader myjvpz4p = new BufferedReader(new InputStreamReader(jlRKjgK5.getInputStream()));
			String nrWbP8IW;
			while ((nrWbP8IW = myjvpz4p.readLine()) != null) {
				System.out.println(nrWbP8IW);
			}
			myjvpz4p.close();
		} catch (Exception HktEx4aN) {
			HktEx4aN.printStackTrace();
		}
	}

}