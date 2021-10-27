class n14651235 {
	public static Document getSkeleton() {
		Document YSFtu0aq = null;
		String vFfKhiYd = System.getProperty("file.separator");
		try {
			java.net.URL ocLrIqRZ = Skeleton.class.getResource(
					vFfKhiYd + "simplemassimeditor" + vFfKhiYd + "resources" + vFfKhiYd + "configskeleton.xml");
			InputStream zAWuFP2G = ocLrIqRZ.openStream();
			DocumentBuilder GB70Q0vl = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			try {
				YSFtu0aq = GB70Q0vl.parse(zAWuFP2G);
			} catch (SAXException VaVeaJkJ) {
				VaVeaJkJ.printStackTrace();
			} catch (IOException teYRek0n) {
				teYRek0n.printStackTrace();
			}
		} catch (ParserConfigurationException SZLB0IiB) {
			SZLB0IiB.printStackTrace();
		} catch (IOException iKg7VEUt) {
			iKg7VEUt.printStackTrace();
		}
		return YSFtu0aq;
	}

}