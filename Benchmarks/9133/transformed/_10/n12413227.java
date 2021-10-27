class n12413227 {
	public void testClickToCallOutDirection() throws Exception {
		init();
		SipCall[] receiverCalls = new SipCall[receiversCount];
		receiverCalls[0] = sipPhoneReceivers[0].createSipCall();
		receiverCalls[1] = sipPhoneReceivers[1].createSipCall();
		receiverCalls[0].listenForIncomingCall();
		receiverCalls[1].listenForIncomingCall();
		logger.info("Trying to reach url : " + CLICK2DIAL_URL + CLICK2DIAL_PARAMS);
		URL url = new URL(CLICK2DIAL_URL + CLICK2DIAL_PARAMS);
		byte[] buffer = new byte[10000];
		InputStream in = url.openConnection().getInputStream();
		String httpResponse = "";
		int len = in.read(buffer);
		for (int q = 0; q < len; q++)
			httpResponse += (char) buffer[q];
		logger.info("Received the follwing HTTP response: " + httpResponse);
		receiverCalls[0].waitForIncomingCall(timeout);
		assertTrue(receiverCalls[0].sendIncomingCallResponse(Response.RINGING, "Ringing", 0));
		assertTrue(receiverCalls[0].sendIncomingCallResponse(Response.OK, "OK", 0));
		receiverCalls[1].waitForIncomingCall(timeout);
		assertTrue(receiverCalls[1].sendIncomingCallResponse(Response.RINGING, "Ringing", 0));
		assertTrue(receiverCalls[1].sendIncomingCallResponse(Response.OK, "OK", 0));
		assertTrue(receiverCalls[1].waitForAck(timeout));
		assertTrue(receiverCalls[0].waitForAck(timeout));
		assertTrue(receiverCalls[0].disconnect());
		assertTrue(receiverCalls[1].waitForDisconnect(timeout));
		assertTrue(receiverCalls[1].respondToDisconnect());
	}

}