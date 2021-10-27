class n562437 {
	public static void doVersionCheck(View J1U8edjf) {
		J1U8edjf.showWaitCursor();
		try {
			URL ieGT8O6T = new URL(jEdit.getProperty("version-check.url"));
			InputStream x3XniQzS = ieGT8O6T.openStream();
			BufferedReader i1QCmfOP = new BufferedReader(new InputStreamReader(x3XniQzS));
			String AbxRSRbI;
			String DqYBJyfS = null;
			String iRbJfucc = null;
			while ((AbxRSRbI = i1QCmfOP.readLine()) != null) {
				if (AbxRSRbI.startsWith(".build"))
					DqYBJyfS = AbxRSRbI.substring(6).trim();
				else if (AbxRSRbI.startsWith(".stablebuild"))
					iRbJfucc = AbxRSRbI.substring(12).trim();
			}
			i1QCmfOP.close();
			if (DqYBJyfS != null && iRbJfucc != null) {
				doVersionCheck(J1U8edjf, iRbJfucc, DqYBJyfS);
			}
		} catch (IOException gqX5Vqy7) {
			String[] GTUJ68WI = { jEdit.getProperty("version-check.url"), gqX5Vqy7.toString() };
			GUIUtilities.error(J1U8edjf, "read-error", GTUJ68WI);
		}
		J1U8edjf.hideWaitCursor();
	}

}