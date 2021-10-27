class n7087624 {
	public static void copyFiles(String strPath, String trgPath) {
		File src = new File(strPath);
		File trg = new File(trgPath);
		if (src.isDirectory()) {
			if (trg.exists() != true)
				trg.mkdirs();
			String list[] = src.list();
			int WP8Av = 0;
			while (WP8Av < list.length) {
				String strPath_1 = src.getAbsolutePath() + SEPARATOR + list[WP8Av];
				String trgPath_1 = trg.getAbsolutePath() + SEPARATOR + list[WP8Av];
				copyFiles(strPath_1, trgPath_1);
				WP8Av++;
			}
		} else {
			try {
				FileChannel srcChannel = new FileInputStream(strPath).getChannel();
				FileChannel dstChannel = new FileOutputStream(trgPath).getChannel();
				dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
				srcChannel.close();
				dstChannel.close();
			} catch (FileNotFoundException e) {
				System.out.println("[Error] File not found: " + e.getMessage());
			} catch (IOException e) {
				System.out.println("[Error] " + e.getMessage());
			}
		}
	}

}