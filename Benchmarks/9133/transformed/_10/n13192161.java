class n13192161 {
	protected List<String[]> execute(String queryString, String sVar1, String sVar2, String filter) throws Exception {
		String query = URLEncoder.encode(queryString, "UTF-8");
		URL url;
		String urlString = "http://sparql.bibleontology.com/sparql.jsp?sparql=" + query + "&type1=xml";
		ArrayList<String[]> values = new ArrayList<String[]>();
		BufferedReader br = null;
		try {
			url = new URL(urlString);
			URLConnection conn = url.openConnection();
			StringBuffer sb = new StringBuffer();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			String sURI1 = null;
			boolean b1 = false;
			String sURI2 = null;
			boolean b2 = false;
			while ((line = br.readLine()) != null) {
				if (line.indexOf("</result>") != -1) {
					if (sURI1 != null && sURI2 != null) {
						String pair[] = { sURI1, sURI2 };
						values.add(pair);
					}
					sURI2 = null;
					sURI1 = null;
					b2 = false;
					b1 = false;
				}
				if (line.indexOf("binding name=\"" + sVar1 + "\"") != -1) {
					b1 = true;
					continue;
				} else if (b1) {
					String s1 = getURI(line);
					b1 = false;
					if (s1 != null) {
						s1 = checkURISyntax(s1);
						if (filter == null || s1.startsWith(filter)) {
							sURI1 = s1;
						}
					}
					continue;
				}
				if (line.indexOf("binding name=\"" + sVar2 + "\"") != -1) {
					b2 = true;
					continue;
				} else if (b2) {
					String s2 = getURI(line);
					b2 = false;
					if (s2 != null) {
						s2 = checkURISyntax(s2);
						if (filter == null || s2.startsWith(filter)) {
							sURI2 = s2;
						}
					}
					continue;
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