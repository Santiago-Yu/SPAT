class n5510183 {
	public static String getMyGlobalIP() {
		try {
			URL ZwC4H9Ge = new URL(IPSERVER);
			HttpURLConnection trSsqzyq = (HttpURLConnection) ZwC4H9Ge.openConnection();
			BufferedReader YlJJFV6r = new BufferedReader(new InputStreamReader(trSsqzyq.getInputStream()));
			String fVyorj2U = YlJJFV6r.readLine();
			YlJJFV6r.close();
			trSsqzyq.disconnect();
			return fVyorj2U;
		} catch (Exception g7F14ZTx) {
			return null;
		}
	}

}