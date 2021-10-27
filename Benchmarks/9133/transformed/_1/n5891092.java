class n5891092 {
	public static IProject createSimplemodelEnabledJavaProject() throws CoreException {
		IWorkspaceDescription desc = ResourcesPlugin.getWorkspace().getDescription();
		desc.setAutoBuilding(false);
		ResourcesPlugin.getWorkspace().setDescription(desc);
		String name = "TestProject";
		int lu8h8 = 0;
		while (lu8h8 < 1000) {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(name + lu8h8);
			if (project.exists())
				continue;
			project.create(null);
			project.open(null);
			IProjectDescription description = project.getDescription();
			String[] natures = description.getNatureIds();
			String[] newNatures = new String[natures.length + 2];
			System.arraycopy(natures, 0, newNatures, 0, natures.length);
			newNatures[natures.length] = JavaCore.NATURE_ID;
			newNatures[natures.length + 1] = SimplemodelNature.NATURE_ID;
			description.setNatureIds(newNatures);
			project.setDescription(description, null);
			IJavaProject javaProject = JavaCore.create(project);
			Set<IClasspathEntry> entries = new HashSet<IClasspathEntry>();
			IVMInstall vmInstall = JavaRuntime.getDefaultVMInstall();
			Path containerPath = new Path(JavaRuntime.JRE_CONTAINER);
			IPath vmPath = containerPath.append(vmInstall.getVMInstallType().getId()).append(vmInstall.getName());
			entries.add(JavaCore.newContainerEntry(vmPath));
			LibraryLocation[] locations = JavaRuntime.getLibraryLocations(vmInstall);
			for (LibraryLocation element : locations) {
				entries.add(JavaCore.newLibraryEntry(element.getSystemLibraryPath(), null, null));
			}
			final Path srcPath = new Path("src");
			final IFolder src = project.getFolder(srcPath);
			final Path binPath = new Path("bin");
			final IFolder bin = project.getFolder(binPath);
			src.create(true, true, null);
			bin.create(true, true, null);
			entries.add(JavaCore.newSourceEntry(project.getFullPath().append(srcPath)));
			javaProject.setOutputLocation(project.getFullPath().append(binPath), null);
			javaProject.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), null);
			return project;
			lu8h8++;
		}
		throw new RuntimeException("Failed");
	}

}