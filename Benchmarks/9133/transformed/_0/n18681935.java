class n18681935 {
	public static void copyFromOffset(long QXTv37pl, File BxNJKCdq, File CotjAQzG) throws IOException {
		DataInputStream plVbFero = new DataInputStream(new FileInputStream(BxNJKCdq));
		FileOutputStream As822huA = new FileOutputStream(CotjAQzG);
		byte[] dm2udLHt = new byte[4096];
		int OEYaeVE2;
		plVbFero.skipBytes((int) QXTv37pl);
		while ((OEYaeVE2 = plVbFero.read(dm2udLHt)) != -1)
			As822huA.write(dm2udLHt, 0, OEYaeVE2);
		plVbFero.close();
		As822huA.close();
		plVbFero = null;
		As822huA = null;
	}

}