class n90593 {
	public static void doVersionCheck(View BvwdGsmE) {
		BvwdGsmE.showWaitCursor();
		try {
			URL Zf6BokpS = new URL(jEdit.getProperty("version-check.url"));
			InputStream nf2NVw3D = Zf6BokpS.openStream();
			BufferedReader UH83zHad = new BufferedReader(new InputStreamReader(nf2NVw3D));
			String bJv4FtWH;
			String cNx5r2hK = null;
			String FUUjoB9k = null;
			while ((bJv4FtWH = UH83zHad.readLine()) != null) {
				if (bJv4FtWH.startsWith(".build"))
					cNx5r2hK = bJv4FtWH.substring(6).trim();
				else if (bJv4FtWH.startsWith(".stablebuild"))
					FUUjoB9k = bJv4FtWH.substring(12).trim();
			}
			UH83zHad.close();
			if (cNx5r2hK != null && FUUjoB9k != null) {
				doVersionCheck(BvwdGsmE, FUUjoB9k, cNx5r2hK);
			}
		} catch (IOException CWSM6MqA) {
			String[] TYdc9BBc = { jEdit.getProperty("version-check.url"), CWSM6MqA.toString() };
			GUIUtilities.error(BvwdGsmE, "read-error", TYdc9BBc);
		}
		BvwdGsmE.hideWaitCursor();
	}

}