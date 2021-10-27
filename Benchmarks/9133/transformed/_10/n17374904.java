class n17374904 {
	protected void saveSelectedFiles() {
		if (dataList.getSelectedRowCount() == 0) {
			return;
		}
		if (dataList.getSelectedRowCount() == 1) {
			Object obj = model.getItemAtRow(sorter.convertRowIndexToModel(dataList.getSelectedRow()));
			JFileChooser fc = new JFileChooser();
			AttachFile entry = (AttachFile) obj;
			fc.setSelectedFile(new File(fc.getCurrentDirectory(), entry.getCurrentPath().getName()));
			if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				File current = entry.getCurrentPath();
				File dest = fc.getSelectedFile();
				try {
					FileOutputStream out = new FileOutputStream(dest);
					FileInputStream in = new FileInputStream(current);
					int readLength;
					byte[] readBuf = new byte[1024 * 512];
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
			if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				for (Integer idx : dataList.getSelectedRows()) {
					Object obj = model.getItemAtRow(sorter.convertRowIndexToModel(idx));
					AttachFile entry = (AttachFile) obj;
					File current = entry.getCurrentPath();
					File dest = new File(fc.getSelectedFile(), entry.getName());
					try {
						FileOutputStream out = new FileOutputStream(dest);
						FileInputStream in = new FileInputStream(current);
						int readLength;
						byte[] readBuf = new byte[1024 * 512];
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