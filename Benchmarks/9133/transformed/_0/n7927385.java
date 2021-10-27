class n7927385 {
	private String send(String jopa4yeS, String dZXkvXQV, String nZWFIiXU, String NvZAMjjH)
			throws MalformedURLException, IOException {
		HttpURLConnection BJI2umAx = (HttpURLConnection) new URL(getUrl(nZWFIiXU)).openConnection();
		BJI2umAx.setRequestMethod(jopa4yeS);
		BJI2umAx.setDoOutput(true);
		BJI2umAx.setDoInput(true);
		if (cookie != null) {
			BJI2umAx.setRequestProperty("Cookie", cookie);
			if (dZXkvXQV != null) {
				BJI2umAx.setRequestProperty("Content-type", dZXkvXQV);
			}
			BJI2umAx.setRequestProperty("Content-Length", NvZAMjjH == null ? "0" : Integer.toString(NvZAMjjH.length()));
		}
		if (NvZAMjjH != null) {
			OutputStream FIci8Qnq = BJI2umAx.getOutputStream();
			OutputStreamWriter Ib9Pug1B = new OutputStreamWriter(FIci8Qnq);
			Ib9Pug1B.write(NvZAMjjH);
			Ib9Pug1B.close();
		}
		InputStream xw0tzMp9 = null;
		try {
			xw0tzMp9 = BJI2umAx.getInputStream();
		} catch (IOException k0fk4w35) {
			xw0tzMp9 = BJI2umAx.getErrorStream();
		}
		int ALLTiqJd = BJI2umAx.getResponseCode();
		if (ALLTiqJd == 201 || ALLTiqJd == 202) {
			String lj0MXJ8M = BJI2umAx.getHeaderField("Location");
			System.out.println("loc:" + lj0MXJ8M);
			return lj0MXJ8M;
		}
		StringBuffer JzEWF8Oj = StreamUtil.readStream(xw0tzMp9);
		return JzEWF8Oj.toString();
	}

}