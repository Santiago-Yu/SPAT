class n14259991 {
	private void sendLocal() throws Exception {
		if (!(validParameters())) {
			throw new Exception("Not valid parameters: quotaBeans !");
		} else {
			URL url = new URL(storageUrlString);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			RequestUtils requestUtils = new RequestUtils();
			requestUtils.preRequestAddParameter("senderObj", "QuotaSender");
			requestUtils.preRequestAddParameter("beanNumbers", new String().valueOf(quotaBeans.size()));
			for (int vPos = 0; vPos < quotaBeans.size(); vPos++) {
				QuotaBean bean = (QuotaBean) quotaBeans.get(vPos);
				requestUtils.preRequestAddParameter("" + vPos + "#portalID", bean.getPortalID());
				requestUtils.preRequestAddParameter("" + vPos + "#userID", bean.getUserID());
				requestUtils.preRequestAddParameter("" + vPos + "#workflowID", bean.getWorkflowID());
				requestUtils.preRequestAddParameter("" + vPos + "#runtimeID", bean.getRuntimeID());
				requestUtils.preRequestAddParameter("" + vPos + "#plussQuotaSize", bean.getPlussQuotaSize().toString());
			}
			requestUtils.preRequestAddFile("zipFileName", "dummyZipFileName.zip");
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
				out.write(new String("dummyFile").getBytes());
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