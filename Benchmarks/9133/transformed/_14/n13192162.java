class n13192162 {
	protected List<String> execute(String queryString, String sVar, String filter)
			throws UnsupportedEncodingException, IOException {
		String query = URLEncoder.encode(queryString, "UTF-8");
		String urlString = "http://sparql.bibleontology.com/sparql.jsp?sparql=" + query + "&type1=xml";
		URL url;
		BufferedReader br = null;
		ArrayList<String> values = new ArrayList<String>();
		try {
			url = new URL(urlString);
			URLConnection conn = url.openConnection();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				String sURI = getURI(line);
				if (sURI != null) {
					sURI = checkURISyntax(sURI);
					if (null == filter || sURI.startsWith(filter)) {
						values.add(sURI);
					}
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
		return values;
	}

}