class n19682242 {
	private boolean getRemoteFiles() throws Exception {
		boolean B0nig7a8 = false;
		int PE5xeyn9 = 0;
		URL aApu87ze = new URL(storageUrlString);
		HttpURLConnection AOoFIArV = (HttpURLConnection) aApu87ze.openConnection();
		RequestUtils y2T7ODNM = new RequestUtils();
		y2T7ODNM.preRequestAddParameter("senderObj", "FileGetter");
		y2T7ODNM.preRequestAddParameter("wfiType", "zen");
		y2T7ODNM.preRequestAddParameter("portalID", this.portalID);
		y2T7ODNM.preRequestAddParameter("userID", this.userID);
		addRenameFileParameters(y2T7ODNM);
		y2T7ODNM.createPostRequest();
		AOoFIArV.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + y2T7ODNM.getBoundary());
		AOoFIArV.setRequestMethod("POST");
		AOoFIArV.setDoOutput(true);
		AOoFIArV.setDoInput(true);
		try {
			AOoFIArV.connect();
			OutputStream mt5FP2fe = AOoFIArV.getOutputStream();
			byte[] YHKcX8ck = y2T7ODNM.getPreRequestStringBytes();
			mt5FP2fe.write(YHKcX8ck);
			mt5FP2fe.flush();
			byte[] fFNX18QV = y2T7ODNM.getPostRequestStringBytes();
			mt5FP2fe.write(fFNX18QV);
			mt5FP2fe.flush();
			mt5FP2fe.close();
			PE5xeyn9 = AOoFIArV.getResponseCode();
			if (HttpURLConnection.HTTP_OK == PE5xeyn9) {
				B0nig7a8 = true;
				InputStream EfvXeju5 = AOoFIArV.getInputStream();
				ZipUtils.getInstance().getFilesFromStream(EfvXeju5, getFilesDir);
				EfvXeju5.close();
			}
			if (PE5xeyn9 == 500) {
				B0nig7a8 = false;
			}
			if (PE5xeyn9 == 560) {
				B0nig7a8 = false;
				throw new Exception("Server Side Remote Exeption !!! respCode = (" + PE5xeyn9 + ")");
			}
		} catch (Exception DTdN5OVI) {
			DTdN5OVI.printStackTrace();
			throw new Exception("Cannot connect to: " + storageUrlString, DTdN5OVI);
		}
		return B0nig7a8;
	}

}