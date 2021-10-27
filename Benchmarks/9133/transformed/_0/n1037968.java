class n1037968 {
	public static void copyFromFileToFileUsingNIO(File kv9Zx3Ca, File OtKlEpz6)
			throws FileNotFoundException, IOException {
		FileChannel K5kCkTjI = new FileInputStream(kv9Zx3Ca).getChannel();
		FileChannel unuS83PI = new FileOutputStream(OtKlEpz6).getChannel();
		try {
			K5kCkTjI.transferTo(0, K5kCkTjI.size(), unuS83PI);
		} catch (IOException bjHrLAx0) {
			throw bjHrLAx0;
		} finally {
			if (K5kCkTjI != null)
				K5kCkTjI.close();
			if (unuS83PI != null)
				unuS83PI.close();
		}
	}

}