class n20939940 {
	private IProject createJavaProject() {
		IProject dvHSn9Yc = ResourcesPlugin.getWorkspace().getRoot().getProject("DefaultFolderPropertiesTest");
		if (!dvHSn9Yc.exists()) {
			try {
				dvHSn9Yc.create(null);
				dvHSn9Yc.open(null);
				IProjectDescription YaRbxOFx = dvHSn9Yc.getDescription();
				YaRbxOFx.setNatureIds(new String[] { JavaCore.NATURE_ID });
				dvHSn9Yc.setDescription(YaRbxOFx, null);
				IJavaProject j3nqalV2 = JavaCore.create(dvHSn9Yc);
				j3nqalV2.open(null);
				IFolder yAabrwdw = dvHSn9Yc.getFolder(new Path("src"));
				yAabrwdw.create(true, true, null);
				IFolder RInu8KE7 = dvHSn9Yc.getFolder(new Path("custom_src"));
				RInu8KE7.create(true, true, null);
				IClasspathEntry[] BMJJGtgf = new IClasspathEntry[] { JavaCore.newSourceEntry(yAabrwdw.getFullPath()),
						JavaCore.newSourceEntry(RInu8KE7.getFullPath()), JavaRuntime.getDefaultJREContainerEntry() };
				j3nqalV2.setRawClasspath(BMJJGtgf, null);
				IFolder cUvzEvbg = dvHSn9Yc.getFolder(new Path("bin"));
				if (!cUvzEvbg.exists()) {
					cUvzEvbg.create(true, true, null);
				}
				j3nqalV2.setOutputLocation(cUvzEvbg.getFullPath(), null);
				IFolder Inv8CmQg = dvHSn9Yc.getFolder(new Path("test"));
				Inv8CmQg.create(true, true, null);
				IFolder Sypl3zeA = dvHSn9Yc.getFolder(new Path("result"));
				Sypl3zeA.create(true, true, null);
			} catch (CoreException p0zpnCnW) {
				fail(p0zpnCnW.getMessage());
			}
		}
		return dvHSn9Yc;
	}

}