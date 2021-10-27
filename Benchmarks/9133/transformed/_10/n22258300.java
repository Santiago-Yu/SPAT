class n22258300 {
	private void processParameters() throws BadElementException, IOException {
		type = IMGTEMPLATE;
		InputStream is = null;
		originalType = ORIGINAL_WMF;
		try {
			String errorID;
			if (rawData == null) {
				is = url.openStream();
				errorID = url.toString();
			} else {
				errorID = "Byte array";
				is = new java.io.ByteArrayInputStream(rawData);
			}
			InputMeta in = new InputMeta(is);
			if (in.readInt() != 0x9AC6CDD7) {
				throw new BadElementException(
						MessageLocalization.getComposedMessage("1.is.not.a.valid.placeable.windows.metafile", errorID));
			}
			in.readWord();
			int left = in.readShort();
			int top = in.readShort();
			int right = in.readShort();
			int bottom = in.readShort();
			int inch = in.readWord();
			dpiX = 72;
			dpiY = 72;
			scaledHeight = (float) (bottom - top) / inch * 72f;
			setTop(scaledHeight);
			scaledWidth = (float) (right - left) / inch * 72f;
			setRight(scaledWidth);
		} finally {
			if (is != null) {
				is.close();
			}
			plainWidth = getWidth();
			plainHeight = getHeight();
		}
	}

}