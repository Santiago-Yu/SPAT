class n12782570 {
	public void logging() throws Fault {
		final InterceptorWrapper XNCvp2fn = new InterceptorWrapper(message);
		final LoggingMessage TaWfhWco = new LoggingMessage("Inbound Message\n----------------------------");
		String kVivtTFO = (String) XNCvp2fn.getEncoding();
		if (kVivtTFO != null) {
			TaWfhWco.getEncoding().append(kVivtTFO);
		}
		Object ZZOPXf52 = XNCvp2fn.getProtocolHeaders();
		if (ZZOPXf52 != null) {
			TaWfhWco.getHeader().append(ZZOPXf52);
		}
		InputStream hu5rh8h3 = (InputStream) XNCvp2fn.getContent(InputStream.class);
		if (hu5rh8h3 != null) {
			CachedOutputStream RxkR0Wfy = new CachedOutputStream();
			try {
				IOUtils.copy(hu5rh8h3, RxkR0Wfy);
				RxkR0Wfy.flush();
				hu5rh8h3.close();
				this.message.setContent(InputStream.class, RxkR0Wfy.getInputStream());
				if (RxkR0Wfy.getTempFile() != null) {
					logger.error("\nMessage (saved to tmp file):\n");
					logger.error("Filename: " + RxkR0Wfy.getTempFile().getAbsolutePath() + "\n");
				}
				if (RxkR0Wfy.size() > limit) {
					logger.error("(message truncated to " + limit + " bytes)\n");
				}
				RxkR0Wfy.writeCacheTo(TaWfhWco.getPayload(), limit);
				RxkR0Wfy.close();
			} catch (IOException jB4dLjnS) {
				throw new Fault(jB4dLjnS);
			}
		}
		logger.debug("Message received :\n" + TaWfhWco.getPayload().toString());
	}

}