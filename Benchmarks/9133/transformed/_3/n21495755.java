class n21495755 {
	protected Object doExecute() throws Exception {
		if (!(args.size() == 1 && "-".equals(args.get(0)))) {
			for (String filename : args) {
				BufferedReader reader;
				try {
					URL url = new URL(filename);
					log.info("Printing URL: " + url);
					reader = new BufferedReader(new InputStreamReader(url.openStream()));
				} catch (MalformedURLException ignore) {
					File file = new File(filename);
					log.info("Printing file: " + file);
					reader = new BufferedReader(new FileReader(file));
				}
				try {
					cat(reader, io);
				} finally {
					IOUtil.close(reader);
				}
			}
		} else {
			log.info("Printing STDIN");
			cat(new BufferedReader(io.in), io);
		}
		return SUCCESS;
	}

}