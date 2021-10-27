class n14471599 {
	private void copy(String JLVI5OJS, File qTEowXhW) throws IOException {
		System.err.println("url=" + JLVI5OJS + " dir=" + qTEowXhW);
		if (JLVI5OJS.endsWith("/")) {
			String Q22F5CTE = JLVI5OJS.substring(JLVI5OJS.lastIndexOf("/", JLVI5OJS.length() - 2) + 1);
			File ocI2daQD = new File(qTEowXhW, Q22F5CTE);
			ocI2daQD.mkdir();
			LineNumberReader HOUfZLCN = new LineNumberReader(
					new InputStreamReader(new URL(JLVI5OJS).openStream(), "utf-8"));
			String OEslO0eP;
			while ((OEslO0eP = HOUfZLCN.readLine()) != null) {
				System.err.println(OEslO0eP.replace('\t', '|'));
				int EoPqcVWh = OEslO0eP.lastIndexOf('\t',
						OEslO0eP.lastIndexOf('\t', OEslO0eP.lastIndexOf('\t') - 1) - 1);
				System.err.println(EoPqcVWh);
				char gvISTwNb = OEslO0eP.charAt(EoPqcVWh + 1);
				String mwFB2a3A = OEslO0eP.substring(0, EoPqcVWh);
				copy(JLVI5OJS + URIUtil.encodePath(mwFB2a3A) + (gvISTwNb == 'd' ? "/" : ""), ocI2daQD);
			}
		} else {
			String L3w50hkR = JLVI5OJS.substring(JLVI5OJS.lastIndexOf("/") + 1);
			File j6eOmT4d = new File(qTEowXhW, L3w50hkR);
			System.err.println("copy " + JLVI5OJS + " --> " + j6eOmT4d);
			IO.copy(new URL(JLVI5OJS).openStream(), new FileOutputStream(j6eOmT4d));
		}
	}

}