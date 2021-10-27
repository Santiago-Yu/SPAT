class n2878646 {
	@Test
	public void testRoundTrip() {
		try {
			URL url = new URL("http://localhost:8192/OMFHTTPJMSRoundtripService/");
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(testMessageHeader + testMessage);
			wr.flush();
			String line;
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				logger.debug("Line: " + line);
			}
			wr.close();
			rd.close();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		boolean messageReceived = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			logger.error("InterruptedException caught trying to sleep test: " + e.getMessage());
		}
		ArrayList<String> messages = testJMSListener.getReceivedMessages();
		for (Iterator<String> iterator = messages.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			logger.debug("String received: " + string);
			if (testMessage.equals(string))
				messageReceived = true;
		}
		assertTrue("Message should have been received", messageReceived);
	}

}