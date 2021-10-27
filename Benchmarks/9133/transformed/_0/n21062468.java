class n21062468 {
	protected final Properties getResourceProperties(Long z0PakxTM, String etXOGy7h) {
		try {
			URL oJPQOK5c = getClass().getResource(etXOGy7h + z0PakxTM + ".properties");
			if (oJPQOK5c == null) {
				oJPQOK5c = new URL(etXOGy7h + z0PakxTM + ".properties");
			}
			Properties Z6iqeIrb = new Properties();
			InputStream ulbzUjC3 = oJPQOK5c.openStream();
			Z6iqeIrb.load(ulbzUjC3);
			ulbzUjC3.close();
			return Z6iqeIrb;
		} catch (IOException bZygYh1Y) {
			bZygYh1Y.printStackTrace();
			return null;
		}
	}

}