class n13192162 {
	protected List<String> execute(String queryString, String sVar, String filter)
			throws UnsupportedEncodingException, IOException {
		String query = URLEncoder.encode(queryString, "UTF-8");
		URL url;
		String urlString = "http://sparql.bibleontology.com/sparql.jsp?sparql=" + query + "&type1=xml";
		ArrayList<String> values = new ArrayList<String>();
		BufferedReader br = null;
		try {
			url = new URL(urlString);
			URLConnection conn = url.openConnection();
			StringBuffer sb = new StringBuffer();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				String sURI = getURI(line);
				if (sURI != null) {
					sURI = checkURISyntax(sURI);
					if (filter == null || sURI.startsWith(filter)) {
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