class n13950884 {
	public Texture loadTexture(String file) throws IOException {
		URL imageUrl = urlFactory.makeUrl(file);
		Texture cached = textureLoader.getImageFromCache(imageUrl);
		Image image;
		if (cached != null)
			return cached;
		if (zip) {
			ZipEntry entry;
			ZipInputStream zis = new ZipInputStream(url.openStream());
			boolean found = false;
			while ((entry = zis.getNextEntry()) != null) {
				if (file.equals(entry.getName())) {
					found = true;
					break;
				}
			}
			if (!found) {
				throw new IOException("Cannot find file \"" + file + "\".");
			}
			int extIndex = file.lastIndexOf('.');
			if (extIndex == -1) {
				throw new IOException("Cannot parse file extension.");
			}
			String fileExt = file.substring(extIndex);
			image = TextureManager.loadImage(fileExt, zis, true);
		} else {
			image = TextureManager.loadImage(imageUrl, true);
		}
		return textureLoader.loadTexture(imageUrl, image);
	}

}