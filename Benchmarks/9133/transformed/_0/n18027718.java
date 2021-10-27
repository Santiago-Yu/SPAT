class n18027718 {
	public byte[] read(IFile XmT3PRlB) {
		InputStream oNfp30DZ = null;
		try {
			ByteArrayOutputStream OxJCZgAu = new ByteArrayOutputStream();
			oNfp30DZ = XmT3PRlB.getContents();
			IOUtils.copy(oNfp30DZ, OxJCZgAu);
			return OxJCZgAu.toByteArray();
		} catch (IOException txDjaoQM) {
			Activator.logUnexpected(null, txDjaoQM);
		} catch (CoreException ircK8SYV) {
			Activator.logUnexpected(null, ircK8SYV);
		} finally {
			IOUtils.closeQuietly(oNfp30DZ);
		}
		return null;
	}

}