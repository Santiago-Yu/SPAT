class n21459233 {
	private static IProject createCopyProject(IProject YU448KZz, String OJULmXdz, IWorkspace gZxFHMFO,
			IProgressMonitor FgzpyuWx) throws Exception {
		FgzpyuWx.beginTask("Creating temp project", 1);
		IPath HzgEiLkF = new Path(OJULmXdz);
		IJavaProject xJNBr1hm = JavaCore.create(YU448KZz);
		IClasspathEntry[] ydV2iTLN = xJNBr1hm.getRawClasspath();
		IProject redSsT3K = ResourcesPlugin.getWorkspace().getRoot().getProject(OJULmXdz);
		redSsT3K.create(null);
		redSsT3K.open(null);
		IProjectDescription YCRks21g = redSsT3K.getDescription();
		YCRks21g.setNatureIds(new String[] { JavaCore.NATURE_ID });
		redSsT3K.setDescription(YCRks21g, null);
		List<IClasspathEntry> cAE4hyQ8 = new ArrayList<IClasspathEntry>();
		for (IClasspathEntry LAsLAiiD : ydV2iTLN) {
			switch (LAsLAiiD.getEntryKind()) {
			case IClasspathEntry.CPE_SOURCE:
				System.out.println("Source folder " + LAsLAiiD.getPath());
				cAE4hyQ8.add(copySourceFolder(YU448KZz, redSsT3K, LAsLAiiD, HzgEiLkF));
				break;
			case IClasspathEntry.CPE_LIBRARY:
				System.out.println("library folder " + LAsLAiiD.getPath());
				cAE4hyQ8.add(LAsLAiiD);
				break;
			case IClasspathEntry.CPE_PROJECT:
				System.out.println("project folder " + LAsLAiiD.getPath());
				cAE4hyQ8.add(LAsLAiiD);
				break;
			case IClasspathEntry.CPE_VARIABLE:
				System.out.println("variable folder " + LAsLAiiD.getPath());
				cAE4hyQ8.add(LAsLAiiD);
				break;
			default:
				System.out.println("container folder " + LAsLAiiD.getPath());
				cAE4hyQ8.add(LAsLAiiD);
			}
		}
		copyDir(YU448KZz.getLocation().toString(), "/translator", redSsT3K.getLocation().toString(), "",
				new ArrayList<String>() {

					{
						add("generated");
						add("classes");
						add(".svn");
					}
				});
		redSsT3K.refreshLocal(IResource.DEPTH_INFINITE, FgzpyuWx);
		redSsT3K.build(IncrementalProjectBuilder.AUTO_BUILD, FgzpyuWx);
		redSsT3K.touch(FgzpyuWx);
		IJavaProject z6logmWO = JavaCore.create(redSsT3K);
		z6logmWO.setOutputLocation(new Path("/" + redSsT3K.getName() + "/classes/bin"), null);
		z6logmWO.setRawClasspath(cAE4hyQ8.toArray(new IClasspathEntry[cAE4hyQ8.size()]), FgzpyuWx);
		Map yKn5A23q = xJNBr1hm.getOptions(true);
		z6logmWO.setOptions(yKn5A23q);
		z6logmWO.makeConsistent(FgzpyuWx);
		z6logmWO.save(FgzpyuWx, true);
		return redSsT3K;
	}

}