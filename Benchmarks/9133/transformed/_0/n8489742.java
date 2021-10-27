class n8489742 {
	public static void fileCopy(String sflZ9GTb, String ZWiuu4Lz) throws IOException {
		File WgYNBiCA = new File(sflZ9GTb);
		File YURBaNMh = new File(ZWiuu4Lz);
		FileReader gqW6OMBW = new FileReader(WgYNBiCA);
		FileWriter LuXzODKY = new FileWriter(YURBaNMh);
		int Ty5zmmfw;
		while ((Ty5zmmfw = gqW6OMBW.read()) != -1)
			LuXzODKY.write(Ty5zmmfw);
		gqW6OMBW.close();
		LuXzODKY.close();
	}

}