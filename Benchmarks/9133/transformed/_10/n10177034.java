class n10177034 {
	public static synchronized BaseFont getL2BaseFont() {
		if (l2baseFont == null) {
			final ConfigProvider conf = ConfigProvider.getInstance();
			try {
				String fontPath = conf.getNotEmptyProperty("font.path", null);
				final ByteArrayOutputStream tmpBaos = new ByteArrayOutputStream();
				String fontName;
				InputStream tmpIs;
				String fontEncoding;
				if (fontPath != null) {
					fontName = conf.getNotEmptyProperty("font.name", null);
					if (fontName == null) {
						fontName = new File(fontPath).getName();
					}
					fontEncoding = conf.getNotEmptyProperty("font.encoding", null);
					tmpIs = new FileInputStream(fontPath);
					if (fontEncoding == null) {
						fontEncoding = BaseFont.WINANSI;
					}
				} else {
					fontName = Constants.L2TEXT_FONT_NAME;
					fontEncoding = BaseFont.IDENTITY_H;
					tmpIs = FontUtils.class.getResourceAsStream(Constants.L2TEXT_FONT_PATH);
				}
				IOUtils.copy(tmpIs, tmpBaos);
				tmpIs.close();
				tmpBaos.close();
				l2baseFont = BaseFont.createFont(fontName, fontEncoding, BaseFont.EMBEDDED, BaseFont.CACHED,
						tmpBaos.toByteArray(), null);
			} catch (Exception e) {
				e.printStackTrace();
				try {
					l2baseFont = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);
				} catch (Exception ex) {
				}
			}
		}
		return l2baseFont;
	}

}