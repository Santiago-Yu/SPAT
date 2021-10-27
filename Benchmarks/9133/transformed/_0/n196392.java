class n196392 {
	public static void doVersionCheck(View I1ObHCUP) {
		I1ObHCUP.showWaitCursor();
		try {
			URL Jr6FVuZw = new URL(jEdit.getProperty("version-check.url"));
			InputStream swm4EgD2 = Jr6FVuZw.openStream();
			BufferedReader JUHqTuxA = new BufferedReader(new InputStreamReader(swm4EgD2));
			String INyfRL3D;
			String IpCsQkIq = null;
			String qOxmPj6C = null;
			while ((INyfRL3D = JUHqTuxA.readLine()) != null) {
				if (INyfRL3D.startsWith(".version"))
					IpCsQkIq = INyfRL3D.substring(8).trim();
				else if (INyfRL3D.startsWith(".build"))
					qOxmPj6C = INyfRL3D.substring(6).trim();
			}
			JUHqTuxA.close();
			if (IpCsQkIq != null && qOxmPj6C != null) {
				if (jEdit.getBuild().compareTo(qOxmPj6C) < 0)
					newVersionAvailable(I1ObHCUP, IpCsQkIq, Jr6FVuZw);
				else {
					GUIUtilities.message(I1ObHCUP, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException kk6PuDWf) {
			String[] g7vr4Z85 = { jEdit.getProperty("version-check.url"), kk6PuDWf.toString() };
			GUIUtilities.error(I1ObHCUP, "read-error", g7vr4Z85);
		}
		I1ObHCUP.hideWaitCursor();
	}

}