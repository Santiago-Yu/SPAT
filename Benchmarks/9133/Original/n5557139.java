class n5557139{
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) return;
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();
            if (lsm.isSelectionEmpty()) {
            } else {
                int selectedRow = lsm.getMinSelectionIndex();
                ChemModel model = modelContent.getValueAt(sortedModelContent.getSortedIndex(selectedRow));
                DADMLResult resource = (DADMLResult) model.getProperty("org.openscience.cdk.internet.DADMLResult");
                URL url = resource.getURL();
                try {
                    URLConnection connection = url.openConnection();
                    InputStreamReader input = new InputStreamReader(connection.getInputStream());
                    if (APIVersionTester.isBiggerOrEqual("1.8", editBus.getAPIVersion())) {
                        try {
                            editBus.showChemFile(input);
                            return;
                        } catch (Exception exception) {
                            logger.error("EditBus error: ", exception.getMessage());
                            logger.debug(exception);
                        }
                    }
                    IChemObjectReader reader = readerFactory.createReader(input);
                    ChemFile chemFile = (ChemFile) reader.read(new ChemFile());
                    editBus.showChemFile(chemFile);
                } catch (FileNotFoundException exception) {
                    String error = "Resource not found: " + url;
                    logger.error(error);
                    JOptionPane.showMessageDialog(null, error);
                    return;
                } catch (Exception exception) {
                    String error = "Error while reading file: " + exception.getMessage();
                    logger.error(error);
                    logger.debug(exception);
                    JOptionPane.showMessageDialog(null, error);
                    return;
                }
                logger.warn("Not displaying model with unknown content");
            }
        }

}