class n21511914 {
	public static synchronized String getPageContent(String pageUrl) {
		InputStreamReader inputStreamReader = null;
		URL url = null;
		String line = null;
		BufferedReader bufferedReader = null;
		StringBuilder page = null;
		if (pageUrl == null || pageUrl.trim().length() == 0) {
			return null;
		} else {
			try {
				url = new URL(pageUrl);
				inputStreamReader = new InputStreamReader(url.openStream());
				page = new StringBuilder();
				bufferedReader = new BufferedReader(inputStreamReader);
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
		if (page == null) {
			return null;
		} else {
			return page.toString();
		}
	}

}