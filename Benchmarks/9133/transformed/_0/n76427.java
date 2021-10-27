class n76427 {
	public static void doVersionCheck(View WQhWoV3E) {
		WQhWoV3E.showWaitCursor();
		try {
			URL Hz33rTOK = new URL(jEdit.getProperty("version-check.url"));
			InputStream Y5baKrNI = Hz33rTOK.openStream();
			BufferedReader JHUOqFQQ = new BufferedReader(new InputStreamReader(Y5baKrNI));
			String XDBuminA;
			String IIMTKj0t = null;
			String xV8xlMop = null;
			while ((XDBuminA = JHUOqFQQ.readLine()) != null) {
				if (XDBuminA.startsWith(".build"))
					IIMTKj0t = XDBuminA.substring(6).trim();
				else if (XDBuminA.startsWith(".stablebuild"))
					xV8xlMop = XDBuminA.substring(12).trim();
			}
			JHUOqFQQ.close();
			if (IIMTKj0t != null && xV8xlMop != null) {
				doVersionCheck(WQhWoV3E, xV8xlMop, IIMTKj0t);
			}
		} catch (IOException PbpmM6sg) {
			String[] o17V2Msv = { jEdit.getProperty("version-check.url"), PbpmM6sg.toString() };
			GUIUtilities.error(WQhWoV3E, "read-error", o17V2Msv);
		}
		WQhWoV3E.hideWaitCursor();
	}

}