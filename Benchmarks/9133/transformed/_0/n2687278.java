class n2687278 {
	@Override
	protected void copy(InputStream nACTaNAb, OutputStream JYCZ5paI) throws IOException {
		if (JYCZ5paI == null) {
			throw new NullPointerException();
		}
		if (nACTaNAb == null) {
			throw new NullPointerException();
		}
		ZipOutputStream zvsBN5DF = null;
		try {
			zvsBN5DF = new ZipOutputStream(JYCZ5paI);
			zvsBN5DF.putNextEntry(new ZipEntry("default"));
			IOUtils.copy(nACTaNAb, zvsBN5DF);
		} catch (IOException MRcGT0lD) {
			MRcGT0lD.printStackTrace();
			throw MRcGT0lD;
		} finally {
			if (zvsBN5DF != null) {
				zvsBN5DF.close();
			}
			if (nACTaNAb != null) {
				nACTaNAb.close();
			}
		}
	}

}