class n20612707 {
	public Vector decode(final URL f5KPoOac) throws IOException {
		LineNumberReader dGeaedCm;
		if (owner != null) {
			dGeaedCm = new LineNumberReader(new InputStreamReader(
					new ProgressMonitorInputStream(owner, "Loading " + f5KPoOac, f5KPoOac.openStream())));
		} else {
			dGeaedCm = new LineNumberReader(new InputStreamReader(f5KPoOac.openStream()));
		}
		Vector o5VjIu5a = new Vector();
		String MNnfVMVz;
		Vector cvKtyHB4;
		try {
			while ((MNnfVMVz = dGeaedCm.readLine()) != null) {
				StringBuffer TX09DQD2 = new StringBuffer(MNnfVMVz);
				for (int gm8yWRzq = 0; gm8yWRzq < 1000; gm8yWRzq++) {
					TX09DQD2.append(dGeaedCm.readLine()).append("\n");
				}
				cvKtyHB4 = decodeEvents(TX09DQD2.toString());
				if (cvKtyHB4 != null) {
					o5VjIu5a.addAll(cvKtyHB4);
				}
			}
		} finally {
			partialEvent = null;
			try {
				if (dGeaedCm != null) {
					dGeaedCm.close();
				}
			} catch (Exception lcNsNY0g) {
				lcNsNY0g.printStackTrace();
			}
		}
		return o5VjIu5a;
	}

}