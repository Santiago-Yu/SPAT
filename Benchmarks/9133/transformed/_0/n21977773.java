class n21977773 {
	public void run() {
		try {
			if (useStream || inputStream != null) {
				InputStream eUJXg2ku = null;
				if (LoadDocumentOperation.this.inputStream != null)
					eUJXg2ku = LoadDocumentOperation.this.inputStream;
				else
					eUJXg2ku = url.openStream();
				if (frame != null)
					document = officeApplication.getDocumentService().loadDocument(frame, eUJXg2ku, documentDescriptor);
				else
					document = officeApplication.getDocumentService().loadDocument(eUJXg2ku, documentDescriptor);
				try {
					eUJXg2ku.close();
				} catch (Throwable u3rgZ1b3) {
				}
			} else {
				if (frame != null)
					document = officeApplication.getDocumentService().loadDocument(frame, url.toString(),
							documentDescriptor);
				else
					document = officeApplication.getDocumentService().loadDocument(url.toString(), documentDescriptor);
			}
			done = true;
		} catch (Exception Drv75Pu1) {
			this.exception = Drv75Pu1;
		} catch (ThreadDeath PXHWuiFi) {
		}
	}

}