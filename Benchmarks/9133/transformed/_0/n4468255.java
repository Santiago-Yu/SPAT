class n4468255 {
	public static void copy(File rkRe0uaW, File Xl9gXejC) {
		boolean PyShFBNk;
		if (rkRe0uaW.isDirectory()) {
			File[] nIb5ypg4 = rkRe0uaW.listFiles();
			for (int abXUOSbe = 0; abXUOSbe < nIb5ypg4.length; abXUOSbe++) {
				File QAhfoeaZ = new File(Xl9gXejC, nIb5ypg4[abXUOSbe].getName());
				PyShFBNk = false;
				if (nIb5ypg4[abXUOSbe].isDirectory()) {
					if (QAhfoeaZ.exists())
						PyShFBNk = true;
					else
						PyShFBNk = QAhfoeaZ.mkdirs();
				} else if (nIb5ypg4[abXUOSbe].isFile()) {
					try {
						PyShFBNk = QAhfoeaZ.createNewFile();
					} catch (IOException uJ9EQa3F) {
						log.error("unable to create new file: " + QAhfoeaZ, uJ9EQa3F);
						PyShFBNk = false;
					}
				}
				if (PyShFBNk)
					copy(nIb5ypg4[abXUOSbe], QAhfoeaZ);
			}
		} else if (rkRe0uaW.isFile()) {
			FileInputStream ASnLjybe = null;
			FileOutputStream CluuTkCo = null;
			try {
				ASnLjybe = new FileInputStream(rkRe0uaW);
				CluuTkCo = new FileOutputStream(Xl9gXejC);
				int oxxGiTNG = (int) rkRe0uaW.length();
				char czwMdLV6[] = new char[oxxGiTNG];
				int ac3wtY1A;
				int PCMx8gwa;
				while ((PCMx8gwa = ASnLjybe.read()) != -1) {
					CluuTkCo.write(PCMx8gwa);
				}
			} catch (FileNotFoundException eMIiznS8) {
				log.error("File not found!", eMIiznS8);
			} catch (IOException X1KWep5L) {
				log.error("Unable to read from file!", X1KWep5L);
			} finally {
				try {
					if (ASnLjybe != null)
						ASnLjybe.close();
					if (CluuTkCo != null)
						CluuTkCo.close();
				} catch (IOException WjD9mYMu) {
					log.error("Error closing file reader/writer", WjD9mYMu);
				}
			}
		}
	}

}