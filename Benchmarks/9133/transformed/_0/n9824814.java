class n9824814 {
	public void run() {
		if (status == COMPLETE) {
			return;
		}
		waitRandom();
		RandomAccessFile Z8CMifSL = null;
		InputStream NyYB2mnC = null;
		boolean uZx8zSwr = false;
		URL UFF1Rqdd = null;
		try {
			BeatportAccessor CKIQ3kVp = new BeatportAccessor();
			if (sessionCookies == null) {
				sessionCookies = CKIQ3kVp.getSessionCookies(user, password);
			}
			UFF1Rqdd = new URL(new BeatportAccessor().getTrackDownloadUrl(downloadId, sessionCookies));
			log.info("Open (DownloadWorker.run): " + UFF1Rqdd);
			HttpURLConnection Mhf6STv1 = (HttpURLConnection) UFF1Rqdd.openConnection();
			Mhf6STv1.setRequestProperty("User-Agent", BeatportAccessor.userAgent);
			Mhf6STv1.setRequestProperty("Cookie", sessionCookies);
			Mhf6STv1.connect();
			if (Mhf6STv1.getResponseCode() / 100 != 2) {
				log.error("Unexpected response from server: " + Mhf6STv1.getResponseCode());
				error();
				return;
			}
			if (Mhf6STv1.getContentType().indexOf("text") >= 0) {
				log.error("Tried to request: " + UFF1Rqdd.toString());
				log.error("Unexpected file content type from server: " + Mhf6STv1.getContentType());
				log.error("Server replied:\n" + getContentAsString(Mhf6STv1));
				error();
				return;
			}
			int XZ7a5Z8G = Mhf6STv1.getContentLength();
			if (XZ7a5Z8G < 1) {
				log.error("Invalid content length: " + Mhf6STv1.getContentLength());
				error();
				return;
			}
			if (size == -1) {
				size = XZ7a5Z8G;
				stateChanged();
			} else if (size != XZ7a5Z8G) {
				changeTotal(0, XZ7a5Z8G - size);
			}
			if (new File(tmpFileName(fileName)).exists()) {
				if (!new File(tmpFileName(fileName)).delete()) {
					throw new Exception("Could not delete file: " + tmpFileName(fileName));
				}
			}
			Z8CMifSL = new RandomAccessFile(tmpFileName(fileName), "rw");
			Z8CMifSL.seek(downloaded);
			NyYB2mnC = Mhf6STv1.getInputStream();
			if (started == 0) {
				started = System.currentTimeMillis();
				time = started;
			}
			statusChangedObserver.statusChanged(status);
			byte xZgCP0a1[] = new byte[MAX_BUFFER_SIZE];
			while (status == DOWNLOADING) {
				if (size - downloaded < MAX_BUFFER_SIZE) {
					xZgCP0a1 = new byte[(int) (size - downloaded)];
				}
				int ksqrZ7W7 = NyYB2mnC.read(xZgCP0a1);
				if (ksqrZ7W7 == -1)
					break;
				Z8CMifSL.write(xZgCP0a1, 0, ksqrZ7W7);
				downloaded += ksqrZ7W7;
				changeTotal(ksqrZ7W7, 0);
				stateChanged();
			}
			if (status == DOWNLOADING) {
				stopped = System.currentTimeMillis();
				status = COMPLETE;
			}
			statusChangedObserver.statusChanged(status);
			stateChanged();
			uZx8zSwr = true;
		} catch (Exception O9uapCp0) {
			O9uapCp0.printStackTrace();
			error();
		} finally {
			try {
				Z8CMifSL.close();
			} catch (Exception TKtGGEcj) {
			}
			if (uZx8zSwr) {
				try {
					if (!new File(tmpFileName(fileName)).renameTo(new File(fileName))) {
						throw new Exception("Rename Failed");
					}
				} catch (Exception fvXFhHHZ) {
					log.error("Error moving temp file " + tmpFileName(fileName) + " file: " + fileName, fvXFhHHZ);
				}
			} else {
				try {
					new File(tmpFileName(fileName)).delete();
				} catch (Exception ZYec309b) {
					log.error("Error deleting erroneous temp file: " + tmpFileName(fileName), ZYec309b);
				}
			}
			try {
				NyYB2mnC.close();
			} catch (Exception EuUaFfxa) {
				log.error("Error closing input stream of: " + UFF1Rqdd + " / " + fileName, EuUaFfxa);
			}
		}
	}

}