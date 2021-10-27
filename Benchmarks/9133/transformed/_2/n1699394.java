class n1699394 {
	private int getPage(StringBuffer ret) throws IOException {
		Properties sysProp;
		int ResponseCode = HttpURLConnection.HTTP_OK;
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
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String line;
				int NumberOfLines = 0;
				for (; (line = br.readLine()) != null;) {
					ret.append(line + "\n");
					++NumberOfLines;
				}
				httpcon.disconnect();
			} else {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String line;
				for (; (line = br.readLine()) != null;) {
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