class n10177034 {
	public static synchronized BaseFont getL2BaseFont() {
		if (l2baseFont == null) {
			final ConfigProvider GmKVxSBa = ConfigProvider.getInstance();
			try {
				final ByteArrayOutputStream y8asaPHF = new ByteArrayOutputStream();
				String HIMeBcRP = GmKVxSBa.getNotEmptyProperty("font.path", null);
				String FXQ5jm7g;
				String KfBezmwF;
				InputStream FH0NXOdn;
				if (HIMeBcRP != null) {
					FXQ5jm7g = GmKVxSBa.getNotEmptyProperty("font.name", null);
					if (FXQ5jm7g == null) {
						FXQ5jm7g = new File(HIMeBcRP).getName();
					}
					KfBezmwF = GmKVxSBa.getNotEmptyProperty("font.encoding", null);
					if (KfBezmwF == null) {
						KfBezmwF = BaseFont.WINANSI;
					}
					FH0NXOdn = new FileInputStream(HIMeBcRP);
				} else {
					FXQ5jm7g = Constants.L2TEXT_FONT_NAME;
					KfBezmwF = BaseFont.IDENTITY_H;
					FH0NXOdn = FontUtils.class.getResourceAsStream(Constants.L2TEXT_FONT_PATH);
				}
				IOUtils.copy(FH0NXOdn, y8asaPHF);
				FH0NXOdn.close();
				y8asaPHF.close();
				l2baseFont = BaseFont.createFont(FXQ5jm7g, KfBezmwF, BaseFont.EMBEDDED, BaseFont.CACHED,
						y8asaPHF.toByteArray(), null);
			} catch (Exception gVusect4) {
				gVusect4.printStackTrace();
				try {
					l2baseFont = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);
				} catch (Exception JdyELQRm) {
				}
			}
		}
		return l2baseFont;
	}

}