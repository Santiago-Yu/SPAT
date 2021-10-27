class n74 {
	static void copy(String jOnKt8w5, String cfA9a3DP) throws IOException {
		File ICVzkbq7 = new File(jOnKt8w5);
		File oOzTSa0O = new File(cfA9a3DP);
		if (ICVzkbq7.exists() == false) {
			throw new IOException("file '" + jOnKt8w5 + "' does not exist");
		}
		FileInputStream hUcVmCC2 = new FileInputStream(ICVzkbq7);
		FileOutputStream BLMKtsQw = new FileOutputStream(oOzTSa0O);
		byte[] NtJbyrD2 = new byte[1024];
		int OfAQZsgO;
		while ((OfAQZsgO = hUcVmCC2.read(NtJbyrD2)) > 0)
			BLMKtsQw.write(NtJbyrD2, 0, OfAQZsgO);
		hUcVmCC2.close();
		BLMKtsQw.close();
	}

}