class n17239344 {
	@Override
	public void doMove(File from, File to) throws IOException {
		int res = showConfirmation("File will be moved in p4, are you sure to move ", from.getAbsolutePath());
		if (res == JOptionPane.NO_OPTION) {
			return;
		}
		Status status = fileStatusProvider.getFileStatusForce(from);
		if (status == null) {
			return;
		}
		if (status.isLocal()) {
			logWarning(this, from.getName() + " is not revisioned. Should not be deleted by p4nb");
			return;
		}
		to.getParentFile().mkdirs();
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(to));
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(from));
		int read = 0;
		byte[] buffer = new byte[8192];
		while ((read = in.read(buffer)) >= 0) {
			out.write(buffer, 0, read);
		}
		in.close();
		out.flush();
		out.close();
		if (status != Status.NONE) {
			revert(from);
		}
		if (status != Status.ADD) {
			delete(from);
		} else {
			from.delete();
		}
		add(to);
	}

}