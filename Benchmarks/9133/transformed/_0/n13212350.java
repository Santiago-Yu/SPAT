class n13212350 {
	public static void copyFile(File uf0Hm5mP, File cFPwWR1M) {
		try {
			FileChannel omxJzxkB = new FileInputStream(uf0Hm5mP).getChannel();
			if (!cFPwWR1M.getParentFile().exists())
				cFPwWR1M.getParentFile().mkdirs();
			FileChannel q6av3kkL = new FileOutputStream(cFPwWR1M).getChannel();
			omxJzxkB.transferTo(0, omxJzxkB.size(), q6av3kkL);
			omxJzxkB.close();
			q6av3kkL.close();
		} catch (IOException oshXVZtP) {
			oshXVZtP.printStackTrace();
		}
	}

}