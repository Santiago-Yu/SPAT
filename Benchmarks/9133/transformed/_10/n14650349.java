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
			String stationName = "<unknown station>";
			NodeList titleNs = root.getElementsByTagName("title");
			if (titleNs.getLength() > 0) {
				String res = "";
				Element titleElement = (Element) titleNs.item(0);
				for (int i = 0; i < titleElement.getChildNodes().getLength(); i++) {
					Node item = titleElement.getChildNodes().item(i);
					if (item.getNodeType() == Node.TEXT_NODE)
						res += item.getNodeValue();
				}
				stationName = URLDecoder.decode(res, "UTF-8");
			}
			ArrayList<XSPFTrackInfo> result = new ArrayList<XSPFTrackInfo>();
			NodeList tracks = doc.getElementsByTagName("track");
			for (int i = 0; i < tracks.getLength(); i++)
				try {
					result.add(new XSPFTrackInfo(stationName, (Element) tracks.item(i)));
				} catch (Utils.ParseException e) {
					Log.e(TAG, "in getPlaylist", e);
					return null;
				}
			Log.d(TAG, "Getting playlist successful");
			return result;
		} catch (Exception e) {
			Log.e(TAG, "in getPlaylist", e);
			return null;
		}
	}

}