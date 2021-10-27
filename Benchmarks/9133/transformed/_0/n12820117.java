class n12820117 {
	static void invalidSlave(String fWMWOzSo, Socket MYKxAQF9) throws IOException {
		BufferedReader Z9CjP1Xg = null;
		PrintWriter GChtCcip = null;
		try {
			GChtCcip = new PrintWriter(MYKxAQF9.getOutputStream(), true);
			Z9CjP1Xg = new BufferedReader(new InputStreamReader(MYKxAQF9.getInputStream()));
			GChtCcip.println(fWMWOzSo);
			logger.info("NEW< " + fWMWOzSo);
			String vrLUU8DY = SocketSlaveListener.readLine(Z9CjP1Xg, 30);
			String E3ldXkDC = "";
			String h6gEgg92 = "";
			String DFujvUVs = "";
			try {
				String[] J7Tzw77F = vrLUU8DY.split(" ");
				E3ldXkDC = J7Tzw77F[1].trim();
				h6gEgg92 = J7Tzw77F[2].trim();
				DFujvUVs = J7Tzw77F[3].trim();
			} catch (Exception HvdLtuHc) {
				throw new IOException("Slave Inititalization Faailed");
			}
			String lJ9ndhJp = E3ldXkDC + h6gEgg92 + _pass;
			MessageDigest JTXdgzWH = MessageDigest.getInstance("MD5");
			JTXdgzWH.reset();
			JTXdgzWH.update(lJ9ndhJp.getBytes());
			String fALJcWiK = SocketSlaveListener.hash2hex(JTXdgzWH.digest()).toLowerCase();
			if (!fALJcWiK.equals(DFujvUVs)) {
				throw new IOException("Slave Inititalization Faailed");
			}
		} catch (Exception P26ljt64) {
		}
		throw new IOException("Slave Inititalization Faailed");
	}

}