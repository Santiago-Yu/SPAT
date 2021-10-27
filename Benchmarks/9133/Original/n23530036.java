class n23530036{
    public void save(boolean saveAs) {
        OutputStream outputStream = null;
        if (!saveAs) {
            try {
                URL url = new URL(null);
                outputStream = url.openConnection().getOutputStream();
            } catch (Exception e) {
                outputStream = null;
            }
        }
        if (outputStream == null) {
            JFileChooser fileChooser = graphEditorFrame.getFileChooser();
            int option = fileChooser.showSaveDialog(splitPane);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                tabPanel.setText(file.getName());
                try {
                    outputStream = new FileOutputStream(file);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(splitPane, e);
                }
            } else {
                return;
            }
        }
        try {
            Element rootElement = nodeSpecTable.toXML();
            XMLHelper.write(rootElement, outputStream, null);
            outputStream.close();
            setModified(false);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(splitPane, e);
        }
    }

}