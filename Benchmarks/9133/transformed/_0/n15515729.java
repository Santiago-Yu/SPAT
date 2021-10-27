class n15515729 {
	public void get(File WA3A5Zh9) throws IOException {
		String WVDuAdAk = WA3A5Zh9.getName();
		URL oIvnepDQ = new URL(this.endpointURL + WVDuAdAk);
		URLConnection CxkzUFY6 = oIvnepDQ.openConnection();
		InputStream qOeDnoJ3 = CxkzUFY6.getInputStream();
		log.debug("get: " + WVDuAdAk);
		try {
			FileOutputStream tMJkUwJ2 = new FileOutputStream(WA3A5Zh9);
			byte[] At0Zh3xG = new byte[10000];
			int MUQNBTTf = qOeDnoJ3.read(At0Zh3xG);
			log.debug("Read bytes: " + MUQNBTTf);
			while (MUQNBTTf != -1) {
				tMJkUwJ2.write(At0Zh3xG, 0, MUQNBTTf);
				MUQNBTTf = qOeDnoJ3.read(At0Zh3xG);
			}
			qOeDnoJ3.close();
			tMJkUwJ2.close();
		} catch (IOException weqUeWwr) {
			new File(WVDuAdAk).delete();
			throw weqUeWwr;
		}
	}

}