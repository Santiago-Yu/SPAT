class n14259991 {
	private void sendLocal() throws Exception {
		if (validParameters()) {
			URL jy08Gn3L = new URL(storageUrlString);
			HttpURLConnection py2RvHaW = (HttpURLConnection) jy08Gn3L.openConnection();
			RequestUtils s7e5rqGe = new RequestUtils();
			s7e5rqGe.preRequestAddParameter("senderObj", "QuotaSender");
			s7e5rqGe.preRequestAddParameter("beanNumbers", new String().valueOf(quotaBeans.size()));
			for (int S1ltzvCO = 0; S1ltzvCO < quotaBeans.size(); S1ltzvCO++) {
				QuotaBean XEiWW5Kz = (QuotaBean) quotaBeans.get(S1ltzvCO);
				s7e5rqGe.preRequestAddParameter("" + S1ltzvCO + "#portalID", XEiWW5Kz.getPortalID());
				s7e5rqGe.preRequestAddParameter("" + S1ltzvCO + "#userID", XEiWW5Kz.getUserID());
				s7e5rqGe.preRequestAddParameter("" + S1ltzvCO + "#workflowID", XEiWW5Kz.getWorkflowID());
				s7e5rqGe.preRequestAddParameter("" + S1ltzvCO + "#runtimeID", XEiWW5Kz.getRuntimeID());
				s7e5rqGe.preRequestAddParameter("" + S1ltzvCO + "#plussQuotaSize",
						XEiWW5Kz.getPlussQuotaSize().toString());
			}
			s7e5rqGe.preRequestAddFile("zipFileName", "dummyZipFileName.zip");
			s7e5rqGe.createPostRequest();
			py2RvHaW.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + s7e5rqGe.getBoundary());
			py2RvHaW.setRequestMethod("POST");
			py2RvHaW.setDoOutput(true);
			py2RvHaW.setDoInput(true);
			try {
				py2RvHaW.connect();
				OutputStream yuKYHtqq = py2RvHaW.getOutputStream();
				byte[] Ndf8of6U = s7e5rqGe.getPreRequestStringBytes();
				yuKYHtqq.write(Ndf8of6U);
				yuKYHtqq.flush();
				yuKYHtqq.write(new String("dummyFile").getBytes());
				byte[] DnwsUsIi = s7e5rqGe.getPostRequestStringBytes();
				yuKYHtqq.write(DnwsUsIi);
				yuKYHtqq.flush();
				yuKYHtqq.close();
				BufferedReader tFs1ceTo = new BufferedReader(new InputStreamReader(py2RvHaW.getInputStream()));
				tFs1ceTo.readLine();
				tFs1ceTo.close();
				if (HttpURLConnection.HTTP_OK != py2RvHaW.getResponseCode()) {
					throw new Exception("response not HTTP_OK !");
				}
			} catch (Exception MZWqtCtg) {
				MZWqtCtg.printStackTrace();
				throw new Exception("Cannot connect to: " + storageUrlString, MZWqtCtg);
			}
		} else {
			throw new Exception("Not valid parameters: quotaBeans !");
		}
	}

}