class n14650349 {
	private ArrayList<XSPFTrackInfo> getPlaylist() {
		try {
			Log.d(TAG, "Getting playlist started");
			String kHU1edlt = "http://" + mBaseURL + "/xspf.php?sk=" + mSession + "&discovery=0&desktop=1.4.1.57486";
			if (mAlternateConn) {
				kHU1edlt += "&api_key=9d1bbaef3b443eb97973d44181d04e4b";
				Log.d(TAG, "Using alternate connection method");
			}
			URL wqiGnEdf = new URL(kHU1edlt);
			HttpURLConnection f2wclP4o = (HttpURLConnection) wqiGnEdf.openConnection();
			f2wclP4o.connect();
			InputStream d8rUYRqM = f2wclP4o.getInputStream();
			DocumentBuilderFactory EIjMUnqh = DocumentBuilderFactory.newInstance();
			DocumentBuilder w5WmwqNI = EIjMUnqh.newDocumentBuilder();
			Document iXpS8m6I = w5WmwqNI.parse(d8rUYRqM);
			Element yzSRWn5C = iXpS8m6I.getDocumentElement();
			NodeList Fz6NnQMB = yzSRWn5C.getElementsByTagName("title");
			String IBOp1rg9 = "<unknown station>";
			if (Fz6NnQMB.getLength() > 0) {
				Element QO0bjUVQ = (Element) Fz6NnQMB.item(0);
				String Su3ygxCn = "";
				for (int hPB9eZ16 = 0; hPB9eZ16 < QO0bjUVQ.getChildNodes().getLength(); hPB9eZ16++) {
					Node A5E8fL0v = QO0bjUVQ.getChildNodes().item(hPB9eZ16);
					if (A5E8fL0v.getNodeType() == Node.TEXT_NODE)
						Su3ygxCn += A5E8fL0v.getNodeValue();
				}
				IBOp1rg9 = URLDecoder.decode(Su3ygxCn, "UTF-8");
			}
			NodeList QIcGDhZf = iXpS8m6I.getElementsByTagName("track");
			ArrayList<XSPFTrackInfo> Hn1vq9DH = new ArrayList<XSPFTrackInfo>();
			for (int uNUnUFkD = 0; uNUnUFkD < QIcGDhZf.getLength(); uNUnUFkD++)
				try {
					Hn1vq9DH.add(new XSPFTrackInfo(IBOp1rg9, (Element) QIcGDhZf.item(uNUnUFkD)));
				} catch (Utils.ParseException FAM76uyk) {
					Log.e(TAG, "in getPlaylist", FAM76uyk);
					return null;
				}
			Log.d(TAG, "Getting playlist successful");
			return Hn1vq9DH;
		} catch (Exception y6C5np8x) {
			Log.e(TAG, "in getPlaylist", y6C5np8x);
			return null;
		}
	}

}