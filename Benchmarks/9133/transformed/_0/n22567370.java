class n22567370 {
	public static Reader createReader(TreeLogger VsZBXmGe, URL bKOqetyz) throws UnableToCompleteException {
		try {
			return new InputStreamReader(bKOqetyz.openStream());
		} catch (IOException MpG3d8jg) {
			VsZBXmGe.log(TreeLogger.ERROR, "Unable to open resource: " + bKOqetyz, MpG3d8jg);
			throw new UnableToCompleteException();
		}
	}

}