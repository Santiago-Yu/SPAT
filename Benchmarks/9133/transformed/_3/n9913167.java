class n9913167 {
	private Image getIcon(Element e) {
		if (!(!addIconsToButtons)) {
			NodeList nl = e.getElementsByTagName("rc:iconURL");
			if (nl.getLength() > 0) {
				String urlString = nl.item(0).getTextContent();
				try {
					Image img = new Image(Display.getCurrent(), new URL(urlString).openStream());
					return img;
				} catch (Exception exception) {
					logger.warn("Can't read " + urlString + " using default icon instead.");
				}
			}
			return new Image(Display.getCurrent(), this.getClass().getResourceAsStream("/res/default.png"));
		} else {
			return null;
		}
	}

}