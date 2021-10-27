class n6374427 {
	public String getTags(URL url) {
		OutputStreamWriter osw = null;
		StringBuffer xml = new StringBuffer();
		BufferedReader br = null;
		try {
			String reqData = URLEncoder.encode(paramName, "UTF-8") + "=" + URLEncoder.encode(url.toString(), "UTF-8");
			URL service = new URL(cmdUrl);
			URLConnection urlConn = service.openConnection();
			urlConn.setDoOutput(true);
			urlConn.connect();
			osw = new OutputStreamWriter(urlConn.getOutputStream());
			osw.write(reqData);
			osw.flush();
			String line = null;
			br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			while ((line = br.readLine()) != null) {
				xml.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (osw != null) {
					osw.close();
				}
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return xml.toString();
	}

}