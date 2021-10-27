class n2858807 {
	public void actionPerformed(ActionEvent IYIR7jQN) {
		Window bI7RtGTb = SwingUtilities.getWindowAncestor(invokerInfo.getComponent());
		if (IYIR7jQN.getActionCommand().equals(LOAD)) {
			URLChooser w2kTybWZ;
			if (bI7RtGTb instanceof Frame) {
				w2kTybWZ = new URLChooser((Frame) bI7RtGTb);
			} else {
				w2kTybWZ = new URLChooser((Dialog) bI7RtGTb);
			}
			w2kTybWZ.setTitle("Load Prototype");
			w2kTybWZ.setLabelText("  Prototype URL:  ");
			w2kTybWZ.setNullSelectionValid(false);
			w2kTybWZ.setFileFilter(new javax.swing.filechooser.FileFilter() {

				public boolean accept(File WeTLZNx2) {
					return WeTLZNx2.getName().endsWith(".xml") || WeTLZNx2.isDirectory();
				}

				public String getDescription() {
					return "XML Prototype Files";
				}
			});
			w2kTybWZ.setResourceFilter(new ResourceFilter() {

				public boolean accept(ResourceDescriptor Wq2E27Ax) {
					return Wq2E27Ax.getType().equals(ResourceDescriptor.NPSNETV_PROTOTYPE);
				}
			});
			GUIUtilities.positionDialog(invokerInfo.getComponent(), invokerInfo.getInvocationPoint(), w2kTybWZ);
			if (w2kTybWZ.showDialog(null)) {
				URL K8iJmHh9 = w2kTybWZ.getSelectedURL();
				try {
					target.applyPrototype(K8iJmHh9);
				} catch (Exception BibSjl6A) {
					JOptionPane.showMessageDialog(invokerInfo.getComponent(), BibSjl6A, "Error Loading Prototype",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if (IYIR7jQN.getActionCommand().equals(SAVE)) {
			URLChooser MhiSKAHC;
			if (bI7RtGTb instanceof Frame) {
				MhiSKAHC = new URLChooser((Frame) bI7RtGTb);
			} else {
				MhiSKAHC = new URLChooser((Dialog) bI7RtGTb);
			}
			MhiSKAHC.setTitle("Save Prototype");
			MhiSKAHC.setLabelText("  Prototype URL:  ");
			MhiSKAHC.setNullSelectionValid(false);
			MhiSKAHC.setFileFilter(new javax.swing.filechooser.FileFilter() {

				public boolean accept(File PZ6z6FtW) {
					return PZ6z6FtW.getName().endsWith(".xml") || PZ6z6FtW.isDirectory();
				}

				public String getDescription() {
					return "XML Prototype Files";
				}
			});
			MhiSKAHC.setResourceFilter(new ResourceFilter() {

				public boolean accept(ResourceDescriptor RgmTnhqj) {
					return RgmTnhqj.getType().equals(ResourceDescriptor.NPSNETV_PROTOTYPE);
				}
			});
			GUIUtilities.positionDialog(invokerInfo.getComponent(), invokerInfo.getInvocationPoint(), MhiSKAHC);
			if (MhiSKAHC.showDialog(null)) {
				URL FoGnEEJW = MhiSKAHC.getSelectedURL();
				try {
					PrintStream uxhmfy2g;
					HttpURLConnection IrGGudaX = null;
					if (FoGnEEJW.getProtocol().equals("file")) {
						uxhmfy2g = new PrintStream(new FileOutputStream(FoGnEEJW.getFile()));
					} else {
						URLConnection RLH7iy7c = FoGnEEJW.openConnection();
						RLH7iy7c.setDoOutput(true);
						if (RLH7iy7c instanceof HttpURLConnection) {
							IrGGudaX = ((HttpURLConnection) RLH7iy7c);
							IrGGudaX.setRequestMethod("PUT");
						}
						uxhmfy2g = new PrintStream(RLH7iy7c.getOutputStream());
					}
					target.writePrototype(uxhmfy2g);
					if (IrGGudaX != null) {
						IrGGudaX.getResponseCode();
					}
				} catch (Exception NfLFPTQF) {
					JOptionPane.showMessageDialog(invokerInfo.getComponent(), NfLFPTQF, "Error Saving Prototype",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if (IYIR7jQN.getActionCommand().equals(PUBLISH)) {
			PublishPrototypeDialog AzRqyUFG;
			if (bI7RtGTb instanceof Frame) {
				AzRqyUFG = new PublishPrototypeDialog((Frame) bI7RtGTb, target);
			} else {
				AzRqyUFG = new PublishPrototypeDialog((Dialog) bI7RtGTb, target);
			}
			GUIUtilities.positionDialog(invokerInfo.getComponent(), invokerInfo.getInvocationPoint(), AzRqyUFG);
			AzRqyUFG.show();
		} else if (IYIR7jQN.getActionCommand().equals(VIEW_EDIT)) {
			ViewEditPrototypeDialog h3P48pA8;
			if (bI7RtGTb instanceof Frame) {
				h3P48pA8 = new ViewEditPrototypeDialog((Frame) bI7RtGTb, target);
			} else {
				h3P48pA8 = new ViewEditPrototypeDialog((Dialog) bI7RtGTb, target);
			}
			GUIUtilities.positionDialog(invokerInfo.getComponent(), invokerInfo.getInvocationPoint(), h3P48pA8);
			h3P48pA8.show();
		}
	}

}