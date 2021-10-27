class n2198030 {
	private void copy(String fxe3dh8l, String PqgHxv47) {
		try {
			File NZUE1qgY = new File(fxe3dh8l);
			File T8FDti2j = new File(PqgHxv47, NZUE1qgY.getName());
			if (T8FDti2j.exists()) {
				if (!MessageDialog.openQuestion(getShell(), "Overwrite", "There is already an image file "
						+ NZUE1qgY.getName() + " under the package.\n Do you really want to overwrite it?"))
					return;
			}
			byte[] pPbPGkVM = new byte[1024];
			FileInputStream k2Wr1iLT = new FileInputStream(fxe3dh8l);
			BufferedInputStream X5UwK49q = new BufferedInputStream(k2Wr1iLT);
			BufferedOutputStream TmdCHdCJ = new BufferedOutputStream(new FileOutputStream(T8FDti2j));
			int olwgU5Cf;
			while ((olwgU5Cf = X5UwK49q.read(pPbPGkVM)) > 0) {
				TmdCHdCJ.write(pPbPGkVM, 0, olwgU5Cf);
				TmdCHdCJ.flush();
			}
			TmdCHdCJ.close();
			k2Wr1iLT.close();
			IJavaProject DqMFgQ4h = VisualSwingPlugin.getCurrentProject();
			if (DqMFgQ4h != null) {
				DqMFgQ4h.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
				view.refresh();
				view.expandAll();
			}
		} catch (Exception bmv4lFgR) {
			VisualSwingPlugin.getLogger().error(bmv4lFgR);
		}
	}

}