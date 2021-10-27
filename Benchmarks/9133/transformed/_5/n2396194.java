class n2396194 {
	public static Vector getKeywordsFromURLFast(String p_url) throws Exception {
		URL x_url = new URL(p_url);
		URLConnection x_conn = x_url.openConnection();
		InputStreamReader x_is_reader = new InputStreamReader(x_conn.getInputStream());
		BufferedReader x_reader = new BufferedReader(x_is_reader);
		String x_line = null;
		String x_title_line = null;
		String x_lc_line = null;
		Vector x_words = new Vector(1000);
		int x_body = -1;
		int x_title = -1;
		boolean x_bod = false;
		int x_end = -1;
		while ((x_line = x_reader.readLine()) != null) {
			x_lc_line = x_line.toLowerCase();
			x_title = x_lc_line.indexOf("<title");
			if (x_title != -1) {
				x_end = x_lc_line.indexOf("</title>");
				if (x_end == -1)
					x_title_line = x_line.substring((x_title + 7), (x_line.length()));
				else
					x_title_line = x_line.substring((x_title + 7), (x_end));
			}
			x_body = x_lc_line.indexOf("<body");
			if (x_body != -1) {
				x_bod = true;
				x_line = x_line.substring(x_body + 5);
				break;
			}
		}
		boolean x_status = false;
		x_end = -1;
		String[] x_temp_words;
		if (x_bod == false) {
			if (x_title_line != null) {
				x_words = new Vector();
				x_temp_words = extractWordsFromSpacedList(x_title_line);
				for (int i = 0; i < x_temp_words.length; i++)
					x_words.addElement(x_temp_words[i]);
				x_words.addElement(x_title_line);
				return x_words;
			} else {
				return null;
			}
		}
		StringBuffer x_buf = new StringBuffer(35);
		do {
			x_lc_line = x_line.toLowerCase();
			x_end = x_lc_line.indexOf("</body>");
			if (x_end != -1) {
				extractOutsideTextFast(x_line.substring(0, x_end), '<', '>', x_words, x_status, x_buf);
				break;
			}
			x_status = extractOutsideTextFast(x_line, '<', '>', x_words, x_status, x_buf);
		} while ((x_line = x_reader.readLine()) != null);
		if (x_title_line != null)
			x_words.addElement(x_title_line);
		return x_words;
	}

}