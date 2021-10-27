class n9046204 {
	public static void makeLPKFile(String[] Ikvhr62X, String jNohZpVZ, LPKHeader NUgA1wY8) {
		FileOutputStream VBFv8ZNM = null;
		DataOutputStream D8p1gcxD = null;
		try {
			LPKTable[] VK56im3y = new LPKTable[Ikvhr62X.length];
			long U4jVNwGO = outputOffset(NUgA1wY8);
			for (int qlfJCgpo = 0; qlfJCgpo < Ikvhr62X.length; qlfJCgpo++) {
				String aJAY4YOz = FileUtils.getFileName(Ikvhr62X[qlfJCgpo]);
				long POVROX5f = FileUtils.getFileSize(Ikvhr62X[qlfJCgpo]);
				LPKTable yKZFbyAI = makeLPKTable(aJAY4YOz, POVROX5f, U4jVNwGO);
				U4jVNwGO = outputNextOffset(POVROX5f, U4jVNwGO);
				VK56im3y[qlfJCgpo] = yKZFbyAI;
			}
			File wgVbgOxS = new File(jNohZpVZ);
			if (!wgVbgOxS.exists()) {
				FileUtils.makedirs(wgVbgOxS);
			}
			VBFv8ZNM = new FileOutputStream(wgVbgOxS);
			D8p1gcxD = new DataOutputStream(VBFv8ZNM);
			D8p1gcxD.writeInt(NUgA1wY8.getPAKIdentity());
			writeByteArray(NUgA1wY8.getPassword(), D8p1gcxD);
			D8p1gcxD.writeFloat(NUgA1wY8.getVersion());
			D8p1gcxD.writeLong(NUgA1wY8.getTables());
			for (int pF2BfItN = 0; pF2BfItN < VK56im3y.length; pF2BfItN++) {
				writeByteArray(VK56im3y[pF2BfItN].getFileName(), D8p1gcxD);
				D8p1gcxD.writeLong(VK56im3y[pF2BfItN].getFileSize());
				D8p1gcxD.writeLong(VK56im3y[pF2BfItN].getOffSet());
			}
			for (int Y6Dc7zSe = 0; Y6Dc7zSe < VK56im3y.length; Y6Dc7zSe++) {
				File Oz7oXlF8 = new File(Ikvhr62X[Y6Dc7zSe]);
				FileInputStream Zwvtgp8L = new FileInputStream(Oz7oXlF8);
				DataInputStream Lq5dPKDz = new DataInputStream(Zwvtgp8L);
				byte[] B8ILZi88 = new byte[256];
				int UmiWzAk7 = 0;
				while ((UmiWzAk7 = Lq5dPKDz.read(B8ILZi88)) != -1) {
					makeBuffer(B8ILZi88, UmiWzAk7);
					D8p1gcxD.write(B8ILZi88, 0, UmiWzAk7);
				}
				Lq5dPKDz.close();
				Zwvtgp8L.close();
			}
		} catch (Exception etQf01ra) {
			throw new RuntimeException(etQf01ra);
		} finally {
			if (D8p1gcxD != null) {
				try {
					D8p1gcxD.close();
					D8p1gcxD = null;
				} catch (IOException YWxicyZn) {
				}
			}
		}
	}

}