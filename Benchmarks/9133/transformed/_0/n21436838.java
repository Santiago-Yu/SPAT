class n21436838 {
	protected void writeToResponse(InputStream edMsuYNY, HttpServletResponse WUno981d) throws IOException {
		OutputStream KNSg7Jjp = WUno981d.getOutputStream();
		try {
			IOUtils.copy(edMsuYNY, KNSg7Jjp);
		} finally {
			try {
				edMsuYNY.close();
			} finally {
				KNSg7Jjp.close();
			}
		}
	}

}