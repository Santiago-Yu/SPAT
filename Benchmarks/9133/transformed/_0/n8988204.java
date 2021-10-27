class n8988204 {
	@Override
	public void onLoadingEnded() {
		if (m_frame != null) {
			try {
				String Fvb5ppMJ = getDocument().getDocumentURI();
				URL CUBU3pYb = new URL(Fvb5ppMJ);
				InputStreamReader A20pi9kb = new InputStreamReader(CUBU3pYb.openStream());
				BufferedReader PHr6urOn = new BufferedReader(A20pi9kb);
				String QTn2Jm7v;
				Fvb5ppMJ = null;
				CUBU3pYb = null;
				m_content.clear();
				while ((QTn2Jm7v = PHr6urOn.readLine()) != null) {
					m_content.add(QTn2Jm7v);
				}
				PHr6urOn.close();
				A20pi9kb = null;
				PHr6urOn = null;
				QTn2Jm7v = null;
				Action nlaTm5sC = parseHtml();
				if (nlaTm5sC.value() == Action.ACTION_BROWSER_LOADING_DONE
						&& nlaTm5sC.toString().equals(Action.COMMAND_CARD_PREVIEW)) {
					FileUtils.copyURLToFile(new URL(getCardImageURL(m_card.MID)), new File(m_card.getImagePath()));
					fireActionEvent(MainWindow.class, nlaTm5sC.value(), nlaTm5sC.toString());
				}
				nlaTm5sC = null;
			} catch (Exception NYoFXSNJ) {
				Dialog.ErrorBox(m_frame, NYoFXSNJ.getStackTrace());
			}
		}
		m_loading = false;
	}

}