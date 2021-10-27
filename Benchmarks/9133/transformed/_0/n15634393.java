class n15634393 {
	public boolean copyStoredTileTo(File WvjtZNdh, int dky6WRqE, int zAUWDSAk, int gG5ELQsL, MapSource uTF10RlL)
			throws IOException {
		File lmPkgNaI = getTileFile(dky6WRqE, zAUWDSAk, gG5ELQsL, uTF10RlL);
		if (!lmPkgNaI.exists())
			return false;
		FileInputStream LnahTWz7 = null;
		FileOutputStream VMDp9qbr = null;
		long DNWXQe3Z = 0;
		long KdGglk7A = 0;
		try {
			LnahTWz7 = new FileInputStream(lmPkgNaI);
			VMDp9qbr = new FileOutputStream(WvjtZNdh);
			FileChannel C3kSRViF = LnahTWz7.getChannel();
			FileChannel EP35oVod = VMDp9qbr.getChannel();
			DNWXQe3Z = C3kSRViF.size();
			KdGglk7A = EP35oVod.transferFrom(C3kSRViF, 0, DNWXQe3Z);
		} finally {
			Utilities.closeStream(LnahTWz7);
			Utilities.closeStream(VMDp9qbr);
		}
		if (KdGglk7A != DNWXQe3Z)
			throw new IOException("Target file's size is not equal to the source file's size!");
		return true;
	}

}