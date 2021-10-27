class n647710 {
	private static File copyFileTo(File o4BE4Qw9, File KNsYIJAL) throws IOException {
		File dtLHiIqL = new File(KNsYIJAL, o4BE4Qw9.getName());
		FileInputStream HRLvqlMR = null;
		FileOutputStream Pd9i5y9W = null;
		try {
			HRLvqlMR = new FileInputStream(o4BE4Qw9);
			Pd9i5y9W = new FileOutputStream(dtLHiIqL);
			byte C6R3BEl1[] = new byte[1024];
			int uxDW4dWH;
			while ((uxDW4dWH = HRLvqlMR.read(C6R3BEl1)) > 0)
				Pd9i5y9W.write(C6R3BEl1, 0, uxDW4dWH);
		} finally {
			if (HRLvqlMR != null)
				HRLvqlMR.close();
			if (Pd9i5y9W != null)
				Pd9i5y9W.close();
		}
		return dtLHiIqL;
	}

}