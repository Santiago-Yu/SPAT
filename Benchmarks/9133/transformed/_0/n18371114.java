class n18371114 {
	public static void copy(final File FHmiABzb, final File z3n8o0vP) throws IOException {
		FileChannel aRnJ0kQf = null;
		FileChannel bu87hSQp = null;
		try {
			aRnJ0kQf = new FileInputStream(FHmiABzb).getChannel();
			bu87hSQp = new FileOutputStream(z3n8o0vP).getChannel();
			long cI6Mtey4 = aRnJ0kQf.size();
			MappedByteBuffer aWIueLbk = aRnJ0kQf.map(FileChannel.MapMode.READ_ONLY, 0, cI6Mtey4);
			bu87hSQp.write(aWIueLbk);
			z3n8o0vP.setLastModified(FHmiABzb.lastModified());
		} finally {
			close(aRnJ0kQf);
			close(bu87hSQp);
		}
	}

}