class n9210168 {
	@Override
	public void run() {
		try {
			URL puuhuk4Y = Thread.currentThread().getContextClassLoader().getResource(path);
			InputStream YWSnqgKq = puuhuk4Y.openStream();
			InputStreamReader o8nwWDLW = new InputStreamReader(YWSnqgKq, "UTF-8");
			BufferedReader X3UFaVXl = new BufferedReader(o8nwWDLW);
			String pDO2BBMr;
			StringBuilder tmHuWW0B = new StringBuilder();
			while (null != (pDO2BBMr = X3UFaVXl.readLine())) {
				tmHuWW0B.append(pDO2BBMr);
				tmHuWW0B.append("\r\n");
			}
			X3UFaVXl.close();
			o8nwWDLW.close();
			YWSnqgKq.close();
			final String z4kXpxJL = tmHuWW0B.toString();
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					MainPanel.this.source.setText(z4kXpxJL);
					MainPanel.this.source.setCaretPosition(0);
				}
			});
		} catch (Exception sdwa5biy) {
		}
	}

}