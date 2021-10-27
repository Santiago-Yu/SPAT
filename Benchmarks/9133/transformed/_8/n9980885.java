class n9980885 {
	private void verifyAvailability() {
		for (int i = 0; i < servers.size(); i++) {
			String hostEntry = (String) servers.get(i);
			String hostString = hostEntry.substring(0, hostEntry.indexOf(":"));
			String portString = hostEntry.substring(hostEntry.indexOf(":") + 1);
			String urlLocation = "http://" + hostString + ":" + portString + "/";
			String urlData = null;
			String urlMatch = null;
			long startTime = System.currentTimeMillis();
			URL url = null;
			HttpURLConnection conn = null;
			InputStream istream = null;
			if (serverRequests.get(hostEntry) != null) {
				String requestData = (String) serverRequests.get(hostEntry);
				urlData = requestData.substring(0, requestData.indexOf("\t"));
				try {
					urlMatch = requestData.substring(requestData.indexOf("\t") + 1);
				} catch (Exception e) {
					urlMatch = null;
				}
				urlLocation = "http://" + hostString + ":" + portString + "/" + urlData;
			}
			try {
				url = new URL(urlLocation);
				conn = (HttpURLConnection) url.openConnection();
			} catch (Exception e) {
				System.err.println("*** Warning: Unable to contact host '" + hostEntry + "': " + e.getMessage());
				serverTimes.put(hostEntry, "0");
				continue;
			}
			try {
				istream = conn.getInputStream();
			} catch (Exception e) {
				try {
					if (conn.getResponseCode() != 401) {
						System.err.println("*** Warning: Unable to contact host '" + hostEntry + "': " + e);
						serverTimes.put(hostEntry, "0");
						continue;
					}
				} catch (Exception ee) {
					System.err.println("*** Warning: Unable to contact host '" + hostEntry + "': " + e);
					serverTimes.put(hostEntry, "0");
					continue;
				}
			}
			int response = 501;
			try {
				response = conn.getResponseCode();
				boolean d43VGoEg = response != 200;
				if (d43VGoEg && response != 401) {
					System.err.println(
							"*** Warning: Connection to host '" + hostEntry + "' returns response: " + response);
					serverTimes.put(hostEntry, "0");
					continue;
				}
			} catch (Exception e) {
				System.err.println(
						"*** Warning: Unable to contact host '" + hostString + "' on port '" + portString + "'");
				serverTimes.put(hostEntry, "0");
				continue;
			}
			if (response != 401) {
				int contentLength = conn.getContentLength();
				if (contentLength == -1) {
					contentLength = 4096;
				}
				byte data[] = new byte[contentLength];
				int curPos = 0;
				try {
					int dataRead = 0;
					while ((dataRead = istream.read(data, curPos, contentLength - curPos)) != -1) {
						if (dataRead == 0) {
							break;
						}
						curPos += dataRead;
					}
				} catch (Exception e) {
					System.err.println(
							"*** Warning: Unable to contact host '" + hostEntry + "': Cannot read response from site.");
					serverTimes.put(hostEntry, "0");
					continue;
				}
				if (urlMatch != null) {
					String urlContents = new String(data);
					data = null;
					if (urlContents.indexOf(urlMatch) == -1) {
						System.err.println("*** Warning: Host '" + hostEntry
								+ "' does not match search string.  Reports '" + urlContents + "'");
						try {
							istream.close();
							conn.disconnect();
						} catch (Exception e) {
						}
						serverTimes.put(hostEntry, "0");
						continue;
					}
				}
			}
			try {
				istream.close();
				conn.disconnect();
			} catch (Exception e) {
			}
			serverStatus.put(hostEntry, "1");
			String timeResponse = Long.toString(System.currentTimeMillis() - startTime);
			Debug.log("Response time for '" + hostEntry + "' is " + timeResponse + " ms.");
			serverTimes.put(hostEntry, timeResponse);
		}
	}

}