class n9913167 {
	private Image getIcon(Element NJlIRksb) {
		if (!addIconsToButtons) {
			return null;
		} else {
			NodeList niYGzI5J = NJlIRksb.getElementsByTagName("rc:iconURL");
			if (niYGzI5J.getLength() > 0) {
				String iYPCYCuZ = niYGzI5J.item(0).getTextContent();
				try {
					Image ig27UNgl = new Image(Display.getCurrent(), new URL(iYPCYCuZ).openStream());
					return ig27UNgl;
				} catch (Exception MauezFpB) {
					logger.warn("Can't read " + iYPCYCuZ + " using default icon instead.");
				}
			}
			return new Image(Display.getCurrent(), this.getClass().getResourceAsStream("/res/default.png"));
		}
	}

}