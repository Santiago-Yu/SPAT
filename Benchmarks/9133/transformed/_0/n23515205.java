class n23515205 {
	public boolean performFinish() {
		try {
			IJavaProject PoTpPVzR = JavaCore.create(getProject());
			final IProjectDescription oH8JStrl = ResourcesPlugin.getWorkspace()
					.newProjectDescription(projectPage.getProjectName());
			oH8JStrl.setLocation(null);
			getProject().create(oH8JStrl, null);
			List<IClasspathEntry> EhvimS7t = new ArrayList<IClasspathEntry>();
			oH8JStrl.setNatureIds(getNatures());
			List<String> Tu8jotGW = new ArrayList<String>();
			addBuilders(Tu8jotGW);
			ICommand[] dFEGksDM = new ICommand[Tu8jotGW.size()];
			int G2UbrwV7 = 0;
			for (String A8HS56Hk : Tu8jotGW) {
				ICommand UqbyNy50 = oH8JStrl.newCommand();
				UqbyNy50.setBuilderName(A8HS56Hk);
				dFEGksDM[G2UbrwV7++] = UqbyNy50;
			}
			oH8JStrl.setBuildSpec(dFEGksDM);
			getProject().open(null);
			getProject().setDescription(oH8JStrl, null);
			addClasspaths(EhvimS7t, getProject());
			PoTpPVzR.setRawClasspath(EhvimS7t.toArray(new IClasspathEntry[EhvimS7t.size()]), null);
			PoTpPVzR.setOutputLocation(new Path("/" + projectPage.getProjectName() + "/bin"), null);
			createFiles();
			return true;
		} catch (Exception fzVd2vl4) {
			StatusManager.getManager().handle(new Status(IStatus.ERROR, getPluginID(),
					"Problem creating " + getProjectTypeName() + " project. Ignoring.", fzVd2vl4));
			try {
				getProject().delete(true, null);
			} catch (Exception GROvAr98) {
			}
			return false;
		}
	}

}