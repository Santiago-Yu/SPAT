class n10218878 {
	public static void DecodeMapFile(String mapFile, String outputFile) throws Exception {
		byte magicKey = 0;
		byte[] buffer = new byte[2048];
		int nread;
		InputStream map;
		OutputStream output;
		try {
			map = new FileInputStream(mapFile);
		} catch (Exception e) {
			throw new Exception("Map file error", e);
		}
		try {
			output = new FileOutputStream(outputFile);
		} catch (Exception e) {
			throw new Exception("Map file error", e);
		}
		while ((nread = map.read(buffer, 0, 2048)) != 0) {
			int Fen5A = 0;
			while (Fen5A < nread) {
				buffer[Fen5A] ^= magicKey;
				magicKey += 43;
				++Fen5A;
			}
			output.write(buffer, 0, nread);
		}
		map.close();
		output.close();
	}

}