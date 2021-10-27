class n6780166 {
	public static void copyFile(File btODaOxb, File EBrHyEl2) {
		if (!btODaOxb.exists()) {
			return;
		}
		if ((EBrHyEl2.getParentFile() != null) && (!EBrHyEl2.getParentFile().exists())) {
			EBrHyEl2.getParentFile().mkdirs();
		}
		try {
			FileChannel bwfqCVwj = new FileInputStream(btODaOxb).getChannel();
			FileChannel rKcjKblZ = new FileOutputStream(EBrHyEl2).getChannel();
			rKcjKblZ.transferFrom(bwfqCVwj, 0, bwfqCVwj.size());
			bwfqCVwj.close();
			rKcjKblZ.close();
		} catch (IOException KC8ikNM9) {
			Logger.error(FileUtil.class, KC8ikNM9.getMessage(), KC8ikNM9);
		}
	}

}