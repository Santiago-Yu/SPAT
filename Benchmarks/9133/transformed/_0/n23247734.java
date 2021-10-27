class n23247734 {
	public static void main(String[] zvHMGBKZ) throws MalformedURLException, IOException {
		InputStream qGtDSwMH = null;
		try {
			qGtDSwMH = new URL("hdfs://localhost:8020/user/leeing/maxtemp/sample.txt").openStream();
			IOUtils.copyBytes(qGtDSwMH, System.out, 8192, false);
		} finally {
			IOUtils.closeStream(qGtDSwMH);
			System.out.println("\nend.");
		}
	}

}