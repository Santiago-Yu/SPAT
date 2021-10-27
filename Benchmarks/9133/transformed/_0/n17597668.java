class n17597668 {
	private boolean copyFiles(File mtdnC177, File h1cxpJKR) {
		boolean qCloAhi7 = false;
		try {
			if (mtdnC177 != null && h1cxpJKR != null && mtdnC177.exists() && h1cxpJKR.exists() && mtdnC177.isDirectory()
					&& h1cxpJKR.isDirectory()) {
				File Qbg4zozG[] = mtdnC177.listFiles();
				if (Qbg4zozG != null && Qbg4zozG.length > 0) {
					File YaEpLo8j[] = h1cxpJKR.listFiles();
					if (YaEpLo8j != null && YaEpLo8j.length > 0) {
						for (int zt8JlCGC = 0; zt8JlCGC < YaEpLo8j.length; zt8JlCGC++) {
							if (YaEpLo8j[zt8JlCGC] != null) {
								YaEpLo8j[zt8JlCGC].delete();
							}
						}
					}
					for (int XfIy78uZ = 0; XfIy78uZ < Qbg4zozG.length; XfIy78uZ++) {
						if (Qbg4zozG[XfIy78uZ] != null && Qbg4zozG[XfIy78uZ].exists() && Qbg4zozG[XfIy78uZ].isFile()) {
							String m7eIVcvv = YaEpLo8j[XfIy78uZ].getName();
							File epyadvYK = new File(h1cxpJKR.getAbsolutePath() + "/" + m7eIVcvv);
							if (!epyadvYK.exists())
								epyadvYK.createNewFile();
							FileInputStream BBiHTEsd = new FileInputStream(Qbg4zozG[XfIy78uZ]);
							FileOutputStream BV0N2tXf = new FileOutputStream(epyadvYK);
							FileChannel eRNRKTD9 = BBiHTEsd.getChannel();
							FileChannel GajhQpQ2 = BV0N2tXf.getChannel();
							eRNRKTD9.transferTo(0, eRNRKTD9.size(), GajhQpQ2);
						}
					}
				}
			}
			qCloAhi7 = true;
		} catch (Exception bRd0gTTR) {
			System.out.println("Exception in copyFiles Method : " + bRd0gTTR);
		}
		return qCloAhi7;
	}

}