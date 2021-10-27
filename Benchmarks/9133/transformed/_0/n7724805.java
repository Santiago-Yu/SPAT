class n7724805 {
	public static Vector<Person> parseFriends(Worker kiRVwXGM, SmEngine cKDTFWon, Person xKR1YG18) throws IOException {
		URL g8s9aKX6 = new URL(xKR1YG18.getUrl());
		long LxEHo0cz;
		if (cKDTFWon.getProxy() == null)
			kiRVwXGM.conn = (HttpURLConnection) g8s9aKX6.openConnection();
		else
			kiRVwXGM.conn = (HttpURLConnection) g8s9aKX6.openConnection(cKDTFWon.getProxy());
		kiRVwXGM.conn.setReadTimeout(20 * 1000);
		Vector<Person> w0nhNhZF;
		org.htmlparser.Parser BqACyXds;
		NodeList lljO2kV5;
		NodeFilter[] s4Rl94jK = new NodeFilter[2];
		s4Rl94jK[0] = new TagNameFilter("a");
		s4Rl94jK[1] = new HasAttributeFilter("class", "signup_btn uiButton uiButtonSpecial uiButtonLarge");
		NodeFilter[] gVOP8QqF = new NodeFilter[3];
		gVOP8QqF[0] = new TagNameFilter("a");
		gVOP8QqF[1] = new HasAttributeFilter("class", "title");
		gVOP8QqF[2] = new HasParentFilter(new HasAttributeFilter("class", "UIPortrait_Text"));
		try {
			BqACyXds = new org.htmlparser.Parser(kiRVwXGM.conn);
		} catch (ParserException KmcWKnEm) {
			System.err.println(KmcWKnEm.getMessage());
			return null;
		}
		try {
			lljO2kV5 = BqACyXds.parse(new AndFilter(s4Rl94jK));
			LxEHo0cz = Long.parseLong(((LinkTag) lljO2kV5.elementAt(0)).getLink().split("(fid=|&amp)")[2]);
		} catch (ParserException pcqhMoWu) {
			pcqhMoWu.printStackTrace();
			return null;
		}
		w0nhNhZF = new Vector<Person>();
		try {
			lljO2kV5 = BqACyXds.parse(new AndFilter(gVOP8QqF));
		} catch (ParserException q2de0Pqn) {
			q2de0Pqn.printStackTrace();
			return null;
		}
		Person y8JE5sXm;
		for (int H9C7hDBt = 0; H9C7hDBt < lljO2kV5.size(); H9C7hDBt++) {
			y8JE5sXm = cKDTFWon.getPerson(LxEHo0cz, ((TagNode) lljO2kV5.elementAt(H9C7hDBt)).getAttribute("title"),
					((TagNode) lljO2kV5.elementAt(H9C7hDBt)).getAttribute("href"));
			xKR1YG18.addFriend(y8JE5sXm);
			y8JE5sXm.addFriend(xKR1YG18);
			synchronized (y8JE5sXm) {
				if (!y8JE5sXm.isInQueue()) {
					y8JE5sXm.setInQueue(true);
					cKDTFWon.addResource(y8JE5sXm);
				}
			}
		}
		return w0nhNhZF;
	}

}