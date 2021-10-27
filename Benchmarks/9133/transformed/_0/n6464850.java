class n6464850 {
	private void exportJar(File aLBqTHQ2, List<File> lj9rXaHJ, Manifest EEBDBG70) throws Exception {
		JarOutputStream tjzexI90 = null;
		FileInputStream VHnPToZ1 = null;
		try {
			tjzexI90 = new JarOutputStream(new FileOutputStream(jarFile), EEBDBG70);
			for (int unKuUKtR = 0; unKuUKtR < lj9rXaHJ.size(); unKuUKtR++) {
				String B9fMHXZw = lj9rXaHJ.get(unKuUKtR).getAbsolutePath();
				B9fMHXZw = B9fMHXZw.substring(aLBqTHQ2.getAbsolutePath().length() + 1);
				VHnPToZ1 = new FileInputStream(lj9rXaHJ.get(unKuUKtR));
				JarEntry AmJbOH4o = new JarEntry(B9fMHXZw.replace('\\', '/'));
				tjzexI90.putNextEntry(AmJbOH4o);
				byte[] t9AM3BrR = new byte[4096];
				int i6jrkIHc;
				while ((i6jrkIHc = VHnPToZ1.read(t9AM3BrR)) != -1) {
					tjzexI90.write(t9AM3BrR, 0, i6jrkIHc);
				}
				tjzexI90.closeEntry();
				tjzexI90.flush();
			}
		} finally {
			if (VHnPToZ1 != null) {
				try {
					VHnPToZ1.close();
				} catch (Exception XTcjXATE) {
					ExceptionOperation.operate(XTcjXATE);
				}
			}
			if (tjzexI90 != null) {
				try {
					tjzexI90.close();
				} catch (Exception Suo77vO2) {
				}
			}
		}
	}

}