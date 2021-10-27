class n5557139 {
	public void valueChanged(ListSelectionEvent BC382lsL) {
		if (BC382lsL.getValueIsAdjusting())
			return;
		ListSelectionModel jamdagkX = (ListSelectionModel) BC382lsL.getSource();
		if (jamdagkX.isSelectionEmpty()) {
		} else {
			int pUXshnHq = jamdagkX.getMinSelectionIndex();
			ChemModel jSS4bhMG = modelContent.getValueAt(sortedModelContent.getSortedIndex(pUXshnHq));
			DADMLResult L3Tx2uSc = (DADMLResult) jSS4bhMG.getProperty("org.openscience.cdk.internet.DADMLResult");
			URL V4hGXrzt = L3Tx2uSc.getURL();
			try {
				URLConnection OLrQySKr = V4hGXrzt.openConnection();
				InputStreamReader f8842Y17 = new InputStreamReader(OLrQySKr.getInputStream());
				if (APIVersionTester.isBiggerOrEqual("1.8", editBus.getAPIVersion())) {
					try {
						editBus.showChemFile(f8842Y17);
						return;
					} catch (Exception BcU0HAx5) {
						logger.error("EditBus error: ", BcU0HAx5.getMessage());
						logger.debug(BcU0HAx5);
					}
				}
				IChemObjectReader NsraSWlC = readerFactory.createReader(f8842Y17);
				ChemFile OmrvU4pq = (ChemFile) NsraSWlC.read(new ChemFile());
				editBus.showChemFile(OmrvU4pq);
			} catch (FileNotFoundException zAMlFd6k) {
				String EoYeeUx2 = "Resource not found: " + V4hGXrzt;
				logger.error(EoYeeUx2);
				JOptionPane.showMessageDialog(null, EoYeeUx2);
				return;
			} catch (Exception N8SdlryK) {
				String z6qJlYn7 = "Error while reading file: " + N8SdlryK.getMessage();
				logger.error(z6qJlYn7);
				logger.debug(N8SdlryK);
				JOptionPane.showMessageDialog(null, z6qJlYn7);
				return;
			}
			logger.warn("Not displaying model with unknown content");
		}
	}

}