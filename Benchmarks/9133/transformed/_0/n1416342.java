class n1416342 {
	public void run() {
		for (int SoWououw = 0; SoWououw < iClNumberOfCycles; SoWououw++) {
			try {
				long CkdLfGLk = System.currentTimeMillis();
				InputStream diNBpTBd = urlClDestinationURL.openStream();
				byte XCDfTcu8[] = new byte[1024];
				int H8tLAzxB;
				while ((H8tLAzxB = diNBpTBd.read(XCDfTcu8)) > 0)
					;
				diNBpTBd.close();
				long SJ856o1x = System.currentTimeMillis();
				Node.getLogger().write((SJ856o1x - CkdLfGLk) + " ms");
				avgCalls.update(SJ856o1x - CkdLfGLk);
				System.out.print("*");
				System.out.flush();
				calls.update();
			} catch (Exception gk9s49BR) {
				cntErrors.update();
				System.out.print("X");
				System.out.flush();
			}
		}
	}

}