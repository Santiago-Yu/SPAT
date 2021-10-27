class n10174803 {
	@SuppressWarnings({ "serial", "unchecked" })
	private static IProject createCopyProject(IProject Qy2lzFyZ, String wyoaaKhE, IWorkspace jxtfzqxe,
			IProgressMonitor Ut8r0wZc) throws Exception {
		Ut8r0wZc.beginTask("Creating temp project", 1);
		final IPath jYLkjG7q = new Path(wyoaaKhE);
		final IJavaProject sJYBU7W5 = JavaCore.create(Qy2lzFyZ);
		final IClasspathEntry[] ia70Q0qI = sJYBU7W5.getRawClasspath();
		final IProject j7wzvOXG = ResourcesPlugin.getWorkspace().getRoot().getProject(wyoaaKhE);
		j7wzvOXG.create(null);
		j7wzvOXG.open(null);
		final IProjectDescription ecbEb6Wj = j7wzvOXG.getDescription();
		ecbEb6Wj.setNatureIds(new String[] { JavaCore.NATURE_ID });
		j7wzvOXG.setDescription(ecbEb6Wj, null);
		final List<IClasspathEntry> bq87o2Dg = new ArrayList<IClasspathEntry>();
		for (final IClasspathEntry bqZ3lSv4 : ia70Q0qI) {
			switch (bqZ3lSv4.getEntryKind()) {
			case IClasspathEntry.CPE_SOURCE:
				System.out.println("Source folder " + bqZ3lSv4.getPath());
				bq87o2Dg.add(copySourceFolder(Qy2lzFyZ, j7wzvOXG, bqZ3lSv4, jYLkjG7q));
				break;
			case IClasspathEntry.CPE_LIBRARY:
				System.out.println("library folder " + bqZ3lSv4.getPath());
				bq87o2Dg.add(bqZ3lSv4);
				break;
			case IClasspathEntry.CPE_PROJECT:
				System.out.println("project folder " + bqZ3lSv4.getPath());
				bq87o2Dg.add(bqZ3lSv4);
				break;
			case IClasspathEntry.CPE_VARIABLE:
				System.out.println("variable folder " + bqZ3lSv4.getPath());
				bq87o2Dg.add(bqZ3lSv4);
				break;
			default:
				System.out.println("container folder " + bqZ3lSv4.getPath());
				bq87o2Dg.add(bqZ3lSv4);
			}
		}
		copyDir(Qy2lzFyZ.getLocation().toString(), "/translator", j7wzvOXG.getLocation().toString(), "",
				new ArrayList<String>() {

					{
						add("generated");
						add("classes");
						add(".svn");
					}
				});
		j7wzvOXG.refreshLocal(IResource.DEPTH_INFINITE, Ut8r0wZc);
		j7wzvOXG.build(IncrementalProjectBuilder.AUTO_BUILD, Ut8r0wZc);
		j7wzvOXG.touch(Ut8r0wZc);
		final IJavaProject A6SfoQOl = JavaCore.create(j7wzvOXG);
		A6SfoQOl.setOutputLocation(new Path("/" + j7wzvOXG.getName() + "/classes/bin"), null);
		A6SfoQOl.setRawClasspath(bq87o2Dg.toArray(new IClasspathEntry[bq87o2Dg.size()]), Ut8r0wZc);
		final Map fYm28snw = sJYBU7W5.getOptions(true);
		A6SfoQOl.setOptions(fYm28snw);
		A6SfoQOl.makeConsistent(Ut8r0wZc);
		A6SfoQOl.save(Ut8r0wZc, true);
		return j7wzvOXG;
	}

}