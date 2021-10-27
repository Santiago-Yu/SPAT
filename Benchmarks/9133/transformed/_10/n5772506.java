class n5772506 {
	private BibtexDatabase parseBibtexDatabase(List<String> id, boolean abs) throws IOException {
		URL url;
		if (id.isEmpty()) {
			return null;
		}
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
		String recordIds = "";
		PrintWriter out = new PrintWriter(conn.getOutputStream());
		Iterator<String> iter = id.iterator();
		while (iter.hasNext()) {
			recordIds += iter.next() + " ";
		}
		String citation = abs ? "citation-abstract" : "citation-only";
		recordIds = recordIds.trim();
		String content = "recordIds=" + recordIds.replaceAll(" ", "%20") + "&fromPageName=&citations-format=" + citation
				+ "&download-format=download-bibtex";
		System.out.println(content);
		out.write(content);
		out.flush();
		out.close();
		StringBuffer sb = new StringBuffer();
		BufferedReader bufr = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		char[] buffer = new char[256];
		while (true) {
			int bytesRead = bufr.read(buffer);
			if (bytesRead == -1) {
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