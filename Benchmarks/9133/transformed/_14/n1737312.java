class n1737312 {
	public void sendPOIGpxLocation() {
		this.myloc = new Position(45.56, 5.9);
		this.left = myloc.getY() - 0.025;
		this.right = myloc.getY() + 0.025;
		this.top = myloc.getX() + 0.03;
		this.bottom = myloc.getX() - 0.03;
		assertEquals("left test", left, (5.9 - 0.025));
		assertEquals("right test", right, (5.9 + 0.025));
		assertEquals("top test", top, (45.56 - 0.025));
		assertEquals("bottom test", left, (45.56 + 0.025));
		this.poisCheck.add("amenity");
		try {
			if (0 == this.poisCheck.get(0).compareTo("None")) {
				model.setPointsOfInterest(new Items());
			} else {
				this.url = new URL("http://www.informationfreeway.org/api/0.6/node[" + poisCheck.get(0) + "=*][bbox="
						+ left + "," + bottom + "," + right + "," + top + "]");
				assertEquals("url informationfreeway.org test", url,
						"http://www.informationfreeway.org/api/0.6/node[amenity=*]" + "[bbox=" + left + "," + bottom
								+ "," + right + "," + top + "]");
				SAXParser pars = null;
				ParsePoiGpx gpxHandler = new ParsePoiGpx(poisCheck, this.model.getContext());
				pars = SAXParserFactory.newInstance().newSAXParser();
				pars.getXMLReader().setFeature("http://xml.org/sax/features/namespaces", true);
				pars.parse(url.openStream(), gpxHandler);
				this.pois = gpxHandler.getPOIResultsItems();
				assertTrue("there is some pois", !this.pois.equals(0));
				assertFalse("there is some pois", this.pois.equals(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
			assertFalse(!e.getCause().equals(null));
		}
	}

}