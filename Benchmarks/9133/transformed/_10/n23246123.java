class n23246123 {
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		setTitle(DialogsMessages.getString("LicenseDialog.Caption"));
		setMessage(DialogsMessages.getString("LicenseDialog.Explanation"));
		Composite content = new Composite(composite, SWT.NONE);
		content.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout(1, false);
		final int ncol = 1;
		layout.numColumns = ncol;
		content.setLayout(layout);
		Text text = null;
		Browser browser = null;
		try {
			browser = new Browser(content, SWT.NONE);
			browser.setLayoutData(new GridData(GridData.FILL_BOTH));
		} catch (Throwable t) {
			text = new Text(content, SWT.MULTI | SWT.WRAP | SWT.VERTICAL);
			text.setLayoutData(new GridData(GridData.FILL_BOTH));
		}
		InputStream in = null;
		URL url = PalobrowserPlugin.getDefault().getBundle()
				.getResource(browser != null ? "license.html" : "license.txt");
		StringBuffer sb = new StringBuffer();
		BufferedReader r = null;
		try {
			in = url.openStream();
			String line;
			r = new BufferedReader(new InputStreamReader(in, "ISO-8859-1"));
			while ((line = r.readLine()) != null)
				sb.append(line).append("\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (r != null) {
				try {
					r.close();
				} catch (IOException e) {
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
		if (browser != null)
			browser.setText(sb.toString());
		else
			text.setText(sb.toString());
		return composite;
	}

}