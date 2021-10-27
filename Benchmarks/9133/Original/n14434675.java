class n14434675{
    private void updateDataSetSelected(URL url) {
        InputStream in = null;
        try {
            in = url.openStream();
            StringBuilder sb = new StringBuilder();
            int by = in.read();
            while (by != -1) {
                sb.append((char) by);
                by = in.read();
            }
            in.close();
            String s = sb.toString();
            final int packetTagLength = 10;
            int contentLength = Integer.parseInt(s.substring(4, packetTagLength));
            String sxml = s.substring(packetTagLength, packetTagLength + contentLength);
            Reader xin = new BufferedReader(new StringReader(sxml));
            DocumentBuilder builder;
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource source = new InputSource(xin);
            final Document document = builder.parse(source);
            Runnable run = new Runnable() {

                public void run() {
                    try {
                        XPathFactory factory = XPathFactory.newInstance();
                        XPath xpath = (XPath) factory.newXPath();
                        String curr = Das2ServerDataSourceEditorPanel.this.timeRangeTextField.getText();
                        Node description = (Node) xpath.evaluate("/stream/properties/@description", document, XPathConstants.NODE);
                        descriptionLabel.setText(description == null ? "" : description.getNodeValue());
                        Node exampleRange = (Node) xpath.evaluate("/stream/properties/@exampleRange", document, XPathConstants.NODE);
                        if (exampleRange != null && curr.equals(DEFAULT_TIMERANGE)) {
                            Das2ServerDataSourceEditorPanel.this.timeRangeTextField.setText(exampleRange.getNodeValue());
                        }
                        if (exampleRange != null) {
                            DefaultComboBoxModel model = new DefaultComboBoxModel(new String[] { "Example Time Ranges", exampleRange.getNodeValue() });
                            Das2ServerDataSourceEditorPanel.this.examplesComboBox.setModel(model);
                            Das2ServerDataSourceEditorPanel.this.examplesComboBox.setEnabled(true);
                        } else {
                            DefaultComboBoxModel model = new DefaultComboBoxModel(new String[] { "No example time ranges found..." });
                            Das2ServerDataSourceEditorPanel.this.examplesComboBox.setModel(model);
                            Das2ServerDataSourceEditorPanel.this.examplesComboBox.setEnabled(false);
                        }
                        if (exampleRange == null) {
                            exampleRange = (Node) xpath.evaluate("/stream/properties/@x_range", document, XPathConstants.NODE);
                            if (exampleRange != null && curr.equals(DEFAULT_TIMERANGE)) {
                                Das2ServerDataSourceEditorPanel.this.timeRangeTextField.setText(exampleRange.getNodeValue());
                            }
                        }
                        Node validRange = (Node) xpath.evaluate("/stream/properties/@validRange", document, XPathConstants.NODE);
                        if (validRange != null) {
                            Das2ServerDataSourceEditorPanel.this.validRangeLabel.setText("valid range: " + validRange.getNodeValue());
                        } else {
                            Das2ServerDataSourceEditorPanel.this.validRangeLabel.setText("<html><em>no valid range for dataset provided</em></html>");
                        }
                    } catch (XPathExpressionException ex) {
                        Logger.getLogger(Das2ServerDataSourceEditorPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            SwingUtilities.invokeLater(run);
        } catch (SAXException ex) {
            JOptionPane.showMessageDialog(examplesComboBox, "Unable to parse dsdf: " + ex.getMessage());
            Logger.getLogger(Das2ServerDataSourceEditorPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            JOptionPane.showMessageDialog(examplesComboBox, "Unable to parse dsdf: " + ex.getMessage());
            Logger.getLogger(Das2ServerDataSourceEditorPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(examplesComboBox, "Unable to parse dsdf: " + ex.getMessage());
            Logger.getLogger(Das2ServerDataSourceEditorPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(examplesComboBox, "Unable to parse dsdf: " + ex.getMessage());
            Logger.getLogger(Das2ServerDataSourceEditorPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (in != null) in.close();
            } catch (IOException ex) {
                Logger.getLogger(Das2ServerDataSourceEditorPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}