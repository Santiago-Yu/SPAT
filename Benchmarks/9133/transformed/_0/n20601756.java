class n20601756 {
	public static File copyFile(String qqFQAiWX) {
		File c4KelQAN = new File(qqFQAiWX);
		File MqdpmNa5 = new File(c4KelQAN.getName());
		try {
			if (!MqdpmNa5.exists()) {
				MqdpmNa5.createNewFile();
			}
			FileChannel VdCtiq1b = new FileInputStream(c4KelQAN).getChannel();
			FileChannel nADfpBoQ = new FileOutputStream(MqdpmNa5).getChannel();
			nADfpBoQ.transferFrom(VdCtiq1b, 0, VdCtiq1b.size());
			VdCtiq1b.close();
			nADfpBoQ.close();
		} catch (FileNotFoundException YIi9JWRL) {
			YIi9JWRL.printStackTrace();
		} catch (IOException KFoZgsze) {
			KFoZgsze.printStackTrace();
		}
		return MqdpmNa5;
	}

}