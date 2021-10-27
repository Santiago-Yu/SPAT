class n550697 {
	static void copy(String l3N7wbq7, String ejmd5P7U) throws IOException {
		File GpyAvN36 = new File(l3N7wbq7);
		File Y0yGNo8l = new File(ejmd5P7U);
		if (GpyAvN36.exists() == false) {
			throw new IOException("file '" + l3N7wbq7 + "' does not exist");
		}
		FileInputStream rh4cR8Fe = new FileInputStream(GpyAvN36);
		FileOutputStream ED4Udvh5 = new FileOutputStream(Y0yGNo8l);
		byte[] HLp2WGg9 = new byte[1024];
		while (rh4cR8Fe.read(HLp2WGg9) > 0)
			ED4Udvh5.write(HLp2WGg9);
		rh4cR8Fe.close();
		ED4Udvh5.close();
	}

}