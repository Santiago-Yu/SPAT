class n16307790 {
	public static void main(String[] j4m3iIBs) throws IOException {
		String LcgGg0jf = "hdfs://localhost:8020/user/leeing/maxtemp/sample.txt";
		Configuration iRsv23Y8 = new Configuration();
		FileSystem VJOS7eW6 = FileSystem.get(URI.create(LcgGg0jf), iRsv23Y8);
		FSDataInputStream KfRnjufK = null;
		try {
			KfRnjufK = VJOS7eW6.open(new Path(LcgGg0jf));
			IOUtils.copyBytes(KfRnjufK, System.out, 8192, false);
			System.out.println("\n");
			KfRnjufK.seek(0);
			IOUtils.copyBytes(KfRnjufK, System.out, 8192, false);
		} finally {
			IOUtils.closeStream(KfRnjufK);
		}
	}

}