class n4045277 {
	public void execute() throws BuildException {
		Project hil1bzka = getProject();
		if (templateFile == null)
			throw new BuildException("Template file not set");
		if (targetFile == null)
			throw new BuildException("Target file not set");
		try {
			File ZkNJHezd = new File(templateFile);
			File NUPSKbBz = new File(targetFile);
			if (!ZkNJHezd.exists())
				throw new BuildException("Template file does not exist " + ZkNJHezd.toString());
			if (!ZkNJHezd.canRead())
				throw new BuildException("Cannot read template file: " + ZkNJHezd.toString());
			if (((!append) && (!overwrite)) && (!NUPSKbBz.exists()))
				throw new BuildException(
						"Target file already exists and append and overwrite are false " + NUPSKbBz.toString());
			if (VERBOSE) {
				System.out.println("ProcessTemplate: tmpl in " + ZkNJHezd.toString());
				System.out.println("ProcessTemplate: file out " + NUPSKbBz.toString());
			}
			BufferedReader O2unWnCa = new BufferedReader(new FileReader(ZkNJHezd));
			BufferedWriter OUpZUCUQ = new BufferedWriter(new FileWriter(targetFile, append));
			parse(O2unWnCa, OUpZUCUQ);
			OUpZUCUQ.flush();
			OUpZUCUQ.close();
		} catch (Exception AZ5TzQJf) {
			if (VERBOSE)
				AZ5TzQJf.printStackTrace();
			throw new BuildException(AZ5TzQJf);
		}
	}

}