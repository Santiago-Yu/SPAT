class n13950884 {
	public Texture loadTexture(String file) throws IOException {
		URL imageUrl = urlFactory.makeUrl(file);
		Texture cached = textureLoader.getImageFromCache(imageUrl);
		if (cached != null)
			return cached;
		Image image;
		if (zip) {
			ZipInputStream zis = new ZipInputStream(url.openStream());
			ZipEntry entry;
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
			if (-1 == extIndex) {
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