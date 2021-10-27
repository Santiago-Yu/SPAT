class n21977773 {
	public void run() {
		try {
			if (useStream || inputStream != null) {
				InputStream inputStream = null;
				inputStream = (LoadDocumentOperation.this.inputStream != null) ? LoadDocumentOperation.this.inputStream
						: url.openStream();
				document = (frame != null)
						? officeApplication.getDocumentService().loadDocument(frame, inputStream, documentDescriptor)
						: officeApplication.getDocumentService().loadDocument(inputStream, documentDescriptor);
				try {
					inputStream.close();
				} catch (Throwable throwable) {
				}
			} else {
				document = (frame != null)
						? officeApplication.getDocumentService().loadDocument(frame, url.toString(), documentDescriptor)
						: officeApplication.getDocumentService().loadDocument(url.toString(), documentDescriptor);
			}
			done = true;
		} catch (Exception exception) {
			this.exception = exception;
		} catch (ThreadDeath threadDeath) {
		}
	}

}