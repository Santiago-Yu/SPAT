class n7162385 {
	@Override
	public boolean postPage() {
		MySpaceBlogExporterGuiApp.getApplication().getWizContainer()
				.showStatus(myResourceMap.getString("CheckingBlogUrl.text"));
		URL tz3L4rpc;
		try {
			tz3L4rpc = new URL(txtBlogUrl.getText());
			URLConnection RRjm5THA = tz3L4rpc.openConnection();
			RRjm5THA.getContentType();
			String NVuBUqs8 = RRjm5THA.getURL().toString();
			if (!NVuBUqs8.equalsIgnoreCase(txtBlogUrl.getText())) {
				JOptionPane.showMessageDialog(new JFrame(), myResourceMap.getString("InvalidBlogUrl.text"), "Error",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} catch (Exception JmgDtoUW) {
			JOptionPane.showMessageDialog(new JFrame(), myResourceMap.getString("InvalidUrl.text"), "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			MySpaceBlogExporterGuiApp.getApplication().getWizContainer().hideStatus();
		}
		if (txtBlogUrl.getText().toLowerCase().indexOf("friendid") > 0) {
			JOptionPane.showMessageDialog(new JFrame(), myResourceMap.getString("InvalidBlogUrl.text"), "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		MySpaceBlogExporterGuiApp.getApplication().getMySpaceBlogExporter().setBlogUrl(txtBlogUrl.getText());
		return true;
	}

}