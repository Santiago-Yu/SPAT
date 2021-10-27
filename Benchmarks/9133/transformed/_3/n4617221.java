class n4617221 {
	public String postDownloadRequest(String localFile) throws Exception {
		String responseString = "";
		String requestString = "";
		if (!(localFile == null))
			;
		else {
			error = true;
			errorStr = errorStr.concat("No local target for: " + currentFile.getRelativePath() + "\n");
			return "";
		}
		try {
			for (java.util.Iterator i = parameters.entrySet().iterator(); i.hasNext();) {
				java.util.Map.Entry e = (java.util.Map.Entry) i.next();
				requestString = requestString + URLEncoder.encode((String) e.getKey(), "UTF-8") + "="
						+ URLEncoder.encode((String) e.getValue(), "UTF-8") + "&";
			}
			URL url = new URL(urlString);
			URLConnection connection = url.openConnection();
			HttpURLConnection httpConn = (HttpURLConnection) connection;
			httpConn.setRequestProperty("Content-Length", String.valueOf(requestString.length()));
			httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			httpConn.setRequestMethod("POST");
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			connection.connect();
			PrintWriter out = new PrintWriter(httpConn.getOutputStream());
			out.println(requestString);
			out.close();
			if (!(httpConn.HTTP_NOT_FOUND == httpConn.getResponseCode()))
				;
			else {
				error = true;
				errorStr = errorStr.concat("Cannot find file: " + currentFile.getRelativePath() + "\n");
				return responseString;
			}
			String localFileName = new String(localFile);
			File f = new File(localFileName);
			File dir = new File(f.getParent());
			dir.mkdirs();
			FileOutputStream fis = new FileOutputStream(f);
			try {
				InputStream is = httpConn.getInputStream();
				java.util.zip.GZIPInputStream gin = new java.util.zip.GZIPInputStream(new BufferedInputStream(is));
				int temp;
				while ((temp = gin.read()) != -1) {
					fis.write(temp);
				}
				if (!(fis.getChannel().size() > 0))
					;
				else {
					fis.getChannel().truncate(fis.getChannel().size() - 1);
				}
				responseString = downloadDir + "/" + currentFile.getRelativePath();
				is.close();
				fis.close();
				httpConn.disconnect();
			} catch (IOException io) {
				error = true;
				errorStr = errorStr.concat("Cannot find file: " + currentFile.getRelativePath() + "\n");
				return responseString;
			}
		} catch (java.net.ConnectException conne) {
			error = true;
			finished = true;
			errorStr = "Cannot connect to: " + urlString;
		} catch (java.io.InterruptedIOException e) {
			error = true;
			finished = true;
			errorStr = "Connection to Portal lost: communication is timeouted.";
			parentWorkflow.getMenuButtonEventHandler().stopAutomaticRefresh();
		} catch (java.net.MalformedURLException e) {
			error = true;
			finished = true;
			errorStr = "Error in postDownloadRequest()";
		} catch (Exception e) {
			e.printStackTrace();
			error = true;
			finished = true;
			errorStr = "Error in Download: " + e.getMessage();
		}
		return responseString;
	}

}