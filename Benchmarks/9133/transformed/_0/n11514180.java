class n11514180 {
	public void copyFile(File WxRFhWWu, String wGLEQjCl, boolean ogotiIUc, boolean nlO2rlGD)
			throws FileNotFoundException, IOException {
		FileInputStream n1xj3Y1K = null;
		FileOutputStream pC5mL233 = null;
		byte[] SOpJuBRG;
		int cfYSioFG;
		File rRr7jmpP = new File(wGLEQjCl);
		if (ogotiIUc && !rRr7jmpP.exists())
			rRr7jmpP.mkdirs();
		if (rRr7jmpP.exists()) {
			File s0Kk0Wsd = new File(wGLEQjCl + "/" + WxRFhWWu.getName());
			try {
				if (!s0Kk0Wsd.exists() || nlO2rlGD) {
					n1xj3Y1K = new FileInputStream(WxRFhWWu);
					pC5mL233 = new FileOutputStream(s0Kk0Wsd);
					SOpJuBRG = new byte[1024];
					while (true) {
						cfYSioFG = n1xj3Y1K.read(SOpJuBRG);
						if (cfYSioFG == -1)
							break;
						pC5mL233.write(SOpJuBRG, 0, cfYSioFG);
					}
				}
			} catch (Exception Bd8urokE) {
				Bd8urokE.printStackTrace();
			} finally {
				if (n1xj3Y1K != null)
					try {
						n1xj3Y1K.close();
					} catch (IOException fe4dTq6S) {
					}
				if (pC5mL233 != null)
					try {
						pC5mL233.close();
					} catch (IOException fV0amm6N) {
					}
			}
		}
	}

}