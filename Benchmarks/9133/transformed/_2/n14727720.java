class n14727720 {
	private byte[] rawHttpPost(URL serverTimeStamp, Hashtable reqProperties, byte[] postData) {
		logger.info("[rawHttpPost.in]:: " + Arrays.asList(new Object[] { serverTimeStamp, reqProperties, postData }));
		URLConnection urlConn;
		DataOutputStream printout;
		DataInputStream input;
		byte[] responseBody = null;
		try {
			urlConn = serverTimeStamp.openConnection();
			urlConn.setDoInput(true);
			urlConn.setDoOutput(true);
			urlConn.setUseCaches(false);
			Iterator iter = reqProperties.entrySet().iterator();
			for (; iter.hasNext();) {
				Map.Entry entry = (Map.Entry) iter.next();
				urlConn.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
			}
			logger.debug("POSTing to: " + serverTimeStamp + " ...");
			printout = new DataOutputStream(urlConn.getOutputStream());
			printout.write(postData);
			printout.flush();
			printout.close();
			input = new DataInputStream(urlConn.getInputStream());
			byte[] buffer = new byte[1024];
			int bytesRead = 0;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			for (; (bytesRead = input.read(buffer, 0, buffer.length)) >= 0;) {
				baos.write(buffer, 0, bytesRead);
			}
			input.close();
			responseBody = baos.toByteArray();
		} catch (MalformedURLException me) {
			logger.warn("[rawHttpPost]:: ", me);
		} catch (IOException ioe) {
			logger.warn("[rawHttpPost]:: ", ioe);
		}
		return responseBody;
	}

}