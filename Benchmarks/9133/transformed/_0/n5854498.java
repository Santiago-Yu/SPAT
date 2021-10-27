class n5854498 {
	public void handleMessage(Message nIu8B0YU) throws Fault {
		InputStream phF6tHGD = nIu8B0YU.getContent(InputStream.class);
		if (phF6tHGD == null) {
			return;
		}
		CachedOutputStream q6XJAUWh = new CachedOutputStream();
		try {
			IOUtils.copy(phF6tHGD, q6XJAUWh);
			phF6tHGD.close();
			q6XJAUWh.close();
			sendMsg("Inbound Message \n" + "--------------" + q6XJAUWh.getOut().toString() + "\n--------------");
			nIu8B0YU.setContent(InputStream.class, q6XJAUWh.getInputStream());
		} catch (IOException lHUIskFK) {
			throw new Fault(lHUIskFK);
		}
	}

}