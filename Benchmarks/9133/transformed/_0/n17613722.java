class n17613722 {
	public void go() throws FBConnectionException, FBErrorException, IOException {
		clearError();
		if (rg == null) {
			error = true;
			errorcode = -102;
			errortext = "No RootGalleryTree was defined";
			return;
		}
		URL N3sOKcSj = new URL(getHost() + getPath());
		HttpURLConnection dHlXQXhs = (HttpURLConnection) N3sOKcSj.openConnection();
		dHlXQXhs.setRequestProperty("X-FB-User", getUser());
		dHlXQXhs.setRequestProperty("X-FB-Auth", makeResponse());
		dHlXQXhs.setRequestProperty("X-FB-Mode", "GetGals");
		dHlXQXhs.connect();
		Element mE3Yj2XX;
		try {
			mE3Yj2XX = readXML(dHlXQXhs);
		} catch (FBConnectionException eo9NLA0G) {
			throw eo9NLA0G;
		} catch (FBErrorException xMIOyb7I) {
			throw xMIOyb7I;
		} catch (Exception OcMknT7c) {
			FBConnectionException kcqVmFo0 = new FBConnectionException("XML parsing failed");
			kcqVmFo0.attachSubException(OcMknT7c);
			throw kcqVmFo0;
		}
		NodeList c7GR5BkL = mE3Yj2XX.getElementsByTagName("Gal");
		for (int zBqO0ZVE = 0; zBqO0ZVE < c7GR5BkL.getLength(); zBqO0ZVE++) {
			Gallery rC9PBxVB;
			Element yPhxjOFi = (Element) c7GR5BkL.item(zBqO0ZVE);
			try {
				if (DOMUtil.getSimpleElementText(yPhxjOFi, "Name").startsWith("Tag: ")) {
					rC9PBxVB = new Tag(rg, DOMUtil.getSimpleElementText(yPhxjOFi, "Name").substring(5),
							Integer.parseInt(DOMUtil.getSimpleAttributeText(yPhxjOFi, "id")));
				} else {
					rC9PBxVB = rg.createGallery(Integer.parseInt(DOMUtil.getSimpleAttributeText(yPhxjOFi, "id")),
							DOMUtil.getSimpleElementText(yPhxjOFi, "Name"));
				}
			} catch (Exception d8Qxuoum) {
				complain("HEY!  Gallery " + DOMUtil.getSimpleAttributeText(yPhxjOFi, "id") + " failed to parse!");
				continue;
			}
			try {
				rC9PBxVB.setURL(DOMUtil.getSimpleElementText(yPhxjOFi, "URL"));
				rC9PBxVB.setSecurity(Integer.parseInt(DOMUtil.getSimpleElementText(yPhxjOFi, "Sec")));
			} catch (Exception b2jTPMHY) {
				complain("HEY!  Metadata failed on " + (rC9PBxVB instanceof Tag ? "tag" : "gallery") + " "
						+ DOMUtil.getSimpleAttributeText(yPhxjOFi, "id") + "!");
				complain(b2jTPMHY.toString());
			}
			try {
				rC9PBxVB.setDate(DOMUtil.getSimpleElementText(yPhxjOFi, "Date"));
			} catch (Exception J4yzQUcV) {
			}
		}
		for (int jvVYzdZM = 0; jvVYzdZM < c7GR5BkL.getLength(); jvVYzdZM++) {
			int xMLLMqbu;
			Element F502A8Pu = (Element) c7GR5BkL.item(jvVYzdZM);
			try {
				xMLLMqbu = Integer.parseInt(DOMUtil.getSimpleAttributeText(F502A8Pu, "id"));
			} catch (Exception rdFozxhW) {
				complain("HEY!  Gallery " + DOMUtil.getSimpleAttributeText(F502A8Pu, "id") + " failed to parse!");
				continue;
			}
			Gallery iaxB1lsU = rg.getNode(xMLLMqbu);
			NodeList csBaAn8O;
			try {
				csBaAn8O = DOMUtil.getFirstElement(F502A8Pu, "ParentGals").getElementsByTagName("ParentGal");
			} catch (Exception K2HPdP3x) {
				complain("HEY!  Parsing failed on gallery " + xMLLMqbu + ", so I'm assuming it's unparented!");
				continue;
			}
			for (int WWKMfAQY = 0; WWKMfAQY < csBaAn8O.getLength(); WWKMfAQY++) {
				try {
					iaxB1lsU.addParent(rg.getNode(
							Integer.parseInt(DOMUtil.getSimpleAttributeText((Element) csBaAn8O.item(WWKMfAQY), "id"))));
				} catch (Exception Kob58ipn) {
					complain("HEY!  Adding parent to gallery " + xMLLMqbu + " failed!");
					continue;
				}
			}
		}
		return;
	}

}