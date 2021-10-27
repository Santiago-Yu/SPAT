class n9564133 {
	public void copy(File mPIATt4i, File jndSP2gS) throws IOException {
		FileInputStream Dr9SEBB6 = new FileInputStream(mPIATt4i);
		FileOutputStream M4EiL0wO = new FileOutputStream(new File(jndSP2gS, mPIATt4i.getName()));
		FileChannel FGanFiAg = Dr9SEBB6.getChannel();
		FileChannel xGL8GnhO = M4EiL0wO.getChannel();
		boolean S6KCRnfE = false;
		while (true) {
			int L68heW5b = FGanFiAg.read(theBuffer);
			if (L68heW5b != -1) {
				theBuffer.flip();
				xGL8GnhO.write(theBuffer);
				theBuffer.clear();
			} else
				break;
		}
		FGanFiAg.close();
		xGL8GnhO.close();
		Dr9SEBB6.close();
		M4EiL0wO.close();
		long tFdpALnE = System.currentTimeMillis();
	}

}