class n8535390 {
	public static File doRequestPost(URL url, String req, String fName, boolean override) throws ArcImsException {
		URL virtualUrl = getVirtualRequestUrlFromUrlAndRequest(url, req);
		File f = null;
		if ((f = getPreviousDownloadedURL(virtualUrl, override)) == null) {
			File tempDirectory = new File(tempDirectoryPath);
			if (!tempDirectory.exists()) {
				tempDirectory.mkdir();
			}
			String nfName = normalizeFileName(fName);
			f = new File(tempDirectoryPath + "/" + nfName);
			f.deleteOnExit();
			logger.info("downloading '" + url.toString() + "' to: " + f.getAbsolutePath());
			try {
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
				conn.setRequestProperty("Content-length", "" + req.length());
				OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
				wr.write(req);
				wr.flush();
				byte[] buffer = new byte[1024 * 256];
				DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
				long readed = 0;
				InputStream is = conn.getInputStream();
				for (int i = is.read(buffer); i > 0; i = is.read(buffer)) {
					dos.write(buffer, 0, i);
					readed += i;
				}
				dos.close();
				is.close();
				wr.close();
				addDownloadedURL(virtualUrl, f.getAbsolutePath());
			} catch (ConnectException ce) {
				logger.error("Timed out error", ce);
				throw new ArcImsException("arcims_server_timeout");
			} catch (FileNotFoundException fe) {
				logger.error("FileNotFound Error", fe);
				throw new ArcImsException("arcims_server_error");
			} catch (IOException e) {
				logger.error("IO Error", e);
				throw new ArcImsException("arcims_server_error");
			}
		}
		if (!f.exists()) {
			downloadedFiles.remove(virtualUrl);
			f = doRequestPost(url, req, fName, override);
		}
		return f;
	}

}