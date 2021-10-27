class n14688886 {
	static void populateResources() throws BasicException {
		try {
			List<URL> templates = DatabaseValidator
					.listResources("/net/adrianromero/templates/" + Locale.getDefault().getLanguage());
			if (templates.size() == 0) {
				templates = DatabaseValidator.listResources("/net/adrianromero/templates/en");
			}
			for (URL url : templates) {
				String fileName = url.getFile();
				fileName = fileName.substring(fileName.lastIndexOf('/') + 1);
				if (fileName.endsWith(".xml") || fileName.endsWith(".txt")) {
					InputStream is = url.openStream();
					Resource templateResource = new Resource(fileName.substring(0, fileName.length() - 4));
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
					StringBuffer strBuff = new StringBuffer();
					String str;
					while ((str = br.readLine()) != null) {
						strBuff.append(str + "\n");
					}
					templateResource.setText(strBuff.toString());
					templateResource.save();
				}
			}
		} catch (MalformedURLException e1) {
			logger.error("Unable to load templates", e1);
		} catch (IOException e1) {
			logger.error("Unable to load templates", e1);
		}
		String[][] images = new String[][] { { "default.user", "yast_sysadmin.png" },
				{ "default.product", "colorize.png" }, { "Window.Logo", "windowlogo.png" },
				{ "Image.Backarrow", "3backarrow.png" } };
		for (int i = 0; i < images.length; i++) {
			Image img = new Image();
			img.setBufferedImage(ImageUtils
					.readImage(DatabaseValidator.class.getResource("/net/adrianromero/images/" + images[i][1])));
			img.save();
			Property imgProperty = new Property(images[i][0]);
			imgProperty.setValue("" + img.getId());
			imgProperty.save();
		}
	}

}