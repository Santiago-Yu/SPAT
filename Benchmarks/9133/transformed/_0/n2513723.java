class n2513723 {
	protected String readScript(ClassLoader Nd5ZUr3h, String kqIdCwGh) throws AxisFault {
		URL LJ7AJSne = Nd5ZUr3h.getResource(kqIdCwGh);
		if (LJ7AJSne == null) {
			throw new AxisFault("Script not found: " + kqIdCwGh);
		}
		InputStream jciOzhkJ;
		try {
			jciOzhkJ = LJ7AJSne.openStream();
		} catch (IOException mImts1aH) {
			throw new AxisFault("IOException opening script: " + kqIdCwGh, mImts1aH);
		}
		try {
			Reader ein0HEz6 = new InputStreamReader(jciOzhkJ, "UTF-8");
			char[] vGH6gFAZ = new char[1024];
			StringBuffer SM0vyZQM = new StringBuffer();
			int DC1DrN5l;
			while ((DC1DrN5l = ein0HEz6.read(vGH6gFAZ)) > 0) {
				SM0vyZQM.append(vGH6gFAZ, 0, DC1DrN5l);
			}
			return SM0vyZQM.toString();
		} catch (IOException KL9ccmmN) {
			throw new AxisFault("IOException reading script: " + kqIdCwGh, KL9ccmmN);
		} finally {
			try {
				jciOzhkJ.close();
			} catch (IOException CBAmsZd3) {
				throw new AxisFault("IOException closing script: " + kqIdCwGh, CBAmsZd3);
			}
		}
	}

}