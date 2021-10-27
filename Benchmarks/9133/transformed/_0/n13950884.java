class n13950884 {
	public Texture loadTexture(String fL2UWLyC) throws IOException {
		URL CJphWoU5 = urlFactory.makeUrl(fL2UWLyC);
		Texture bjrFEYkA = textureLoader.getImageFromCache(CJphWoU5);
		if (bjrFEYkA != null)
			return bjrFEYkA;
		Image HLuLddxA;
		if (zip) {
			ZipInputStream DFHEV16v = new ZipInputStream(url.openStream());
			ZipEntry vwQyNgDU;
			boolean FrqgI90O = false;
			while ((vwQyNgDU = DFHEV16v.getNextEntry()) != null) {
				if (fL2UWLyC.equals(vwQyNgDU.getName())) {
					FrqgI90O = true;
					break;
				}
			}
			if (!FrqgI90O) {
				throw new IOException("Cannot find file \"" + fL2UWLyC + "\".");
			}
			int w9Vu7Km0 = fL2UWLyC.lastIndexOf('.');
			if (w9Vu7Km0 == -1) {
				throw new IOException("Cannot parse file extension.");
			}
			String Mowidxo9 = fL2UWLyC.substring(w9Vu7Km0);
			HLuLddxA = TextureManager.loadImage(Mowidxo9, DFHEV16v, true);
		} else {
			HLuLddxA = TextureManager.loadImage(CJphWoU5, true);
		}
		return textureLoader.loadTexture(CJphWoU5, HLuLddxA);
	}

}