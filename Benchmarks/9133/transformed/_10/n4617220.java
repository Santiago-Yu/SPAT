class n4617220 {
	public String postFileRequest(String fileName, String internalFileName) throws Exception {
		String responseString = null;
		status = STATUS_INIT;
		if (isThreadStopped) {
			return "";
		}
		String requestStringPostFix = new String("");
		status = STATUS_UPLOADING;
		String requestString = new String("");
		if (isThreadStopped) {
			return "";
		}
		int contentLength = 0, c = 0, counter = 0;
		try {
			for (java.util.Iterator i = parameters.entrySet().iterator(); i.hasNext();) {
				java.util.Map.Entry e = (java.util.Map.Entry) i.next();
				requestString = requestString + "-----------------------------7d338a374003ea\n"
						+ "Content-Disposition: form-data; name=\"" + (String) e.getKey() + "\"\n\n"
						+ (String) e.getValue() + "\n\n";
			}
			URL url = new URL(urlString);
			URLConnection connection = url.openConnection();
			requestString = requestString + "-----------------------------7d338a374003ea\n"
					+ "Content-Disposition: form-data; name=\"" + internalFileName + "\"; filename=\"" + fileName
					+ "\"\n" + "Content-Type: text/plain\n\n";
			HttpURLConnection httpConn = (HttpURLConnection) connection;
			FileInputStream fis = null;
			requestStringPostFix = requestStringPostFix + "\n\n" + "-----------------------------7d338a374003ea\n"
					+ "\n";
			String str = null;
			try {
				fis = new FileInputStream(fileName);
				int fileSize = fis.available();
				contentLength = requestString.length() + requestStringPostFix.length() + fileSize;
				httpConn.setRequestProperty("Content-Length", String.valueOf(contentLength));
				httpConn.setRequestProperty("Content-Type",
						"multipart/form-data; boundary=---------------------------7d338a374003ea");
				httpConn.setRequestMethod("POST");
				httpConn.setDoOutput(true);
				httpConn.setDoInput(true);
				try {
					connection.connect();
				} catch (ConnectException ec2) {
					error = true;
					finished = true;
					errorStr = "Cannot connect to: " + urlString;
					System.out.println("Cannot connect to:" + urlString);
				} catch (java.io.InterruptedIOException e) {
					error = true;
					finished = true;
					errorStr = "Connection to Portal lost: communication is timeouted.";
					parentWorkflow.getMenuButtonEventHandler().stopAutomaticRefresh();
				} catch (IllegalStateException ei) {
					error = true;
					finished = true;
					errorStr = "IllegalStateException: " + ei.getMessage();
				}
				byte[] toTransfer = requestString.getBytes("UTF-8");
				OutputStream out = httpConn.getOutputStream();
				int count;
				for (int i = 0; i < toTransfer.length; i++) {
					out.write(toTransfer[i]);
				}
				int zBUFFER = 8 * 1024;
				setUploadProgress(fileSize, counter);
				GZIPOutputStream zos = new GZIPOutputStream(out);
				byte data[] = new byte[zBUFFER];
				while ((count = fis.read(data, 0, zBUFFER)) != -1) {
					if (isThreadStopped) {
						return "";
					}
					zos.write(data, 0, count);
					setUploadProgress(fileSize, counter);
					counter += count;
				}
				zos.flush();
				zos.finish();
				setUploadProgress(fileSize, counter);
				toTransfer = requestStringPostFix.getBytes("UTF-8");
				for (int i = 0; i < toTransfer.length; i++) {
					out.write(toTransfer[i]);
				}
				out.close();
			} catch (IOException e) {
				finished = true;
				error = true;
				errorStr = "Error in Uploading file: " + fileName;
			} finally {
				try {
					fis.close();
				} catch (IOException e2) {
				}
			}
			InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
			String temp;
			BufferedReader br = new BufferedReader(isr);
			String tempResponse = "";
			while ((temp = br.readLine()) != null) {
				tempResponse = tempResponse + temp + "\n";
				if (isThreadStopped) {
					return "";
				}
				setDecompressStatusAtUpload(temp);
			}
			responseString = tempResponse;
			isr.close();
		} catch (ConnectException ec) {
			error = true;
			finished = true;
			errorStr = "Cannot connect to: " + urlString + "\nServer is not responding.";
		} catch (java.io.InterruptedIOException e) {
			error = true;
			finished = true;
			errorStr = "Connection to Portal lost: communication is timeouted.";
			parentWorkflow.getMenuButtonEventHandler().stopAutomaticRefresh();
		} catch (IOException e2) {
			finished = true;
			error = true;
			errorStr = "IOError in postFileRequest: " + e2.getMessage();
		} catch (Exception e4) {
			finished = true;
			error = true;
			errorStr = "Error while trying to communicate the server: " + e4.getMessage();
		}
		return responseString;
	}

}