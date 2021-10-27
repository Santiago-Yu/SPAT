class n5543349 {
	public UserFunction loadMFileViaWeb(URL prpmv2Pa, String vSdt4k8d, String l7z4kTmR) {
		String jFMC9zgQ = "";
		UserFunction OG0bBVAU = null;
		ErrorLogger.debugLine("MFileLoader: loading >" + l7z4kTmR + ".m<");
		try {
			URL Tm8xqaX4 = new URL(prpmv2Pa, vSdt4k8d);
			InputStream His2FeI2 = Tm8xqaX4.openStream();
			BufferedReader qw4jHbJy = new BufferedReader(new InputStreamReader(His2FeI2));
			String spCAKanI;
			while ((spCAKanI = qw4jHbJy.readLine()) != null) {
				jFMC9zgQ += spCAKanI + "\n";
			}
			qw4jHbJy.close();
		} catch (Exception V6JMmOAq) {
			Errors.throwMathLibException("MFileLoader: m-file exception via web");
		}
		ErrorLogger.debugLine("MFileLoader: code: begin \n" + jFMC9zgQ + "\ncode end");
		FunctionParser tlLSubBr = new FunctionParser();
		OG0bBVAU = tlLSubBr.parseFunction(jFMC9zgQ);
		OG0bBVAU.setName(l7z4kTmR);
		ErrorLogger.debugLine("MFileLoader: finished webloading >" + l7z4kTmR + ".m<");
		return OG0bBVAU;
	}

}