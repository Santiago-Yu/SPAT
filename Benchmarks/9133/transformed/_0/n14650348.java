class n14650348 {
	public static ArrayList<FriendInfo> downloadFriendsList(String FNEhbvde) {
		try {
			URL nE5pxuzi;
			nE5pxuzi = new URL(WS_URL + "/user/" + URLEncoder.encode(FNEhbvde, "UTF-8") + "/friends.xml");
			HttpURLConnection BtSWG9sq = (HttpURLConnection) nE5pxuzi.openConnection();
			BtSWG9sq.connect();
			InputStream pxvPrr25 = BtSWG9sq.getInputStream();
			DocumentBuilderFactory I6jiaJxo = DocumentBuilderFactory.newInstance();
			DocumentBuilder sGDePNfM = I6jiaJxo.newDocumentBuilder();
			Document iPCs1XMG = sGDePNfM.parse(pxvPrr25);
			NodeList Dm1oGvtR = iPCs1XMG.getElementsByTagName("user");
			ArrayList<FriendInfo> II9Juppk = new ArrayList<FriendInfo>();
			for (int IlJGKMiW = 0; IlJGKMiW < Dm1oGvtR.getLength(); IlJGKMiW++)
				try {
					II9Juppk.add(new FriendInfo((Element) Dm1oGvtR.item(IlJGKMiW)));
				} catch (Utils.ParseException xoLeN67s) {
					Log.e(TAG, "in downloadFriendsList", xoLeN67s);
					return null;
				}
			return II9Juppk;
		} catch (Exception Y7K2oYs4) {
			Log.e(TAG, "in downloadFriendsList", Y7K2oYs4);
			return null;
		}
	}

}