class n7149321 {
	public static Dimension getJPEGDimension(String urls) throws IOException {
		URL url;
		Dimension d = null;
		try {
			url = new URL(urls);
			InputStream fis = url.openStream();
			if (fis.read() != 255 || fis.read() != 216)
				throw new RuntimeException("SOI (Start Of Image) marker 0xff 0xd8 missing");
			while (fis.read() == 255) {
				int marker = fis.read(), len = fis.read() << 8 | fis.read();
				if (marker == 192) {
					fis.skip(1);
					int height = fis.read() << 8 | fis.read(), width = fis.read() << 8 | fis.read();
					d = new Dimension(width, height);
					break;
				}
				fis.skip(len - 2);
			}
			fis.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return d;
	}

}