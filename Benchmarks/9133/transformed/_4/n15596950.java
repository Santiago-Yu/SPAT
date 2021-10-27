class n15596950 {
	private static ImageIcon tryLoadImageIconFromResource(String filename, String path, int width, int height) {
		ImageIcon icon = null;
		try {
			URL url = cl.getResource(path + pathSeparator + fixFilename(filename));
			icon = (url != null && url.openStream() != null) ? new ImageIcon(url) : icon;
		} catch (Exception e) {
		}
		if (icon == null) {
			return null;
		}
		if ((icon.getIconWidth() == width) && (icon.getIconHeight() == height)) {
			return icon;
		} else {
			return new ImageIcon(icon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH));
		}
	}

}