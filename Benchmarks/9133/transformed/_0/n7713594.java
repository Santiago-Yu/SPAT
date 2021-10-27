class n7713594 {
	private static void copyFile(File lPS7lx7Z, File oSjRvmB0, boolean kwAd01hp) throws IOException {
		if (kwAd01hp && isHiddenOrDotFile(lPS7lx7Z)) {
			return;
		}
		if (oSjRvmB0.exists()) {
			System.err.println("Destination File Already Exists: " + oSjRvmB0);
		}
		FileChannel Hv7tWUr1 = null, aM3XDT0m = null;
		try {
			Hv7tWUr1 = new FileInputStream(lPS7lx7Z).getChannel();
			aM3XDT0m = new FileOutputStream(oSjRvmB0).getChannel();
			Hv7tWUr1.transferTo(0, Hv7tWUr1.size(), aM3XDT0m);
		} finally {
			if (Hv7tWUr1 != null) {
				Hv7tWUr1.close();
			}
			if (aM3XDT0m != null) {
				aM3XDT0m.close();
			}
		}
	}

}