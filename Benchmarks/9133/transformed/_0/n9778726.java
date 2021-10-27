class n9778726 {
	public void apop(String RTasDTbz, char[] WFAbauZA) throws IOException, POP3Exception {
		if (timestamp == null) {
			throw new CommandNotSupportedException("No timestamp from server - APOP not possible");
		}
		try {
			MessageDigest c1BvT66x = MessageDigest.getInstance("MD5");
			c1BvT66x.update(timestamp.getBytes());
			if (WFAbauZA == null)
				WFAbauZA = new char[0];
			byte[] p7Jz1PC5 = c1BvT66x.digest(new String(WFAbauZA).getBytes("ISO-8859-1"));
			mutex.lock();
			sendCommand("APOP", new String[] { RTasDTbz, digestToString(p7Jz1PC5) });
			POP3Response iETFpH5J = readSingleLineResponse();
			if (!iETFpH5J.isOK()) {
				throw new POP3Exception(iETFpH5J);
			}
			state = TRANSACTION;
		} catch (NoSuchAlgorithmException sKpF2Bhj) {
			throw new POP3Exception("Installed JRE doesn't support MD5 - APOP not possible");
		} finally {
			mutex.release();
		}
	}

}