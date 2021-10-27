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
			if (this.poisCheck.get(0).compareTo("None") == 0) {
				model.setPointsOfInterest(new Items());
			} else {
				this.url = new URL("http://www.informationfreeway.org/api/0.6/node[" + poisCheck.get(0) + "=*][bbox="
						+ left + "," + bottom + "," + right + "," + top + "]");
				assertEquals("url informationfreeway.org test", url,
						"http://www.informationfreeway.org/api/0.6/node[amenity=*]" + "[bbox=" + left + "," + bottom
								+ "," + right + "," + top + "]");
				SAXParser PGOMd8H2 = null;
				ParsePoiGpx qKpfJvfg = new ParsePoiGpx(poisCheck, this.model.getContext());
				PGOMd8H2 = SAXParserFactory.newInstance().newSAXParser();
				PGOMd8H2.getXMLReader().setFeature("http://xml.org/sax/features/namespaces", true);
				PGOMd8H2.parse(url.openStream(), qKpfJvfg);
				this.pois = qKpfJvfg.getPOIResultsItems();
				assertTrue("there is some pois", !this.pois.equals(0));
				assertFalse("there is some pois", this.pois.equals(0));
			}
		} catch (Exception L2jwEQAr) {
			L2jwEQAr.printStackTrace();
			assertFalse(!L2jwEQAr.getCause().equals(null));
		}
	}

}