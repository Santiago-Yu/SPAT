class n11044947 {
	public static void copyFile(File LMCnLsrc, File YAtenij3, boolean pvCct8wj) throws IOException {
		FileChannel eVU4C2Dk = new FileInputStream(LMCnLsrc).getChannel();
		FileChannel Fl78Oagw = new FileOutputStream(YAtenij3, pvCct8wj).getChannel();
		try {
			eVU4C2Dk.transferTo(0, eVU4C2Dk.size(), Fl78Oagw);
		} catch (IOException sxZotV33) {
			throw sxZotV33;
		} finally {
			if (eVU4C2Dk != null)
				eVU4C2Dk.close();
			if (Fl78Oagw != null)
				Fl78Oagw.close();
		}
	}

}