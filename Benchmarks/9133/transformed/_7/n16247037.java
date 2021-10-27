class n16247037 {
	protected void download() {
		boolean connected = false;
		String outcome = "";
		try {
			InputStream is = null;
			try {
				SESecurityManager.setThreadPasswordHandler(this);
				synchronized (this) {
					if (destroyed) {
						return;
					}
					scratch_file = AETemporaryFileHandler.createTempFile();
					raf = new RandomAccessFile(scratch_file, "rw");
				}
				HttpURLConnection connection;
				int response;
				connection = (HttpURLConnection) original_url.openConnection();
				connection.setRequestProperty("Connection", "Keep-Alive");
				connection.setRequestProperty("User-Agent", user_agent);
				int time_remaining = listener.getPermittedTime();
				if (time_remaining > 0) {
					Java15Utils.setConnectTimeout(connection, time_remaining);
				}
				connection.connect();
				time_remaining = listener.getPermittedTime();
				if (time_remaining < 0) {
					throw (new IOException("Timeout during connect"));
				}
				Java15Utils.setReadTimeout(connection, time_remaining);
				connected = true;
				response = connection.getResponseCode();
				last_response = response;
				last_response_retry_after_secs = -1;
				if (response == 503) {
					long retry_after_date = new Long(connection.getHeaderFieldDate("Retry-After", -1L)).longValue();
					if (retry_after_date <= -1) {
						last_response_retry_after_secs = connection.getHeaderFieldInt("Retry-After", -1);
					} else {
						last_response_retry_after_secs = (int) ((retry_after_date - System.currentTimeMillis()) / 1000);
						if (last_response_retry_after_secs < 0) {
							last_response_retry_after_secs = -1;
						}
					}
				}
				is = connection.getInputStream();
				if (response == HttpURLConnection.HTTP_ACCEPTED || response == HttpURLConnection.HTTP_OK
						|| response == HttpURLConnection.HTTP_PARTIAL) {
					byte[] buffer = new byte[64 * 1024];
					int requests_outstanding = 1;
					while (!destroyed) {
						int permitted = listener.getPermittedBytes();
						if (requests_outstanding == 0 || permitted < 1) {
							permitted = 1;
							Thread.sleep(100);
						}
						int len = is.read(buffer, 0, Math.min(permitted, buffer.length));
						if (len <= 0) {
							break;
						}
						synchronized (this) {
							try {
								raf.write(buffer, 0, len);
							} catch (Throwable e) {
								outcome = "Write failed: " + e.getMessage();
								ExternalSeedException error = new ExternalSeedException(outcome, e);
								error.setPermanentFailure(true);
								throw (error);
							}
						}
						listener.reportBytesRead(len);
						requests_outstanding = checkRequests();
					}
					checkRequests();
				} else {
					outcome = "Connection failed: " + connection.getResponseMessage();
					ExternalSeedException error = new ExternalSeedException(outcome);
					error.setPermanentFailure(true);
					throw (error);
				}
			} catch (IOException e) {
				if (con_fail_is_perm_fail && !connected) {
					outcome = "Connection failed: " + e.getMessage();
					ExternalSeedException error = new ExternalSeedException(outcome);
					error.setPermanentFailure(true);
					throw (error);
				} else {
					outcome = "Connection failed: " + Debug.getNestedExceptionMessage(e);
					if (last_response_retry_after_secs >= 0) {
						outcome = outcome + (", Retry-After: " + last_response_retry_after_secs + " seconds");
					}
					ExternalSeedException excep = new ExternalSeedException(outcome, e);
					if (e instanceof FileNotFoundException) {
						excep.setPermanentFailure(true);
					}
					throw (excep);
				}
			} catch (ExternalSeedException e) {
				throw (e);
			} catch (Throwable e) {
				if (e instanceof ExternalSeedException) {
					throw ((ExternalSeedException) e);
				}
				outcome = "Connection failed: " + Debug.getNestedExceptionMessage(e);
				throw (new ExternalSeedException("Connection failed", e));
			} finally {
				SESecurityManager.unsetThreadPasswordHandler();
				if (is != null) {
					try {
						is.close();
					} catch (Throwable e) {
					}
				}
			}
		} catch (ExternalSeedException e) {
			if (!connected && con_fail_is_perm_fail) {
				e.setPermanentFailure(true);
			}
			destroy(e);
		}
	}

}