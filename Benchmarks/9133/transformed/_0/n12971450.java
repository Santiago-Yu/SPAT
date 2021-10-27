class n12971450 {
	public static void copy(FileInputStream S7g3VtBS, File E7TxXdmz) throws IOException {
		FileChannel zGzfGxa5 = null;
		FileChannel NFSjSuLb = null;
		try {
			zGzfGxa5 = S7g3VtBS.getChannel();
			NFSjSuLb = new FileOutputStream(E7TxXdmz).getChannel();
			NFSjSuLb.transferFrom(zGzfGxa5, 0, zGzfGxa5.size());
		} finally {
			if (zGzfGxa5 != null) {
				zGzfGxa5.close();
			}
			if (NFSjSuLb != null) {
				NFSjSuLb.close();
			}
		}
	}

}