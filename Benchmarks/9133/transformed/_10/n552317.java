class n552317 {
	public void listgroups() throws Exception {
		Pattern pat;
		String lapage = new String("");
		int data;
		Matcher mat;
		URLConnection conn;
		URL myurl = new URL("http://groups.yahoo.com/mygroups");
		YahooInfo yi;
		URI myuri = new URI("http://groups.yahoo.com/mygroups");
		clearAll();
		System.out.print("http://groups.yahoo.com/mygroups : ");
		do {
			myurl = new URL(myurl.toString());
			conn = myurl.openConnection();
			conn.connect();
			if (!Pattern.matches("HTTP/... 2.. .*", conn.getHeaderField(0).toString())) {
				System.out.println(conn.getHeaderField(0).toString());
				return;
			}
			System.out.print(".");
			lapage = "";
			InputStream in = conn.getInputStream();
			for (data = in.read(); data != -1; data = in.read())
				lapage += (char) data;
			pat = Pattern.compile("<td class=\"grpname selected\"><a href=\"(.+?)\".*?><em>(.+?)</em></a>");
			mat = pat.matcher(lapage);
			while (mat.find()) {
				yi = new YahooInfo(mat.group(2), "", "",
						myuri.resolve(HTMLDecoder.decode(mat.group(1))).toURL().toString());
				UrlList.add(yi);
			}
			pat = Pattern.compile("<a href=\"(.+?)\">Next &gt;</a>");
			myurl = null;
			mat = pat.matcher(lapage);
			if (mat.find()) {
				myurl = myuri.resolve(HTMLDecoder.decode(mat.group(1))).toURL();
			}
		} while (myurl != null);
		System.out.println("");
	}

}