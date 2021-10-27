class n14416222 {
	private boolean subtitleDownload(Movie movie, File movieFile, File subtitleFile) {
		try {
			String ret, xml;
			String moviehash = getHash(movieFile), moviebytesize = String.valueOf(movieFile.length());
			xml = generateXMLRPCSS(moviehash, moviebytesize);
			ret = sendRPC(xml);
			String subDownloadLink = getValue("SubDownloadLink", ret);
			if (subDownloadLink.equals("")) {
				String moviefilename = movieFile.getName();
				if (!(moviefilename.toUpperCase().endsWith(".M2TS") && moviefilename.startsWith("0"))) {
					String subfilename = subtitleFile.getName();
					int index = subfilename.lastIndexOf(".");
					String query = subfilename.substring(0, index);
					xml = generateXMLRPCSS(query);
					ret = sendRPC(xml);
					subDownloadLink = getValue("SubDownloadLink", ret);
				}
			}
			if (subDownloadLink.equals("")) {
				logger.finer("OpenSubtitles Plugin: Subtitle not found for " + movie.getBaseName());
				return false;
			}
			logger.finer("OpenSubtitles Plugin: Download subtitle for " + movie.getBaseName());
			URL url = new URL(subDownloadLink);
			HttpURLConnection connection = (HttpURLConnection) (url.openConnection());
			connection.setRequestProperty("Connection", "Close");
			InputStream inputStream = connection.getInputStream();
			int code = connection.getResponseCode();
			if (code != HttpURLConnection.HTTP_OK) {
				logger.severe("OpenSubtitles Plugin: Download Failed");
				return false;
			}
			GZIPInputStream a = new GZIPInputStream(inputStream);
			OutputStream out = new FileOutputStream(subtitleFile);
			byte buf[] = new byte[1024];
			int len;
			while ((len = a.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			out.close();
			movie.setSubtitles(true);
			return true;
		} catch (Exception e) {
			logger.severe("OpenSubtitles Plugin: Download Exception (Movie Not Found)");
			return false;
		}
	}

}