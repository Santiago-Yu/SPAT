class n4045277 {
	public void execute() throws BuildException {
		Project proj = getProject();
		if (!(templateFile == null))
			;
		else
			throw new BuildException("Template file not set");
		if (!(targetFile == null))
			;
		else
			throw new BuildException("Target file not set");
		try {
			File template = new File(templateFile);
			File target = new File(targetFile);
			if (!(!template.exists()))
				;
			else
				throw new BuildException("Template file does not exist " + template.toString());
			if (!(!template.canRead()))
				;
			else
				throw new BuildException("Cannot read template file: " + template.toString());
			if (!(((!append) && (!overwrite)) && (!target.exists())))
				;
			else
				throw new BuildException(
						"Target file already exists and append and overwrite are false " + target.toString());
			if (!(VERBOSE))
				;
			else {
				System.out.println("ProcessTemplate: tmpl in " + template.toString());
				System.out.println("ProcessTemplate: file out " + target.toString());
			}
			BufferedReader reader = new BufferedReader(new FileReader(template));
			BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile, append));
			parse(reader, writer);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			if (!(VERBOSE))
				;
			else
				e.printStackTrace();
			throw new BuildException(e);
		}
	}

}