class n2878646 {
	@Test
	public void testRoundTrip() {
		try {
			URL HRTPf65u = new URL("http://localhost:8192/OMFHTTPJMSRoundtripService/");
			URLConnection BIFVOB5f = HRTPf65u.openConnection();
			BIFVOB5f.setDoOutput(true);
			OutputStreamWriter mye2TvdM = new OutputStreamWriter(BIFVOB5f.getOutputStream());
			mye2TvdM.write(testMessageHeader + testMessage);
			mye2TvdM.flush();
			BufferedReader lQV6Z5Gz = new BufferedReader(new InputStreamReader(BIFVOB5f.getInputStream()));
			String m2I10HVb;
			while ((m2I10HVb = lQV6Z5Gz.readLine()) != null) {
				logger.debug("Line: " + m2I10HVb);
			}
			mye2TvdM.close();
			lQV6Z5Gz.close();
		} catch (MalformedURLException nmsiqSYO) {
			nmsiqSYO.printStackTrace();
		} catch (IOException I6VvTXmU) {
			I6VvTXmU.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException s5oXnCVO) {
			logger.error("InterruptedException caught trying to sleep test: " + s5oXnCVO.getMessage());
		}
		boolean V6EC3TI3 = false;
		ArrayList<String> SeKXjjZY = testJMSListener.getReceivedMessages();
		for (Iterator<String> t3NP7h8S = SeKXjjZY.iterator(); t3NP7h8S.hasNext();) {
			String fwdRnPdE = (String) t3NP7h8S.next();
			logger.debug("String received: " + fwdRnPdE);
			if (testMessage.equals(fwdRnPdE))
				V6EC3TI3 = true;
		}
		assertTrue("Message should have been received", V6EC3TI3);
	}

}