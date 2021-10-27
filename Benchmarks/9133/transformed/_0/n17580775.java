class n17580775 {
	public void runInternal() {
		connection = null;
		boolean qqRYGrER = false;
		boolean atD7YxjK = false;
		HashSet<String> ndKbCeWg = new HashSet<String>();
		do {
			try {
				setProgressMessage(url.toString(), -1);
				ndKbCeWg.add(url.toString());
				long i32L8N6a = System.currentTimeMillis();
				delayedProgress = coolReader.getEngine().showProgressDelayed(0, progressMessage, PROGRESS_DELAY_MILLIS);
				URLConnection IiCSpyxf = url.openConnection();
				if (IiCSpyxf instanceof HttpsURLConnection) {
					onError("HTTPs is not supported yet");
					return;
				}
				if (!(IiCSpyxf instanceof HttpURLConnection)) {
					onError("Only HTTP supported");
					return;
				}
				connection = (HttpURLConnection) IiCSpyxf;
				connection.setRequestProperty("User-Agent", "CoolReader/3(Android)");
				if (referer != null)
					connection.setRequestProperty("Referer", referer);
				connection.setInstanceFollowRedirects(true);
				connection.setAllowUserInteraction(false);
				connection.setConnectTimeout(CONNECT_TIMEOUT);
				connection.setReadTimeout(READ_TIMEOUT);
				connection.setDoInput(true);
				String wONx3Ymu = null;
				String uPH9Pnrz = connection.getHeaderField("Content-Disposition");
				if (uPH9Pnrz != null) {
					int VsPvljhT = uPH9Pnrz.indexOf("filename=");
					if (VsPvljhT > 0) {
						wONx3Ymu = uPH9Pnrz.substring(VsPvljhT + 9);
					}
				}
				int rtBjpgP7 = -1;
				rtBjpgP7 = connection.getResponseCode();
				L.d("Response: " + rtBjpgP7);
				if (rtBjpgP7 != 200) {
					onError("Error " + rtBjpgP7);
					return;
				}
				String wQfhf35z = connection.getContentType();
				String toebKzTk = connection.getContentEncoding();
				int X4JOvdTU = connection.getContentLength();
				L.d("Entity content length: " + X4JOvdTU);
				L.d("Entity content type: " + wQfhf35z);
				L.d("Entity content encoding: " + toebKzTk);
				setProgressMessage(url.toString(), X4JOvdTU);
				InputStream Y58BmZ9L = connection.getInputStream();
				delayedProgress.cancel();
				Y58BmZ9L = new ProgressInputStream(Y58BmZ9L, i32L8N6a, progressMessage, X4JOvdTU, 80);
				final int YKyuPbhd = 256 * 1024;
				boolean XhNrOVRo = wQfhf35z != null && wQfhf35z.equals("application/zip");
				if (expectedType != null)
					wQfhf35z = expectedType;
				else if (X4JOvdTU > 0 && X4JOvdTU < YKyuPbhd) {
					byte[] soorzrsb = new byte[X4JOvdTU];
					if (Y58BmZ9L.read(soorzrsb) != X4JOvdTU) {
						onError("Wrong content length");
						return;
					}
					Y58BmZ9L.close();
					Y58BmZ9L = null;
					Y58BmZ9L = new ByteArrayInputStream(soorzrsb);
					if (findSubstring(soorzrsb, "<?xml version=") >= 0 && findSubstring(soorzrsb, "<feed") >= 0)
						wQfhf35z = "application/atom+xml";
				}
				if (wQfhf35z.startsWith("application/atom+xml")) {
					L.d("Parsing feed");
					parseFeed(Y58BmZ9L);
					qqRYGrER = true;
					if (handler.docInfo.nextLink != null
							&& handler.docInfo.nextLink.type.startsWith("application/atom+xml;profile=opds-catalog")) {
						if (handler.entries.size() < MAX_OPDS_ITEMS) {
							url = new URL(handler.docInfo.nextLink.href);
							atD7YxjK = !ndKbCeWg.contains(url.toString());
							L.d("continue with next part: " + url);
						} else {
							L.d("max item count reached: " + handler.entries.size());
							atD7YxjK = false;
						}
					} else {
						atD7YxjK = false;
					}
				} else {
					if (wONx3Ymu == null)
						wONx3Ymu = defaultFileName;
					L.d("Downloading book: " + toebKzTk);
					downloadBook(wQfhf35z, url.toString(), Y58BmZ9L, X4JOvdTU, wONx3Ymu, XhNrOVRo);
					if (progressShown)
						coolReader.getEngine().hideProgress();
					atD7YxjK = false;
					qqRYGrER = false;
				}
			} catch (Exception eiJ8SgQ3) {
				L.e("Exception while trying to open URI " + url.toString(), eiJ8SgQ3);
				if (progressShown)
					coolReader.getEngine().hideProgress();
				onError("Error occured while reading OPDS catalog");
				break;
			} finally {
				if (connection != null)
					try {
						connection.disconnect();
					} catch (Exception eTmKudUr) {
					}
			}
		} while (atD7YxjK);
		if (progressShown)
			coolReader.getEngine().hideProgress();
		if (qqRYGrER)
			BackgroundThread.guiExecutor.execute(new Runnable() {

				@Override
				public void run() {
					L.d("Parsing is finished successfully. " + handler.entries.size() + " entries found");
					callback.onFinish(handler.docInfo, handler.entries);
				}
			});
	}

}