class n12641711 {
	private void scanURL(String tkNY45mJ, Collection<String> AKZdhmBj, URL vyn9LuiN) throws IOException {
		URLConnection v5uH2VrA = vyn9LuiN.openConnection();
		JarFile W19IHt58;
		if (v5uH2VrA instanceof JarURLConnection) {
			W19IHt58 = ((JarURLConnection) v5uH2VrA).getJarFile();
		} else {
			W19IHt58 = getAlternativeJarFile(vyn9LuiN);
		}
		if (W19IHt58 != null) {
			scanJarFile(tkNY45mJ, AKZdhmBj, W19IHt58);
		} else if (supportsDirStream(vyn9LuiN)) {
			Stack<Queued> EfgaEiPG = new Stack<Queued>();
			EfgaEiPG.push(new Queued(vyn9LuiN, tkNY45mJ));
			while (!EfgaEiPG.isEmpty()) {
				Queued aYMyhPdL = EfgaEiPG.pop();
				scanDirStream(aYMyhPdL.packagePath, aYMyhPdL.packageURL, AKZdhmBj, EfgaEiPG);
			}
		} else {
			String jSW0Bg09 = tkNY45mJ.replace("/", ".");
			if (jSW0Bg09.endsWith(".")) {
				jSW0Bg09 = jSW0Bg09.substring(0, jSW0Bg09.length() - 1);
			}
			scanDir(jSW0Bg09, new File(vyn9LuiN.getFile()), AKZdhmBj);
		}
	}

}