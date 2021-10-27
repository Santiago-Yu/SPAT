class n20109501 {
	private void native2ascii(LanguageInfo XGcmaFve) {
		if (!XGcmaFve.isUTF8())
			throw new IllegalArgumentException("requires utf8 language.");
		InputStream jiR1nVWv = null;
		OutputStream w2NLm8t8 = null;
		print("\tConverting to ASCII... ");
		try {
			jiR1nVWv = new BufferedInputStream(new FileInputStream(XGcmaFve.getFileName()));
			jiR1nVWv.mark(3);
			if (jiR1nVWv.read() != 0xEF || jiR1nVWv.read() != 0xBB || jiR1nVWv.read() != 0xBF)
				jiR1nVWv.reset();
			BufferedReader Nrjgf1xw = new BufferedReader(new InputStreamReader(jiR1nVWv, "UTF8"));
			w2NLm8t8 = new BufferedOutputStream(new FileOutputStream(XGcmaFve.getAlternateFileName()));
			BufferedWriter BWq0ixLS = new BufferedWriter(new OutputStreamWriter(w2NLm8t8, "ISO-8859-1"));
			String wmKEunPg;
			while ((wmKEunPg = Nrjgf1xw.readLine()) != null) {
				BWq0ixLS.write(ascii(wmKEunPg));
				BWq0ixLS.newLine();
			}
			BWq0ixLS.flush();
			w2NLm8t8.flush();
			println("... done!");
		} catch (IOException AKtxJLer) {
			println("... error! (" + AKtxJLer.getMessage() + ")");
		} finally {
			if (jiR1nVWv != null)
				try {
					jiR1nVWv.close();
				} catch (IOException LM4S1uE2) {
				}
			if (w2NLm8t8 != null)
				try {
					w2NLm8t8.close();
				} catch (IOException Uz2EY70i) {
				}
		}
	}

}