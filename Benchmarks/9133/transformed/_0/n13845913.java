class n13845913 {
	public synchronized boolean copyTmpDataFile(String tfTs1Nbs) throws IOException {
		if (tmpDataOutput != null)
			tmpDataOutput.close();
		tmpDataOutput = null;
		if (tmpDataFile == null)
			return false;
		File hQZ1QPOT = new File(tfTs1Nbs);
		if (hQZ1QPOT.exists())
			hQZ1QPOT.delete();
		FileInputStream Vw5Dz4V8 = new FileInputStream(tmpDataFile);
		FileOutputStream ZSALjou6 = new FileOutputStream(hQZ1QPOT);
		byte[] GLmlSZYA = new byte[4096];
		int Ted99Q3S;
		while ((Ted99Q3S = Vw5Dz4V8.read(GLmlSZYA)) != -1)
			ZSALjou6.write(GLmlSZYA, 0, Ted99Q3S);
		Vw5Dz4V8.close();
		ZSALjou6.close();
		return true;
	}

}