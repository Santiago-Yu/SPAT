class n841792 {
	public static void doVersionCheck(View JTqaY64m) {
		JTqaY64m.showWaitCursor();
		try {
			URL eo7CTqZL = new URL(jEdit.getProperty("version-check.url"));
			InputStream LKC8Ip7Q = eo7CTqZL.openStream();
			BufferedReader bMAYJu72 = new BufferedReader(new InputStreamReader(LKC8Ip7Q));
			String AWLU6kdV;
			String dVLuRtAR = null;
			String JiuGxZML = null;
			while ((AWLU6kdV = bMAYJu72.readLine()) != null) {
				if (AWLU6kdV.startsWith(".build"))
					dVLuRtAR = AWLU6kdV.substring(6).trim();
				else if (AWLU6kdV.startsWith(".stablebuild"))
					JiuGxZML = AWLU6kdV.substring(12).trim();
			}
			bMAYJu72.close();
			if (dVLuRtAR != null && JiuGxZML != null) {
				doVersionCheck(JTqaY64m, JiuGxZML, dVLuRtAR);
			}
		} catch (IOException AUpFt7bd) {
			String[] FaHRvtqR = { jEdit.getProperty("version-check.url"), AUpFt7bd.toString() };
			GUIUtilities.error(JTqaY64m, "read-error", FaHRvtqR);
		}
		JTqaY64m.hideWaitCursor();
	}

}