class n6597132 {
	public static void copyFile(final File CqoxEiZp, final File MoABRWpW) throws IOException {
		if (!MoABRWpW.exists()) {
			MoABRWpW.createNewFile();
		}
		FileInputStream DyAlgdNw = null;
		FileOutputStream L0TvDcRu = null;
		FileChannel KHLLmxt5 = null;
		FileChannel r9jToavs = null;
		try {
			KHLLmxt5 = (DyAlgdNw = new FileInputStream(CqoxEiZp)).getChannel();
			r9jToavs = (L0TvDcRu = new FileOutputStream(MoABRWpW)).getChannel();
			r9jToavs.transferFrom(KHLLmxt5, 0, KHLLmxt5.size());
		} finally {
			closeIO(KHLLmxt5);
			closeIO(DyAlgdNw);
			closeIO(r9jToavs);
			closeIO(L0TvDcRu);
		}
	}

}