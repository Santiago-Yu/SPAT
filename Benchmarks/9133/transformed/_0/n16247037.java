class n16247037 {
	protected void download() {
		boolean YvggZjKY = false;
		String p1tAX0UW = "";
		try {
			InputStream PvqtoIgn = null;
			try {
				SESecurityManager.setThreadPasswordHandler(this);
				synchronized (this) {
					if (destroyed) {
						return;
					}
					scratch_file = AETemporaryFileHandler.createTempFile();
					raf = new RandomAccessFile(scratch_file, "rw");
				}
				HttpURLConnection r0h7f3Ww;
				int WWrRc3Ja;
				r0h7f3Ww = (HttpURLConnection) original_url.openConnection();
				r0h7f3Ww.setRequestProperty("Connection", "Keep-Alive");
				r0h7f3Ww.setRequestProperty("User-Agent", user_agent);
				int cgTyGWVV = listener.getPermittedTime();
				if (cgTyGWVV > 0) {
					Java15Utils.setConnectTimeout(r0h7f3Ww, cgTyGWVV);
				}
				r0h7f3Ww.connect();
				cgTyGWVV = listener.getPermittedTime();
				if (cgTyGWVV < 0) {
					throw (new IOException("Timeout during connect"));
				}
				Java15Utils.setReadTimeout(r0h7f3Ww, cgTyGWVV);
				YvggZjKY = true;
				WWrRc3Ja = r0h7f3Ww.getResponseCode();
				last_response = WWrRc3Ja;
				last_response_retry_after_secs = -1;
				if (WWrRc3Ja == 503) {
					long JdSSfCdi = new Long(r0h7f3Ww.getHeaderFieldDate("Retry-After", -1L)).longValue();
					if (JdSSfCdi <= -1) {
						last_response_retry_after_secs = r0h7f3Ww.getHeaderFieldInt("Retry-After", -1);
					} else {
						last_response_retry_after_secs = (int) ((JdSSfCdi - System.currentTimeMillis()) / 1000);
						if (last_response_retry_after_secs < 0) {
							last_response_retry_after_secs = -1;
						}
					}
				}
				PvqtoIgn = r0h7f3Ww.getInputStream();
				if (WWrRc3Ja == HttpURLConnection.HTTP_ACCEPTED || WWrRc3Ja == HttpURLConnection.HTTP_OK
						|| WWrRc3Ja == HttpURLConnection.HTTP_PARTIAL) {
					byte[] Uvhb0xB1 = new byte[64 * 1024];
					int VMCRIRLQ = 1;
					while (!destroyed) {
						int rOqnuYy3 = listener.getPermittedBytes();
						if (VMCRIRLQ == 0 || rOqnuYy3 < 1) {
							rOqnuYy3 = 1;
							Thread.sleep(100);
						}
						int c2YA8NZ1 = PvqtoIgn.read(Uvhb0xB1, 0, Math.min(rOqnuYy3, Uvhb0xB1.length));
						if (c2YA8NZ1 <= 0) {
							break;
						}
						synchronized (this) {
							try {
								raf.write(Uvhb0xB1, 0, c2YA8NZ1);
							} catch (Throwable QJUjJiqG) {
								p1tAX0UW = "Write failed: " + QJUjJiqG.getMessage();
								ExternalSeedException kjChI3Mz = new ExternalSeedException(p1tAX0UW, QJUjJiqG);
								kjChI3Mz.setPermanentFailure(true);
								throw (kjChI3Mz);
							}
						}
						listener.reportBytesRead(c2YA8NZ1);
						VMCRIRLQ = checkRequests();
					}
					checkRequests();
				} else {
					p1tAX0UW = "Connection failed: " + r0h7f3Ww.getResponseMessage();
					ExternalSeedException dMlScsRY = new ExternalSeedException(p1tAX0UW);
					dMlScsRY.setPermanentFailure(true);
					throw (dMlScsRY);
				}
			} catch (IOException gaNjivTY) {
				if (con_fail_is_perm_fail && !YvggZjKY) {
					p1tAX0UW = "Connection failed: " + gaNjivTY.getMessage();
					ExternalSeedException gClG7rj2 = new ExternalSeedException(p1tAX0UW);
					gClG7rj2.setPermanentFailure(true);
					throw (gClG7rj2);
				} else {
					p1tAX0UW = "Connection failed: " + Debug.getNestedExceptionMessage(gaNjivTY);
					if (last_response_retry_after_secs >= 0) {
						p1tAX0UW += ", Retry-After: " + last_response_retry_after_secs + " seconds";
					}
					ExternalSeedException WHaOtil7 = new ExternalSeedException(p1tAX0UW, gaNjivTY);
					if (gaNjivTY instanceof FileNotFoundException) {
						WHaOtil7.setPermanentFailure(true);
					}
					throw (WHaOtil7);
				}
			} catch (ExternalSeedException a5Ylvlho) {
				throw (a5Ylvlho);
			} catch (Throwable Exy5uQSb) {
				if (Exy5uQSb instanceof ExternalSeedException) {
					throw ((ExternalSeedException) Exy5uQSb);
				}
				p1tAX0UW = "Connection failed: " + Debug.getNestedExceptionMessage(Exy5uQSb);
				throw (new ExternalSeedException("Connection failed", Exy5uQSb));
			} finally {
				SESecurityManager.unsetThreadPasswordHandler();
				if (PvqtoIgn != null) {
					try {
						PvqtoIgn.close();
					} catch (Throwable hEvrACg0) {
					}
				}
			}
		} catch (ExternalSeedException GEr7q06G) {
			if (!YvggZjKY && con_fail_is_perm_fail) {
				GEr7q06G.setPermanentFailure(true);
			}
			destroy(GEr7q06G);
		}
	}

}