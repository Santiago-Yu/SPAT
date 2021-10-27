class n13361852 {
	public static File copyFile(File C8D0YYyM, File YTWO3cHL) throws IOException {
		FileOutputStream Db5Hzafl = new FileOutputStream(YTWO3cHL);
		FileInputStream McaKB77o = new FileInputStream(C8D0YYyM);
		FileChannel DBAevfio = Db5Hzafl.getChannel();
		FileChannel KuKgbYpC = McaKB77o.getChannel();
		DBAevfio.transferFrom(KuKgbYpC, 0, KuKgbYpC.size());
		DBAevfio.close();
		KuKgbYpC.close();
		return YTWO3cHL;
	}

}