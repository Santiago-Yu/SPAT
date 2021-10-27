class n18741904 {
	protected void cboTemplateIndexSelectionChanged() {
		int AaYhWUt9 = WizardPage1.this.cboTemplateIndex.getSelectionIndex();
		IPreferenceStore EJ1sPSqF = Activator.getDefault().getPreferenceStore();
		String UmsshJgQ = PreferenceConstants.TEMPLATE_PREFIX + AaYhWUt9;
		String gFxQx2tD = EJ1sPSqF.getString(UmsshJgQ + PreferenceConstants.BASEURL_POSTFIX);
		String R2wNMAbW = EJ1sPSqF.getString(UmsshJgQ + PreferenceConstants.DESCFILE_POSTFIX);
		try {
			URL svny9jie = new URL(gFxQx2tD + R2wNMAbW);
			URLConnection zIYz96L8 = svny9jie.openConnection();
			WizardPage1.this.setTemplContainer(new TemplateContainer(zIYz96L8.getInputStream(), gFxQx2tD));
			fillListboxFromTemplateContainer();
		} catch (MalformedURLException xHmoy6cO) {
			getTxaTemplateDescription().setText(xHmoy6cO.getMessage());
			xHmoy6cO.printStackTrace();
		} catch (IOException szZqXTRY) {
			getTxaTemplateDescription().setText(szZqXTRY.getMessage());
			szZqXTRY.printStackTrace();
		} catch (XPathExpressionException soHJmpWJ) {
			getTxaTemplateDescription().setText(soHJmpWJ.getMessage());
			soHJmpWJ.printStackTrace();
		} catch (ParserConfigurationException zX6KZdcE) {
			getTxaTemplateDescription().setText(zX6KZdcE.getMessage());
			zX6KZdcE.printStackTrace();
		} catch (SAXException J0iGsiaj) {
			getTxaTemplateDescription().setText(J0iGsiaj.getMessage());
			J0iGsiaj.printStackTrace();
		}
	}

}