class n7422454 {
	public void run() {
		if (name == null) {
			System.err.println("Must set file name for retrieval");
			return;
		}
		if (handle == null) {
			System.err.println("Must set CCNHandle");
			return;
		}
		if (htmlPane == null) {
			System.err.println("Must set JEditorPane");
			return;
		}
		JFrame rBXkN5aK = new JFrame();
		JFileChooser AjhUcpJk = new JFileChooser();
		File drkYVHbO = null;
		AjhUcpJk.setCurrentDirectory(null);
		int MKYgReT8 = AjhUcpJk.showSaveDialog(rBXkN5aK);
		if (MKYgReT8 == JFileChooser.APPROVE_OPTION) {
			drkYVHbO = AjhUcpJk.getSelectedFile();
		} else {
			htmlPane.setText("Save File cancelled");
			return;
		}
		boolean MUWRhXqj = false;
		try {
			if (drkYVHbO.exists()) {
				htmlPane.setText("Overwriting contents of " + drkYVHbO.getPath());
				MUWRhXqj = true;
			} else {
				drkYVHbO.createNewFile();
			}
			if (drkYVHbO.canWrite()) {
			} else {
				htmlPane.setText("The ContentExplorer is unable to write the content to the specified file.");
				return;
			}
		} catch (IOException DBm9Cdyn) {
			System.err.println("could not create " + drkYVHbO.getPath() + " for saving content to filesystem");
			htmlPane.setText("could not create " + drkYVHbO.getPath() + " for saving content to filesystem");
		}
		try {
			if (!MUWRhXqj)
				htmlPane.setText("saving " + name + " to " + drkYVHbO.getCanonicalPath());
			else
				htmlPane.setText("overwriting contents of " + drkYVHbO.getCanonicalPath() + " to save " + name);
			CCNFileInputStream DjQZPlIh = new CCNFileInputStream(name, handle);
			FileOutputStream tVHPEuKb = new FileOutputStream(drkYVHbO);
			byte[] NyAJ4SrP = new byte[readsize];
			int TfPqGec2 = 0;
			int zTmAzE8B = 0;
			while ((TfPqGec2 = DjQZPlIh.read(NyAJ4SrP)) != -1) {
				zTmAzE8B += TfPqGec2;
				tVHPEuKb.write(NyAJ4SrP, 0, TfPqGec2);
				tVHPEuKb.flush();
			}
			htmlPane.setText("Saved " + name + " to " + drkYVHbO.getCanonicalPath());
		} catch (Exception mDTx69T9) {
			htmlPane.setText("Could not save " + name + " to " + drkYVHbO.getPath()
					+ " This may be a prefix for an object or just may not be available at this time.");
			System.err.println("Could not retrieve file: " + name);
		}
	}

}