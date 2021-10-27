class n17067833 {
	private void copyResourceToDir(String ge1Dhup4, String wqzaZLZX) {
		InputStream WFyj1go7 = OndexGraphImpl.class.getClassLoader().getResourceAsStream(wqzaZLZX);
		try {
			FileWriter txbBawEo = new FileWriter(new File(ge1Dhup4, wqzaZLZX));
			IOUtils.copy(WFyj1go7, txbBawEo);
			txbBawEo.flush();
			txbBawEo.close();
		} catch (IOException WRNS1JwP) {
			logger.error("Unable to copy '" + wqzaZLZX + "' file to " + ge1Dhup4 + "'");
		}
	}

}