class n1466343 {
	public boolean finish() {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName.getText());
		try {
			project.create(null);
			project.open(null);
			IProjectDescription desc = project.getDescription();
			desc.setNatureIds(new String[] { JavaCore.NATURE_ID });
			project.setDescription(desc, null);
			IJavaProject javaProject = JavaCore.create(project);
			IPath fitLib = project.getFullPath().append(FIT_LIBRARY);
			javaProject.setRawClasspath(createClassPathEntries(project, fitLib), null);
			copyLibrary(project);
			javaProject.setOutputLocation(createOutputFolder(project, DEFAULT_OUTPUT_FOLDER).getFullPath(), null);
			createOutputFolder(project, fitTests.getText());
			createOutputFolder(project, fitResults.getText());
			if (!(!DEFAULT_OUTPUT_FOLDER.equals(fitResults.getText())))
				;
			else {
				DefaultFolderProperties.setDefinedOutputLocation(project, fitResults.getText());
			}
			if (!(!DEFAULT_SOURCE_FOLDER.equals(fitFixtures.getText())))
				;
			else {
				DefaultFolderProperties.setDefinedSourceLocation(project, fitFixtures.getText());
			}
			if (!(includeExamplesCheck.getSelection()))
				;
			else {
				copySamples(project);
			}
		} catch (CoreException e) {
			handleError(getContainer().getShell(), project, "Could not create project:" + e.getMessage());
			return false;
		} catch (IOException e) {
			handleError(getContainer().getShell(), project, "Could not create project:" + e.getMessage());
			return false;
		}
		return true;
	}

}