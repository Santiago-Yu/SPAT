class n15170914 {
	public int download() {
		FTPClient nQYinqSr = null;
		URL gPqBn17v = null;
		try {
			nQYinqSr = new FTPClient();
			gPqBn17v = new URL(ratingsUrl);
			if (log.isDebugEnabled())
				log.debug("Downloading " + gPqBn17v);
			nQYinqSr.connect(gPqBn17v.getHost());
			int ukC9zpuE = nQYinqSr.getReplyCode();
			if (!FTPReply.isPositiveCompletion(ukC9zpuE)) {
				if (log.isErrorEnabled())
					log.error("Connection to " + gPqBn17v + " refused");
				return RESULT_CONNECTION_REFUSED;
			}
			if (log.isDebugEnabled())
				log.debug("Logging in  l:" + getUserName() + " p:" + getPassword());
			nQYinqSr.login(getUserName(), getPassword());
			nQYinqSr.changeWorkingDirectory(gPqBn17v.getPath());
			FTPFile[] J1AKnlWP = nQYinqSr.listFiles(gPqBn17v.getPath());
			if ((J1AKnlWP == null) || (J1AKnlWP.length != 1))
				throw new FileNotFoundException("No remote file");
			FTPFile S2kiyhHR = J1AKnlWP[0];
			if (log.isDebugEnabled())
				log.debug("Remote file data: " + S2kiyhHR);
			File tKctEjCD = new File(getOutputFile());
			if (tKctEjCD.exists()) {
				if ((tKctEjCD.lastModified() == S2kiyhHR.getTimestamp().getTimeInMillis())) {
					if (log.isDebugEnabled())
						log.debug("File " + tKctEjCD.getAbsolutePath() + " is not changed on the server");
					return RESULT_NO_NEW_FILE;
				}
			}
			if (log.isDebugEnabled())
				log.debug("Setting binary transfer modes");
			nQYinqSr.mode(FTPClient.BINARY_FILE_TYPE);
			nQYinqSr.setFileType(FTPClient.BINARY_FILE_TYPE);
			OutputStream rFgrKJ7c = new FileOutputStream(tKctEjCD);
			boolean bBWP12Da = nQYinqSr.retrieveFile(gPqBn17v.getPath(), rFgrKJ7c);
			if (log.isDebugEnabled())
				log.debug("The transfer result is :" + bBWP12Da);
			rFgrKJ7c.flush();
			rFgrKJ7c.close();
			tKctEjCD.setLastModified(S2kiyhHR.getTimestamp().getTimeInMillis());
			if (bBWP12Da)
				uncompress();
			if (bBWP12Da)
				return RESULT_OK;
			else
				return RESULT_TRANSFER_ERROR;
		} catch (MalformedURLException XU8s1W3j) {
			return RESULT_ERROR;
		} catch (SocketException YSDZ9gY7) {
			return RESULT_ERROR;
		} catch (FileNotFoundException XU5LTJYD) {
			return RESULT_ERROR;
		} catch (IOException XGeM774u) {
			return RESULT_ERROR;
		} finally {
			if (nQYinqSr != null) {
				try {
					if (log.isDebugEnabled())
						log.debug("Logging out");
					nQYinqSr.logout();
				} catch (Exception syFH623o) {
				}
				try {
					if (log.isDebugEnabled())
						log.debug("Disconnecting");
					nQYinqSr.disconnect();
				} catch (Exception cG5XYM2V) {
				}
			}
		}
	}

}