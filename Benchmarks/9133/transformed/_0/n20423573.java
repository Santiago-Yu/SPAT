class n20423573 {
	private static String fetchFile(String QbEUgdcM) {
		try {
			URL xVkWMDOa = new URL(QbEUgdcM);
			URLConnection Dg0kE4t1 = xVkWMDOa.openConnection();
			File TAAeOtyj = File.createTempFile("marla", ".jar");
			OutputStream jKvMTnWm = new FileOutputStream(TAAeOtyj);
			IOUtils.copy(Dg0kE4t1.getInputStream(), jKvMTnWm);
			return TAAeOtyj.getAbsolutePath();
		} catch (IOException ldwMvuGh) {
			throw new MarlaException("Unable to fetch file '" + QbEUgdcM + "' from server", ldwMvuGh);
		}
	}

}