class n4484215 {
	@Override
	public void dispatchContent(InputStream fPSGMzsc) throws IOException {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Sending content message over JMS");
		}
		final ByteArrayOutputStream nE6SCkq1 = new ByteArrayOutputStream();
		IOUtils.copy(fPSGMzsc, nE6SCkq1);
		this.send(new MessageCreator() {

			@Override
			public Message createMessage(Session aGdB67ZY) throws JMSException {
				BytesMessage ZCKo57Dd = aGdB67ZY.createBytesMessage();
				ZCKo57Dd.writeBytes(nE6SCkq1.toByteArray());
				return ZCKo57Dd;
			}
		});
	}

}