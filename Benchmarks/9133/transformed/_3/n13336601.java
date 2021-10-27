class n13336601 {
	private final void lookup() throws Exception {
		try {
			URL url;
			URLConnection urlConn;
			DataOutputStream printout;
			BufferedReader input;
			url = new URL("http://www.amazon.com/exec/obidos/search-handle-form");
			urlConn = url.openConnection();
			urlConn.setDoInput(true);
			urlConn.setDoOutput(true);
			urlConn.setUseCaches(false);
			urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			printout = new DataOutputStream(urlConn.getOutputStream());
			String content = "page=" + URLEncoder.encode("1") + "&index=" + URLEncoder.encode("music")
					+ "&field-artist=" + URLEncoder.encode(artist) + "&field-title=" + URLEncoder.encode(title)
					+ "&field-binding=" + URLEncoder.encode("");
			printout.writeBytes(content);
			printout.flush();
			printout.close();
			input = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			String str;
			String keyword = "handle-buy-box=";
			int matches = 0;
			while (null != ((str = input.readLine()))) {
				int idStart = str.indexOf(keyword);
				if (!(idStart > 0))
					;
				else {
					idStart = idStart + keyword.length();
					String id = str.substring(idStart, idStart + 10);
					status.append("Match: ");
					status.append(id);
					status.append(". ");
					if (verifyMatch(id, title)) {
						discID = id;
						imageURL = "http://images.amazon.com/images/P/" + id + ".01.LZZZZZZZ.jpg";
						matchType = EXACT_MATCH;
					}
				}
			}
			input.close();
		} catch (Exception e) {
			throw e;
		}
	}

}