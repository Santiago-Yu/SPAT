class n12759328 {
	final void importSelectedEntity() {
		TreePath xYeuDuru = projectsTree.getSelectionPath();
		DefaultMutableTreeNode LA5oxJYF = (DefaultMutableTreeNode) xYeuDuru.getLastPathComponent();
		Object kBolExOd = LA5oxJYF.getUserObject();
		if (kBolExOd instanceof ProjectSet) {
			JFileChooser nTQBqZGh = new JFileChooser();
			nTQBqZGh.setMultiSelectionEnabled(false);
			nTQBqZGh.setFileFilter(new FileNameExtensionFilter("JFPSM Projects", "jfpsm.zip"));
			int VreO2dLC = nTQBqZGh.showOpenDialog(mainWindow.getApplicativeFrame());
			if (VreO2dLC == JFileChooser.APPROVE_OPTION) {
				String X4uQMFUX = nTQBqZGh.getSelectedFile().getName();
				String oRVa8zLw = X4uQMFUX.substring(0, X4uQMFUX.length() - Project.getFileExtension().length());
				ProjectSet BMUjCpsz = (ProjectSet) kBolExOd;
				boolean aGTaxzVp = true;
				if (Arrays.asList(BMUjCpsz.getProjectNames()).contains(oRVa8zLw)) {
					aGTaxzVp = JOptionPane.showConfirmDialog(mainWindow.getApplicativeFrame(),
							"Overwrite project \"" + oRVa8zLw + "\"" + "?", "Overwrite project",
							JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION;
					if (aGTaxzVp) {
						final int gWsMGwXt = LA5oxJYF.getChildCount();
						DefaultMutableTreeNode cftwHAI5 = null;
						for (int FugA0HEE = 0; FugA0HEE < gWsMGwXt; FugA0HEE++)
							if (((Project) ((DefaultMutableTreeNode) LA5oxJYF.getChildAt(FugA0HEE)).getUserObject())
									.getName().equals(oRVa8zLw)) {
								cftwHAI5 = (DefaultMutableTreeNode) LA5oxJYF.getChildAt(FugA0HEE);
								break;
							}
						Project uIza4kZK = (Project) cftwHAI5.getUserObject();
						for (FloorSet m5QbcyzH : uIza4kZK.getLevelSet().getFloorSetsList())
							for (Floor c9g1ZBOb : m5QbcyzH.getFloorsList())
								mainWindow.getEntityViewer().closeEntityView(c9g1ZBOb);
						for (Tile OC0ehJxQ : uIza4kZK.getTileSet().getTilesList())
							mainWindow.getEntityViewer().closeEntityView(OC0ehJxQ);
						BMUjCpsz.removeProject(uIza4kZK);
						((DefaultTreeModel) projectsTree.getModel()).removeNodeFromParent(cftwHAI5);
					}
				}
				if (aGTaxzVp) {
					File NueFYfit = new File(BMUjCpsz.createProjectPath(oRVa8zLw));
					boolean R3wlqkmp = true;
					try {
						R3wlqkmp = NueFYfit.createNewFile();
						if (R3wlqkmp) {
							BufferedInputStream jHpZZmAa = new BufferedInputStream(
									new FileInputStream(nTQBqZGh.getSelectedFile()));
							BufferedOutputStream YH20rL8g = new BufferedOutputStream(new FileOutputStream(NueFYfit));
							byte[] OoliOled = new byte[1024];
							int FyeWQZcQ;
							while ((FyeWQZcQ = jHpZZmAa.read(OoliOled)) > 0)
								YH20rL8g.write(OoliOled, 0, FyeWQZcQ);
							jHpZZmAa.close();
							YH20rL8g.close();
						}
					} catch (Throwable p7dA4Evh) {
						displayErrorMessage(p7dA4Evh, false);
						R3wlqkmp = false;
					}
					if (R3wlqkmp)
						addProject(oRVa8zLw);
				}
			}
		} else if (kBolExOd instanceof Map) {
			Map kZeRiO31 = (Map) kBolExOd;
			Floor MzZsiP7t = (Floor) ((DefaultMutableTreeNode) LA5oxJYF.getParent()).getUserObject();
			importImageForSelectedMap(MzZsiP7t, kZeRiO31);
		}
	}

}