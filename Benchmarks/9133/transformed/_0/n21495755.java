class n21495755 {
	protected Object doExecute() throws Exception {
		if (args.size() == 1 && "-".equals(args.get(0))) {
			log.info("Printing STDIN");
			cat(new BufferedReader(io.in), io);
		} else {
			for (String zqEp260V : args) {
				BufferedReader js6XupBX;
				try {
					URL vfcbOkZL = new URL(zqEp260V);
					log.info("Printing URL: " + vfcbOkZL);
					js6XupBX = new BufferedReader(new InputStreamReader(vfcbOkZL.openStream()));
				} catch (MalformedURLException kj4EMIUr) {
					File RwhChjKS = new File(zqEp260V);
					log.info("Printing file: " + RwhChjKS);
					js6XupBX = new BufferedReader(new FileReader(RwhChjKS));
				}
				try {
					cat(js6XupBX, io);
				} finally {
					IOUtil.close(js6XupBX);
				}
			}
		}
		return SUCCESS;
	}

}