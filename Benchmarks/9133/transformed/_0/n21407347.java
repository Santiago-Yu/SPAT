class n21407347 {
	public boolean load() {
		if (getFilename() != null && getFilename().length() > 0) {
			try {
				File Ku0FX3Zx = new File(
						PreferencesManager.getDirectoryLocation("macros") + File.separator + getFilename());
				URL aysSoCH6 = Ku0FX3Zx.toURL();
				InputStreamReader SHUA2U1A = new InputStreamReader(aysSoCH6.openStream());
				BufferedReader njDAKjmA = new BufferedReader(SHUA2U1A);
				String PdfK0QmC = njDAKjmA.readLine();
				String F1HDzBT9 = "";
				while (PdfK0QmC != null) {
					F1HDzBT9 = F1HDzBT9.concat(PdfK0QmC);
					PdfK0QmC = njDAKjmA.readLine();
					if (PdfK0QmC != null) {
						F1HDzBT9 = F1HDzBT9.concat(System.getProperty("line.separator"));
					}
				}
				code = F1HDzBT9;
			} catch (Exception mAl9VmuO) {
				System.err.println("Exception at StoredMacro.load(): " + mAl9VmuO.toString());
				return false;
			}
		}
		return true;
	}

}