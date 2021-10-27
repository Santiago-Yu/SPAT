class n2858807 {
	public void actionPerformed(ActionEvent ae) {
		Window win = SwingUtilities.getWindowAncestor(invokerInfo.getComponent());
		if (ae.getActionCommand().equals(LOAD)) {
			URLChooser uc;
			uc = (win instanceof Frame) ? new URLChooser((Frame) win) : new URLChooser((Dialog) win);
			uc.setTitle("Load Prototype");
			uc.setLabelText("  Prototype URL:  ");
			uc.setNullSelectionValid(false);
			uc.setFileFilter(new javax.swing.filechooser.FileFilter() {

				public boolean accept(File f) {
					return f.getName().endsWith(".xml") || f.isDirectory();
				}

				public String getDescription() {
					return "XML Prototype Files";
				}
			});
			uc.setResourceFilter(new ResourceFilter() {

				public boolean accept(ResourceDescriptor rd) {
					return rd.getType().equals(ResourceDescriptor.NPSNETV_PROTOTYPE);
				}
			});
			GUIUtilities.positionDialog(invokerInfo.getComponent(), invokerInfo.getInvocationPoint(), uc);
			if (uc.showDialog(null)) {
				URL url = uc.getSelectedURL();
				try {
					target.applyPrototype(url);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(invokerInfo.getComponent(), e, "Error Loading Prototype",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if (ae.getActionCommand().equals(SAVE)) {
			URLChooser uc;
			uc = (win instanceof Frame) ? new URLChooser((Frame) win) : new URLChooser((Dialog) win);
			uc.setTitle("Save Prototype");
			uc.setLabelText("  Prototype URL:  ");
			uc.setNullSelectionValid(false);
			uc.setFileFilter(new javax.swing.filechooser.FileFilter() {

				public boolean accept(File f) {
					return f.getName().endsWith(".xml") || f.isDirectory();
				}

				public String getDescription() {
					return "XML Prototype Files";
				}
			});
			uc.setResourceFilter(new ResourceFilter() {

				public boolean accept(ResourceDescriptor rd) {
					return rd.getType().equals(ResourceDescriptor.NPSNETV_PROTOTYPE);
				}
			});
			GUIUtilities.positionDialog(invokerInfo.getComponent(), invokerInfo.getInvocationPoint(), uc);
			if (uc.showDialog(null)) {
				URL url = uc.getSelectedURL();
				try {
					PrintStream ps;
					HttpURLConnection huc = null;
					if (url.getProtocol().equals("file")) {
						ps = new PrintStream(new FileOutputStream(url.getFile()));
					} else {
						URLConnection urlc = url.openConnection();
						urlc.setDoOutput(true);
						if (urlc instanceof HttpURLConnection) {
							huc = ((HttpURLConnection) urlc);
							huc.setRequestMethod("PUT");
						}
						ps = new PrintStream(urlc.getOutputStream());
					}
					target.writePrototype(ps);
					if (huc != null) {
						huc.getResponseCode();
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(invokerInfo.getComponent(), e, "Error Saving Prototype",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if (ae.getActionCommand().equals(PUBLISH)) {
			PublishPrototypeDialog ppd;
			ppd = (win instanceof Frame) ? new PublishPrototypeDialog((Frame) win, target)
					: new PublishPrototypeDialog((Dialog) win, target);
			GUIUtilities.positionDialog(invokerInfo.getComponent(), invokerInfo.getInvocationPoint(), ppd);
			ppd.show();
		} else if (ae.getActionCommand().equals(VIEW_EDIT)) {
			ViewEditPrototypeDialog vepd;
			vepd = (win instanceof Frame) ? new ViewEditPrototypeDialog((Frame) win, target)
					: new ViewEditPrototypeDialog((Dialog) win, target);
			GUIUtilities.positionDialog(invokerInfo.getComponent(), invokerInfo.getInvocationPoint(), vepd);
			vepd.show();
		}
	}

}