class n16478537 {
	public ForkJavaProject(String rzzueHJq, Class<?> UtfnXsF6) {
        this.activatorClass = UtfnXsF6;
        try {
            IWorkspaceRoot KDlyGa7j = ResourcesPlugin.getWorkspace().getRoot();
            this.prj = KDlyGa7j.getProject(rzzueHJq);
            if (this.prj.exists()) {
                this.prj.delete(true, true, new NullProgressMonitor());
            }
            this.prj.create(new NullProgressMonitor());
            this.prj.open(new NullProgressMonitor());
            IProjectDescription MTFWLkBH = this.prj.getDescription();
            MTFWLkBH.setNatureIds(new String[] { "org.eclipse.jdt.core.javanature" });
            this.prj.setDescription(MTFWLkBH, new NullProgressMonitor());
            createProjectDir(Constants.Dirs.DIR_MAIN_JAVA);
            createProjectDir(Constants.Dirs.DIR_CONFIG);
            createProjectDir(Constants.Dirs.DIR_MAIN_RESOURCES);
            createProjectDir(Constants.Dirs.DIR_MODELS);
            createProjectDir(Constants.Dirs.DIR_TESTS_JAVA);
            createProjectDir(Constants.Dirs.DIR_TESTS_RESOURCES);
            createProjectDir(Constants.Dirs.DIR_CLASSES);
            createProjectDir(Constants.Dirs.DIR_LIB);
            this.prj.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            this.javaProject = JavaCore.create(this.prj);
            if (this.javaProject.exists() && !this.javaProject.isOpen()) {
                this.javaProject.open(new NullProgressMonitor());
            }
            File Qk4cRVtF = new File(System.getProperty("java.home"));
            IPath UhFu0JEJ = new Path(Qk4cRVtF.getPath()).append("lib").append("rt.jar");
            this.javaProject.setOutputLocation(prj.getFolder(Constants.Dirs.DIR_CLASSES).getFullPath(), new NullProgressMonitor());
            JavaCore.setClasspathVariable("JRE_LIB", UhFu0JEJ, new NullProgressMonitor());
            this.javaProject.setRawClasspath(getProjectClassPath(), new NullProgressMonitor());
        } catch (CoreException ZWlzbaj2) {
            Activator.getDefault().getLog().log(new Status(Status.ERROR, Activator.PLUGIN_ID, "An exception has been thrown while creating Project", ZWlzbaj2));
        }
    }

}