class n12349562 {
	public byte[] loadResource(String XGdFqNKW) throws IOException {
		if ((XGdFqNKW == null) || (XGdFqNKW.length() == 0)) {
			throw new IOException("The given resource location must not be null and non empty.");
		}
		URL lEDBuKmE = buildURL(XGdFqNKW);
		URLConnection Fy0vMnfy = lEDBuKmE.openConnection();
		InputStream vgtF9zv0 = null;
		try {
			byte[] Wvv8Q9YG = new byte[2048];
			ByteArrayOutputStream Ae9OT7KK = new ByteArrayOutputStream(2048);
			vgtF9zv0 = Fy0vMnfy.getInputStream();
			int g54qm2kD = 0;
			while ((g54qm2kD = vgtF9zv0.read(Wvv8Q9YG, 0, 2048)) >= 0) {
				Ae9OT7KK.write(Wvv8Q9YG, 0, g54qm2kD);
			}
			return Ae9OT7KK.toByteArray();
		} finally {
			if (vgtF9zv0 != null) {
				vgtF9zv0.close();
			}
		}
	}

}