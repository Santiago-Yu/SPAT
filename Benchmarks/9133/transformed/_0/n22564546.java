class n22564546 {
	public void unzip(String MiOn1vU5) {
		File wPmd0PGf = new File(MiOn1vU5);
		if (!wPmd0PGf.exists())
			throw new RuntimeException("The specified resources does not exist (" + MiOn1vU5 + ")");
		String IbVkqAhE = wPmd0PGf.getParent().toString();
		try {
			BufferedOutputStream VbBfqIig = null;
			FileInputStream lNIF2Uza = new FileInputStream(MiOn1vU5);
			ZipInputStream z1JmR6fT = new ZipInputStream(new BufferedInputStream(lNIF2Uza));
			ZipEntry Ai234HSI;
			while ((Ai234HSI = z1JmR6fT.getNextEntry()) != null) {
				log.info("Extracting archive entry: " + Ai234HSI);
				String jhmge0LM = new StringBuilder(IbVkqAhE).append(System.getProperty("file.separator"))
						.append(Ai234HSI.getName()).toString();
				if (Ai234HSI.isDirectory()) {
					log.info("Creating directory: " + jhmge0LM);
					(new File(jhmge0LM)).mkdir();
					continue;
				}
				int sRYagkgm;
				byte TWOV8ym0[] = new byte[BUFFER];
				FileOutputStream xTYBWEzY = new FileOutputStream(jhmge0LM);
				VbBfqIig = new BufferedOutputStream(xTYBWEzY, BUFFER);
				while ((sRYagkgm = z1JmR6fT.read(TWOV8ym0, 0, BUFFER)) != -1)
					VbBfqIig.write(TWOV8ym0, 0, sRYagkgm);
				VbBfqIig.flush();
				VbBfqIig.close();
			}
			z1JmR6fT.close();
		} catch (Exception zkvFdcUK) {
			zkvFdcUK.printStackTrace();
		}
	}

}