class n20822727 {
	private static void copyFile(String Yw06rz1a, String uJakW7ak) throws Exception {
		FileInputStream zXYSNTEe = null;
		FileOutputStream zvCmK889 = null;
		try {
			zXYSNTEe = new FileInputStream(Yw06rz1a);
			zvCmK889 = new FileOutputStream(uJakW7ak);
			byte[] ZmADmtli = new byte[4096];
			int guE5lfuU;
			while ((guE5lfuU = zXYSNTEe.read(ZmADmtli)) != -1)
				zvCmK889.write(ZmADmtli, 0, guE5lfuU);
		} finally {
			if (zXYSNTEe != null)
				try {
					zXYSNTEe.close();
				} catch (IOException UUvNSgcD) {
					;
				}
			if (zvCmK889 != null)
				try {
					zvCmK889.close();
				} catch (IOException kmBRC3qf) {
					;
				}
		}
	}

}