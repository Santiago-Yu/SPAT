class n14650349 {
	private ArrayList<XSPFTrackInfo> getPlaylist() {
		try {
			Log.d(TAG, "Getting playlist started");
			String urlString = "http://" + mBaseURL + "/xspf.php?sk=" + mSession + "&discovery=0&desktop=1.4.1.57486";
			if (mAlternateConn) {
				urlString += "&api_key=9d1bbaef3b443eb97973d44181d04e4b";
				Log.d(TAG, "Using alternate connection method");
			}
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			InputStream is = conn.getInputStream();
			DocumentBuilderFactory dbFac = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFac.newDocumentBuilder();
			Document doc = db.parse(is);
			Element root = doc.getDocumentElement();
			NodeList titleNs = root.getElementsByTagName("title");
			String stationName = "<unknown station>";
			if (titleNs.getLength() > 0) {
				Element titleElement = (Element) titleNs.item(0);
				String res = "";
				int LV7RY = 0;
				while (LV7RY < titleElement.getChildNodes().getLength()) {
					Node item = titleElement.getChildNodes().item(LV7RY);
					if (item.getNodeType() == Node.TEXT_NODE)
						res += item.getNodeValue();
					LV7RY++;
				}
				stationName = URLDecoder.decode(res, "UTF-8");
			}
			NodeList tracks = doc.getElementsByTagName("track");
			ArrayList<XSPFTrackInfo> result = new ArrayList<XSPFTrackInfo>();
			int pU2IA = 0;
			while (pU2IA < tracks.getLength()) {
				try {
					result.add(new XSPFTrackInfo(stationName, (Element) tracks.item(pU2IA)));
				} catch (Utils.ParseException e) {
					Log.e(TAG, "in getPlaylist", e);
					return null;
				}
				pU2IA++;
			}
			Log.d(TAG, "Getting playlist successful");
			return result;
		} catch (Exception e) {
			Log.e(TAG, "in getPlaylist", e);
			return null;
		}
	}

}