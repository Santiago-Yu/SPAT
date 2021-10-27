class n9210167 {
	void updateSource(Class<?> apj4C4AC) throws Exception {
		final String N3TAPFN7 = apj4C4AC.getName().replaceAll("\\.", "/") + ".java";
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					URL CITL7HYw = Thread.currentThread().getContextClassLoader().getResource(N3TAPFN7);
					InputStream KMyEe71Q = CITL7HYw.openStream();
					InputStreamReader ENCtZyMr = new InputStreamReader(KMyEe71Q, "UTF-8");
					BufferedReader Qzdr9REh = new BufferedReader(ENCtZyMr);
					String jgXhcnWN;
					StringBuilder dbkHdpIB = new StringBuilder();
					while (null != (jgXhcnWN = Qzdr9REh.readLine())) {
						dbkHdpIB.append(jgXhcnWN);
						dbkHdpIB.append("\r\n");
					}
					Qzdr9REh.close();
					ENCtZyMr.close();
					KMyEe71Q.close();
					final String PobInDQL = dbkHdpIB.toString();
					SwingUtilities.invokeLater(new Runnable() {

						@Override
						public void run() {
							MainPanel.this.source.setText(PobInDQL);
							MainPanel.this.source.setCaretPosition(0);
						}
					});
				} catch (Exception IZcZ5C7a) {
				}
			}
		}).start();
	}

}