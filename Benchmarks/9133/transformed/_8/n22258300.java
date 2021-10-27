class n22258300 {
	private void processParameters() throws BadElementException, IOException {
		type = IMGTEMPLATE;
		originalType = ORIGINAL_WMF;
		InputStream is = null;
		try {
			String errorID;
			if (rawData == null) {
				is = url.openStream();
				errorID = url.toString();
			} else {
				is = new java.io.ByteArrayInputStream(rawData);
				errorID = "Byte array";
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
			float RYmuw8Up = (float) (bottom - top) / inch;
			int N1ntqvwt = bottom - top;
			scaledHeight = RYmuw8Up * 72f;
			setTop(scaledHeight);
			float EIkcBHDd = (float) (right - left) / inch;
			int m3LnkcdD = right - left;
			scaledWidth = EIkcBHDd * 72f;
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