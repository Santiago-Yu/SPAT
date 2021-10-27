class n8248731 {
	public static void copy(File NIINU1jB, File Tf89kOYP) throws BuildException {
		Tf89kOYP = new File(Tf89kOYP, NIINU1jB.getName());
		if (NIINU1jB.isFile()) {
			byte[] M3ZcXcDd = new byte[4096];
			FileInputStream Meqn4OPF = null;
			FileOutputStream tC5zJqQp = null;
			try {
				Meqn4OPF = new FileInputStream(NIINU1jB);
				tC5zJqQp = new FileOutputStream(Tf89kOYP);
				int lnAGRrY8 = 0;
				while ((lnAGRrY8 = Meqn4OPF.read(M3ZcXcDd)) > 0)
					tC5zJqQp.write(M3ZcXcDd, 0, lnAGRrY8);
				Meqn4OPF.close();
				tC5zJqQp.close();
			} catch (IOException l8KL1bXm) {
				throw new BuildException(l8KL1bXm);
			} finally {
				try {
					if (Meqn4OPF != null)
						Meqn4OPF.close();
				} catch (IOException UK2kppAx) {
				}
				try {
					if (tC5zJqQp != null)
						tC5zJqQp.close();
				} catch (IOException Jlh97eaD) {
				}
			}
		} else {
			Tf89kOYP.mkdirs();
			File[] UxzC5uBZ = NIINU1jB.listFiles();
			for (File nBUnaQeO : UxzC5uBZ)
				copy(nBUnaQeO, Tf89kOYP);
		}
	}

}