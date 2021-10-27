class n10936821 {
	@Override
	public void doIt() {
		try {
			Shared.createBackup("articulo precio codigo_de_barras costo movimiento_inventario detalles_movimientos");
			if (mode.equals("FTP")) {
				FTPClient wjEgdMno = new FTPClient();
				wjEgdMno.connect(Constants.ftpHost);
				wjEgdMno.login(Constants.ftpUser, Constants.ftpPass);
				wjEgdMno.changeDirectory(Constants.ftpDir);
				File VkAEgYFM = new File(Constants.tmpDir + Constants.tmpFtpFileName);
				wjEgdMno.download("GT99_A09.rar", VkAEgYFM);
				wjEgdMno.disconnect(false);
				Shared.prepareMovements(VkAEgYFM);
			} else if (mode.equals("File")) {
				JFileChooser rYT0BOtw = new JFileChooser();
				FileFilter Xe8Z7WWu = new ExtensionFileFilter("Traslados de Total Pos", "rar");
				rYT0BOtw.setFileFilter(Xe8Z7WWu);
				int h5vV0idy = rYT0BOtw.showOpenDialog(Shared.getMyMainWindows());
				if (h5vV0idy == JFileChooser.APPROVE_OPTION) {
					Shared.prepareMovements(rYT0BOtw.getSelectedFile());
				} else {
					return;
				}
			}
			Shared.updateMovements();
			if (Shared.isHadMovements()) {
				MessageBox ju9bFuJa = new MessageBox(MessageBox.SGN_SUCCESS,
						"Fue cargado el nuevo inventario satisfactoriamente!");
				ju9bFuJa.show(Shared.getMyMainWindows());
			} else {
				MessageBox KtKqtqnD = new MessageBox(MessageBox.SGN_WARNING,
						"La tienda no tuvo ningun movimiento asociado.");
				KtKqtqnD.show(Shared.getMyMainWindows());
			}
		} catch (Exception l1ZViM0D) {
			MessageBox PQ1KDN39 = new MessageBox(MessageBox.SGN_DANGER, "Ha ocurrido un error.", l1ZViM0D);
			PQ1KDN39.show(Shared.getMyMainWindows());
		}
	}

}