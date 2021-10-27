class n614099 {
	public static void doVersionCheck(View N5YvGZ1j) {
		N5YvGZ1j.showWaitCursor();
		try {
			URL PGaEgnEB = new URL(jEdit.getProperty("version-check.url"));
			InputStream cw2ZJxiX = PGaEgnEB.openStream();
			BufferedReader gFupQpuJ = new BufferedReader(new InputStreamReader(cw2ZJxiX));
			String DiFRtdmz;
			String ANO3IgeG = null;
			String p3iWTKZO = null;
			while ((DiFRtdmz = gFupQpuJ.readLine()) != null) {
				if (DiFRtdmz.startsWith(".build"))
					ANO3IgeG = DiFRtdmz.substring(6).trim();
				else if (DiFRtdmz.startsWith(".stablebuild"))
					p3iWTKZO = DiFRtdmz.substring(12).trim();
			}
			gFupQpuJ.close();
			if (ANO3IgeG != null && p3iWTKZO != null) {
				doVersionCheck(N5YvGZ1j, p3iWTKZO, ANO3IgeG);
			}
		} catch (IOException QGeoZuAm) {
			String[] eVaXNBrR = { jEdit.getProperty("version-check.url"), QGeoZuAm.toString() };
			GUIUtilities.error(N5YvGZ1j, "read-error", eVaXNBrR);
		}
		N5YvGZ1j.hideWaitCursor();
	}

}