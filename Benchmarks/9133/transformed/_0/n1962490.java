class n1962490 {
	private void createContents(final Shell uFZ85NIS) {
		Package n5EX8Olw = Package.getPackage("org.sf.pkb.gui");
		String UaNOpZNS = n5EX8Olw.getImplementationVendor();
		String g5fWvUW2 = n5EX8Olw.getImplementationVersion();
		if (UaNOpZNS == null || UaNOpZNS.trim().length() == 0) {
			UaNOpZNS = "Felton Fee";
		}
		if (g5fWvUW2 != null && g5fWvUW2.trim().length() > 0) {
			g5fWvUW2 = "V" + g5fWvUW2;
		} else {
			g5fWvUW2 = "";
		}
		FormData zrygwdQb = null;
		uFZ85NIS.setLayout(new FormLayout());
		Label URjO4E3O = new Label(uFZ85NIS, SWT.NONE);
		URjO4E3O.setImage(Resources.IMAGE_PKB);
		zrygwdQb = new FormData();
		zrygwdQb.top = new FormAttachment(0, 20);
		zrygwdQb.left = new FormAttachment(0, 20);
		URjO4E3O.setLayoutData(zrygwdQb);
		Label X1mWZ9Dn = new Label(uFZ85NIS, SWT.NONE);
		X1mWZ9Dn.setText(PreferenceDialog.PKBProperty.DEFAULT_rebrand_application_title + " " + g5fWvUW2);
		Font w6qtNxp6 = new Font(uFZ85NIS.getDisplay(), "Arial", 12, SWT.NONE);
		X1mWZ9Dn.setFont(w6qtNxp6);
		zrygwdQb = new FormData();
		zrygwdQb.top = new FormAttachment(0, 25);
		zrygwdQb.left = new FormAttachment(URjO4E3O, 15);
		zrygwdQb.right = new FormAttachment(100, -25);
		X1mWZ9Dn.setLayoutData(zrygwdQb);
		CustomSeparator dffsHHzK = new CustomSeparator(uFZ85NIS, SWT.SHADOW_IN | SWT.HORIZONTAL);
		zrygwdQb = new FormData();
		zrygwdQb.top = new FormAttachment(X1mWZ9Dn, 20);
		zrygwdQb.left = new FormAttachment(0, 0);
		zrygwdQb.right = new FormAttachment(100, 0);
		dffsHHzK.setLayoutData(zrygwdQb);
		Label a0JY4GYQ = new Label(uFZ85NIS, SWT.NONE);
		a0JY4GYQ.setText("Written by " + UaNOpZNS + " <");
		zrygwdQb = new FormData();
		zrygwdQb.top = new FormAttachment(dffsHHzK, 10);
		zrygwdQb.left = new FormAttachment(0, 15);
		a0JY4GYQ.setLayoutData(zrygwdQb);
		Hyperlink KMtfaFBK = new Hyperlink(uFZ85NIS, SWT.NONE | SWT.NO_FOCUS);
		KMtfaFBK.setText(PKBMain.CONTACT_EMAIL);
		KMtfaFBK.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event cTkX4SOC) {
				Program.launch("mailto:" + PKBMain.CONTACT_EMAIL + "?subject=[" + PKBMain.PRODUCT_ALEX_PKB + "]");
			}
		});
		zrygwdQb = new FormData();
		zrygwdQb.top = new FormAttachment(dffsHHzK, 10);
		zrygwdQb.left = new FormAttachment(a0JY4GYQ, 2);
		KMtfaFBK.setLayoutData(zrygwdQb);
		Label qFKGg326 = new Label(uFZ85NIS, SWT.NONE);
		qFKGg326.setText(">");
		zrygwdQb = new FormData();
		zrygwdQb.top = new FormAttachment(dffsHHzK, 10);
		zrygwdQb.left = new FormAttachment(KMtfaFBK, 2);
		zrygwdQb.right = new FormAttachment(100, -20);
		qFKGg326.setLayoutData(zrygwdQb);
		Label Tm055iR8 = new Label(uFZ85NIS, SWT.NONE);
		Tm055iR8.setText("Web site:");
		zrygwdQb = new FormData();
		zrygwdQb.top = new FormAttachment(qFKGg326, 10);
		zrygwdQb.left = new FormAttachment(0, 15);
		Tm055iR8.setLayoutData(zrygwdQb);
		Hyperlink ymn3HS2z = new Hyperlink(uFZ85NIS, SWT.NONE | SWT.NO_FOCUS);
		ymn3HS2z.setText(PKBMain.PRODUCT_WEBSITE);
		ymn3HS2z.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event UXJ7HoQM) {
				Program.launch(PKBMain.PRODUCT_WEBSITE);
			}
		});
		zrygwdQb = new FormData();
		zrygwdQb.top = new FormAttachment(qFKGg326, 10);
		zrygwdQb.left = new FormAttachment(Tm055iR8, 2);
		ymn3HS2z.setLayoutData(zrygwdQb);
		Button iOnchVkn = new Button(uFZ85NIS, SWT.PUSH);
		iOnchVkn.setText("Close");
		iOnchVkn.setLayoutData(zrygwdQb);
		iOnchVkn.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent q63UTGEH) {
				uFZ85NIS.close();
			}
		});
		zrygwdQb = new FormData();
		zrygwdQb.top = new FormAttachment(Tm055iR8, 10);
		zrygwdQb.right = new FormAttachment(100, -20);
		zrygwdQb.bottom = new FormAttachment(100, -10);
		iOnchVkn.setLayoutData(zrygwdQb);
		Button xHbkMMm0 = new Button(uFZ85NIS, SWT.PUSH);
		xHbkMMm0.setText("Check version");
		xHbkMMm0.setLayoutData(zrygwdQb);
		xHbkMMm0.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent Y3sLASZS) {
				try {
					URL MQF7qmc5 = new URL(PKBMain.PRODUCT_WEBSITE + "/latest-version.txt");
					Properties P46vqA9i = new Properties();
					P46vqA9i.load(MQF7qmc5.openStream());
					Package OzRTmg9o = Package.getPackage("org.sf.pkb.gui");
					String sk3PqDsF = OzRTmg9o.getImplementationVersion();
					if (sk3PqDsF == null) {
						sk3PqDsF = "";
					}
					String QkLKdXo1 = P46vqA9i.getProperty("version") + " b" + P46vqA9i.getProperty("build");
					if (QkLKdXo1.trim().compareTo(sk3PqDsF.trim()) != 0) {
						StringBuffer aWgrGtKm = new StringBuffer();
						aWgrGtKm.append("<HTML><BODY>")
								.append("<h3 style='color: #0033FF'>You do not have the latest version. <br/> ")
								.append("The latest version is PKB ")
								.append(P46vqA9i.getProperty("version") + " b" + P46vqA9i.getProperty("build"))
								.append(".</h3><A HREF='").append(P46vqA9i.getProperty("url"))
								.append("' TARGET='_BLANK'>Please download here </a> <br/><br/>")
								.append("<B>It is strongly suggested to backup your knowledge base before install or unzip the new package!</B>")
								.append("</BODY></HTML>");
						MainScreen.Widget.getKnowledgeContentPanel().showTextInBrowser(aWgrGtKm.toString());
					} else {
						StringBuffer uzr2hMtJ = new StringBuffer();
						uzr2hMtJ.append("<HTML><BODY>")
								.append("<h3 style='color: #0033FF'>You already had the latest version - ALEX PKB ")
								.append(P46vqA9i.getProperty("version") + " b" + P46vqA9i.getProperty("build"))
								.append(".</h3>").append("</BODY></HTML>");
						MainScreen.Widget.getKnowledgeContentPanel().showTextInBrowser(uzr2hMtJ.toString());
					}
				} catch (Exception PRtcnz1C) {
					PRtcnz1C.printStackTrace();
				}
				uFZ85NIS.close();
			}
		});
		zrygwdQb = new FormData();
		zrygwdQb.top = new FormAttachment(Tm055iR8, 10);
		zrygwdQb.right = new FormAttachment(iOnchVkn, -5);
		zrygwdQb.bottom = new FormAttachment(100, -10);
		xHbkMMm0.setLayoutData(zrygwdQb);
		uFZ85NIS.setDefaultButton(iOnchVkn);
	}

}