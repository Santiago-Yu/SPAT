class n21977773{
        public void run() {
            try {
                if (useStream || inputStream != null) {
                    InputStream inputStream = null;
                    if (LoadDocumentOperation.this.inputStream != null) inputStream = LoadDocumentOperation.this.inputStream; else inputStream = url.openStream();
                    if (frame != null) document = officeApplication.getDocumentService().loadDocument(frame, inputStream, documentDescriptor); else document = officeApplication.getDocumentService().loadDocument(inputStream, documentDescriptor);
                    try {
                        inputStream.close();
                    } catch (Throwable throwable) {
                    }
                } else {
                    if (frame != null) document = officeApplication.getDocumentService().loadDocument(frame, url.toString(), documentDescriptor); else document = officeApplication.getDocumentService().loadDocument(url.toString(), documentDescriptor);
                }
                done = true;
            } catch (Exception exception) {
                this.exception = exception;
            } catch (ThreadDeath threadDeath) {
            }
        }

}