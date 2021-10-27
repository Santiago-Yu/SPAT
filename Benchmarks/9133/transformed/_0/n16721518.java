class n16721518 {
	void openTextFile(String rZjPzXRY, boolean MMkDVkr5) {
		StringBuffer DzQgCKad = null;
		try {
			URL TeTvFtO3 = new URL(rZjPzXRY);
			InputStream ZSKuB13U = TeTvFtO3.openStream();
			BufferedReader GyCYuaRR = new BufferedReader(new InputStreamReader(ZSKuB13U));
			DzQgCKad = new StringBuffer();
			String RByL6Ev5;
			while ((RByL6Ev5 = GyCYuaRR.readLine()) != null)
				DzQgCKad.append(RByL6Ev5 + "\n");
			ZSKuB13U.close();
		} catch (IOException AGhUJUTj) {
			if (!(MMkDVkr5 && rZjPzXRY.endsWith("StartupMacros.txt")))
				IJ.error("URL Opener", "" + AGhUJUTj);
			DzQgCKad = null;
		}
		if (DzQgCKad != null) {
			if (MMkDVkr5)
				(new MacroInstaller()).install(new String(DzQgCKad));
			else {
				int OZ2T0rL7 = rZjPzXRY.lastIndexOf("/");
				if (OZ2T0rL7 != -1 && OZ2T0rL7 <= rZjPzXRY.length() - 1)
					rZjPzXRY = rZjPzXRY.substring(OZ2T0rL7 + 1);
				(new Editor()).create(rZjPzXRY, new String(DzQgCKad));
			}
		}
	}

}