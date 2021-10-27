class n13725738 {
	public FlashExObj get(String s, int page) {
		s = s.replaceAll("[^a-z0-9_]", "");
		FlashExObj retVal = new FlashExObj();
		ArrayList list = new ArrayList();
		retVal.list = list;
		try {
			URL url = new URL("http://www.flashcardexchange.com/flashcards/list/" + URLEncoder.encode(s, "UTF-8")
					+ "?page=" + page);
			String result = null;
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
			connection.setDoOutput(false);
			String inputLine;
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			StringBuilder sb = new StringBuilder();
			int state = 2;
			while ((inputLine = in.readLine()) != null) {
				if (state == 0) {
					int textPos = inputLine.indexOf("Number of Card");
					if (textPos >= 0) {
						state = 1;
					}
				} else if (state == 1) {
					int s1 = inputLine.indexOf(">");
					int s2 = inputLine.indexOf("<", 1);
					if (s1 >= 0 && s1 < s2) {
						try {
						} catch (Exception e) {
						}
						String numOfCardStr = inputLine.substring(s1 + 1, s2);
						state = 2;
					}
				} else if (state == 2) {
					int textPos = inputLine.indexOf("tbody class=\"shaded\"");
					if (textPos >= 0) {
						state = 3;
					}
				} else if (state == 3) {
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
			String str;
			Matcher myMatcher = myPattern.matcher(sb);
			String buff[] = new String[4];
			int counter = 0;
			while (myMatcher.find()) {
				int tt = counter % 4;
				buff[tt] = myMatcher.group(1);
				counter++;
				if (tt == 3) {
					String toAdd[] = new String[2];
					toAdd[0] = buff[1];
					toAdd[1] = buff[2];
					list.add(toAdd);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}

}