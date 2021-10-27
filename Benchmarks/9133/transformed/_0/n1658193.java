class n1658193 {
	public ForkJavaProject(String bUnbrwvG, Class<?> HokocooW) {
        this.activatorClass = HokocooW;
        try {
            IWorkspaceRoot ucthSKCe = ResourcesPlugin.getWorkspace().getRoot();
            this.prj = ucthSKCe.getProject(bUnbrwvG);
            if (this.prj.exists()) {
                this.prj.delete(true, true, new NullProgressMonitor());
            }
            this.prj.create(new NullProgressMonitor());
            this.prj.open(new NullProgressMonitor());
            IProjectDescription ZmX2bXty = this.prj.getDescription();
            ZmX2bXty.setNatureIds(new String[] { "org.eclipse.jdt.core.javanature" });
            this.prj.setDescription(ZmX2bXty, new NullProgressMonitor());
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
            File f1KMLeOA = new File(System.getProperty("java.home"));
            IPath Bek1KGfW = new Path(f1KMLeOA.getPath()).append("lib").append("rt.jar");
            this.javaProject.setOutputLocation(prj.getFolder(Constants.Dirs.DIR_CLASSES).getFullPath(), new NullProgressMonitor());
            JavaCore.setClasspathVariable("JRE_LIB", Bek1KGfW, new NullProgressMonitor());
            this.javaProject.setRawClasspath(getProjectClassPath(), new NullProgressMonitor());
        } catch (CoreException FznJ2KFM) {
            Activator.getDefault().logError("An exception has been thrown while creating Project", FznJ2KFM);
        }
    }

}