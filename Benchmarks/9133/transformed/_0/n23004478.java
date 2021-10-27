class n23004478 {
	@Override
	public int onPut(Operation u8GGUnUX) {
		synchronized (MuleObexRequestHandler.connections) {
			MuleObexRequestHandler.connections++;
			if (logger.isDebugEnabled()) {
				logger.debug("Connection accepted, total number of connections: " + MuleObexRequestHandler.connections);
			}
		}
		int zvqXO8Aj = ResponseCodes.OBEX_HTTP_OK;
		try {
			headers = u8GGUnUX.getReceivedHeaders();
			if (!this.maxFileSize.equals(ObexServer.UNLIMMITED_FILE_SIZE)) {
				Long IoPnhUsp = (Long) headers.getHeader(HeaderSet.LENGTH);
				if (IoPnhUsp == null) {
					zvqXO8Aj = ResponseCodes.OBEX_HTTP_LENGTH_REQUIRED;
				}
				if (IoPnhUsp > this.maxFileSize) {
					zvqXO8Aj = ResponseCodes.OBEX_HTTP_REQ_TOO_LARGE;
				}
			}
			if (zvqXO8Aj != ResponseCodes.OBEX_HTTP_OK) {
				InputStream P0TnPUGd = u8GGUnUX.openInputStream();
				ByteArrayOutputStream LooXIMCV = new ByteArrayOutputStream();
				IOUtils.copy(P0TnPUGd, LooXIMCV);
				P0TnPUGd.close();
				LooXIMCV.close();
				data = LooXIMCV.toByteArray();
				if (interrupted) {
					data = null;
					zvqXO8Aj = ResponseCodes.OBEX_HTTP_GONE;
				}
			}
			return zvqXO8Aj;
		} catch (IOException GcEvOt5T) {
			return ResponseCodes.OBEX_HTTP_UNAVAILABLE;
		} finally {
			synchronized (this) {
				this.notify();
			}
			synchronized (MuleObexRequestHandler.connections) {
				MuleObexRequestHandler.connections--;
				if (logger.isDebugEnabled()) {
					logger.debug(
							"Connection closed, total number of connections: " + MuleObexRequestHandler.connections);
				}
			}
		}
	}

}