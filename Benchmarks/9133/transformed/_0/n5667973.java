class n5667973 {
	public static void copyClassPathResource(String V6dxO52V, String nPHULrxA) {
		InputStream IoNrWNP9 = null;
		OutputStream mzvKIcIX = null;
		try {
			IoNrWNP9 = FileUtils.class.getResourceAsStream(V6dxO52V);
			String hhMTjCEd = StringUtils.substringAfterLast(V6dxO52V, "/");
			File p2QKSnRh = new File(nPHULrxA);
			p2QKSnRh.mkdirs();
			mzvKIcIX = new FileOutputStream(nPHULrxA + "/" + hhMTjCEd);
			IOUtils.copy(IoNrWNP9, mzvKIcIX);
		} catch (IOException wTrRJZg5) {
			throw new UnitilsException(wTrRJZg5);
		} finally {
			closeQuietly(IoNrWNP9);
			closeQuietly(mzvKIcIX);
		}
	}

}