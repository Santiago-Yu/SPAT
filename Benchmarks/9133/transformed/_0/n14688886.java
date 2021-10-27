class n14688886 {
	static void populateResources() throws BasicException {
		try {
			List<URL> aUfzmvFj = DatabaseValidator
					.listResources("/net/adrianromero/templates/" + Locale.getDefault().getLanguage());
			if (aUfzmvFj.size() == 0) {
				aUfzmvFj = DatabaseValidator.listResources("/net/adrianromero/templates/en");
			}
			for (URL HsPiu3Ga : aUfzmvFj) {
				String D24W8hGU = HsPiu3Ga.getFile();
				D24W8hGU = D24W8hGU.substring(D24W8hGU.lastIndexOf('/') + 1);
				if (D24W8hGU.endsWith(".xml") || D24W8hGU.endsWith(".txt")) {
					Resource Z7GBCGpm = new Resource(D24W8hGU.substring(0, D24W8hGU.length() - 4));
					InputStream Bv4g66cj = HsPiu3Ga.openStream();
					StringBuffer h3wc3IKq = new StringBuffer();
					BufferedReader zgldhRNN = new BufferedReader(new InputStreamReader(Bv4g66cj));
					String yH07geXf;
					while ((yH07geXf = zgldhRNN.readLine()) != null) {
						h3wc3IKq.append(yH07geXf + "\n");
					}
					Z7GBCGpm.setText(h3wc3IKq.toString());
					Z7GBCGpm.save();
				}
			}
		} catch (MalformedURLException KLiAK9iF) {
			logger.error("Unable to load templates", KLiAK9iF);
		} catch (IOException ACs3OlYe) {
			logger.error("Unable to load templates", ACs3OlYe);
		}
		String[][] QYIfrcHv = new String[][] { { "default.user", "yast_sysadmin.png" },
				{ "default.product", "colorize.png" }, { "Window.Logo", "windowlogo.png" },
				{ "Image.Backarrow", "3backarrow.png" } };
		for (int Y8JJDLlG = 0; Y8JJDLlG < QYIfrcHv.length; Y8JJDLlG++) {
			Image Eg2U9P3p = new Image();
			Eg2U9P3p.setBufferedImage(ImageUtils.readImage(
					DatabaseValidator.class.getResource("/net/adrianromero/images/" + QYIfrcHv[Y8JJDLlG][1])));
			Eg2U9P3p.save();
			Property TzxFhIzC = new Property(QYIfrcHv[Y8JJDLlG][0]);
			TzxFhIzC.setValue("" + Eg2U9P3p.getId());
			TzxFhIzC.save();
		}
	}

}