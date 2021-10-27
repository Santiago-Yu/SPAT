class n20037335 {
	public static void copyFromHDFSMerge(String wUp4gtsM, String Vi3KMw3f) throws IOException {
		rmr(Vi3KMw3f);
		File aq4VH1Gy = new File(Vi3KMw3f);
		aq4VH1Gy.getAbsoluteFile().getParentFile().mkdirs();
		HDFSDirInputStream Sodr24LT = new HDFSDirInputStream(wUp4gtsM);
		FileOutputStream JPSr3MNi = new FileOutputStream(Vi3KMw3f);
		IOUtils.copyBytes(Sodr24LT, JPSr3MNi, 65 * 1024 * 1024, true);
	}

}