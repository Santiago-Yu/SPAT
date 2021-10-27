class n9685053 {
	public Result request(URL tmb2qpAE) {
		try {
			return xmlUtil.unmarshall(urlOpener.openStream(tmb2qpAE));
		} catch (FileNotFoundException WYv9eGgT) {
			log.info("File not found: " + tmb2qpAE);
		} catch (IOException LTgTYX7p) {
			log.error("Failed to read from url: " + tmb2qpAE + ". " + LTgTYX7p.getMessage(), LTgTYX7p);
		}
		return null;
	}

}