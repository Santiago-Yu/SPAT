class n588571 {
	public static void main(String[] uxsukl7S) throws Exception {
		String MfN4ZxjP = uxsukl7S[0];
		Configuration yuV51ZeL = new Configuration();
		FileSystem wGW83YUw = FileSystem.get(URI.create(MfN4ZxjP), yuV51ZeL);
		InputStream SnDE5ct6 = null;
		try {
			SnDE5ct6 = wGW83YUw.open(new Path(MfN4ZxjP));
			IOUtils.copyBytes(SnDE5ct6, System.out, 4096, false);
		} finally {
			IOUtils.closeStream(SnDE5ct6);
		}
	}

}