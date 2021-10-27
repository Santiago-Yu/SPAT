class n16803474 {
	public static void copyFile(File moNiEG8B, File HmNttzmK) throws Exception {
		FileInputStream TCWQidiK = new FileInputStream(moNiEG8B);
		try {
			FileOutputStream BZktJz5H = new FileOutputStream(HmNttzmK);
			try {
				int OC1Va6L6 = TCWQidiK.read();
				while (OC1Va6L6 != -1) {
					BZktJz5H.write(OC1Va6L6);
					OC1Va6L6 = TCWQidiK.read();
				}
			} finally {
				BZktJz5H.close();
			}
		} finally {
			TCWQidiK.close();
		}
	}

}