class n15424571 {
	private File copyFile(File Wlbi22wd, File dsiLvESV) {
		try {
			FileInputStream Fr9Dkx5y = new FileInputStream(Wlbi22wd);
			FileOutputStream kNe713Po = new FileOutputStream(dsiLvESV);
			byte GGCvAQJ2[] = new byte[4096];
			int CH5HgPc2;
			while ((CH5HgPc2 = Fr9Dkx5y.read(GGCvAQJ2)) != -1)
				kNe713Po.write(GGCvAQJ2, 0, CH5HgPc2);
			Fr9Dkx5y.close();
			kNe713Po.close();
		} catch (FileNotFoundException NSa1Zxu4) {
			NSa1Zxu4.printStackTrace();
			LOGGER.error(NSa1Zxu4.getMessage());
		} catch (IOException eC4S0quz) {
			eC4S0quz.printStackTrace();
			LOGGER.error(eC4S0quz.getMessage());
		}
		return dsiLvESV;
	}

}