class n20651942 {
	public synchronized void receive(MessageEvent ArxAMIzV) {
		switch (ArxAMIzV.message.getType()) {
		case MessageTypes.QUIT:
			activeSessions--;
			break;
		case MessageTypes.SHUTDOWN_SERVER:
			activeSessions--;
			if (Options.password.trim().equals("")) {
				System.err.println("No default password set. Shutdown not allowed.");
				break;
			}
			if (ArxAMIzV.message.get("pwhash") == null) {
				System.err.println("Shutdown message without password received. Shutdown not allowed.");
				break;
			}
			try {
				java.security.MessageDigest TeSdwZET = java.security.MessageDigest.getInstance("SHA-1");
				TeSdwZET.update(Options.password.getBytes("UTF-8"));
				if (!java.security.MessageDigest.isEqual(TeSdwZET.digest(), (byte[]) ArxAMIzV.message.get("pwhash"))) {
					System.err.println("Wrong shutdown password. Shutdown not allowed.");
					break;
				} else {
					System.out.println("Valid shutdown password received.");
				}
			} catch (java.security.NoSuchAlgorithmException KkFneNm2) {
				System.err.println("Password hash algorithm SHA-1 not supported by runtime.");
				break;
			} catch (UnsupportedEncodingException qaZAPaI6) {
				System.err.println("Password character encoding not supported.");
				break;
			} catch (Exception S2LyFA3p) {
				System.err.println("Unhandled exception occured. Shutdown aborted. Details:");
				S2LyFA3p.printStackTrace(System.err);
				break;
			}
			if (activeSessions == 0)
				tStop();
			else
				System.err.println("there are other active sessions - shutdown failed");
			break;
		default:
		}
	}

}