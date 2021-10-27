class n14434675 {
	private void updateDataSetSelected(URL DxTmPQy7) {
		InputStream JMEeMeRd = null;
		try {
			JMEeMeRd = DxTmPQy7.openStream();
			StringBuilder Lss9O8kw = new StringBuilder();
			int Hp2fYhGN = JMEeMeRd.read();
			while (Hp2fYhGN != -1) {
				Lss9O8kw.append((char) Hp2fYhGN);
				Hp2fYhGN = JMEeMeRd.read();
			}
			JMEeMeRd.close();
			String rRtI5zre = Lss9O8kw.toString();
			final int K8K8hTkG = 10;
			int nseGiYjb = Integer.parseInt(rRtI5zre.substring(4, K8K8hTkG));
			String jXrODo6N = rRtI5zre.substring(K8K8hTkG, K8K8hTkG + nseGiYjb);
			Reader mlijsfbN = new BufferedReader(new StringReader(jXrODo6N));
			DocumentBuilder eRWrMxSf;
			eRWrMxSf = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource MyiTY2kK = new InputSource(mlijsfbN);
			final Document SZA43377 = eRWrMxSf.parse(MyiTY2kK);
			Runnable EY37bQIH = new Runnable() {

				public void run() {
					try {
						XPathFactory jF3r6vyj = XPathFactory.newInstance();
						XPath Bf9x4OUX = (XPath) jF3r6vyj.newXPath();
						String HiZsUIIB = Das2ServerDataSourceEditorPanel.this.timeRangeTextField.getText();
						Node UGmdDdbg = (Node) Bf9x4OUX.evaluate("/stream/properties/@description", SZA43377,
								XPathConstants.NODE);
						descriptionLabel.setText(UGmdDdbg == null ? "" : UGmdDdbg.getNodeValue());
						Node Rlz2b3gm = (Node) Bf9x4OUX.evaluate("/stream/properties/@exampleRange", SZA43377,
								XPathConstants.NODE);
						if (Rlz2b3gm != null && HiZsUIIB.equals(DEFAULT_TIMERANGE)) {
							Das2ServerDataSourceEditorPanel.this.timeRangeTextField.setText(Rlz2b3gm.getNodeValue());
						}
						if (Rlz2b3gm != null) {
							DefaultComboBoxModel Ae9BB87N = new DefaultComboBoxModel(
									new String[] { "Example Time Ranges", Rlz2b3gm.getNodeValue() });
							Das2ServerDataSourceEditorPanel.this.examplesComboBox.setModel(Ae9BB87N);
							Das2ServerDataSourceEditorPanel.this.examplesComboBox.setEnabled(true);
						} else {
							DefaultComboBoxModel tJ5M7Mcl = new DefaultComboBoxModel(
									new String[] { "No example time ranges found..." });
							Das2ServerDataSourceEditorPanel.this.examplesComboBox.setModel(tJ5M7Mcl);
							Das2ServerDataSourceEditorPanel.this.examplesComboBox.setEnabled(false);
						}
						if (Rlz2b3gm == null) {
							Rlz2b3gm = (Node) Bf9x4OUX.evaluate("/stream/properties/@x_range", SZA43377,
									XPathConstants.NODE);
							if (Rlz2b3gm != null && HiZsUIIB.equals(DEFAULT_TIMERANGE)) {
								Das2ServerDataSourceEditorPanel.this.timeRangeTextField
										.setText(Rlz2b3gm.getNodeValue());
							}
						}
						Node lEv8z5aB = (Node) Bf9x4OUX.evaluate("/stream/properties/@validRange", SZA43377,
								XPathConstants.NODE);
						if (lEv8z5aB != null) {
							Das2ServerDataSourceEditorPanel.this.validRangeLabel
									.setText("valid range: " + lEv8z5aB.getNodeValue());
						} else {
							Das2ServerDataSourceEditorPanel.this.validRangeLabel
									.setText("<html><em>no valid range for dataset provided</em></html>");
						}
					} catch (XPathExpressionException BzR0J7tV) {
						Logger.getLogger(Das2ServerDataSourceEditorPanel.class.getName()).log(Level.SEVERE, null,
								BzR0J7tV);
					}
				}
			};
			SwingUtilities.invokeLater(EY37bQIH);
		} catch (SAXException PJJzMOs8) {
			JOptionPane.showMessageDialog(examplesComboBox, "Unable to parse dsdf: " + PJJzMOs8.getMessage());
			Logger.getLogger(Das2ServerDataSourceEditorPanel.class.getName()).log(Level.SEVERE, null, PJJzMOs8);
		} catch (ParserConfigurationException zQ2O7pmU) {
			JOptionPane.showMessageDialog(examplesComboBox, "Unable to parse dsdf: " + zQ2O7pmU.getMessage());
			Logger.getLogger(Das2ServerDataSourceEditorPanel.class.getName()).log(Level.SEVERE, null, zQ2O7pmU);
		} catch (MalformedURLException pcPMezKZ) {
			JOptionPane.showMessageDialog(examplesComboBox, "Unable to parse dsdf: " + pcPMezKZ.getMessage());
			Logger.getLogger(Das2ServerDataSourceEditorPanel.class.getName()).log(Level.SEVERE, null, pcPMezKZ);
		} catch (IOException RpSn1oun) {
			JOptionPane.showMessageDialog(examplesComboBox, "Unable to parse dsdf: " + RpSn1oun.getMessage());
			Logger.getLogger(Das2ServerDataSourceEditorPanel.class.getName()).log(Level.SEVERE, null, RpSn1oun);
		} finally {
			try {
				if (JMEeMeRd != null)
					JMEeMeRd.close();
			} catch (IOException noJQm9M4) {
				Logger.getLogger(Das2ServerDataSourceEditorPanel.class.getName()).log(Level.SEVERE, null, noJQm9M4);
			}
		}
	}

}