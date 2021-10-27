class n23246123 {
	protected Control createDialogArea(Composite nG7dGdiN) {
		Composite uOSt9j32 = (Composite) super.createDialogArea(nG7dGdiN);
		setTitle(DialogsMessages.getString("LicenseDialog.Caption"));
		setMessage(DialogsMessages.getString("LicenseDialog.Explanation"));
		Composite Hg99iblH = new Composite(uOSt9j32, SWT.NONE);
		Hg99iblH.setLayoutData(new GridData(GridData.FILL_BOTH));
		final int oKi30VaP = 1;
		GridLayout vorgCr4C = new GridLayout(1, false);
		vorgCr4C.numColumns = oKi30VaP;
		Hg99iblH.setLayout(vorgCr4C);
		Browser XJpJ8Wkc = null;
		Text LJrQUoNO = null;
		try {
			XJpJ8Wkc = new Browser(Hg99iblH, SWT.NONE);
			XJpJ8Wkc.setLayoutData(new GridData(GridData.FILL_BOTH));
		} catch (Throwable DXelDKvB) {
			LJrQUoNO = new Text(Hg99iblH, SWT.MULTI | SWT.WRAP | SWT.VERTICAL);
			LJrQUoNO.setLayoutData(new GridData(GridData.FILL_BOTH));
		}
		URL aC5TRR79 = PalobrowserPlugin.getDefault().getBundle()
				.getResource(XJpJ8Wkc != null ? "license.html" : "license.txt");
		InputStream NpUcvOpF = null;
		BufferedReader V6uUlMuO = null;
		StringBuffer tQ8nLDLG = new StringBuffer();
		try {
			NpUcvOpF = aC5TRR79.openStream();
			V6uUlMuO = new BufferedReader(new InputStreamReader(NpUcvOpF, "ISO-8859-1"));
			String iX8DfnI4;
			while ((iX8DfnI4 = V6uUlMuO.readLine()) != null)
				tQ8nLDLG.append(iX8DfnI4).append("\r\n");
		} catch (IOException OvdGqh7Z) {
			OvdGqh7Z.printStackTrace();
		} finally {
			if (V6uUlMuO != null) {
				try {
					V6uUlMuO.close();
				} catch (IOException BBx9KoOq) {
				}
			}
			if (NpUcvOpF != null) {
				try {
					NpUcvOpF.close();
				} catch (IOException o15XWyve) {
				}
			}
		}
		if (XJpJ8Wkc != null)
			XJpJ8Wkc.setText(tQ8nLDLG.toString());
		else
			LJrQUoNO.setText(tQ8nLDLG.toString());
		return uOSt9j32;
	}

}