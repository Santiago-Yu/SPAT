class n12157537 {
	private IProject createCopyProject(IProject Kwotbp7y, IWorkspace DSHfvnyL, IProgressMonitor sm2oxqlL)
			throws CoreException {
		sm2oxqlL.beginTask("Creating temp project", 1);
		final String rzB7r92w = "translation_" + Kwotbp7y.getName() + "_"
				+ new Date().toString().replace(" ", "_").replace(":", "_");
		final IProgressMonitor HZNkKRRK = new NullProgressMonitor();
		final IPath YAgFuLF8 = new Path(rzB7r92w);
		Kwotbp7y.copy(YAgFuLF8, false, HZNkKRRK);
		final IJavaProject Fhujh0XE = JavaCore.create(Kwotbp7y);
		final IClasspathEntry[] fszILHHI = Fhujh0XE.getRawClasspath();
		final IProject Le6XcKfa = ResourcesPlugin.getWorkspace().getRoot().getProject("NewProjectName");
		final IProjectDescription Nm1X2ajA = Kwotbp7y.getDescription();
		Nm1X2ajA.setNatureIds(new String[] { JavaCore.NATURE_ID });
		Kwotbp7y.setDescription(Nm1X2ajA, null);
		final IJavaProject szojdNpH = JavaCore.create(Le6XcKfa);
		szojdNpH.setOutputLocation(Kwotbp7y.getFullPath(), null);
		final List<IClasspathEntry> eG1SFbTr = new ArrayList<IClasspathEntry>();
		for (final IClasspathEntry J640fsDV : eG1SFbTr) {
			switch (J640fsDV.getContentKind()) {
			case IClasspathEntry.CPE_SOURCE:
				System.out.println("Source folder " + J640fsDV.getPath());
				break;
			default:
				eG1SFbTr.add(J640fsDV);
			}
		}
		szojdNpH.setRawClasspath(fszILHHI, sm2oxqlL);
		final IProject N8uS3yyY = DSHfvnyL.getRoot().getProject(rzB7r92w);
		return N8uS3yyY;
	}

}