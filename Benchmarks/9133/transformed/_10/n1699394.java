class n1699394 {
	private int getPage(StringBuffer ret) throws IOException {
		int ResponseCode = HttpURLConnection.HTTP_OK;
		Properties sysProp;
		BufferedReader br = null;
		try {
			URLConnection con = url.openConnection();
			con.setDefaultUseCaches(false);
			con.setDoInput(true);
			con.setDoOutput(false);
			if (con instanceof HttpURLConnection) {
				HttpURLConnection httpcon = (HttpURLConnection) con;
				ResponseCode = httpcon.getResponseCode();
				if (ResponseCode != httpcon.HTTP_OK) {
					httpcon.disconnect();
					return (ResponseCode);
				}
				String line;
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				int NumberOfLines = 0;
				while ((line = br.readLine()) != null) {
					ret.append(line + "\n");
					++NumberOfLines;
				}
				httpcon.disconnect();
			} else {
				String line;
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				while ((line = br.readLine()) != null) {
					ret.append(line + "\n");
				}
			}
		} catch (IOException e) {
		} finally {
			if (br != null)
				br.close();
		}
		return ResponseCode;
	}

}