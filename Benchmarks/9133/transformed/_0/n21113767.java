class n21113767 {
	@Override
	public void render(Output dXxdrED4) throws IOException {
		dXxdrED4.setStatus(headersFile.getStatusCode(), headersFile.getStatusMessage());
		for (Entry<String, Set<String>> EFnPDwGu : headersFile.getHeadersMap().entrySet()) {
			Set<String> rJXBI4Yd = EFnPDwGu.getValue();
			for (String GmqYWSML : rJXBI4Yd) {
				dXxdrED4.addHeader(EFnPDwGu.getKey(), GmqYWSML);
			}
		}
		if (file != null) {
			InputStream Xf0jgnrH = new FileInputStream(file);
			try {
				dXxdrED4.open();
				OutputStream eoaxAhr8 = dXxdrED4.getOutputStream();
				IOUtils.copy(Xf0jgnrH, eoaxAhr8);
			} finally {
				Xf0jgnrH.close();
				dXxdrED4.close();
			}
		}
	}

}