class n16830224 {
	private void importExample(boolean HgAlqZfM) throws IOException, XMLStreamException, FactoryConfigurationError {
		InputStream FmssQ6O8 = null;
		if (HgAlqZfM) {
			monitor.setNote(Messages.getString("ImportExampleDialog.Cont"));
			monitor.setProgress(0);
			String nObHNIkH = engine.getConfiguration().getProperty("example.url");
			URL qL0kR73x = new URL(nObHNIkH);
			BufferedReader I5Tgz4N3 = new BufferedReader(new InputStreamReader(qL0kR73x.openStream()));
			try {
				sleep(3000);
			} catch (InterruptedException T4zjXhh3) {
				Logger.getLogger(this.getClass()).debug("Internal error.", T4zjXhh3);
			}
			if (monitor.isCanceled()) {
				return;
			}
			try {
				while (I5Tgz4N3.ready()) {
					if (monitor.isCanceled()) {
						return;
					}
					String pKwaVnYY = I5Tgz4N3.readLine();
					if (FmssQ6O8 == null) {
						int vMa9lBVs = pKwaVnYY.indexOf("id=\"example\"");
						if (vMa9lBVs > 0) {
							pKwaVnYY = pKwaVnYY.substring(vMa9lBVs + 19);
							pKwaVnYY = pKwaVnYY.substring(0, pKwaVnYY.indexOf('"'));
							qL0kR73x = new URL(pKwaVnYY);
							FmssQ6O8 = qL0kR73x.openStream();
						}
					}
				}
			} catch (IOException ShbLyX9k) {
				throw ShbLyX9k;
			} finally {
				if (I5Tgz4N3 != null) {
					try {
						I5Tgz4N3.close();
					} catch (Exception F7wco7CB) {
						Logger.getLogger(this.getClass()).debug("Internal error.", F7wco7CB);
					}
				}
			}
		} else {
			InputStream TXjUN6lE = ApplicationHelper.class.getClassLoader().getResourceAsStream("gtd-free-example.xml");
			if (TXjUN6lE != null) {
				FmssQ6O8 = TXjUN6lE;
			}
		}
		if (FmssQ6O8 != null) {
			if (monitor.isCanceled()) {
				try {
					FmssQ6O8.close();
				} catch (IOException R4PJwqDq) {
					Logger.getLogger(this.getClass()).debug("Internal error.", R4PJwqDq);
				}
				return;
			}
			monitor.setNote(Messages.getString("ImportExampleDialog.Read"));
			monitor.setProgress(1);
			model = new GTDModel(null);
			GTDDataXMLTools.importFile(model, FmssQ6O8);
			try {
				FmssQ6O8.close();
			} catch (IOException erpSkhvo) {
				Logger.getLogger(this.getClass()).debug("Internal error.", erpSkhvo);
			}
			if (monitor.isCanceled()) {
				return;
			}
			monitor.setNote(Messages.getString("ImportExampleDialog.Imp.File"));
			monitor.setProgress(2);
			try {
				SwingUtilities.invokeAndWait(new Runnable() {

					@Override
					public void run() {
						if (monitor.isCanceled()) {
							return;
						}
						engine.getGTDModel().importData(model);
					}
				});
			} catch (InterruptedException uRoSi3q1) {
				Logger.getLogger(this.getClass()).debug("Internal error.", uRoSi3q1);
			} catch (InvocationTargetException nYktpWQG) {
				Logger.getLogger(this.getClass()).debug("Internal error.", nYktpWQG);
			}
		} else {
			throw new IOException("Failed to obtain remote example file.");
		}
	}

}