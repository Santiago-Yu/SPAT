class n22418839 {
	public void handleHandshake(Packet2Handshake K92P9pg3) {
		boolean koIPfaSw = true;
		String XfMgNAh3 = K92P9pg3.username;
		if (XfMgNAh3 == null || XfMgNAh3.trim().length() == 0) {
			koIPfaSw = false;
		} else if (!XfMgNAh3.equals("-")) {
			try {
				Long.parseLong(XfMgNAh3, 16);
			} catch (NumberFormatException jJshGgBt) {
				koIPfaSw = false;
			}
		}
		if (!koIPfaSw) {
			netManager.networkShutdown("disconnect.genericReason",
					new Object[] { "The server responded with an invalid server key" });
		} else if (K92P9pg3.username.equals("-")) {
			addToSendQueue(new Packet1Login(mc.session.username, 29));
		} else {
			try {
				URL tBnNhyKu = new URL(
						(new StringBuilder()).append("http://session.minecraft.net/game/joinserver.jsp?user=")
								.append(mc.session.username).append("&sessionId=").append(mc.session.sessionId)
								.append("&serverId=").append(K92P9pg3.username).toString());
				BufferedReader b0pJBAFn = new BufferedReader(new InputStreamReader(tBnNhyKu.openStream()));
				String v8uPhKW2 = b0pJBAFn.readLine();
				b0pJBAFn.close();
				if (v8uPhKW2.equalsIgnoreCase("ok")) {
					addToSendQueue(new Packet1Login(mc.session.username, 29));
				} else {
					netManager.networkShutdown("disconnect.loginFailedInfo", new Object[] { v8uPhKW2 });
				}
			} catch (Exception uhF07J2w) {
				uhF07J2w.printStackTrace();
				netManager.networkShutdown("disconnect.genericReason", new Object[] { (new StringBuilder())
						.append("Internal client error: ").append(uhF07J2w.toString()).toString() });
			}
		}
	}

}