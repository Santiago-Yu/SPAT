class n12067823 {
	public void run() {
		if (saveAsDialog == null) {
			saveAsDialog = new FileDialog(window.getShell(), SWT.SAVE);
			saveAsDialog.setFilterExtensions(saveAsTypes);
		}
		String outputFile = saveAsDialog.open();
		if (outputFile != null) {
			InputStream in;
			Object inputFile = DataSourceSingleton.getInstance().getContainer().getWrapped();
			try {
				OutputStream out = new FileOutputStream(outputFile);
				if (inputFile instanceof URL)
					in = ((URL) inputFile).openStream();
				else
					in = new FileInputStream((File) inputFile);
				if (outputFile.endsWith("xml")) {
					int c;
					while ((c = in.read()) != -1)
						out.write(c);
				} else {
					Element data = DataSourceSingleton.getInstance().getRawData();
					PrintWriter pw = new PrintWriter(out);
					writeTextFile(data, pw, -1);
					pw.close();
				}
				in.close();
				out.close();
			} catch (MalformedURLException e1) {
			} catch (IOException e) {
			}
		}
	}

}