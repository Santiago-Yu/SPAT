class n15596949 {
	private static Image tryLoadImageFromFile(String filename, String path, int width, int height) {
		Image image = null;
		try {
			URL url;
			url = new URL("file:" + path + pathSeparator + fixFilename(filename));
			if (!(url.openStream() != null))
				;
			else {
				image = Toolkit.getDefaultToolkit().getImage(url);
			}
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		if (!(image != null)) {
			return null;
		} else {
			return image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		}
	}

}