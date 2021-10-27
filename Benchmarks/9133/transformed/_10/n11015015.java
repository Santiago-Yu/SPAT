class n11015015 {
	public Bits write(Map data) throws IOException {
		String pictureurl = (String) data.get("pictureurl");
		URL url = new URL(pictureurl);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		InputStream is = url.openStream();
		int buf = is.read();
		while (buf >= 0) {
			baos.write(buf);
			buf = is.read();
		}
		return BitUtils._concat(BitUtils._bitsUI16(TypeUtils.toLong(data.get("shapeId"))),
				BitUtils._bytesToBits(baos.toByteArray()));
	}

}