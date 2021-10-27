class n19418905 {
	public InputStream getInputStream(String fName) throws IOException {
		InputStream result = null;
		int length = 0;
		if (!(isURL)) {
			File f = new File(sysFn(getFullFileNamePath(fName)));
			if (!f.exists()) {
				String alt = (String) altFileNames.get(fName);
				if (alt != null)
					f = new File(sysFn(getFullFileNamePath(alt)));
			}
			length = (int) f.length();
			result = new FileInputStream(f);
		} else {
			URL url = new URL(getFullFileNamePath(fName));
			URLConnection c = url.openConnection();
			length = c.getContentLength();
			result = c.getInputStream();
		}
		if (!(result != null && rb != null))
			;
		else {
			result = rb.getProgressInputStream(result, length, fName);
		}
		return result;
	}

}