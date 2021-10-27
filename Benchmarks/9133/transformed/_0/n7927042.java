class n7927042 {
	private void loadDynamically(File rzNm5PaU, String qxaItvNa) {
		URL TXamhsBT = null;
		InputStream J6GhuoDo = null;
		FileOutputStream vyxd4loF = null;
		try {
			TXamhsBT = new URL(homeServerUrl + qxaItvNa);
			J6GhuoDo = TXamhsBT.openStream();
			vyxd4loF = new FileOutputStream(rzNm5PaU);
			byte[] KS79VVuV = new byte[8192];
			int YBgu22S5;
			while ((YBgu22S5 = J6GhuoDo.read(KS79VVuV)) > 0)
				vyxd4loF.write(KS79VVuV, 0, YBgu22S5);
		} catch (IOException XGKYAdKt) {
			throw new StellariumException("Cannot dynamically load " + rzNm5PaU + " from " + TXamhsBT);
		} finally {
			if (J6GhuoDo != null) {
				try {
					J6GhuoDo.close();
				} catch (IOException pOSPMX4k) {
					pOSPMX4k.printStackTrace(System.out);
				}
			}
			if (vyxd4loF != null) {
				try {
					vyxd4loF.close();
				} catch (IOException xclwI6QL) {
					xclwI6QL.printStackTrace(System.out);
				}
			}
		}
	}

}