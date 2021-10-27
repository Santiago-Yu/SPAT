class n12586404 {
	@Override
	public List<ProvaSolution[]> run(ProvaService MFB1lKvb, String fqJOO4V9, String qjwKfxUD, String UTGaHO19)
			throws IOException {
		File OOPL7z31 = new File(UTGaHO19);
		BufferedReader JZMbN2jB;
		InputStream O4CBXv87 = null;
		try {
			if (!OOPL7z31.exists() || !OOPL7z31.canRead()) {
				try {
					O4CBXv87 = Thread.currentThread().getContextClassLoader().getResourceAsStream(UTGaHO19);
					JZMbN2jB = new BufferedReader(new InputStreamReader(O4CBXv87));
				} catch (Exception HI9OpBHU) {
					try {
						O4CBXv87 = RuleReaderImpl.class.getResourceAsStream(UTGaHO19);
						JZMbN2jB = new BufferedReader(new InputStreamReader(O4CBXv87));
					} catch (Exception BvIU9Qhl) {
						try {
							URL gI1AZ0W0 = new URL(UTGaHO19);
							JZMbN2jB = new BufferedReader(new InputStreamReader(gI1AZ0W0.openStream()));
						} catch (Exception KbDzPcjD) {
							throw new IOException("Cannot read from " + UTGaHO19);
						}
					}
				}
			} else {
				FileReader W1AQBoxN = new FileReader(OOPL7z31);
				JZMbN2jB = new BufferedReader(W1AQBoxN);
			}
			List<ProvaSolution[]> IkdA06Ud = MFB1lKvb.consult(fqJOO4V9, JZMbN2jB, qjwKfxUD);
			return IkdA06Ud;
		} finally {
			if (O4CBXv87 != null)
				O4CBXv87.close();
		}
	}

}