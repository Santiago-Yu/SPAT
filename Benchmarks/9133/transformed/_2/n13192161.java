class n13192161 {
	protected List<String[]> execute(String queryString, String sVar1, String sVar2, String filter) throws Exception {
		String query = URLEncoder.encode(queryString, "UTF-8");
		String urlString = "http://sparql.bibleontology.com/sparql.jsp?sparql=" + query + "&type1=xml";
		URL url;
		BufferedReader br = null;
		ArrayList<String[]> values = new ArrayList<String[]>();
		try {
			url = new URL(urlString);
			URLConnection conn = url.openConnection();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			String sURI1 = null;
			String sURI2 = null;
			boolean b1 = false;
			boolean b2 = false;
			for (; (line = br.readLine()) != null;) {
				if (line.indexOf("</result>") != -1) {
					if (sURI1 != null && sURI2 != null) {
						String pair[] = { sURI1, sURI2 };
						values.add(pair);
					}
					sURI1 = null;
					sURI2 = null;
					b1 = false;
					b2 = false;
				}
				if (line.indexOf("binding name=\"" + sVar1 + "\"") != -1) {
					b1 = true;
					continue;
				} else if (b1) {
					String s1 = getURI(line);
					if (s1 != null) {
						s1 = checkURISyntax(s1);
						if (filter == null || s1.startsWith(filter)) {
							sURI1 = s1;
						}
					}
					b1 = false;
					continue;
				}
				if (line.indexOf("binding name=\"" + sVar2 + "\"") != -1) {
					b2 = true;
					continue;
				} else if (b2) {
					String s2 = getURI(line);
					if (s2 != null) {
						s2 = checkURISyntax(s2);
						if (filter == null || s2.startsWith(filter)) {
							sURI2 = s2;
						}
					}
					b2 = false;
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