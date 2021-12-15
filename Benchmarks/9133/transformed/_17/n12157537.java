class n12157537 {
	private IProject createCopyProject(IProject project, IWorkspace ws, IProgressMonitor pm) throws CoreException {
		pm.beginTask("Creating temp project", 1);
		final String pName = "translation_" + project.getName() + "_"
				+ new Date().toString().replace(" ", "_").replace(":", "_");
		final IProgressMonitor npm = new NullProgressMonitor();
		final IPath destination = new Path(pName);
		project.copy(destination, false, npm);
		final IJavaProject oldJavaproj = JavaCore.create(project);
		final IClasspathEntry[] classPath = oldJavaproj.getRawClasspath();
		final IProject newProject = ResourcesPlugin.getWorkspace().getRoot().getProject("NewProjectName");
		final IProjectDescription desc = project.getDescription();
		desc.setNatureIds(new String[] { JavaCore.NATURE_ID });
		project.setDescription(desc, null);
		final IJavaProject javaproj = JavaCore.create(newProject);
		javaproj.setOutputLocation(project.getFullPath(), null);
		final List<IClasspathEntry> newClassPath = new ArrayList<IClasspathEntry>();
		for (final IClasspathEntry cEntry : newClassPath) {
			if (cEntry.getContentKind() == IClasspathEntry.CPE_SOURCE) {
				System.out.println("Source folder " + cEntry.getPath());
			} else {
				newClassPath.add(cEntry);
			}
		}
		javaproj.setRawClasspath(classPath, pm);
		final IProject newP = ws.getRoot().getProject(pName);
		return newP;
	}

}