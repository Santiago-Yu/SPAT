class n17374904 {
	protected void saveSelectedFiles() {
		if (0 == dataList.getSelectedRowCount()) {
			return;
		}
		if (1 == dataList.getSelectedRowCount()) {
			Object obj = model.getItemAtRow(sorter.convertRowIndexToModel(dataList.getSelectedRow()));
			AttachFile entry = (AttachFile) obj;
			JFileChooser fc = new JFileChooser();
			fc.setSelectedFile(new File(fc.getCurrentDirectory(), entry.getCurrentPath().getName()));
			if (JFileChooser.APPROVE_OPTION == fc.showSaveDialog(this)) {
				File current = entry.getCurrentPath();
				File dest = fc.getSelectedFile();
				try {
					FileInputStream in = new FileInputStream(current);
					FileOutputStream out = new FileOutputStream(dest);
					byte[] readBuf = new byte[1024 * 512];
					int readLength;
					while ((readLength = in.read(readBuf)) != -1) {
						out.write(readBuf, 0, readLength);
					}
					in.close();
					out.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return;
		} else {
			JFileChooser fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if (JFileChooser.APPROVE_OPTION == fc.showSaveDialog(this)) {
				for (Integer idx : dataList.getSelectedRows()) {
					Object obj = model.getItemAtRow(sorter.convertRowIndexToModel(idx));
					AttachFile entry = (AttachFile) obj;
					File current = entry.getCurrentPath();
					File dest = new File(fc.getSelectedFile(), entry.getName());
					try {
						FileInputStream in = new FileInputStream(current);
						FileOutputStream out = new FileOutputStream(dest);
						byte[] readBuf = new byte[1024 * 512];
						int readLength;
						while ((readLength = in.read(readBuf)) != -1) {
							out.write(readBuf, 0, readLength);
						}
						in.close();
						out.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return;
		}
	}

}