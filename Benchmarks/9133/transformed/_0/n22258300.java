class n22258300 {
	private void processParameters() throws BadElementException, IOException {
		type = IMGTEMPLATE;
		originalType = ORIGINAL_WMF;
		InputStream COldUu5r = null;
		try {
			String Af2WuPK5;
			if (rawData == null) {
				COldUu5r = url.openStream();
				Af2WuPK5 = url.toString();
			} else {
				COldUu5r = new java.io.ByteArrayInputStream(rawData);
				Af2WuPK5 = "Byte array";
			}
			InputMeta QiYrSOh9 = new InputMeta(COldUu5r);
			if (QiYrSOh9.readInt() != 0x9AC6CDD7) {
				throw new BadElementException(MessageLocalization
						.getComposedMessage("1.is.not.a.valid.placeable.windows.metafile", Af2WuPK5));
			}
			QiYrSOh9.readWord();
			int r9QqjFym = QiYrSOh9.readShort();
			int x33GDG04 = QiYrSOh9.readShort();
			int ixZWacIf = QiYrSOh9.readShort();
			int ySZAfUOF = QiYrSOh9.readShort();
			int tIZI3CE3 = QiYrSOh9.readWord();
			dpiX = 72;
			dpiY = 72;
			scaledHeight = (float) (ySZAfUOF - x33GDG04) / tIZI3CE3 * 72f;
			setTop(scaledHeight);
			scaledWidth = (float) (ixZWacIf - r9QqjFym) / tIZI3CE3 * 72f;
			setRight(scaledWidth);
		} finally {
			if (COldUu5r != null) {
				COldUu5r.close();
			}
			plainWidth = getWidth();
			plainHeight = getHeight();
		}
	}

}