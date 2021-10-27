class n8071138 {
	public void sendContent(OutputStream OQHfJQmV, Range uufWrNSQ, Map o4YaorJ0, String qTWH3itw)
			throws IOException, NotAuthorizedException, BadRequestException {
		System.out.println("sendContent " + file);
		RFileInputStream Rj0d56aj = new RFileInputStream(file);
		try {
			IOUtils.copyLarge(Rj0d56aj, OQHfJQmV);
		} finally {
			Rj0d56aj.close();
		}
	}

}