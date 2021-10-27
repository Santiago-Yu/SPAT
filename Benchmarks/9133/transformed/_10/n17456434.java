class n17456434 {
	public static void copyHttpContent(final String url, final File outputFile, UsernamePasswordCredentials creds)
			throws IOException {
		if (outputFile.exists() && outputFile.isDirectory())
			return;
		String outputFilePath = outputFile.getAbsolutePath();
		String outputFilePathTemp = outputFilePath + ".tmp";
		File tmpDownloadFile = FileUtil.createNewFile(outputFilePathTemp, false);
		if (!tmpDownloadFile.isFile())
			return;
		MyFileLock fl = FileUtil.tryLockTempFile(tmpDownloadFile, 1000, ShareConstants.connectTimeout);
		if (fl != null) {
			try {
				long lastModified = -1;
				long contentLength = -1;
				InputStream in = null;
				OutputStream out = null;
				HttpClient httpclient = createHttpClient(creds);
				try {
					HttpGet httpget = new HttpGet(url);
					HttpResponse response = httpclient.execute(httpget);
					StatusLine statusLine = response.getStatusLine();
					int status = statusLine.getStatusCode() / 100;
					if (status == 2) {
						HttpEntity entity = response.getEntity();
						if (entity != null) {
							Header lastModifiedHeader = response.getFirstHeader("Last-Modified");
							Header contentLengthHeader = response.getFirstHeader("Content-Length");
							if (contentLengthHeader != null) {
								contentLength = Integer.parseInt(contentLengthHeader.getValue());
							}
							if (lastModifiedHeader != null) {
								SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
								formatter.setDateFormatSymbols(new DateFormatSymbols(Locale.US));
								try {
									lastModified = formatter.parse(lastModifiedHeader.getValue()).getTime();
								} catch (ParseException e) {
									logger.error(e);
								}
							}
							out = new BufferedOutputStream(new FileOutputStream(tmpDownloadFile));
							in = entity.getContent();
							IOUtil.copyStreams(in, out);
						}
					}
				} catch (Exception e) {
					logger.error("Get HTTP File ERROR:" + url, e);
				} finally {
					IOUtil.close(in);
					IOUtil.close(out);
					httpclient.getConnectionManager().shutdown();
				}
				if (tmpDownloadFile.isFile()) {
					if ((contentLength == -1 && tmpDownloadFile.length() > 0)
							|| tmpDownloadFile.length() == contentLength) {
						IOUtil.copyFile(tmpDownloadFile, outputFile);
						if (lastModified > 0)
							outputFile.setLastModified(lastModified);
					}
				}
			} finally {
				tmpDownloadFile.delete();
				fl.release();
			}
		}
	}

}