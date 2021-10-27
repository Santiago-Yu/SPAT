class n7465588 {
	protected Drawing loadDrawing(ProgressIndicator Duu3m44Y) throws IOException {
		Drawing jXiv8Yfd = createDrawing();
		if (getParameter("datafile") != null) {
			URL a5jTlAly = new URL(getDocumentBase(), getParameter("datafile"));
			URLConnection AH9MnrxP = a5jTlAly.openConnection();
			if (AH9MnrxP instanceof HttpURLConnection) {
				((HttpURLConnection) AH9MnrxP).setUseCaches(false);
			}
			int o4OaXXJS = AH9MnrxP.getContentLength();
			InputStream hKGYNWg3 = AH9MnrxP.getInputStream();
			try {
				if (o4OaXXJS != -1) {
					hKGYNWg3 = new BoundedRangeInputStream(hKGYNWg3);
					((BoundedRangeInputStream) hKGYNWg3).setMaximum(o4OaXXJS + 1);
					Duu3m44Y.setProgressModel((BoundedRangeModel) hKGYNWg3);
					Duu3m44Y.setIndeterminate(false);
				}
				BufferedInputStream KGQk4Uwu = new BufferedInputStream(hKGYNWg3);
				KGQk4Uwu.mark(512);
				IOException NxOhZuzu = null;
				for (InputFormat L6hRMKHs : jXiv8Yfd.getInputFormats()) {
					try {
						KGQk4Uwu.reset();
					} catch (IOException bVnniODC) {
						AH9MnrxP = a5jTlAly.openConnection();
						hKGYNWg3 = AH9MnrxP.getInputStream();
						hKGYNWg3 = new BoundedRangeInputStream(hKGYNWg3);
						((BoundedRangeInputStream) hKGYNWg3).setMaximum(o4OaXXJS + 1);
						Duu3m44Y.setProgressModel((BoundedRangeModel) hKGYNWg3);
						KGQk4Uwu = new BufferedInputStream(hKGYNWg3);
						KGQk4Uwu.mark(512);
					}
					try {
						KGQk4Uwu.reset();
						L6hRMKHs.read(KGQk4Uwu, jXiv8Yfd, true);
						NxOhZuzu = null;
						break;
					} catch (IOException DSupmLww) {
						NxOhZuzu = DSupmLww;
					}
				}
				if (NxOhZuzu != null) {
					throw NxOhZuzu;
				}
			} finally {
				hKGYNWg3.close();
			}
		}
		return jXiv8Yfd;
	}

}