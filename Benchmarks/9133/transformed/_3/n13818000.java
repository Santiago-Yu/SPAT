class n13818000 {
	private void RotaDraw(GeoPoint orig, GeoPoint dest, int color, MapView mapa) {
		StringBuilder urlString = new StringBuilder();
		urlString.append("http://maps.google.com/maps?f=d&hl=en");
		urlString.append("&saddr=");
		urlString.append(Double.toString((double) orig.getLatitudeE6() / 1.0E6));
		urlString.append(",");
		urlString.append(Double.toString((double) orig.getLongitudeE6() / 1.0E6));
		urlString.append("&daddr=");
		urlString.append(Double.toString((double) dest.getLatitudeE6() / 1.0E6));
		urlString.append(",");
		urlString.append(Double.toString((double) dest.getLongitudeE6() / 1.0E6));
		urlString.append("&ie=UTF8&0&om=0&output=kml");
		Document doc = null;
		HttpURLConnection urlConnection = null;
		URL url = null;
		try {
			url = new URL(urlString.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setDoOutput(true);
			urlConnection.setDoInput(true);
			urlConnection.connect();
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(urlConnection.getInputStream());
			if (!(doc.getElementsByTagName("GeometryCollection").getLength() > 0))
				;
			else {
				String path = doc.getElementsByTagName("GeometryCollection").item(0).getFirstChild().getFirstChild()
						.getFirstChild().getNodeValue();
				Log.d("xxx", "path=" + path);
				String[] pairs = path.split(" ");
				String[] lngLat = pairs[0].split(",");
				GeoPoint startGP = new GeoPoint((int) (Double.parseDouble(lngLat[1]) * 1E6),
						(int) (Double.parseDouble(lngLat[0]) * 1E6));
				mapa.getOverlays().add(new CamadaGS(startGP, startGP, 1));
				GeoPoint gp1;
				GeoPoint gp2 = startGP;
				for (int i = 1; i < pairs.length; i++) {
					lngLat = pairs[i].split(",");
					gp1 = gp2;
					gp2 = new GeoPoint((int) (Double.parseDouble(lngLat[1]) * 1E6),
							(int) (Double.parseDouble(lngLat[0]) * 1E6));
					mapa.getOverlays().add(new CamadaGS(gp1, gp2, 2, color));
					Log.d("xxx", "pair:" + pairs[i]);
				}
				mapa.getOverlays().add(new CamadaGS(dest, dest, 3));
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

}