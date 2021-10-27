class n15034107 {
	private static void copyFile(File pt18quvb, File bnv0MgPA) throws Exception {
		FileChannel vRupJzUv = new FileInputStream(pt18quvb).getChannel();
		FileChannel H8bKcLwr = new FileOutputStream(bnv0MgPA).getChannel();
		vRupJzUv.transferTo(0, vRupJzUv.size(), H8bKcLwr);
		vRupJzUv.close();
		H8bKcLwr.close();
	}

}