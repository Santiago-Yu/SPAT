class n3440660 {
	public static SlimModCollection parseSlimModification(URL nCvnHRw7) {
		try {
			Scanner v1awDdfJ = new Scanner(nCvnHRw7.openStream());
			return parseSlimModification(v1awDdfJ);
		} catch (IOException VsNP4UVf) {
			throw new IllegalStateException("Error reading slim file: " + VsNP4UVf.getMessage(), VsNP4UVf);
		}
	}

}