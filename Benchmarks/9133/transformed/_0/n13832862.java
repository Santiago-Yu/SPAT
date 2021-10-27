class n13832862 {
	public static void main(String ePdqSVLx[]) {
		Connection TWJVijzg;
		if (ePdqSVLx.length != 2) {
			System.out.println("Usage: Shutdown <host> <password>");
			System.exit(0);
		}
		try {
			TWJVijzg = new Connection(ePdqSVLx[0]);
			TWJVijzg.tStart();
			Message UwUlkNeu = new Message(MessageTypes.SHUTDOWN_SERVER);
			java.security.MessageDigest w74qRQct = java.security.MessageDigest.getInstance("SHA-1");
			w74qRQct.update(ePdqSVLx[1].getBytes("UTF-8"));
			UwUlkNeu.put("pwhash", w74qRQct.digest());
			TWJVijzg.send(UwUlkNeu);
			TWJVijzg.join();
		} catch (java.io.UnsupportedEncodingException rc6ufeGo) {
			System.err.println("Password character encoding not supported.");
		} catch (java.io.IOException ZW10M5eT) {
			System.out.println(ZW10M5eT.toString());
		} catch (java.security.NoSuchAlgorithmException SRATOoGT) {
			System.out.println("Password hash algorithm SHA-1 not supported by runtime.");
		} catch (InterruptedException R2xGYWhA) {
		}
		System.exit(0);
	}

}