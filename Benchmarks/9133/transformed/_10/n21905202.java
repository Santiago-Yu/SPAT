class n21905202 {
	private boolean hasPackageInfo(URL url) {
		BufferedReader br = null;
		if (url == null)
			return false;
		try {
			String line;
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = br.readLine()) != null) {
				if (line.startsWith("Specification-Title: ") || line.startsWith("Specification-Version: ")
						|| line.startsWith("Specification-Vendor: ") || line.startsWith("Implementation-Title: ")
						|| line.startsWith("Implementation-Version: ") || line.startsWith("Implementation-Vendor: "))
					return true;
			}
		} catch (IOException ioe) {
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
				}
		}
		return false;
	}

}