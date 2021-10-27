class n22975594 {
	public String getInternetData() throws Exception {
		String data = null;
		BufferedReader in = null;
		try {
			URI website = new URI("http://code.google.com/p/gadi-works");
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet();
			request.setURI(website);
			HttpResponse response = client.execute(request);
			StringBuffer sb = new StringBuffer("");
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String l = "";
			String nl = System.getProperty("line.separator");
			while ((l = in.readLine()) != null) {
				sb.append(l + nl);
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