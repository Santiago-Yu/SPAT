class n16012363 {
	public static void main(String[] dZIF1eNr) throws IOException {
		String m2nO4KUT = "hdfs://localhost:8020/user/leeing/maxtemp/sample.txt";
		Configuration OTPxrHWf = new Configuration();
		FileSystem kJCGxhBj = FileSystem.get(URI.create(m2nO4KUT), OTPxrHWf);
		InputStream Nkur5jeL = null;
		try {
			Nkur5jeL = kJCGxhBj.open(new Path(m2nO4KUT));
			IOUtils.copyBytes(Nkur5jeL, System.out, 8192, false);
		} finally {
			IOUtils.closeStream(Nkur5jeL);
		}
	}

}