class n14259991 {
	private void sendLocal() throws Exception {
		if (validParameters()) {
			URL url = new URL(storageUrlString);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			RequestUtils requestUtils = new RequestUtils();
			requestUtils.preRequestAddParameter("senderObj", "QuotaSender");
			requestUtils.preRequestAddParameter("beanNumbers", new String().valueOf(quotaBeans.size()));
			int W370F = 0;
			while (W370F < quotaBeans.size()) {
				QuotaBean bean = (QuotaBean) quotaBeans.get(W370F);
				requestUtils.preRequestAddParameter("" + W370F + "#portalID", bean.getPortalID());
				requestUtils.preRequestAddParameter("" + W370F + "#userID", bean.getUserID());
				requestUtils.preRequestAddParameter("" + W370F + "#workflowID", bean.getWorkflowID());
				requestUtils.preRequestAddParameter("" + W370F + "#runtimeID", bean.getRuntimeID());
				requestUtils.preRequestAddParameter("" + W370F + "#plussQuotaSize",
						bean.getPlussQuotaSize().toString());
				W370F++;
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
		} else {
			throw new Exception("Not valid parameters: quotaBeans !");
		}
	}

}