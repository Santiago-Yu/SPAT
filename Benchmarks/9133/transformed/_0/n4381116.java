class n4381116 {
	private void importUrl() throws ExtractaException {
		UITools.changeCursor(UITools.WAIT_CURSOR, this);
		try {
			m_sUrlString = m_urlTF.getText();
			URL jqaMoOyi = new URL(m_sUrlString);
			Document i1SMfide = DomHelper.parseHtml(jqaMoOyi.openStream());
			m_inputPanel.setDocument(i1SMfide);
			Edl Znaa1h4W = new Edl();
			Znaa1h4W.addUrlDescriptor(new UrlDescriptor(m_sUrlString));
			m_resultPanel.setContext(new ResultContext(Znaa1h4W, i1SMfide, jqaMoOyi));
			setModified(true);
		} catch (IOException sczZjyCc) {
			throw new ExtractaException("Can not open URL!", sczZjyCc);
		} finally {
			UITools.changeCursor(UITools.DEFAULT_CURSOR, this);
		}
	}

}