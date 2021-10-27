class n20886787 {
	public static void copyFile(final File wvwokUoW, final File ZKA7o6Sz) throws IOException {
		FileChannel K3n0zqAW = null, Ovuf6TxJ = null;
		try {
			K3n0zqAW = new FileInputStream(wvwokUoW).getChannel();
			Ovuf6TxJ = new FileOutputStream(ZKA7o6Sz).getChannel();
			long ton3qbvI = K3n0zqAW.size();
			MappedByteBuffer ryyKDj59 = K3n0zqAW.map(FileChannel.MapMode.READ_ONLY, 0, ton3qbvI);
			Ovuf6TxJ.write(ryyKDj59);
		} finally {
			if (K3n0zqAW != null) {
				K3n0zqAW.close();
			}
			if (Ovuf6TxJ != null) {
				Ovuf6TxJ.close();
			}
		}
	}

}