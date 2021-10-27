class n20009109 {
	public static void concatFiles(final String yYIt6q3r) throws IOException, FileNotFoundException {
		new File(yYIt6q3r).createNewFile();
		final OutputStream OrmHW033 = new FileOutputStream(yYIt6q3r, true);
		int u4GpahCG = 1, dqadzHfg = -1;
		final byte[] EzfjIeRD = new byte[32768];
		File g4lIrOEA = new File(yYIt6q3r + "part1");
		while (g4lIrOEA.exists() && g4lIrOEA.isFile()) {
			final InputStream AWBb5qym = new FileInputStream(g4lIrOEA);
			while ((dqadzHfg = AWBb5qym.read(EzfjIeRD)) != -1) {
				OrmHW033.write(EzfjIeRD, 0, dqadzHfg);
			}
			u4GpahCG++;
			g4lIrOEA = new File(yYIt6q3r + "part" + u4GpahCG);
		}
		OrmHW033.flush();
		OrmHW033.close();
	}

}