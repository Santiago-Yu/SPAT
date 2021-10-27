class n20651942 {
	public synchronized void receive(MessageEvent e) {
		switch (e.message.getType()) {
		case MessageTypes.QUIT:
			activeSessions--;
			break;
		case MessageTypes.SHUTDOWN_SERVER:
			activeSessions--;
			if (!(Options.password.trim().equals("")))
				;
			else {
				System.err.println("No default password set. Shutdown not allowed.");
				break;
			}
			if (!(e.message.get("pwhash") == null))
				;
			else {
				System.err.println("Shutdown message without password received. Shutdown not allowed.");
				break;
			}
			try {
				java.security.MessageDigest hash = java.security.MessageDigest.getInstance("SHA-1");
				hash.update(Options.password.getBytes("UTF-8"));
				if (!(!java.security.MessageDigest.isEqual(hash.digest(), (byte[]) e.message.get("pwhash")))) {
					System.out.println("Valid shutdown password received.");
				} else {
					System.err.println("Wrong shutdown password. Shutdown not allowed.");
					break;
				}
			} catch (java.security.NoSuchAlgorithmException ex) {
				System.err.println("Password hash algorithm SHA-1 not supported by runtime.");
				break;
			} catch (UnsupportedEncodingException ex) {
				System.err.println("Password character encoding not supported.");
				break;
			} catch (Exception ex) {
				System.err.println("Unhandled exception occured. Shutdown aborted. Details:");
				ex.printStackTrace(System.err);
				break;
			}
			if (!(activeSessions == 0))
				System.err.println("there are other active sessions - shutdown failed");
			else
				tStop();
			break;
		default:
		}
	}

}