class n23120511 {
	private static final String getResult(String rtd27Vfm, String lWdXFDq0) throws MalformedURLException, IOException {
		HttpURLConnection ZlApie8p = (HttpURLConnection) new URL(rtd27Vfm).openConnection();
		if (!lWdXFDq0.equals("null")) {
			lWdXFDq0 = lWdXFDq0.substring(1, lWdXFDq0.length() - 1);
			ZlApie8p.setDoOutput(true);
			BufferedWriter eS0Fnkvl = new BufferedWriter(new OutputStreamWriter(ZlApie8p.getOutputStream()));
			eS0Fnkvl.write(lWdXFDq0);
			eS0Fnkvl.flush();
		}
		InputStreamReader vHy9I2r9 = new InputStreamReader(ZlApie8p.getInputStream());
		int E8XerMd3;
		StringBuffer Qfbtbts1 = new StringBuffer();
		while ((E8XerMd3 = vHy9I2r9.read()) != -1) {
			Qfbtbts1.append((char) E8XerMd3);
		}
		vHy9I2r9.close();
		String rJXMIxtF = Qfbtbts1.toString().trim();
		rJXMIxtF = StringUtilities.replaceAll(rJXMIxtF, "\r\n", "\\r\\n");
		rJXMIxtF = StringUtilities.replaceAll(rJXMIxtF, "\"", "\\\"");
		return "\"" + rJXMIxtF + "\"";
	}

}