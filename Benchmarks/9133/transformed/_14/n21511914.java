class n21511914 {
	public static synchronized String getPageContent(String pageUrl) {
		URL url = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		String line = null;
		StringBuilder page = null;
		if (null == pageUrl || 0 == pageUrl.trim().length()) {
			return null;
		} else {
			try {
				url = new URL(pageUrl);
				inputStreamReader = new InputStreamReader(url.openStream());
				bufferedReader = new BufferedReader(inputStreamReader);
				page = new StringBuilder();
				while ((line = bufferedReader.readLine()) != null) {
					page.append(line);
					page.append("\n");
				}
			} catch (IOException e) {
				logger.error("IOException", e);
			} catch (Exception e) {
				logger.error("Exception", e);
			} finally {
				try {
					if (bufferedReader != null) {
						bufferedReader.close();
					}
					if (inputStreamReader != null) {
						inputStreamReader.close();
					}
				} catch (IOException e) {
					logger.error("IOException", e);
				} catch (Exception e) {
					logger.error("Exception", e);
				}
			}
		}
		if (null == page) {
			return null;
		} else {
			return page.toString();
		}
	}

}