class n4381116{
    private void importUrl() throws ExtractaException {
        UITools.changeCursor(UITools.WAIT_CURSOR, this);
        try {
            m_sUrlString = m_urlTF.getText();
            URL url = new URL(m_sUrlString);
            Document document = DomHelper.parseHtml(url.openStream());
            m_inputPanel.setDocument(document);
            Edl edl = new Edl();
            edl.addUrlDescriptor(new UrlDescriptor(m_sUrlString));
            m_resultPanel.setContext(new ResultContext(edl, document, url));
            setModified(true);
        } catch (IOException ex) {
            throw new ExtractaException("Can not open URL!", ex);
        } finally {
            UITools.changeCursor(UITools.DEFAULT_CURSOR, this);
        }
    }

}