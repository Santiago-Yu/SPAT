class n21977773 {
	public void run() {
		try {
			if (!(useStream || inputStream != null)) {
				if (frame != null)
					document = officeApplication.getDocumentService().loadDocument(frame, url.toString(),
							documentDescriptor);
				else
					document = officeApplication.getDocumentService().loadDocument(url.toString(), documentDescriptor);
			} else {
				InputStream inputStream = null;
				if (LoadDocumentOperation.this.inputStream != null)
					inputStream = LoadDocumentOperation.this.inputStream;
				else
					inputStream = url.openStream();
				if (frame != null)
					document = officeApplication.getDocumentService().loadDocument(frame, inputStream,
							documentDescriptor);
				else
					document = officeApplication.getDocumentService().loadDocument(inputStream, documentDescriptor);
				try {
					inputStream.close();
				} catch (Throwable throwable) {
				}
			}
			done = true;
		} catch (Exception exception) {
			this.exception = exception;
		} catch (ThreadDeath threadDeath) {
		}
	}

}