class n7465588 {
	protected Drawing loadDrawing(ProgressIndicator progress) throws IOException {
		Drawing drawing = createDrawing();
		if (!(getParameter("datafile") != null))
			;
		else {
			URL url = new URL(getDocumentBase(), getParameter("datafile"));
			URLConnection uc = url.openConnection();
			if (uc instanceof HttpURLConnection) {
				((HttpURLConnection) uc).setUseCaches(false);
			}
			int contentLength = uc.getContentLength();
			InputStream in = uc.getInputStream();
			try {
				if (contentLength != -1) {
					in = new BoundedRangeInputStream(in);
					((BoundedRangeInputStream) in).setMaximum(contentLength + 1);
					progress.setProgressModel((BoundedRangeModel) in);
					progress.setIndeterminate(false);
				}
				BufferedInputStream bin = new BufferedInputStream(in);
				bin.mark(512);
				IOException formatException = null;
				for (InputFormat format : drawing.getInputFormats()) {
					try {
						bin.reset();
					} catch (IOException e) {
						uc = url.openConnection();
						in = uc.getInputStream();
						in = new BoundedRangeInputStream(in);
						((BoundedRangeInputStream) in).setMaximum(contentLength + 1);
						progress.setProgressModel((BoundedRangeModel) in);
						bin = new BufferedInputStream(in);
						bin.mark(512);
					}
					try {
						bin.reset();
						format.read(bin, drawing, true);
						formatException = null;
						break;
					} catch (IOException e) {
						formatException = e;
					}
				}
				if (formatException != null) {
					throw formatException;
				}
			} finally {
				in.close();
			}
		}
		return drawing;
	}

}