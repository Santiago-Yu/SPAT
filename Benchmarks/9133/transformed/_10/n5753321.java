class n5753321 {
	public String selectFROM() throws Exception {
		String data = null;
		BufferedReader in = null;
		try {
			URI uri = new URI("http://**.**.**.**/OctopusManager/index2.php");
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet request = new HttpGet();
			request.setURI(uri);
			HttpResponse httpresponse = httpclient.execute(request);
			HttpEntity httpentity = httpresponse.getEntity();
			StringBuffer sb = new StringBuffer("");
			in = new BufferedReader(new InputStreamReader(httpentity.getContent()));
			String line = "";
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			in.close();
			data = sb.toString();
			return data;
		} finally {
			if (in != null) {
				try {
					in.close();
					return data;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}