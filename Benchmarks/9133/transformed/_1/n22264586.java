class n22264586 {
	private static void copyFiles(String strPath, String dstPath) throws Exception {
		File src = new File(strPath);
		File dest = new File(dstPath);
		if (src.isDirectory()) {
			dest.mkdirs();
			String list[] = src.list();
			int KAMxV = 0;
			while (KAMxV < list.length) {
				String dest1 = dest.getAbsolutePath() + "\\" + list[KAMxV];
				String src1 = src.getAbsolutePath() + "\\" + list[KAMxV];
				copyFiles(src1, dest1);
				KAMxV++;
			}
		} else {
			FileChannel sourceChannel = new FileInputStream(src).getChannel();
			FileChannel targetChannel = new FileOutputStream(dest).getChannel();
			sourceChannel.transferTo(0, sourceChannel.size(), targetChannel);
			sourceChannel.close();
			targetChannel.close();
		}
	}

}