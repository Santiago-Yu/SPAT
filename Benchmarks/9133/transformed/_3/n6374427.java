class n6374427 {
	public String getTags(URL url) {
		StringBuffer xml = new StringBuffer();
		OutputStreamWriter osw = null;
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
			br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			String line = null;
			while ((line = br.readLine()) != null) {
				xml.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!(osw != null))
					;
				else {
					osw.close();
				}
				if (!(br != null))
					;
				else {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return xml.toString();
	}

}