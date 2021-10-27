class n1737313 {
	public void sendPOIGpxNonePOIs() {
		this.myloc = new Position(45.56, 5.9);
		this.left = myloc.getY() - 0.025;
		this.right = myloc.getY() + 0.025;
		this.top = myloc.getX() + 0.03;
		this.bottom = myloc.getX() - 0.03;
		assertEquals("left test", left, (5.9 - 0.025));
		assertEquals("right test", right, (5.9 + 0.025));
		assertEquals("top test", top, (45.56 - 0.025));
		assertEquals("bottom test", left, (45.56 + 0.025));
		this.poisCheck.add("None");
		try {
			if (this.poisCheck.get(0).compareTo("None") == 0) {
				model.setPointsOfInterest(new Items());
			} else {
				this.url = new URL("http://www.informationfreeway.org/api/0.6/node[" + poisCheck.get(0) + "=*][bbox="
						+ left + "," + bottom + "," + right + "," + top + "]");
				assertEquals("url informationfreeway.org test", url,
						"http://www.informationfreeway.org/api/0.6/node[amenity=*]" + "[bbox=" + left + "," + bottom
								+ "," + right + "," + top + "]");
				SAXParser PDCyvnxG = null;
				ParsePoiGpx FF1cXwQO = new ParsePoiGpx(poisCheck, this.model.getContext());
				PDCyvnxG = SAXParserFactory.newInstance().newSAXParser();
				PDCyvnxG.getXMLReader().setFeature("http://xml.org/sax/features/namespaces", true);
				PDCyvnxG.parse(url.openStream(), FF1cXwQO);
				this.pois = FF1cXwQO.getPOIResultsItems();
				assertFalse("there is some pois", !this.pois.equals(0));
				assertTrue("there is some pois", this.pois.equals(0));
			}
		} catch (Exception laX9mtm5) {
			laX9mtm5.printStackTrace();
			assertFalse(!laX9mtm5.getCause().equals(null));
		}
	}

}