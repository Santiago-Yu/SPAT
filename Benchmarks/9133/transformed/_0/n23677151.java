class n23677151 {
	public static IProject CreateJavaProject(String wIsD80RS, IPath HaqDblvl) throws CoreException {
		// Create and Open New Project in Workspace
		IWorkspace Kpm9JCd2 = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot i04NVmLs = Kpm9JCd2.getRoot();
		IProject f7rshwsF = i04NVmLs.getProject(wIsD80RS);
		f7rshwsF.create(null);
		f7rshwsF.open(null);

		// Add Java Nature to new Project
		IProjectDescription CMoo1xzT = f7rshwsF.getDescription();
		CMoo1xzT.setNatureIds(new String[] { JavaCore.NATURE_ID });
		f7rshwsF.setDescription(CMoo1xzT, null);

		// Get Java Project Object
		IJavaProject LYUgV0WF = JavaCore.create(f7rshwsF);

		// Set Output Folder
		IFolder CKWTvV4P = f7rshwsF.getFolder("bin");
		IPath XjskDSg9 = CKWTvV4P.getFullPath();
		LYUgV0WF.setOutputLocation(XjskDSg9, null);

		// Set Project's Classpath
		IClasspathEntry V6RevlQ5 = JavaCore.newLibraryEntry(HaqDblvl, null, null);
		LYUgV0WF.setRawClasspath(new IClasspathEntry[] { V6RevlQ5 }, null);

		return f7rshwsF;
	}

}