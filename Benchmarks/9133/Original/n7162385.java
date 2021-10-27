class n7162385{
    @Override
    public boolean postPage() {
        MySpaceBlogExporterGuiApp.getApplication().getWizContainer().showStatus(myResourceMap.getString("CheckingBlogUrl.text"));
        URL url;
        try {
            url = new URL(txtBlogUrl.getText());
            URLConnection con = url.openConnection();
            con.getContentType();
            String newLink = con.getURL().toString();
            if (!newLink.equalsIgnoreCase(txtBlogUrl.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), myResourceMap.getString("InvalidBlogUrl.text"), "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), myResourceMap.getString("InvalidUrl.text"), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            MySpaceBlogExporterGuiApp.getApplication().getWizContainer().hideStatus();
        }
        if (txtBlogUrl.getText().toLowerCase().indexOf("friendid") > 0) {
            JOptionPane.showMessageDialog(new JFrame(), myResourceMap.getString("InvalidBlogUrl.text"), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        MySpaceBlogExporterGuiApp.getApplication().getMySpaceBlogExporter().setBlogUrl(txtBlogUrl.getText());
        return true;
    }

}