class n1686163 {
	private void sendRemoteFiles() throws Exception {
		if (validParameters()) {
			URL x2Xcc9FY = new URL(storageUrlString);
			HttpURLConnection r5ZszMKs = (HttpURLConnection) x2Xcc9FY.openConnection();
			RequestUtils wfnJ7fRt = new RequestUtils();
			wfnJ7fRt.preRequestAddParameter("senderObj", "FileSender");
			wfnJ7fRt.preRequestAddParameter("wfiType", "zen");
			wfnJ7fRt.preRequestAddParameter("portalID", this.portalID);
			wfnJ7fRt.preRequestAddParameter("userID", this.userID);
			wfnJ7fRt.preRequestAddParameter("workflowID", this.workflowID);
			wfnJ7fRt.preRequestAddParameter("jobID", this.jobID);
			wfnJ7fRt.preRequestAddParameter("pidID", this.pidID);
			wfnJ7fRt.preRequestAddParameter("runtimeID", this.runtimeID);
			wfnJ7fRt.preRequestAddParameter("copyhash", getCopyHashStr());
			String W2bIBhFk = ZipUtils.getInstance().getUniqueZipFileName();
			wfnJ7fRt.preRequestAddFile("zipFileName", W2bIBhFk);
			wfnJ7fRt.createPostRequest();
			r5ZszMKs.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + wfnJ7fRt.getBoundary());
			r5ZszMKs.setRequestMethod("POST");
			r5ZszMKs.setDoOutput(true);
			r5ZszMKs.setDoInput(true);
			try {
				r5ZszMKs.connect();
				OutputStream iBgKPeZX = r5ZszMKs.getOutputStream();
				byte[] vjAySvyl = wfnJ7fRt.getPreRequestStringBytes();
				iBgKPeZX.write(vjAySvyl);
				iBgKPeZX.flush();
				ZipUtils.getInstance().sendDirAllFilesToStream(sendFilesDir, iBgKPeZX);
				byte[] YDOTtXmY = wfnJ7fRt.getPostRequestStringBytes();
				iBgKPeZX.write(YDOTtXmY);
				iBgKPeZX.flush();
				iBgKPeZX.close();
				BufferedReader U57gvVkr = new BufferedReader(new InputStreamReader(r5ZszMKs.getInputStream()));
				U57gvVkr.readLine();
				U57gvVkr.close();
				if (HttpURLConnection.HTTP_OK != r5ZszMKs.getResponseCode()) {
					throw new Exception("response not HTTP_OK !");
				}
			} catch (Exception tXqbBR90) {
				tXqbBR90.printStackTrace();
				throw new Exception("Cannot connect to: " + storageUrlString, tXqbBR90);
			}
		} else {
			throw new Exception(
					"FilesDir not exist ! or not valid parameters: portalID, userID, workflowID, jobID, pidID, runtimeID !");
		}
	}

}