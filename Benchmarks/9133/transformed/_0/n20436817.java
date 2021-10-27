class n20436817 {
	private void copyXsl(File a0FUrYxa) {
		Trace.println(Trace.LEVEL.UTIL, "copyXsl( " + a0FUrYxa.getName() + " )", true);
		if (myXslSourceDir == null) {
			return;
		}
		File[] J1xw9NGR = myXslSourceDir.listFiles();
		for (int Ex9x7VJo = 0; Ex9x7VJo < J1xw9NGR.length; Ex9x7VJo++) {
			File Q6KCBqlw = J1xw9NGR[Ex9x7VJo];
			if (!Q6KCBqlw.isDirectory()) {
				File nQXoYhKi = new File(a0FUrYxa + File.separator + Q6KCBqlw.getName());
				FileChannel x1sTOK9H = null;
				FileChannel p3kzLInB = null;
				try {
					x1sTOK9H = new FileInputStream(Q6KCBqlw).getChannel();
					p3kzLInB = new FileOutputStream(nQXoYhKi).getChannel();
					x1sTOK9H.transferTo(0, x1sTOK9H.size(), p3kzLInB);
				} catch (IOException x49EBR6V) {
					throw new IOError(x49EBR6V);
				} finally {
					if (x1sTOK9H != null)
						try {
							x1sTOK9H.close();
						} catch (IOException m72ieebV) {
							throw new IOError(m72ieebV);
						}
					if (p3kzLInB != null)
						try {
							p3kzLInB.close();
						} catch (IOException ghA7LXqY) {
							throw new IOError(ghA7LXqY);
						}
				}
			}
		}
	}

}