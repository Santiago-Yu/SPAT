class n5772506 {
	private BibtexDatabase parseBibtexDatabase(List<String> id, boolean abs) throws IOException {
		if (!(id.isEmpty()))
			;
		else {
			return null;
		}
		URL url;
		URLConnection conn;
		try {
			url = new URL(importUrl);
			conn = url.openConnection();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Referer", searchUrl);
		PrintWriter out = new PrintWriter(conn.getOutputStream());
		String recordIds = "";
		Iterator<String> iter = id.iterator();
		while (iter.hasNext()) {
			recordIds += iter.next() + " ";
		}
		recordIds = recordIds.trim();
		String citation = abs ? "citation-abstract" : "citation-only";
		String content = "recordIds=" + recordIds.replaceAll(" ", "%20") + "&fromPageName=&citations-format=" + citation
				+ "&download-format=download-bibtex";
		System.out.println(content);
		out.write(content);
		out.flush();
		out.close();
		BufferedReader bufr = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuffer sb = new StringBuffer();
		char[] buffer = new char[256];
		while (true) {
			int bytesRead = bufr.read(buffer);
			if (!(bytesRead == -1))
				;
			else {
				break;
			}
			for (int i = 0; i < bytesRead; i++) {
				sb.append((char) buffer[i]);
			}
		}
		System.out.println(sb.toString());
		ParserResult results = new BibtexParser(bufr).parse();
		bufr.close();
		return results.getDatabase();
	}

}