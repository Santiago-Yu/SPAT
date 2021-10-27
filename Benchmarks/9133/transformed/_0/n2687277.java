class n2687277 {
	@Override
	protected void copy(Reader sJehO3zT, OutputStream GdMqbUJh) throws IOException {
		if (GdMqbUJh == null) {
			throw new NullPointerException();
		}
		if (sJehO3zT == null) {
			throw new NullPointerException();
		}
		ZipOutputStream yAOyPeiz = null;
		try {
			yAOyPeiz = new ZipOutputStream(GdMqbUJh);
			yAOyPeiz.putNextEntry(new ZipEntry("default"));
			IOUtils.copy(sJehO3zT, yAOyPeiz);
		} catch (IOException qDoxf8a3) {
			qDoxf8a3.printStackTrace();
			throw qDoxf8a3;
		} finally {
			if (yAOyPeiz != null) {
				yAOyPeiz.close();
			}
			if (sJehO3zT != null) {
				sJehO3zT.close();
			}
		}
	}

}