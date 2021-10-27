class n1829463 {
	public boolean createProject(String projectName, String export) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProgressMonitor progressMonitor = new NullProgressMonitor();
		IProject project = root.getProject(projectName);
		try {
			if (!project.exists()) {
				project.create(progressMonitor);
			}
			project.open(progressMonitor);
			IProjectDescription description = project.getDescription();
			description.setNatureIds(new String[] { JavaCore.NATURE_ID });
			project.setDescription(description, progressMonitor);
			IJavaProject javaProject = JavaCore.create(project);
			IFolder binFolder = project.getFolder("bin");
			IFolder outputFolder = project.getFolder(export);
			if (!binFolder.exists()) {
				binFolder.create(false, true, null);
			}
			javaProject.setOutputLocation(outputFolder.getFullPath(), progressMonitor);
			IVMInstall vmInstall = JavaRuntime.getDefaultVMInstall();
			List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
			LibraryLocation[] locations = JavaRuntime.getLibraryLocations(vmInstall);
			for (LibraryLocation element : locations) {
				entries.add(JavaCore.newLibraryEntry(element.getSystemLibraryPath(), null, null));
			}
			javaProject.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), null);
			IFolder sourceFolder = project.getFolder("src");
			if (!sourceFolder.exists()) {
				sourceFolder.create(false, true, null);
			}
			IPackageFragmentRoot rootfolder = javaProject.getPackageFragmentRoot(sourceFolder);
			IClasspathEntry[] oldEntries = javaProject.getRawClasspath();
			IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 1];
			System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
			newEntries[oldEntries.length] = JavaCore.newSourceEntry(rootfolder.getPath());
			javaProject.setRawClasspath(newEntries, null);
			IPackageFragment pack;
			StringBuffer buffer = new StringBuffer();
			if (rootfolder.getPackageFragment("") == null) {
				pack = rootfolder.createPackageFragment("", true, progressMonitor);
			} else {
				pack = rootfolder.getPackageFragment("");
			}
			buffer.append("\n");
			buffer.append(source);
			ICompilationUnit cu = pack.createCompilationUnit("ProcessingApplet.java", buffer.toString(), false, null);
			return true;
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return false;
	}

}