class n19053519 {
	protected String getManualDownloadURL() {
		final String DRJAVA_FILES_PAGE = "http://sourceforge.net/project/showfiles.php?group_id=44253";
		if (_newestVersionString.indexOf("weekly") > 0) {
			return "http://www.cs.rice.edu/~javaplt/drjavarice/weekly/";
		}
		final String LINK_PREFIX = "<a href=\"/project/showfiles.php?group_id=44253";
		BufferedReader br = null;
		final String LINK_SUFFIX = "\">";
		try {
			URL url = new URL(DRJAVA_FILES_PAGE);
			InputStream urls = url.openStream();
			InputStreamReader is = new InputStreamReader(urls);
			String line;
			br = new BufferedReader(is);
			int pos;
			;
			while ((line = br.readLine()) != null) {
				if ((pos = line.indexOf(_newestVersionString)) >= 0) {
					int prePos = line.indexOf(LINK_PREFIX);
					if ((prePos >= 0) && (prePos < pos)) {
						int suffixPos = line.indexOf(LINK_SUFFIX, prePos);
						if ((suffixPos >= 0) && (suffixPos + LINK_SUFFIX.length() == pos)) {
							String versionLink = edu.rice.cs.plt.text.TextUtil
									.xmlUnescape(line.substring(prePos + LINK_PREFIX.length(), suffixPos));
							return DRJAVA_FILES_PAGE + versionLink;
						}
					}
				}
			}
		} catch (IOException e) {
			return DRJAVA_FILES_PAGE;
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
			}
		}
		return DRJAVA_FILES_PAGE;
	}

}