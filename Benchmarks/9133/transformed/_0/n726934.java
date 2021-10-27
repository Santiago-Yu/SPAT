class n726934 {
	public static void doVersionCheck(View J4FkuUat) {
		J4FkuUat.showWaitCursor();
		try {
			URL lB9CmUCC = new URL(jEdit.getProperty("version-check.url"));
			InputStream QK9OdGe8 = lB9CmUCC.openStream();
			BufferedReader EUy99mW7 = new BufferedReader(new InputStreamReader(QK9OdGe8));
			String HQf6d3Vm;
			String AnOeEqUL = null;
			String VT9HUX3W = null;
			while ((HQf6d3Vm = EUy99mW7.readLine()) != null) {
				if (HQf6d3Vm.startsWith(".version"))
					AnOeEqUL = HQf6d3Vm.substring(8).trim();
				else if (HQf6d3Vm.startsWith(".build"))
					VT9HUX3W = HQf6d3Vm.substring(6).trim();
			}
			EUy99mW7.close();
			if (AnOeEqUL != null && VT9HUX3W != null) {
				if (jEdit.getBuild().compareTo(VT9HUX3W) < 0)
					newVersionAvailable(J4FkuUat, AnOeEqUL, lB9CmUCC);
				else {
					GUIUtilities.message(J4FkuUat, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException FYJwBXnA) {
			String[] N6ehXSEZ = { jEdit.getProperty("version-check.url"), FYJwBXnA.toString() };
			GUIUtilities.error(J4FkuUat, "read-error", N6ehXSEZ);
		}
		J4FkuUat.hideWaitCursor();
	}

}