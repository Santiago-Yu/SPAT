class n19898737 {
	private void updateSystem() throws IOException {
		String eDeN73un = "http://code.google.com/p/senai-pe-cronos/downloads/list";
		try {
			url = new URL(eDeN73un);
		} catch (MalformedURLException uLDrDSp3) {
			uLDrDSp3.printStackTrace();
		}
		InputStream lhHzrVIl = url.openStream();
		InputStreamReader QkzdTVHU = new InputStreamReader(lhHzrVIl);
		BufferedReader NjHrzZZP = new BufferedReader(QkzdTVHU);

		String IkmUo8s1 = NjHrzZZP.readLine();

		while (IkmUo8s1 != null) {
			IkmUo8s1 = NjHrzZZP.readLine();

			if (IkmUo8s1.contains("/files/updateCronos-0-")) {
				String[] oogNfL8o = IkmUo8s1.split("-");
				String[] DoEMlzrh = oogNfL8o[4].split(".exe");
				versao = DoEMlzrh[0];
				println("----" + versao);

				break;
			}

		}

		eDeN73un = "http://senai-pe-cronos.googlecode.com/files/updateCronos-0-" + versao + ".exe";
		UpdateCronos pSv6lFLm = new UpdateCronos();
		try {
			url = new URL(eDeN73un);
		} catch (MalformedURLException gQvyfTTX) {
			gQvyfTTX.printStackTrace();
		}
		System.out.println("vers?o:" + versao);
		if (Integer.parseInt(versao) > version) {

			File x9Z3qqAG = pSv6lFLm.gravaArquivoDeURL(url, System.getProperty("user.dir"), String.valueOf(version),
					versao);

			if (pSv6lFLm.isS()) {
				Runtime.getRuntime().exec(location + "\\update.exe");
				System.exit(0);
			}
		}

	}

}