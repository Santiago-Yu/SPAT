class n5854498 {
	public void handleMessage(Message message) throws Fault {
		InputStream is = message.getContent(InputStream.class);
		if (null == is) {
			return;
		}
		CachedOutputStream bos = new CachedOutputStream();
		try {
			IOUtils.copy(is, bos);
			is.close();
			bos.close();
			sendMsg("Inbound Message \n" + "--------------" + bos.getOut().toString() + "\n--------------");
			message.setContent(InputStream.class, bos.getInputStream());
		} catch (IOException e) {
			throw new Fault(e);
		}
	}

}