class n2538511 {
	public static void copyFile(File kbqElTrI, File EHEW1CqI) throws IOException {
		FileInputStream N5jamhHt = new FileInputStream(kbqElTrI);
		FileOutputStream OjxEzSPy = new FileOutputStream(EHEW1CqI);
		int RYysoz0Z;
		while ((RYysoz0Z = N5jamhHt.read()) != -1)
			OjxEzSPy.write(RYysoz0Z);
		N5jamhHt.close();
		OjxEzSPy.close();
	}

}