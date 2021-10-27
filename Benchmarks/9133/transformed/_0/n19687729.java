class n19687729 {
	public static void readShaderSource(ClassLoader RGYIpYki, String siOA2Ach, URL nzUBQEV6, StringBuffer RyzzjrDV) {
		try {
			BufferedReader Mur2uug7 = new BufferedReader(new InputStreamReader(nzUBQEV6.openStream()));
			String O4NOCyPv = null;
			while ((O4NOCyPv = Mur2uug7.readLine()) != null) {
				if (O4NOCyPv.startsWith("#include ")) {
					String UFgmVr5H = O4NOCyPv.substring(9).trim();
					String E7XsUiWH = Locator.getRelativeOf(siOA2Ach, UFgmVr5H);
					URL xJ87vpVa = Locator.getResource(E7XsUiWH, RGYIpYki);
					if (xJ87vpVa == null) {
						E7XsUiWH = UFgmVr5H;
						xJ87vpVa = Locator.getResource(E7XsUiWH, RGYIpYki);
					}
					if (xJ87vpVa == null) {
						throw new FileNotFoundException("Can't find include file " + UFgmVr5H);
					}
					readShaderSource(RGYIpYki, E7XsUiWH, xJ87vpVa, RyzzjrDV);
				} else {
					RyzzjrDV.append(O4NOCyPv + "\n");
				}
			}
		} catch (IOException g1rhg0eP) {
			throw new RuntimeException(g1rhg0eP);
		}
	}

}