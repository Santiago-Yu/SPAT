class n20548201 {
	public void sorter() {
		String PNpSR4sJ, dz6cglHB;
		String Tt9b1dlk[] = new String[1000];
		String rZeY3qCz[] = new String[1000];
		int FqHwYvCH = 0;
		try {
			String P9tCkVbV = pluginInterface.getPluginDirectoryName();
			String jnuAEI2s = P9tCkVbV + System.getProperty("file.separator") + "EpisodeList.txt";
			File d3JcNlWI = new File(jnuAEI2s);
			if (!d3JcNlWI.isFile()) {
				d3JcNlWI.createNewFile();
			}
			final BufferedReader TtNaoR4J = new BufferedReader(new FileReader(d3JcNlWI));
			while ((PNpSR4sJ = TtNaoR4J.readLine()) != null) {
				if ((dz6cglHB = TtNaoR4J.readLine()) != null) {
					Tt9b1dlk[FqHwYvCH] = PNpSR4sJ;
					rZeY3qCz[FqHwYvCH] = dz6cglHB;
					FqHwYvCH++;
				}
			}
			TtNaoR4J.close();
			int bgZ0jY9Q = Tt9b1dlk.length;
			for (int glrcqBpb = 0; glrcqBpb < (FqHwYvCH); glrcqBpb++) {
				for (int OaM8KiyS = 0; OaM8KiyS < (FqHwYvCH - 1); OaM8KiyS++) {
					if (Tt9b1dlk[OaM8KiyS].compareToIgnoreCase(Tt9b1dlk[OaM8KiyS + 1]) > 0) {
						String rvSvkHoT = Tt9b1dlk[OaM8KiyS];
						Tt9b1dlk[OaM8KiyS] = Tt9b1dlk[OaM8KiyS + 1];
						Tt9b1dlk[OaM8KiyS + 1] = rvSvkHoT;
						String QvF31wHh = rZeY3qCz[OaM8KiyS];
						rZeY3qCz[OaM8KiyS] = rZeY3qCz[OaM8KiyS + 1];
						rZeY3qCz[OaM8KiyS + 1] = QvF31wHh;
					}
				}
			}
			File sPgqPdXm = new File(jnuAEI2s);
			BufferedWriter vdEoebgx = new BufferedWriter(new FileWriter(sPgqPdXm));
			for (int rzG4cqNF = 0; rzG4cqNF <= FqHwYvCH; rzG4cqNF++) {
				if (Tt9b1dlk[rzG4cqNF] == null) {
					break;
				}
				vdEoebgx.write(Tt9b1dlk[rzG4cqNF] + "\n");
				vdEoebgx.write(rZeY3qCz[rzG4cqNF] + "\n");
			}
			vdEoebgx.close();
		} catch (IOException ENcYOk8X) {
			ENcYOk8X.printStackTrace();
		}
	}

}