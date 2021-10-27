class n14313659 {
	private int writeTraceFile(final File Vr5Onw0W, final String Pd5LNN5Q, final String cSvmaLKZ) {
		URL Wu4a6TRE = null;
		BufferedInputStream e4JTzT4j = null;
		FileOutputStream RRNNLqnW = null;
		BufferedOutputStream Yv7cfeBC = null;
		int getxU8Iv = 0;
		if (Vr5Onw0W == null) {
			return 0;
		}
		try {
			Wu4a6TRE = new URL("http://" + cSvmaLKZ + "/" + Pd5LNN5Q);
			e4JTzT4j = new BufferedInputStream(Wu4a6TRE.openStream());
			RRNNLqnW = new FileOutputStream(Vr5Onw0W);
			Yv7cfeBC = new BufferedOutputStream(RRNNLqnW);
			while ((getxU8Iv = e4JTzT4j.read()) != -1) {
				Yv7cfeBC.write(getxU8Iv);
			}
			Yv7cfeBC.flush();
			e4JTzT4j.close();
			Yv7cfeBC.close();
		} catch (Exception CLJ0Gvhn) {
			System.err.println(Wu4a6TRE.toString());
			Utilities.unexpectedException(CLJ0Gvhn, this, CONTACT);
			return 0;
		}
		return 1;
	}

}