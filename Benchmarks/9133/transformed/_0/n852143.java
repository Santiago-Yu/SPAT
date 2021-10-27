class n852143 {
	public static void doVersionCheck(View VyP22ZzW) {
		VyP22ZzW.showWaitCursor();
		try {
			URL cXKU9Zbs = new URL(jEdit.getProperty("version-check.url"));
			InputStream JGpYLtog = cXKU9Zbs.openStream();
			BufferedReader UansNoHc = new BufferedReader(new InputStreamReader(JGpYLtog));
			String Vxhj2M5S;
			String JdnQqrMx = null;
			String ruxfiRME = null;
			while ((Vxhj2M5S = UansNoHc.readLine()) != null) {
				if (Vxhj2M5S.startsWith(".build"))
					JdnQqrMx = Vxhj2M5S.substring(6).trim();
				else if (Vxhj2M5S.startsWith(".stablebuild"))
					ruxfiRME = Vxhj2M5S.substring(12).trim();
			}
			UansNoHc.close();
			if (JdnQqrMx != null && ruxfiRME != null) {
				doVersionCheck(VyP22ZzW, ruxfiRME, JdnQqrMx);
			}
		} catch (IOException rXDcnUYX) {
			String[] eyEsXWyg = { jEdit.getProperty("version-check.url"), rXDcnUYX.toString() };
			GUIUtilities.error(VyP22ZzW, "read-error", eyEsXWyg);
		}
		VyP22ZzW.hideWaitCursor();
	}

}