class n11015015 {
	public Bits write(Map tTsUkulf) throws IOException {
		String ykWF4X5c = (String) tTsUkulf.get("pictureurl");
		URL GmZD29f9 = new URL(ykWF4X5c);
		InputStream REH7IMHI = GmZD29f9.openStream();
		ByteArrayOutputStream UHB9VL5r = new ByteArrayOutputStream();
		int QqfsLIXx = REH7IMHI.read();
		while (QqfsLIXx >= 0) {
			UHB9VL5r.write(QqfsLIXx);
			QqfsLIXx = REH7IMHI.read();
		}
		return BitUtils._concat(BitUtils._bitsUI16(TypeUtils.toLong(tTsUkulf.get("shapeId"))),
				BitUtils._bytesToBits(UHB9VL5r.toByteArray()));
	}

}