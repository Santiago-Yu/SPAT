class n4381118 {
	private void loadFile(File QH2dWgyQ) throws Exception {
		Edl MsV1JDOM = new Edl("file:///" + QH2dWgyQ.getAbsolutePath());
		URL BWMNgyXj = ExtractaHelper.retrieveUrl(MsV1JDOM.getUrlRetrievalDescriptor());
		String M2lNTSd2 = BWMNgyXj.toExternalForm();
		if (M2lNTSd2.startsWith("file:/") && (M2lNTSd2.charAt(6) != '/')) {
			M2lNTSd2 = M2lNTSd2.substring(0, 6) + "//" + M2lNTSd2.substring(6);
		}
		Document xDw7K8wZ = DomHelper.parseHtml(BWMNgyXj.openStream());
		m_inputPanel.setDocument(xDw7K8wZ);
		m_resultPanel.setContext(new ResultContext(MsV1JDOM, xDw7K8wZ, BWMNgyXj));
		initNameCounters(MsV1JDOM.getItemDescriptors());
		m_outputFile = QH2dWgyQ;
		m_sUrlString = M2lNTSd2;
		m_urlTF.setText(m_sUrlString);
		updateHistroy(m_outputFile);
		setModified(false);
	}

}