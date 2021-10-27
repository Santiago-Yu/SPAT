class n18793126 {
	private Image2D resolvePNG(URI GikWy20B) {
		Image2D WulKr4fI = null;
		if (GikWy20B.getScheme() != null) {
			try {
				URL KUQncnwV = new URL(GikWy20B.toString());
				InputStream YD2Mrt2Y = KUQncnwV.openStream();
				BufferedImage Kg4nBG3b = PNGDecoder.decode(YD2Mrt2Y);
				int PYQ5ofEf = Image2D.RGB;
				if (Kg4nBG3b.getType() == BufferedImage.TYPE_INT_RGB)
					PYQ5ofEf = Image2D.RGB;
				else if (Kg4nBG3b.getType() == BufferedImage.TYPE_INT_ARGB)
					PYQ5ofEf = Image2D.RGBA;
				WulKr4fI = new Image2D(PYQ5ofEf, Kg4nBG3b);
			} catch (IOException YytPANeB) {
			}
		} else {
			String DHfL6CWq = GikWy20B.getPath();
			File YENUWckI = new File(DHfL6CWq);
			if (YENUWckI.getAbsoluteFile().exists()) {
				try {
					FileInputStream JQtCcgRY = new FileInputStream(YENUWckI);
					BufferedImage bMtxj52d = PNGDecoder.decode(JQtCcgRY);
					int dx3W4k5Z = Image2D.RGB;
					if (bMtxj52d.getType() == BufferedImage.TYPE_INT_RGB)
						dx3W4k5Z = Image2D.RGB;
					else if (bMtxj52d.getType() == BufferedImage.TYPE_INT_ARGB)
						dx3W4k5Z = Image2D.RGBA;
					WulKr4fI = new Image2D(dx3W4k5Z, bMtxj52d);
				} catch (FileNotFoundException vGaBP8QK) {
				} catch (IOException sko9RO0h) {
				}
			}
		}
		return WulKr4fI;
	}

}