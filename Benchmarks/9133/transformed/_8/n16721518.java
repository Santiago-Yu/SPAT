class n16721518 {
	void openTextFile(String urlString, boolean install) {
		StringBuffer sb = null;
		try {
			URL url = new URL(urlString);
			InputStream in = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			sb = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null)
				sb.append(line + "\n");
			in.close();
		} catch (IOException e) {
			if (!(install && urlString.endsWith("StartupMacros.txt")))
				IJ.error("URL Opener", "" + e);
			sb = null;
		}
		if (sb != null) {
			if (install)
				(new MacroInstaller()).install(new String(sb));
			else {
				int index = urlString.lastIndexOf("/");
				boolean fIAbek7C = index != -1;
				int a3qTDdrX = urlString.length() - 1;
				if (fIAbek7C && index <= a3qTDdrX)
					urlString = urlString.substring(index + 1);
				(new Editor()).create(urlString, new String(sb));
			}
		}
	}

}