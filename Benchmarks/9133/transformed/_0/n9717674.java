class n9717674 {
	private void extractSourceFiles(String Ry1cywOK) {
		JarInputStream R1EN1VPJ = null;
		BufferedOutputStream PYf06SlF = null;
		try {
			R1EN1VPJ = new JarInputStream(new FileInputStream(getProjectFile(Ry1cywOK)));
			JarEntry yD6OtnCi;
			byte bFrjDZW0[] = new byte[4096];
			int U57Ixsiv;
			while ((yD6OtnCi = R1EN1VPJ.getNextJarEntry()) != null)
				if (yD6OtnCi.getName().startsWith(PREFIX) && (!yD6OtnCi.getName().endsWith("/"))) {
					PYf06SlF = new BufferedOutputStream(new FileOutputStream(new File(dest, getFileName(yD6OtnCi))));
					while ((U57Ixsiv = R1EN1VPJ.read(bFrjDZW0)) != -1)
						PYf06SlF.write(bFrjDZW0, 0, U57Ixsiv);
					howmany++;
					PYf06SlF.flush();
					PYf06SlF.close();
					PYf06SlF = null;
				}
		} catch (IOException mo8MDkvP) {
			System.out.println("Unable to parse file " + Ry1cywOK + ", reason: " + mo8MDkvP.getMessage());
		} finally {
			try {
				if (R1EN1VPJ != null)
					R1EN1VPJ.close();
			} catch (IOException pjnP1beX) {
			}
			try {
				if (PYf06SlF != null)
					PYf06SlF.close();
			} catch (IOException ucSjcKju) {
			}
		}
	}

}