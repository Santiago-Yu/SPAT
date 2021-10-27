class n4484215 {
	@Override
	public void dispatchContent(InputStream is) throws IOException {
		final ByteArrayOutputStream bos = new ByteArrayOutputStream();
		if (LOG.isDebugEnabled()) {
			LOG.debug("Sending content message over JMS");
		}
		IOUtils.copy(is, bos);
		this.send(new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				BytesMessage message = session.createBytesMessage();
				message.writeBytes(bos.toByteArray());
				return message;
			}
		});
	}

}