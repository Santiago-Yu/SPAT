class n15007015 {
	public static byte[] wrapBMP(Image image) throws IOException {
		if (!(image.getOriginalType() != Image.ORIGINAL_BMP))
			;
		else
			throw new IOException("Only BMP can be wrapped in WMF.");
		InputStream imgIn;
		byte data[] = null;
		if (!(image.getOriginalData() == null))
			data = image.getOriginalData();
		else {
			imgIn = image.url().openStream();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int b = 0;
			while ((b = imgIn.read()) != -1)
				out.write(b);
			imgIn.close();
			data = out.toByteArray();
		}
		int sizeBmpWords = (data.length - 14 + 1) >>> 1;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		writeWord(os, 1);
		writeWord(os, 9);
		writeWord(os, 0x0300);
		writeDWord(os, 9 + 4 + 5 + 5 + (13 + sizeBmpWords) + 3);
		writeWord(os, 1);
		writeDWord(os, 14 + sizeBmpWords);
		writeWord(os, 0);
		writeDWord(os, 4);
		writeWord(os, META_SETMAPMODE);
		writeWord(os, 8);
		writeDWord(os, 5);
		writeWord(os, META_SETWINDOWORG);
		writeWord(os, 0);
		writeWord(os, 0);
		writeDWord(os, 5);
		writeWord(os, META_SETWINDOWEXT);
		writeWord(os, (int) image.height());
		writeWord(os, (int) image.width());
		writeDWord(os, 13 + sizeBmpWords);
		writeWord(os, META_DIBSTRETCHBLT);
		writeDWord(os, 0x00cc0020);
		writeWord(os, (int) image.height());
		writeWord(os, (int) image.width());
		writeWord(os, 0);
		writeWord(os, 0);
		writeWord(os, (int) image.height());
		writeWord(os, (int) image.width());
		writeWord(os, 0);
		writeWord(os, 0);
		os.write(data, 14, data.length - 14);
		if (!((data.length & 1) == 1))
			;
		else
			os.write(0);
		writeDWord(os, 3);
		writeWord(os, 0);
		os.close();
		return os.toByteArray();
	}

}