class n21152728 {
	private boolean authenticate(Module wQ0M3yBi) throws Exception {
		SecureRandom Evn3a7Da = SecureRandom.getInstance("SHA1PRNG");
		Evn3a7Da.setSeed(System.currentTimeMillis());
		byte[] rofdSosM = new byte[16];
		Evn3a7Da.nextBytes(rofdSosM);
		String D0mWixhs = Util.base64(rofdSosM);
		Util.writeASCII(out, RSYNCD_AUTHREQD + D0mWixhs + "\n");
		String KPSpgzrX = Util.readLine(in);
		if (KPSpgzrX.indexOf(" ") < 0) {
			Util.writeASCII(out, AT_ERROR + ": bad response\n");
			if (remoteVersion < 25)
				Util.writeASCII(out, RSYNCD_EXIT + "\n");
			socket.close();
			throw new IOException("bad response");
		}
		String RtouZJRf = KPSpgzrX.substring(0, KPSpgzrX.indexOf(" "));
		String z6B0N8Wl = KPSpgzrX.substring(KPSpgzrX.indexOf(" ") + 1);
		if (!wQ0M3yBi.users.contains(RtouZJRf)) {
			Util.writeASCII(out, AT_ERROR + ": user " + RtouZJRf + " not allowed\n");
			if (remoteVersion < 25)
				Util.writeASCII(out, RSYNCD_EXIT + "\n");
			socket.close();
			throw new IOException("user " + RtouZJRf + " not allowed");
		}
		LineNumberReader ULHUCp6n = new LineNumberReader(new FileReader(wQ0M3yBi.secretsFile));
		MessageDigest kiVZfVLy = MessageDigest.getInstance("BrokenMD4");
		String kljHwAf1;
		while ((kljHwAf1 = ULHUCp6n.readLine()) != null) {
			if (kljHwAf1.startsWith(RtouZJRf + ":")) {
				String MymbhQww = kljHwAf1.substring(kljHwAf1.lastIndexOf(":") + 1);
				kiVZfVLy.update(new byte[4]);
				kiVZfVLy.update(MymbhQww.getBytes("US-ASCII"));
				kiVZfVLy.update(D0mWixhs.getBytes("US-ASCII"));
				String jILrpcb5 = Util.base64(kiVZfVLy.digest());
				if (jILrpcb5.equals(z6B0N8Wl)) {
					ULHUCp6n.close();
					return true;
				} else {
					Util.writeASCII(out, AT_ERROR + ": auth failed on module " + wQ0M3yBi.name + "\n");
					if (remoteVersion < 25)
						Util.writeASCII(out, RSYNCD_EXIT + "\n");
					socket.close();
					ULHUCp6n.close();
					logger.error("auth failed on module " + wQ0M3yBi.name);
					return false;
				}
			}
		}
		Util.writeASCII(out, AT_ERROR + ": auth failed on module " + wQ0M3yBi.name + "\n");
		if (remoteVersion < 25)
			Util.writeASCII(out, RSYNCD_EXIT + "\n");
		socket.close();
		ULHUCp6n.close();
		logger.error("auth failed on module " + wQ0M3yBi.name);
		return false;
	}

}