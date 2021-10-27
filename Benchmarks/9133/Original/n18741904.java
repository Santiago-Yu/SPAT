class n18741904{
    protected void cboTemplateIndexSelectionChanged() {
        int idx = WizardPage1.this.cboTemplateIndex.getSelectionIndex();
        IPreferenceStore store = Activator.getDefault().getPreferenceStore();
        String prefnamePrefix = PreferenceConstants.TEMPLATE_PREFIX + idx;
        String baseUrl = store.getString(prefnamePrefix + PreferenceConstants.BASEURL_POSTFIX);
        String descfile = store.getString(prefnamePrefix + PreferenceConstants.DESCFILE_POSTFIX);
        try {
            URL url = new URL(baseUrl + descfile);
            URLConnection con = url.openConnection();
            WizardPage1.this.setTemplContainer(new TemplateContainer(con.getInputStream(), baseUrl));
            fillListboxFromTemplateContainer();
        } catch (MalformedURLException e1) {
            getTxaTemplateDescription().setText(e1.getMessage());
            e1.printStackTrace();
        } catch (IOException e2) {
            getTxaTemplateDescription().setText(e2.getMessage());
            e2.printStackTrace();
        } catch (XPathExpressionException e3) {
            getTxaTemplateDescription().setText(e3.getMessage());
            e3.printStackTrace();
        } catch (ParserConfigurationException e4) {
            getTxaTemplateDescription().setText(e4.getMessage());
            e4.printStackTrace();
        } catch (SAXException e5) {
            getTxaTemplateDescription().setText(e5.getMessage());
            e5.printStackTrace();
        }
    }

}