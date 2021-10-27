class n1466343 {
	public boolean finish() {
		IProject Q1uUa0gX = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName.getText());
		try {
			Q1uUa0gX.create(null);
			Q1uUa0gX.open(null);
			IProjectDescription Wq39hRFx = Q1uUa0gX.getDescription();
			Wq39hRFx.setNatureIds(new String[] { JavaCore.NATURE_ID });
			Q1uUa0gX.setDescription(Wq39hRFx, null);
			IJavaProject KtvvUxnQ = JavaCore.create(Q1uUa0gX);
			IPath zcKDWeEM = Q1uUa0gX.getFullPath().append(FIT_LIBRARY);
			KtvvUxnQ.setRawClasspath(createClassPathEntries(Q1uUa0gX, zcKDWeEM), null);
			copyLibrary(Q1uUa0gX);
			KtvvUxnQ.setOutputLocation(createOutputFolder(Q1uUa0gX, DEFAULT_OUTPUT_FOLDER).getFullPath(), null);
			createOutputFolder(Q1uUa0gX, fitTests.getText());
			createOutputFolder(Q1uUa0gX, fitResults.getText());
			if (!DEFAULT_OUTPUT_FOLDER.equals(fitResults.getText())) {
				DefaultFolderProperties.setDefinedOutputLocation(Q1uUa0gX, fitResults.getText());
			}
			if (!DEFAULT_SOURCE_FOLDER.equals(fitFixtures.getText())) {
				DefaultFolderProperties.setDefinedSourceLocation(Q1uUa0gX, fitFixtures.getText());
			}
			if (includeExamplesCheck.getSelection()) {
				copySamples(Q1uUa0gX);
			}
		} catch (CoreException Eo7hPwG6) {
			handleError(getContainer().getShell(), Q1uUa0gX, "Could not create project:" + Eo7hPwG6.getMessage());
			return false;
		} catch (IOException g6Hg4QKO) {
			handleError(getContainer().getShell(), Q1uUa0gX, "Could not create project:" + g6Hg4QKO.getMessage());
			return false;
		}
		return true;
	}

}