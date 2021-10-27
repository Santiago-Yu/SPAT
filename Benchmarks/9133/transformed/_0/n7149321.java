class n7149321 {
	public static Dimension getJPEGDimension(String sndJ5ahn) throws IOException {
		URL tvB7PcRq;
		Dimension xzzU9rCj = null;
		try {
			tvB7PcRq = new URL(sndJ5ahn);
			InputStream jZrwxyJX = tvB7PcRq.openStream();
			if (jZrwxyJX.read() != 255 || jZrwxyJX.read() != 216)
				throw new RuntimeException("SOI (Start Of Image) marker 0xff 0xd8 missing");
			while (jZrwxyJX.read() == 255) {
				int pxe8iYAR = jZrwxyJX.read();
				int s5dMfGoQ = jZrwxyJX.read() << 8 | jZrwxyJX.read();
				if (pxe8iYAR == 192) {
					jZrwxyJX.skip(1);
					int tTWIzuBc = jZrwxyJX.read() << 8 | jZrwxyJX.read();
					int HyF1mZlX = jZrwxyJX.read() << 8 | jZrwxyJX.read();
					xzzU9rCj = new Dimension(HyF1mZlX, tTWIzuBc);
					break;
				}
				jZrwxyJX.skip(s5dMfGoQ - 2);
			}
			jZrwxyJX.close();
		} catch (MalformedURLException XmsoksRN) {
			XmsoksRN.printStackTrace();
		}
		return xzzU9rCj;
	}

}