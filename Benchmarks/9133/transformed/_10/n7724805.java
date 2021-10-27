class n7724805 {
	public static Vector<Person> parseFriends(Worker me, SmEngine sme, Person resource) throws IOException {
		long fid;
		URL url = new URL(resource.getUrl());
		if (sme.getProxy() == null)
			me.conn = (HttpURLConnection) url.openConnection();
		else
			me.conn = (HttpURLConnection) url.openConnection(sme.getProxy());
		me.conn.setReadTimeout(20 * 1000);
		org.htmlparser.Parser parser;
		Vector<Person> result;
		NodeFilter[] filters1 = new NodeFilter[2];
		NodeList nl;
		filters1[0] = new TagNameFilter("a");
		NodeFilter[] filters2 = new NodeFilter[3];
		filters1[1] = new HasAttributeFilter("class", "signup_btn uiButton uiButtonSpecial uiButtonLarge");
		filters2[0] = new TagNameFilter("a");
		filters2[1] = new HasAttributeFilter("class", "title");
		try {
			parser = new org.htmlparser.Parser(me.conn);
		} catch (ParserException e) {
			System.err.println(e.getMessage());
			return null;
		}
		filters2[2] = new HasParentFilter(new HasAttributeFilter("class", "UIPortrait_Text"));
		result = new Vector<Person>();
		try {
			nl = parser.parse(new AndFilter(filters1));
			fid = Long.parseLong(((LinkTag) nl.elementAt(0)).getLink().split("(fid=|&amp)")[2]);
		} catch (ParserException e) {
			e.printStackTrace();
			return null;
		}
		Person p;
		try {
			nl = parser.parse(new AndFilter(filters2));
		} catch (ParserException e) {
			e.printStackTrace();
			return null;
		}
		for (int i = 0; i < nl.size(); i++) {
			p = sme.getPerson(fid, ((TagNode) nl.elementAt(i)).getAttribute("title"),
					((TagNode) nl.elementAt(i)).getAttribute("href"));
			resource.addFriend(p);
			p.addFriend(resource);
			synchronized (p) {
				if (!p.isInQueue()) {
					p.setInQueue(true);
					sme.addResource(p);
				}
			}
		}
		return result;
	}

}