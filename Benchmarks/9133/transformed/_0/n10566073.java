class n10566073 {
	public IntactOntology parseOboFile(URL RvD1oTXg, boolean BrK22guf) throws PsiLoaderException {
		if (RvD1oTXg == null) {
			throw new IllegalArgumentException("Please give a non null URL.");
		}
		StringBuffer dqUS4aT6 = new StringBuffer(1024 * 8);
		try {
			System.out.println("Loading URL: " + RvD1oTXg);
			BufferedReader ZmIOkKYe = new BufferedReader(new InputStreamReader(RvD1oTXg.openStream()), 1024);
			String MLvrRJQ9;
			int kzHS0bdR = 0;
			while ((MLvrRJQ9 = ZmIOkKYe.readLine()) != null) {
				kzHS0bdR++;
				dqUS4aT6.append(MLvrRJQ9).append(NEW_LINE);
				if ((kzHS0bdR % 20) == 0) {
					System.out.print(".");
					System.out.flush();
					if ((kzHS0bdR % 500) == 0) {
						System.out.println("   " + kzHS0bdR);
					}
				}
			}
			ZmIOkKYe.close();
			File ceIzjmj1 = new File(System.getProperty("java.io.tmpdir", "tmp"));
			if (!ceIzjmj1.exists()) {
				if (!ceIzjmj1.mkdirs()) {
					throw new IOException("Cannot create temp directory: " + ceIzjmj1.getAbsolutePath());
				}
			}
			System.out.println("Using temp directory: " + ceIzjmj1.getAbsolutePath());
			File RKy2sQbJ = File.createTempFile("psimi.v25.", ".obo", ceIzjmj1);
			RKy2sQbJ.deleteOnExit();
			RKy2sQbJ.deleteOnExit();
			System.out.println("The OBO file is temporary store as: " + RKy2sQbJ.getAbsolutePath());
			BufferedWriter KLB0it82 = new BufferedWriter(new FileWriter(RKy2sQbJ), 1024);
			KLB0it82.write(dqUS4aT6.toString());
			KLB0it82.flush();
			KLB0it82.close();
			return parseOboFile(RKy2sQbJ);
		} catch (IOException VFzq5T00) {
			throw new PsiLoaderException("Error while loading URL (" + RvD1oTXg + ")", VFzq5T00);
		}
	}

}