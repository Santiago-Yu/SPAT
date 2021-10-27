class n13725738 {
	public FlashExObj get(String s, int page) {
		FlashExObj retVal = new FlashExObj();
		s = s.replaceAll("[^a-z0-9_]", "");
		ArrayList list = new ArrayList();
		retVal.list = list;
		try {
			String result = null;
			URL url = new URL("http://www.flashcardexchange.com/flashcards/list/" + URLEncoder.encode(s, "UTF-8")
					+ "?page=" + page);
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
			connection.setDoOutput(false);
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String inputLine;
			int state = 2;
			StringBuilder sb = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				if (0 == state) {
					int textPos = inputLine.indexOf("Number of Card");
					if (textPos >= 0) {
						state = 1;
					}
				} else if (1 == state) {
					int s1 = inputLine.indexOf(">");
					int s2 = inputLine.indexOf("<", 1);
					if (s1 >= 0 && s1 < s2) {
						String numOfCardStr = inputLine.substring(s1 + 1, s2);
						try {
						} catch (Exception e) {
						}
						state = 2;
					}
				} else if (2 == state) {
					int textPos = inputLine.indexOf("tbody class=\"shaded\"");
					if (textPos >= 0) {
						state = 3;
					}
				} else if (3 == state) {
					int textPos = inputLine.indexOf("tbody");
					if (textPos >= 0) {
						break;
					}
					sb.append(inputLine);
					sb.append(" ");
				}
			}
			in.close();
			Pattern myPattern = Pattern.compile("<td>(.*?)</td>");
			Matcher myMatcher = myPattern.matcher(sb);
			String str;
			int counter = 0;
			String buff[] = new String[4];
			while (myMatcher.find()) {
				int tt = counter % 4;
				buff[tt] = myMatcher.group(1);
				if (3 == tt) {
					String toAdd[] = new String[2];
					toAdd[0] = buff[1];
					toAdd[1] = buff[2];
					list.add(toAdd);
				}
				counter++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}

}