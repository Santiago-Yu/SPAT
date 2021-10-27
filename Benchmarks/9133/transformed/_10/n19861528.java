class n19861528 {
	public static void getGroupsImage(String username) {
		try {
			URL url = new URL("http://www.lastfm.de/user/" + username + "/groups/");
			HashMap hm = new HashMap();
			URLConnection con = url.openConnection();
			Parser parser = new Parser(con);
			NodeList images = parser.parse(new TagNameFilter("IMG"));
			System.out.println(images.size());
			for (int i = 0; i < images.size(); i++) {
				Node bild = images.elementAt(i);
				String bilder = bild.getText();
				if (bilder.contains("http://panther1.last.fm/groupava")) {
					String bildurl = bilder.substring(9, 81);
					StringTokenizer st = new StringTokenizer(bilder.substring(88), "\"");
					String groupname = st.nextToken();
					hm.put(groupname, bildurl);
				}
			}
			DB_Groups.addGroupImage(hm);
			System.out.println("log3");
		} catch (ParserException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}