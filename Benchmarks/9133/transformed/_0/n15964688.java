class n15964688 {
	public void actionPerformed(ActionEvent lyR3tpct) {
		if (lyR3tpct.getActionCommand().equals("LOAD")) {
			JFileChooser tERXTwjI = new JFileChooser();
			tERXTwjI.setFileFilter(new JPEGFilter());
			tERXTwjI.setMultiSelectionEnabled(false);
			if (tERXTwjI.showOpenDialog(getTopLevelAncestor()) == JFileChooser.APPROVE_OPTION) {
				try {
					File NvLSJJ2E = tERXTwjI.getSelectedFile();
					BufferedInputStream J0Lmk7ek = new BufferedInputStream(new FileInputStream(NvLSJJ2E));
					ByteArrayOutputStream kBJo6ekX = new ByteArrayOutputStream((int) NvLSJJ2E.length());
					int S1ALgJ3R = J0Lmk7ek.read();
					while (S1ALgJ3R != -1) {
						kBJo6ekX.write(S1ALgJ3R);
						S1ALgJ3R = J0Lmk7ek.read();
					}
					J0Lmk7ek.close();
					_changed = true;
					setImage(kBJo6ekX.toByteArray());
				} catch (Exception lsQ0Q91i) {
					_log.error("actionPerformed(ActionEvent)", lsQ0Q91i);
				}
			}
		} else if (lyR3tpct.getActionCommand().equals("SAVE")) {
			JFileChooser ho7X0qGR = new JFileChooser();
			ho7X0qGR.setFileFilter(new JPEGFilter());
			ho7X0qGR.setMultiSelectionEnabled(false);
			if (_data != null && ho7X0qGR.showSaveDialog(getTopLevelAncestor()) == JFileChooser.APPROVE_OPTION) {
				try {
					File q9c1RThv = ho7X0qGR.getSelectedFile();
					BufferedOutputStream OU7x3Snd = new BufferedOutputStream(new FileOutputStream(q9c1RThv));
					OU7x3Snd.write(_data);
					OU7x3Snd.flush();
					OU7x3Snd.close();
				} catch (Exception r8OmoG6Q) {
					_log.error("actionPerformed(ActionEvent)", r8OmoG6Q);
				}
			}
		} else if (lyR3tpct.getActionCommand().equals("DELETE")) {
			if (_data != null) {
				int WROFKU0h = JOptionPane.showConfirmDialog(getTopLevelAncestor(),
						GuiStrings.getString("message.removeimg"), GuiStrings.getString("title.confirm"),
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (WROFKU0h == JOptionPane.YES_OPTION) {
					removeImage();
					_changed = true;
				}
			}
		}
	}

}