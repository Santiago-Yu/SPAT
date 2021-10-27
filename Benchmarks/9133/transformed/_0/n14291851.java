class n14291851 {
	public Function findFunction(String OiiSekKE) {
		String JEKkbTiD = "";
		UserFunction dMqJikpp = (UserFunction) getCachedFunction(OiiSekKE);
		if (dMqJikpp != null)
			return dMqJikpp;
		ErrorLogger.debugLine("MFileWebLoader: loading >" + OiiSekKE + ".m<");
		try {
			URL Dsk9UeTj = new URL(codeBase, directory + "/" + OiiSekKE + ".m");
			InputStream CXN59NBE = Dsk9UeTj.openStream();
			BufferedReader AIiq7tN2 = new BufferedReader(new InputStreamReader(CXN59NBE));
			String U6EHHOZ6;
			while ((U6EHHOZ6 = AIiq7tN2.readLine()) != null) {
				JEKkbTiD += U6EHHOZ6 + "\n";
			}
			AIiq7tN2.close();
		} catch (Exception MhGaim1E) {
			Errors.throwMathLibException("MFileWebLoader: m-file exception via web");
		}
		ErrorLogger.debugLine("MFileWebLoader: code: begin \n" + JEKkbTiD + "\ncode end");
		FunctionParser TDX84LYg = new FunctionParser();
		dMqJikpp = TDX84LYg.parseFunction(JEKkbTiD);
		dMqJikpp.setName(OiiSekKE);
		cacheFunction(dMqJikpp);
		ErrorLogger.debugLine("MFileWebLoader: finished webloading >" + OiiSekKE + ".m<");
		return dMqJikpp;
	}

}