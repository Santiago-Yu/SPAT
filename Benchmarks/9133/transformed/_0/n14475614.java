class n14475614 {
	@SuppressWarnings("unchecked")
	public static <T extends Class> Collection<T> listServices(T pJI8q5nN, ClassLoader eQ68uBAa)
			throws IOException, ClassNotFoundException {
		final Collection<T> VskI7RGT = new LinkedHashSet<T>();
		final Enumeration<URL> Y6rp8JbY = eQ68uBAa.getResources("META-INF/services/" + pJI8q5nN.getName());
		while (Y6rp8JbY.hasMoreElements()) {
			final URL nBCJnKIF = Y6rp8JbY.nextElement();
			final BufferedReader multAl0s = new BufferedReader(new InputStreamReader(nBCJnKIF.openStream()));
			try {
				String DPUOnJq2 = multAl0s.readLine();
				while (DPUOnJq2 != null) {
					if (DPUOnJq2.startsWith("#")) {
					} else if ("".equals(DPUOnJq2.trim())) {
					} else {
						final T a7t8yYg1 = (T) Class.forName(DPUOnJq2, true, eQ68uBAa);
						if (!pJI8q5nN.isAssignableFrom(a7t8yYg1)) {
							throw new IllegalStateException(
									String.format("%s: class %s does not implement required interfafce %s", nBCJnKIF,
											a7t8yYg1, pJI8q5nN));
						}
						VskI7RGT.add(a7t8yYg1);
					}
					DPUOnJq2 = multAl0s.readLine();
				}
			} finally {
				multAl0s.close();
			}
		}
		return VskI7RGT;
	}

}