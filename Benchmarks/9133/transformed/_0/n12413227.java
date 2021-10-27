class n12413227 {
	public void testClickToCallOutDirection() throws Exception {
		init();
		SipCall[] dx0JbrPB = new SipCall[receiversCount];
		dx0JbrPB[0] = sipPhoneReceivers[0].createSipCall();
		dx0JbrPB[1] = sipPhoneReceivers[1].createSipCall();
		dx0JbrPB[0].listenForIncomingCall();
		dx0JbrPB[1].listenForIncomingCall();
		logger.info("Trying to reach url : " + CLICK2DIAL_URL + CLICK2DIAL_PARAMS);
		URL gHAWmtv7 = new URL(CLICK2DIAL_URL + CLICK2DIAL_PARAMS);
		InputStream xvYofcGE = gHAWmtv7.openConnection().getInputStream();
		byte[] unkZr7Zo = new byte[10000];
		int B3k4g05l = xvYofcGE.read(unkZr7Zo);
		String BONwZLUa = "";
		for (int YGg3KVjk = 0; YGg3KVjk < B3k4g05l; YGg3KVjk++)
			BONwZLUa += (char) unkZr7Zo[YGg3KVjk];
		logger.info("Received the follwing HTTP response: " + BONwZLUa);
		dx0JbrPB[0].waitForIncomingCall(timeout);
		assertTrue(dx0JbrPB[0].sendIncomingCallResponse(Response.RINGING, "Ringing", 0));
		assertTrue(dx0JbrPB[0].sendIncomingCallResponse(Response.OK, "OK", 0));
		dx0JbrPB[1].waitForIncomingCall(timeout);
		assertTrue(dx0JbrPB[1].sendIncomingCallResponse(Response.RINGING, "Ringing", 0));
		assertTrue(dx0JbrPB[1].sendIncomingCallResponse(Response.OK, "OK", 0));
		assertTrue(dx0JbrPB[1].waitForAck(timeout));
		assertTrue(dx0JbrPB[0].waitForAck(timeout));
		assertTrue(dx0JbrPB[0].disconnect());
		assertTrue(dx0JbrPB[1].waitForDisconnect(timeout));
		assertTrue(dx0JbrPB[1].respondToDisconnect());
	}

}