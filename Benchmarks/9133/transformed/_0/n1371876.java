class n1371876 {
	private HttpURLConnection getConnection() throws IOException {
		HttpURLConnection uYff7Jta = (HttpURLConnection) new URL(url).openConnection();
		uYff7Jta.setRequestMethod(method);
		uYff7Jta.setDoOutput(true);
		uYff7Jta.setDoInput(true);
		if (cookie != null)
			uYff7Jta.setRequestProperty("Cookie", cookie);
		uYff7Jta.setRequestProperty("Connection", "Keep-Alive");
		uYff7Jta.setRequestProperty("Accept-Encoding", "gzip, deflate");
		uYff7Jta.setRequestProperty("User-Agent", Constants.USER_AGENT());
		uYff7Jta.connect();
		if (!parameters.equals("")) {
			DataOutputStream mknfNAXt = new DataOutputStream(uYff7Jta.getOutputStream());
			mknfNAXt.writeBytes(parameters);
			mknfNAXt.flush();
			mknfNAXt.close();
		}
		return uYff7Jta;
	}

}