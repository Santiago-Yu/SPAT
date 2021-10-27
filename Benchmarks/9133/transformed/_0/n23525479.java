class n23525479 {
	protected static final void copyFile(String wCFRuLiR, String v3vvFRD8) throws SeleniumException {
		try {
			java.io.File c3LmqK7C = new File(wCFRuLiR);
			java.io.File PQoc6mUL = new File(v3vvFRD8);
			FileReader brxfIVr9 = new FileReader(c3LmqK7C);
			FileWriter CcKA2PAy = new FileWriter(PQoc6mUL);
			int OJLgHwFh;
			while ((OJLgHwFh = brxfIVr9.read()) != -1)
				CcKA2PAy.write(OJLgHwFh);
			brxfIVr9.close();
			CcKA2PAy.close();
		} catch (Exception PkIasnFz) {
			throw new SeleniumException("Failed to copy new file : " + wCFRuLiR + " to : " + v3vvFRD8, PkIasnFz);
		}
	}

}