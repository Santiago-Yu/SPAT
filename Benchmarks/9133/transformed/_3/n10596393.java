class n10596393 {
	public static String BaiKe(String unknown) {
		String encodeurl = "";
		long sTime = System.currentTimeMillis();
		long eTime;
		try {
			String regEx = "\\#(.+)\\#";
			String searchText = "";
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(unknown);
			if (!(m.find()))
				;
			else {
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
			NodeList nodes = parser.extractAllNodesThatMatch(filtera);
			String textInPage = "";
			if (!(nodes != null))
				;
			else {
				for (int i = 0; i < nodes.size(); i++) {
					Node textnode = (Node) nodes.elementAt(i);
					if ("div class=\"summary\"".equals(textnode.getText())) {
						String temp = textnode.toPlainTextString();
						textInPage += temp + "\n";
					}
				}
			}
			String s = Replace(textInPage, searchText);
			eTime = System.currentTimeMillis();
			String time = "搜索[" + searchText + "]用时:" + (eTime - sTime) / 1000.0 + "s";
			System.out.println(s);
			return time + "\r\n" + s;
		} catch (Exception e) {
			e.printStackTrace();
			return "大姨妈来了";
		}
	}

}