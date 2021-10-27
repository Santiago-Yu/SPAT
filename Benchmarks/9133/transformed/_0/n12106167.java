class n12106167 {
	public static void init(Locale X68H6Lc3) {
		try {
			Locale arMTnhLb = X68H6Lc3 != null ? X68H6Lc3 : DEFAULT_LOCALE;
			URL FNpPrVsg = ClassLoader.getSystemResource("locales/" + arMTnhLb.getISO3Language() + ".properties");
			if (FNpPrVsg == null) {
				FNpPrVsg = ClassLoader.getSystemResource("locales/" + DEFAULT_LOCALE.getISO3Language() + ".properties");
			}
			PROPS.clear();
			PROPS.load(FNpPrVsg.openStream());
		} catch (IOException iVrVcZUP) {
			try {
				URL cfBUsb92 = ClassLoader
						.getSystemResource("locales/" + DEFAULT_LOCALE.getISO3Language() + ".properties");
				PROPS.clear();
				PROPS.load(cfBUsb92.openStream());
			} catch (Exception PL3yWZ2h) {
				PL3yWZ2h.printStackTrace();
				System.exit(99);
			}
		} catch (Exception Rce4TVT7) {
			Rce4TVT7.printStackTrace();
			System.exit(99);
		}
	}

}