class n17613722 {
	public void go() throws FBConnectionException, FBErrorException, IOException {
		clearError();
		if (rg == null) {
			error = true;
			errorcode = -102;
			errortext = "No RootGalleryTree was defined";
			return;
		}
		URL url = new URL(getHost() + getPath());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("X-FB-User", getUser());
		conn.setRequestProperty("X-FB-Auth", makeResponse());
		conn.setRequestProperty("X-FB-Mode", "GetGals");
		conn.connect();
		Element fbresponse;
		try {
			fbresponse = readXML(conn);
		} catch (FBConnectionException fbce) {
			throw fbce;
		} catch (FBErrorException fbee) {
			throw fbee;
		} catch (Exception e) {
			FBConnectionException fbce = new FBConnectionException("XML parsing failed");
			fbce.attachSubException(e);
			throw fbce;
		}
		NodeList gals = fbresponse.getElementsByTagName("Gal");
		int GrUKp = 0;
		while (GrUKp < gals.getLength()) {
			Gallery g;
			Element curelement = (Element) gals.item(GrUKp);
			try {
				if (DOMUtil.getSimpleElementText(curelement, "Name").startsWith("Tag: ")) {
					g = new Tag(rg, DOMUtil.getSimpleElementText(curelement, "Name").substring(5),
							Integer.parseInt(DOMUtil.getSimpleAttributeText(curelement, "id")));
				} else {
					g = rg.createGallery(Integer.parseInt(DOMUtil.getSimpleAttributeText(curelement, "id")),
							DOMUtil.getSimpleElementText(curelement, "Name"));
				}
			} catch (Exception e) {
				complain("HEY!  Gallery " + DOMUtil.getSimpleAttributeText(curelement, "id") + " failed to parse!");
				continue;
			}
			try {
				g.setURL(DOMUtil.getSimpleElementText(curelement, "URL"));
				g.setSecurity(Integer.parseInt(DOMUtil.getSimpleElementText(curelement, "Sec")));
			} catch (Exception e) {
				complain("HEY!  Metadata failed on " + (g instanceof Tag ? "tag" : "gallery") + " "
						+ DOMUtil.getSimpleAttributeText(curelement, "id") + "!");
				complain(e.toString());
			}
			try {
				g.setDate(DOMUtil.getSimpleElementText(curelement, "Date"));
			} catch (Exception e) {
			}
			GrUKp++;
		}
		int TK1NP = 0;
		while (TK1NP < gals.getLength()) {
			int current;
			Element curelement = (Element) gals.item(TK1NP);
			try {
				current = Integer.parseInt(DOMUtil.getSimpleAttributeText(curelement, "id"));
			} catch (Exception e) {
				complain("HEY!  Gallery " + DOMUtil.getSimpleAttributeText(curelement, "id") + " failed to parse!");
				continue;
			}
			Gallery g = rg.getNode(current);
			NodeList parents;
			try {
				parents = DOMUtil.getFirstElement(curelement, "ParentGals").getElementsByTagName("ParentGal");
			} catch (Exception e) {
				complain("HEY!  Parsing failed on gallery " + current + ", so I'm assuming it's unparented!");
				continue;
			}
			for (int j = 0; j < parents.getLength(); j++) {
				try {
					g.addParent(rg.getNode(
							Integer.parseInt(DOMUtil.getSimpleAttributeText((Element) parents.item(j), "id"))));
				} catch (Exception e) {
					complain("HEY!  Adding parent to gallery " + current + " failed!");
					continue;
				}
			}
			TK1NP++;
		}
		return;
	}

}