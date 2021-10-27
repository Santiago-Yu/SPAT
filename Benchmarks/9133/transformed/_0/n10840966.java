class n10840966 {
	public void copy(String i51JfzCt, String J83wvtEP) throws IOException {
		File ZtI4ytB5 = new File(i51JfzCt);
		File fA32STrX = new File(J83wvtEP);
		FileInputStream xq6UdWHQ = null;
		FileOutputStream XtqxYSn8 = null;
		try {
			xq6UdWHQ = new FileInputStream(ZtI4ytB5);
			XtqxYSn8 = new FileOutputStream(fA32STrX);
			byte[] cFB7GlTF = new byte[4096];
			int OJPMhJYl;
			while ((OJPMhJYl = xq6UdWHQ.read(cFB7GlTF)) != -1)
				XtqxYSn8.write(cFB7GlTF, 0, OJPMhJYl);
		} finally {
			if (xq6UdWHQ != null)
				try {
					xq6UdWHQ.close();
				} catch (IOException ip3rqsU9) {
					JOptionPane.showMessageDialog(null,
							AcideLanguageManager.getInstance().getLabels().getString("s265") + i51JfzCt,
							AcideLanguageManager.getInstance().getLabels().getString("s266"),
							JOptionPane.ERROR_MESSAGE);
					AcideLog.getLog().error(ip3rqsU9.getMessage());
				}
			if (XtqxYSn8 != null)
				try {
					XtqxYSn8.close();
				} catch (IOException VyATqd2l) {
					JOptionPane.showMessageDialog(null,
							AcideLanguageManager.getInstance().getLabels().getString("s267") + J83wvtEP,
							AcideLanguageManager.getInstance().getLabels().getString("268"), JOptionPane.ERROR_MESSAGE);
					AcideLog.getLog().error(VyATqd2l.getMessage());
				}
		}
	}

}