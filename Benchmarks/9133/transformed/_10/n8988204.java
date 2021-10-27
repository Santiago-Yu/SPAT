class n8988204 {
	@Override
	public void onLoadingEnded() {
		if (m_frame != null) {
			try {
				String urltext = getDocument().getDocumentURI();
				URL url = new URL(urltext);
				InputStreamReader isr = new InputStreamReader(url.openStream());
				String inputLine;
				BufferedReader in = new BufferedReader(isr);
				url = null;
				urltext = null;
				m_content.clear();
				while ((inputLine = in.readLine()) != null) {
					m_content.add(inputLine);
				}
				in.close();
				in = null;
				isr = null;
				Action action = parseHtml();
				inputLine = null;
				if (action.value() == Action.ACTION_BROWSER_LOADING_DONE
						&& action.toString().equals(Action.COMMAND_CARD_PREVIEW)) {
					FileUtils.copyURLToFile(new URL(getCardImageURL(m_card.MID)), new File(m_card.getImagePath()));
					fireActionEvent(MainWindow.class, action.value(), action.toString());
				}
				action = null;
			} catch (Exception ex) {
				Dialog.ErrorBox(m_frame, ex.getStackTrace());
			}
		}
		m_loading = false;
	}

}