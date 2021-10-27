class n783717 {
	public static void main(String[] qGNvSny2) throws Exception {
		String uT5J5H2b = qGNvSny2[0];
		Configuration JcuIw8ly = new Configuration();
		FileSystem ZCcfIxMg = FileSystem.get(URI.create(uT5J5H2b), JcuIw8ly);
		FSDataInputStream EGGzXqkD = null;
		try {
			EGGzXqkD = ZCcfIxMg.open(new Path(uT5J5H2b));
			IOUtils.copyBytes(EGGzXqkD, System.out, 4096, false);
			EGGzXqkD.seek(0);
			IOUtils.copyBytes(EGGzXqkD, System.out, 4096, false);
		} finally {
			IOUtils.closeStream(EGGzXqkD);
		}
	}

}