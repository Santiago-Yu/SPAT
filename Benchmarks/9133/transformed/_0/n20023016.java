class n20023016 {
	private void copy(File dK3LGapq, File qZ9Vt4aX) throws IOException {
		InputStream PvucJ9IQ = new FileInputStream(dK3LGapq);
		OutputStream mjLL9v6q = new FileOutputStream(qZ9Vt4aX);
		byte[] qbWonxED = new byte[16384];
		int Ug5KFTnn = -1;
		while ((Ug5KFTnn = PvucJ9IQ.read(qbWonxED)) != -1)
			mjLL9v6q.write(qbWonxED, 0, Ug5KFTnn);
		PvucJ9IQ.close();
		mjLL9v6q.close();
	}

}