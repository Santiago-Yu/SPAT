class n20037335 {
	public static void copyFromHDFSMerge(String hdfsDir, String local) throws IOException {
		rmr(local);
		File f = new File(local);
		f.getAbsoluteFile().getParentFile().mkdirs();
		FileOutputStream oup = new FileOutputStream(local);
		HDFSDirInputStream inp = new HDFSDirInputStream(hdfsDir);
		IOUtils.copyBytes(inp, oup, 65 * 1024 * 1024, true);
	}

}