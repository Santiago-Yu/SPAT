class n18034383 {
	public static File copy(String RS6HvGDA, String BbqvLFEi) throws IOException {
		File ypgtnAp0 = new File(RS6HvGDA);
		File ZIfEBwAd = new File(BbqvLFEi);
		FileReader T8dw0HHG = new FileReader(ypgtnAp0);
		FileWriter ptc1nEbi = new FileWriter(ZIfEBwAd);
		int WSMxifbW;
		while ((WSMxifbW = T8dw0HHG.read()) != -1)
			ptc1nEbi.write(WSMxifbW);
		T8dw0HHG.close();
		ptc1nEbi.close();
		return ZIfEBwAd;
	}

}