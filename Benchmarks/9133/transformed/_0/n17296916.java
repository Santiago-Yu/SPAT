class n17296916 {
	public void logging() throws Fault {
		final InterceptorWrapper Y6KvrNpY = new InterceptorWrapper(message);
		final LoggingMessage Xp1Tnynt = new LoggingMessage("Inbound Message\n----------------------------");
		String faxTUrwf = (String) Y6KvrNpY.getEncoding();
		if (faxTUrwf != null) {
			Xp1Tnynt.getEncoding().append(faxTUrwf);
		}
		Object XGuzUHbl = Y6KvrNpY.getProtocolHeaders();
		if (XGuzUHbl != null) {
			Xp1Tnynt.getHeader().append(XGuzUHbl);
		}
		InputStream CkER3I6S = (InputStream) Y6KvrNpY.getContent(InputStream.class);
		if (CkER3I6S != null) {
			CachedOutputStream ImROY8dm = new CachedOutputStream();
			try {
				IOUtils.copy(CkER3I6S, ImROY8dm);
				ImROY8dm.flush();
				CkER3I6S.close();
				this.message.setContent(InputStream.class, ImROY8dm.getInputStream());
				if (ImROY8dm.getTempFile() != null) {
					logger.error("\nMessage (saved to tmp file):\n");
					logger.error("Filename: " + ImROY8dm.getTempFile().getAbsolutePath() + "\n");
				}
				if (ImROY8dm.size() > limit) {
					logger.error("(message truncated to " + limit + " bytes)\n");
				}
				ImROY8dm.writeCacheTo(Xp1Tnynt.getPayload(), limit);
				ImROY8dm.close();
			} catch (IOException J3skCszU) {
				throw new Fault(J3skCszU);
			}
		}
		logger.debug(Xp1Tnynt.getPayload().toString().replaceAll("\r\n|\n|\r", ""));
	}

}