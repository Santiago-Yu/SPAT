class n6037296 {
	public void copyRes(long Y8BzD8Nf, long Aaod3M9Y) throws Exception {
		File ICSJsLbO = new File(this.getResDir(Y8BzD8Nf));
		File iMrrHnCW = new File(this.getResDir(Aaod3M9Y));
		this.recursiveDir(iMrrHnCW);
		if (ICSJsLbO.isDirectory()) {
			File[] tBzYf9SO = ICSJsLbO.listFiles();
			if (tBzYf9SO != null) {
				for (int CXXxIMwp = 0; CXXxIMwp < tBzYf9SO.length; CXXxIMwp++) {
					if (tBzYf9SO[CXXxIMwp].isFile()) {
						File gU1KwTAJ = new File(iMrrHnCW.getAbsolutePath() + "/" + tBzYf9SO[CXXxIMwp].getName());
						if (!gU1KwTAJ.exists()) {
							gU1KwTAJ.createNewFile();
							BufferedOutputStream r3OkwJIp = new BufferedOutputStream(new FileOutputStream(gU1KwTAJ));
							BufferedInputStream tnvEnvpH = new BufferedInputStream(
									new FileInputStream(tBzYf9SO[CXXxIMwp]));
							int jG0VHmEI;
							while ((jG0VHmEI = tnvEnvpH.read()) != -1) {
								r3OkwJIp.write(jG0VHmEI);
							}
							r3OkwJIp.flush();
							if (tnvEnvpH != null) {
								try {
									tnvEnvpH.close();
								} catch (IOException LSeGl3IZ) {
									LSeGl3IZ.printStackTrace();
								}
							}
							if (r3OkwJIp != null) {
								try {
									r3OkwJIp.close();
								} catch (IOException aJFskaXg) {
									aJFskaXg.printStackTrace();
								}
							}
						}
					}
				}
			}
		}
	}

}