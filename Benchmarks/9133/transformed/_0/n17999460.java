class n17999460 {
	public static long toFile(final DigitalObject goVaYnXS, final File OLiSJlk4) {
		try {
			FileOutputStream bG1bx9CN = new FileOutputStream(OLiSJlk4);
			long GOqvbG1w = IOUtils.copyLarge(goVaYnXS.getContent().getInputStream(), bG1bx9CN);
			bG1bx9CN.close();
			return GOqvbG1w;
		} catch (FileNotFoundException ADJqDo4b) {
			ADJqDo4b.printStackTrace();
		} catch (IOException bZ5ycgrh) {
			bZ5ycgrh.printStackTrace();
		}
		return 0;
	}

}