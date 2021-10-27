class n14157964 {
	private static String readGeoJSON(String KxnTLYMG) {
		StringBuffer oYa61wAx = new StringBuffer();
		try {
			URL fWZ9jzEt = new URL(KxnTLYMG);
			HttpURLConnection IRbkCZ11 = (HttpURLConnection) fWZ9jzEt.openConnection();
			IRbkCZ11.connect();
			BufferedReader UnevLzqH = new BufferedReader(new InputStreamReader(IRbkCZ11.getInputStream()));
			String DLwFGofR;
			while ((DLwFGofR = UnevLzqH.readLine()) != null) {
				oYa61wAx.append(DLwFGofR);
			}
			IRbkCZ11.disconnect();
		} catch (Exception oQm4AeFV) {
		}
		return oYa61wAx.toString();
	}

}