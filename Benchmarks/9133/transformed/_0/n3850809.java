class n3850809 {
	private void buildBundle() {
		if (targetProject == null) {
			MessageDialog.openError(getShell(), "Error", "No target SPAB project selected!");
			return;
		}
		if (projectProcessDirSelector.getText().trim().length() == 0) {
			MessageDialog.openError(getShell(), "Error",
					"No process directory selected for project " + targetProject.getName() + "!");
			return;
		}
		deleteBundleFile();
		try {
			File EzU5lKdm = targetProject.getLocation().toFile();
			File v6t9Wcjh = new File(EzU5lKdm, projectProcessDirSelector.getText());
			boolean C2nQfApo = IOUtils.copyProcessFilesSecure(getBPMOFile(), v6t9Wcjh);
			boolean Fv6I4Q1T = IOUtils.copyProcessFilesSecure(getSBPELFile(), v6t9Wcjh);
			boolean mtGwieu3 = IOUtils.copyProcessFilesSecure(getBPEL4SWSFile(), v6t9Wcjh);
			bundleFile = IOUtils.archiveBundle(EzU5lKdm, Activator.getDefault().getStateLocation().toFile());
			if (C2nQfApo) {
				new File(v6t9Wcjh, getBPMOFile().getName()).delete();
			}
			if (Fv6I4Q1T) {
				new File(v6t9Wcjh, getSBPELFile().getName()).delete();
			}
			if (mtGwieu3) {
				new File(v6t9Wcjh, getBPEL4SWSFile().getName()).delete();
			}
		} catch (Throwable XwzPm90S) {
			LogManager.logError(XwzPm90S);
			MessageDialog.openError(getShell(), "Error", "Error building SPAB :\n" + XwzPm90S.getMessage());
			updateBundleUI();
			return;
		}
		bpmoFile = getBPMOFile();
		sbpelFile = getSBPELFile();
		xmlFile = getBPEL4SWSFile();
		updateBundleUI();
		getWizard().getContainer().updateButtons();
	}

}