class n10596393 {
	public static String BaiKe(String unknown) {
		long sTime = System.currentTimeMillis();
		String encodeurl = "";
		long eTime;
		try {
			String regEx = "\\#(.+)\\#";
			Pattern p = Pattern.compile(regEx);
			String searchText = "";
			Matcher m = p.matcher(unknown);
			if (m.find()) {
				searchText = m.group(1);
			}
			System.out.println("searchText :  " + searchText);
			encodeurl = URLEncoder.encode(searchText, "UTF-8");
			String url = "http://www.hudong.com/wiki/" + encodeurl;
			HttpURLConnection conn = (HttpURLConnection) (new URL(url)).openConnection();
			conn.setConnectTimeout(10000);
			Parser parser = new Parser(conn);
			parser.setEncoding(parser.getEncoding());
			NodeFilter filtera = new TagNameFilter("DIV");
			String textInPage = "";
			NodeList nodes = parser.extractAllNodesThatMatch(filtera);
			if (nodes != null) {
				for (int i = 0; i < nodes.size(); i++) {
					Node textnode = (Node) nodes.elementAt(i);
					if ("div class=\"summary\"".equals(textnode.getText())) {
						String temp = textnode.toPlainTextString();
						textInPage += temp + "\n";
					}
				}
			}
			eTime = System.currentTimeMillis();
			String s = Replace(textInPage, searchText);
			String time = "搜索[" + searchText + "]用时:" + (eTime - sTime) / 1000.0 + "s";
			System.out.println(s);
			return time + "\r\n" + s;
		} catch (Exception e) {
			e.printStackTrace();
			return "大姨妈来了";
		}
	}

}