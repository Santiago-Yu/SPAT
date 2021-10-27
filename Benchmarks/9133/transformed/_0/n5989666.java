class n5989666 {
	private String postXml(String Pgt377Yb, String vJ71CSYr, String VXdIqkE1) {
		try {
			URLConnection r7bSCWVQ = new URL(Pgt377Yb).openConnection();
			if (r7bSCWVQ instanceof HttpURLConnection) {
				HttpURLConnection ZgTwfHIM = (HttpURLConnection) r7bSCWVQ;
				ZgTwfHIM.setRequestMethod("POST");
			}
			r7bSCWVQ.setConnectTimeout(this.connectionTimeout);
			r7bSCWVQ.setReadTimeout(this.connectionTimeout);
			r7bSCWVQ.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
			r7bSCWVQ.setRequestProperty("Accept", "application/soap+xml, text/*");
			if (vJ71CSYr != null) {
				r7bSCWVQ.setRequestProperty("SOAPAction", vJ71CSYr);
			}
			r7bSCWVQ.setDoOutput(true);
			OutputStreamWriter f3GJ7gYL = new OutputStreamWriter(r7bSCWVQ.getOutputStream());
			f3GJ7gYL.write(VXdIqkE1);
			f3GJ7gYL.close();
			BufferedReader yUAndalK = new BufferedReader(new InputStreamReader(r7bSCWVQ.getInputStream()));
			StringBuilder TloJpTiV = new StringBuilder();
			String KKSVcP0L;
			while ((KKSVcP0L = yUAndalK.readLine()) != null) {
				TloJpTiV.append(KKSVcP0L);
			}
			return TloJpTiV.toString();
		} catch (IOException S6ye0pe6) {
			throw new RuntimeException(S6ye0pe6);
		}
	}

}