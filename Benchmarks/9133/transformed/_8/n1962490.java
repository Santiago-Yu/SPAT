class n1962490 {
	private void createContents(final Shell shell) {
		Package currentPackage = Package.getPackage("org.sf.pkb.gui");
		String author = currentPackage.getImplementationVendor();
		String version = currentPackage.getImplementationVersion();
		boolean f9G2q1Ev = author == null;
		if (f9G2q1Ev || author.trim().length() == 0) {
			author = "Felton Fee";
		}
		boolean wZ6gaUrC = version != null;
		if (wZ6gaUrC && version.trim().length() > 0) {
			version = "V" + version;
		} else {
			version = "";
		}
		FormData data = null;
		shell.setLayout(new FormLayout());
		Label label1 = new Label(shell, SWT.NONE);
		label1.setImage(Resources.IMAGE_PKB);
		data = new FormData();
		data.top = new FormAttachment(0, 20);
		data.left = new FormAttachment(0, 20);
		label1.setLayoutData(data);
		Label label2 = new Label(shell, SWT.NONE);
		label2.setText(PreferenceDialog.PKBProperty.DEFAULT_rebrand_application_title + " " + version);
		Font font = new Font(shell.getDisplay(), "Arial", 12, SWT.NONE);
		label2.setFont(font);
		data = new FormData();
		data.top = new FormAttachment(0, 25);
		data.left = new FormAttachment(label1, 15);
		data.right = new FormAttachment(100, -25);
		label2.setLayoutData(data);
		CustomSeparator separator1 = new CustomSeparator(shell, SWT.SHADOW_IN | SWT.HORIZONTAL);
		data = new FormData();
		data.top = new FormAttachment(label2, 20);
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, 0);
		separator1.setLayoutData(data);
		Label label3 = new Label(shell, SWT.NONE);
		label3.setText("Written by " + author + " <");
		data = new FormData();
		data.top = new FormAttachment(separator1, 10);
		data.left = new FormAttachment(0, 15);
		label3.setLayoutData(data);
		Hyperlink link = new Hyperlink(shell, SWT.NONE | SWT.NO_FOCUS);
		link.setText(PKBMain.CONTACT_EMAIL);
		link.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				Program.launch("mailto:" + PKBMain.CONTACT_EMAIL + "?subject=[" + PKBMain.PRODUCT_ALEX_PKB + "]");
			}
		});
		data = new FormData();
		data.top = new FormAttachment(separator1, 10);
		data.left = new FormAttachment(label3, 2);
		link.setLayoutData(data);
		Label label4 = new Label(shell, SWT.NONE);
		label4.setText(">");
		data = new FormData();
		data.top = new FormAttachment(separator1, 10);
		data.left = new FormAttachment(link, 2);
		data.right = new FormAttachment(100, -20);
		label4.setLayoutData(data);
		Label label6 = new Label(shell, SWT.NONE);
		label6.setText("Web site:");
		data = new FormData();
		data.top = new FormAttachment(label4, 10);
		data.left = new FormAttachment(0, 15);
		label6.setLayoutData(data);
		Hyperlink link1 = new Hyperlink(shell, SWT.NONE | SWT.NO_FOCUS);
		link1.setText(PKBMain.PRODUCT_WEBSITE);
		link1.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				Program.launch(PKBMain.PRODUCT_WEBSITE);
			}
		});
		data = new FormData();
		data.top = new FormAttachment(label4, 10);
		data.left = new FormAttachment(label6, 2);
		link1.setLayoutData(data);
		Button closeBtn = new Button(shell, SWT.PUSH);
		closeBtn.setText("Close");
		closeBtn.setLayoutData(data);
		closeBtn.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				shell.close();
			}
		});
		data = new FormData();
		data.top = new FormAttachment(label6, 10);
		data.right = new FormAttachment(100, -20);
		data.bottom = new FormAttachment(100, -10);
		closeBtn.setLayoutData(data);
		Button checkVersionBtn = new Button(shell, SWT.PUSH);
		checkVersionBtn.setText("Check version");
		checkVersionBtn.setLayoutData(data);
		checkVersionBtn.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				try {
					URL url = new URL(PKBMain.PRODUCT_WEBSITE + "/latest-version.txt");
					Properties prop = new Properties();
					prop.load(url.openStream());
					Package currentPackage = Package.getPackage("org.sf.pkb.gui");
					String version = currentPackage.getImplementationVersion();
					if (version == null) {
						version = "";
					}
					String remoteVersion = prop.getProperty("version") + " b" + prop.getProperty("build");
					if (remoteVersion.trim().compareTo(version.trim()) != 0) {
						StringBuffer buf = new StringBuffer();
						buf.append("<HTML><BODY>")
								.append("<h3 style='color: #0033FF'>You do not have the latest version. <br/> ")
								.append("The latest version is PKB ")
								.append(prop.getProperty("version") + " b" + prop.getProperty("build"))
								.append(".</h3><A HREF='").append(prop.getProperty("url"))
								.append("' TARGET='_BLANK'>Please download here </a> <br/><br/>")
								.append("<B>It is strongly suggested to backup your knowledge base before install or unzip the new package!</B>")
								.append("</BODY></HTML>");
						MainScreen.Widget.getKnowledgeContentPanel().showTextInBrowser(buf.toString());
					} else {
						StringBuffer buf = new StringBuffer();
						buf.append("<HTML><BODY>")
								.append("<h3 style='color: #0033FF'>You already had the latest version - ALEX PKB ")
								.append(prop.getProperty("version") + " b" + prop.getProperty("build")).append(".</h3>")
								.append("</BODY></HTML>");
						MainScreen.Widget.getKnowledgeContentPanel().showTextInBrowser(buf.toString());
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				shell.close();
			}
		});
		data = new FormData();
		data.top = new FormAttachment(label6, 10);
		data.right = new FormAttachment(closeBtn, -5);
		data.bottom = new FormAttachment(100, -10);
		checkVersionBtn.setLayoutData(data);
		shell.setDefaultButton(closeBtn);
	}

}