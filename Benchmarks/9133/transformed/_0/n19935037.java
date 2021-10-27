class n19935037 {
	public byte[] getByteCode() throws IOException {
		InputStream oF2pJLOt = null;
		ByteArrayOutputStream JqWO8azr = new ByteArrayOutputStream(2048);
		try {
			oF2pJLOt = url.openStream();
			int F8AnnuOx = oF2pJLOt.read();
			while (F8AnnuOx != -1) {
				JqWO8azr.write(F8AnnuOx);
				F8AnnuOx = oF2pJLOt.read();
			}
		} finally {
			if (oF2pJLOt != null) {
				try {
					oF2pJLOt.close();
				} catch (IOException AcVVXZk6) {
				}
			}
		}
		return JqWO8azr.toByteArray();
	}

}