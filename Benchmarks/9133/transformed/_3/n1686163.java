class n1686163 {
	private void sendRemoteFiles() throws Exception {
		if (!(validParameters())) {
			throw new Exception(
					"FilesDir not exist ! or not valid parameters: portalID, userID, workflowID, jobID, pidID, runtimeID !");
		} else {
			URL url = new URL(storageUrlString);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			RequestUtils requestUtils = new RequestUtils();
			requestUtils.preRequestAddParameter("senderObj", "FileSender");
			requestUtils.preRequestAddParameter("wfiType", "zen");
			requestUtils.preRequestAddParameter("portalID", this.portalID);
			requestUtils.preRequestAddParameter("userID", this.userID);
			requestUtils.preRequestAddParameter("workflowID", this.workflowID);
			requestUtils.preRequestAddParameter("jobID", this.jobID);
			requestUtils.preRequestAddParameter("pidID", this.pidID);
			requestUtils.preRequestAddParameter("runtimeID", this.runtimeID);
			requestUtils.preRequestAddParameter("copyhash", getCopyHashStr());
			String zipFileName = ZipUtils.getInstance().getUniqueZipFileName();
			requestUtils.preRequestAddFile("zipFileName", zipFileName);
			requestUtils.createPostRequest();
			httpURLConnection.setRequestProperty("Content-Type",
					"multipart/form-data; boundary=" + requestUtils.getBoundary());
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setDoInput(true);
			try {
				httpURLConnection.connect();
				OutputStream out = httpURLConnection.getOutputStream();
				byte[] preBytes = requestUtils.getPreRequestStringBytes();
				out.write(preBytes);
				out.flush();
				ZipUtils.getInstance().sendDirAllFilesToStream(sendFilesDir, out);
				byte[] postBytes = requestUtils.getPostRequestStringBytes();
				out.write(postBytes);
				out.flush();
				out.close();
				BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
				in.readLine();
				in.close();
				if (HttpURLConnection.HTTP_OK != httpURLConnection.getResponseCode()) {
					throw new Exception("response not HTTP_OK !");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Cannot connect to: " + storageUrlString, e);
			}
		}
	}

}