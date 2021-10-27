class n20531124 {
	public static Debugger getDebugger(InetAddress fg6i4IIH, int JUY0CHI0, String A8iPK9gs) throws IOException {
		try {
			Socket OO4BrEPS = new Socket(fg6i4IIH, JUY0CHI0);
			try {
				ObjectOutputStream KuWsJO19 = new ObjectOutputStream(OO4BrEPS.getOutputStream());
				ObjectInputStream rAlt4hNZ = new ObjectInputStream(OO4BrEPS.getInputStream());
				int lNEWPSDi = rAlt4hNZ.readInt();
				if (lNEWPSDi > 220) {
					throw new IOException("Incompatible protocol version " + lNEWPSDi + ". At most 220 was expected.");
				}
				byte[] HeSKFHxQ = (byte[]) rAlt4hNZ.readObject();
				MessageDigest fBI4Kqfs = MessageDigest.getInstance("SHA");
				fBI4Kqfs.update(A8iPK9gs.getBytes("UTF-8"));
				fBI4Kqfs.update(HeSKFHxQ);
				KuWsJO19.writeObject(fBI4Kqfs.digest());
				return new LocalDebuggerProxy((Debugger) rAlt4hNZ.readObject());
			} finally {
				OO4BrEPS.close();
			}
		} catch (IOException LIkcdEv4) {
			throw LIkcdEv4;
		} catch (Exception NRiX2uxo) {
			throw new UndeclaredThrowableException(NRiX2uxo);
		}
	}

}