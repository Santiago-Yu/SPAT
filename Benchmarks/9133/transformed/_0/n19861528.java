class n19861528 {
	public static void getGroupsImage(String hm0b3knK) {
		try {
			URL hsJGjL3H = new URL("http://www.lastfm.de/user/" + hm0b3knK + "/groups/");
			URLConnection wZf64Un1 = hsJGjL3H.openConnection();
			HashMap iPpBKKsW = new HashMap();
			Parser Cznq3fVK = new Parser(wZf64Un1);
			NodeList VaUNOj2p = Cznq3fVK.parse(new TagNameFilter("IMG"));
			System.out.println(VaUNOj2p.size());
			for (int rCyQxopt = 0; rCyQxopt < VaUNOj2p.size(); rCyQxopt++) {
				Node rcqIDqbM = VaUNOj2p.elementAt(rCyQxopt);
				String JgypTMGI = rcqIDqbM.getText();
				if (JgypTMGI.contains("http://panther1.last.fm/groupava")) {
					String d1UQF817 = JgypTMGI.substring(9, 81);
					StringTokenizer izcf31Dt = new StringTokenizer(JgypTMGI.substring(88), "\"");
					String nKw3RA8F = izcf31Dt.nextToken();
					iPpBKKsW.put(nKw3RA8F, d1UQF817);
				}
			}
			DB_Groups.addGroupImage(iPpBKKsW);
			System.out.println("log3");
		} catch (ParserException pd0QkKSl) {
			pd0QkKSl.printStackTrace();
		} catch (MalformedURLException qVaLjkEd) {
			qVaLjkEd.printStackTrace();
		} catch (IOException WXbeHzNu) {
			WXbeHzNu.printStackTrace();
		}
	}

}