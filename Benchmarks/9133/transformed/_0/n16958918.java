class n16958918 {
	public static boolean copyFile(final String xBax10IL, final String ezPmpyow) {
		if (fileExists(xBax10IL)) {
			try {
				FileChannel poTtZSqc = new FileInputStream(xBax10IL).getChannel();
				FileChannel NV17sWO3 = new FileOutputStream(ezPmpyow).getChannel();
				NV17sWO3.transferFrom(poTtZSqc, 0, poTtZSqc.size());
				poTtZSqc.close();
				NV17sWO3.close();
				return true;
			} catch (IOException tz651Vga) {
				Logger.getAnonymousLogger().severe(tz651Vga.getLocalizedMessage());
			}
		}
		return false;
	}

}