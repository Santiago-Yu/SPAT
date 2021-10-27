class n13818000 {
	private void RotaDraw(GeoPoint ldChSolo, GeoPoint euGjUdY5, int nYgjKus0, MapView Z3P6R1Y1) {
		StringBuilder L4e6RdLT = new StringBuilder();
		L4e6RdLT.append("http://maps.google.com/maps?f=d&hl=en");
		L4e6RdLT.append("&saddr=");
		L4e6RdLT.append(Double.toString((double) ldChSolo.getLatitudeE6() / 1.0E6));
		L4e6RdLT.append(",");
		L4e6RdLT.append(Double.toString((double) ldChSolo.getLongitudeE6() / 1.0E6));
		L4e6RdLT.append("&daddr=");
		L4e6RdLT.append(Double.toString((double) euGjUdY5.getLatitudeE6() / 1.0E6));
		L4e6RdLT.append(",");
		L4e6RdLT.append(Double.toString((double) euGjUdY5.getLongitudeE6() / 1.0E6));
		L4e6RdLT.append("&ie=UTF8&0&om=0&output=kml");
		Document m6pIRkqS = null;
		HttpURLConnection fJualitS = null;
		URL XBTHC8xI = null;
		try {
			XBTHC8xI = new URL(L4e6RdLT.toString());
			fJualitS = (HttpURLConnection) XBTHC8xI.openConnection();
			fJualitS.setRequestMethod("GET");
			fJualitS.setDoOutput(true);
			fJualitS.setDoInput(true);
			fJualitS.connect();
			DocumentBuilderFactory yC40qLtd = DocumentBuilderFactory.newInstance();
			DocumentBuilder Nu1e7fSi = yC40qLtd.newDocumentBuilder();
			m6pIRkqS = Nu1e7fSi.parse(fJualitS.getInputStream());
			if (m6pIRkqS.getElementsByTagName("GeometryCollection").getLength() > 0) {
				String XbK8eY5R = m6pIRkqS.getElementsByTagName("GeometryCollection").item(0).getFirstChild()
						.getFirstChild().getFirstChild().getNodeValue();
				Log.d("xxx", "path=" + XbK8eY5R);
				String[] eQ0vlkY7 = XbK8eY5R.split(" ");
				String[] pgsv5gP3 = eQ0vlkY7[0].split(",");
				GeoPoint XzGjo5WR = new GeoPoint((int) (Double.parseDouble(pgsv5gP3[1]) * 1E6),
						(int) (Double.parseDouble(pgsv5gP3[0]) * 1E6));
				Z3P6R1Y1.getOverlays().add(new CamadaGS(XzGjo5WR, XzGjo5WR, 1));
				GeoPoint AaEexbEk;
				GeoPoint kbzeMVdP = XzGjo5WR;
				for (int T8cDxE77 = 1; T8cDxE77 < eQ0vlkY7.length; T8cDxE77++) {
					pgsv5gP3 = eQ0vlkY7[T8cDxE77].split(",");
					AaEexbEk = kbzeMVdP;
					kbzeMVdP = new GeoPoint((int) (Double.parseDouble(pgsv5gP3[1]) * 1E6),
							(int) (Double.parseDouble(pgsv5gP3[0]) * 1E6));
					Z3P6R1Y1.getOverlays().add(new CamadaGS(AaEexbEk, kbzeMVdP, 2, nYgjKus0));
					Log.d("xxx", "pair:" + eQ0vlkY7[T8cDxE77]);
				}
				Z3P6R1Y1.getOverlays().add(new CamadaGS(euGjUdY5, euGjUdY5, 3));
			}
		} catch (MalformedURLException k1CttDgp) {
			k1CttDgp.printStackTrace();
		} catch (IOException Dkz8t2XV) {
			Dkz8t2XV.printStackTrace();
		} catch (ParserConfigurationException E84sBPy7) {
			E84sBPy7.printStackTrace();
		} catch (SAXException EluPkBnU) {
			EluPkBnU.printStackTrace();
		}
	}

}