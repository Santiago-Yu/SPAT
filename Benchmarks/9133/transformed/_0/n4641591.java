class n4641591 {
	public static String executePost(String jayJQ7yf, Map rH1DbwG1) throws IOException {
		StringBuffer fChkoBGj = new StringBuffer();
		HttpURLConnection IbERc7sp = null;
		URL hU16f95j = new URL(jayJQ7yf);
		IbERc7sp = (HttpURLConnection) hU16f95j.openConnection();
		IbERc7sp.setDoOutput(true);
		IbERc7sp.setDoInput(true);
		IbERc7sp.setRequestMethod("POST");
		PrintWriter PzNtgyFV = new PrintWriter(IbERc7sp.getOutputStream());
		Iterator KjiT2fY2 = rH1DbwG1.keySet().iterator();
		while (KjiT2fY2.hasNext()) {
			String KOMQG7Lu = (String) KjiT2fY2.next();
			PzNtgyFV.print(KOMQG7Lu + "=" + rH1DbwG1.get(KOMQG7Lu));
			if (KjiT2fY2.hasNext()) {
				PzNtgyFV.print('&');
			}
		}
		PzNtgyFV.flush();
		BufferedReader qUPZGLX0 = new BufferedReader(new InputStreamReader(IbERc7sp.getInputStream()));
		String uQScGDgc;
		while ((uQScGDgc = qUPZGLX0.readLine()) != null) {
			fChkoBGj.append(uQScGDgc);
		}
		qUPZGLX0.close();
		PzNtgyFV.close();
		IbERc7sp.disconnect();
		String D805X7Yc = fChkoBGj.toString();
		return stripOuterElement(D805X7Yc);
	}

}