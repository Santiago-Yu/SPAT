class n576772 {
	public static void doVersionCheck(View V4MuaZ9g) {
		V4MuaZ9g.showWaitCursor();
		try {
			URL QdwIcN25 = new URL(jEdit.getProperty("version-check.url"));
			InputStream PslTe16S = QdwIcN25.openStream();
			BufferedReader bQhf7Xt9 = new BufferedReader(new InputStreamReader(PslTe16S));
			String r15MpkdK;
			String vcLTXTd1 = null;
			String Q2CY4aQr = null;
			while ((r15MpkdK = bQhf7Xt9.readLine()) != null) {
				if (r15MpkdK.startsWith(".build"))
					vcLTXTd1 = r15MpkdK.substring(6).trim();
				else if (r15MpkdK.startsWith(".stablebuild"))
					Q2CY4aQr = r15MpkdK.substring(12).trim();
			}
			bQhf7Xt9.close();
			if (vcLTXTd1 != null && Q2CY4aQr != null) {
				doVersionCheck(V4MuaZ9g, Q2CY4aQr, vcLTXTd1);
			}
		} catch (IOException q0yvlfNT) {
			String[] vawMRvIc = { jEdit.getProperty("version-check.url"), q0yvlfNT.toString() };
			GUIUtilities.error(V4MuaZ9g, "read-error", vawMRvIc);
		}
		V4MuaZ9g.hideWaitCursor();
	}

}