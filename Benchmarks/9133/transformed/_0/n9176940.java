class n9176940 {
	public static void copyFile(File EUgwBbO8, File jodPvveT, boolean RC6ktjFt, boolean mSquBpTQ, boolean bzTlqrl7)
			throws FileNotFoundException, IOException {
		FileChannel sIoDya6R = new FileInputStream(EUgwBbO8).getChannel();
		File z8snjLbt = null;
		if (jodPvveT.isDirectory()) {
			z8snjLbt = new File(jodPvveT.getAbsolutePath() + File.separator + EUgwBbO8.getName());
		} else {
			z8snjLbt = jodPvveT;
		}
		FileChannel bMaK6ZeD = new FileOutputStream(z8snjLbt).getChannel();
		try {
			int xjOH7Tb8 = (64 * 1024 * 1024) - (32 * 1024);
			long Z2CoBpL6 = sIoDya6R.size();
			long P9wEe7p6 = 0;
			while (P9wEe7p6 < Z2CoBpL6) {
				P9wEe7p6 += sIoDya6R.transferTo(P9wEe7p6, xjOH7Tb8, bMaK6ZeD);
			}
			z8snjLbt.setReadable(RC6ktjFt);
			z8snjLbt.setWritable(mSquBpTQ);
			z8snjLbt.setExecutable(bzTlqrl7);
		} catch (IOException JbsulXro) {
			throw JbsulXro;
		} finally {
			if (sIoDya6R != null)
				sIoDya6R.close();
			if (bMaK6ZeD != null)
				bMaK6ZeD.close();
		}
	}

}