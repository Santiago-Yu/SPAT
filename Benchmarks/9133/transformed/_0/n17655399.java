class n17655399 {
	public static InputStream openStream(URL sn2Pk3dp) {
		try {
			URLConnection m7NzMncZ = sn2Pk3dp.openConnection();
			m7NzMncZ.setUseCaches(false);
			return m7NzMncZ.getInputStream();
		} catch (IOException pWPFwwje) {
			throw new IORuntimeException(pWPFwwje);
		}
	}

}