class n10313620 {
	public void read(Model IWzc2sDZ, String FP3HUvIo) {
		try {
			URLConnection QmoIwgm0 = new URL(FP3HUvIo).openConnection();
			String IxMUsDxj = QmoIwgm0.getContentEncoding();
			if (IxMUsDxj == null) {
				read(IWzc2sDZ, QmoIwgm0.getInputStream(), FP3HUvIo);
			} else {
				read(IWzc2sDZ, new InputStreamReader(QmoIwgm0.getInputStream(), IxMUsDxj), FP3HUvIo);
			}
		} catch (IOException JYY5CL5O) {
			throw new JenaException(JYY5CL5O);
		}
	}

}