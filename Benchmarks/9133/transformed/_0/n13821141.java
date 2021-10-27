class n13821141 {
	public static String readUrlText(String IXUMgxml) throws IOException {
		URL ylpo3uYV = new URL(IXUMgxml);
		InputStream YbeN5jDm = ylpo3uYV.openStream();
		StringBuilder xntCXmyW = new StringBuilder();
		BufferedReader A4MadKi3 = null;
		try {
			A4MadKi3 = new BufferedReader(new InputStreamReader(YbeN5jDm));
			String xttutkKN;
			while ((xttutkKN = A4MadKi3.readLine()) != null) {
				xntCXmyW.append(xttutkKN);
				xntCXmyW.append(System.getProperty("line.separator"));
			}
		} catch (IOException lSO3sSoE) {
			System.out.println("Error reading text from URL [" + ylpo3uYV + "]: " + lSO3sSoE.toString());
			throw lSO3sSoE;
		} finally {
			if (A4MadKi3 != null) {
				try {
					A4MadKi3.close();
				} catch (IOException wjF3HKhD) {
					System.out.println(
							"Error closing after reading text from URL [" + ylpo3uYV + "]: " + wjF3HKhD.toString());
				}
			}
		}
		return xntCXmyW.toString();
	}

}