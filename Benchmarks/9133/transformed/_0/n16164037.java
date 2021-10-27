class n16164037 {
	public void run(Preprocessor qRhuu8q7) throws SijappException {
		for (int EYeyBxHM = 0; EYeyBxHM < this.filenames.length; EYeyBxHM++) {
			File VBJ1chzj = new File(this.srcDir, this.filenames[EYeyBxHM]);
			BufferedReader slbNxnAk;
			try {
				InputStreamReader VkNnGcSA = new InputStreamReader(new FileInputStream(VBJ1chzj), "CP1251");
				slbNxnAk = new BufferedReader(VkNnGcSA);
			} catch (Exception wzwIFblu) {
				throw (new SijappException("File " + VBJ1chzj.getPath() + " could not be read"));
			}
			File bgy1QIkp = new File(this.destDir, this.filenames[EYeyBxHM]);
			BufferedWriter L5dGwFY7;
			try {
				(new File(bgy1QIkp.getParent())).mkdirs();
				OutputStreamWriter CJA2pdeW = new OutputStreamWriter(new FileOutputStream(bgy1QIkp), "CP1251");
				L5dGwFY7 = new BufferedWriter(CJA2pdeW);
			} catch (Exception FeJbclCG) {
				throw (new SijappException("File " + bgy1QIkp.getPath() + " could not be written"));
			}
			try {
				qRhuu8q7.run(slbNxnAk, L5dGwFY7);
			} catch (SijappException X7gsoDsp) {
				try {
					slbNxnAk.close();
				} catch (IOException MOFVRWfN) {
				}
				try {
					L5dGwFY7.close();
				} catch (IOException F1OQzeYp) {
				}
				try {
					bgy1QIkp.delete();
				} catch (SecurityException GvNEp6PI) {
				}
				throw (new SijappException(VBJ1chzj.getPath() + ":" + X7gsoDsp.getMessage()));
			}
			try {
				slbNxnAk.close();
			} catch (IOException mVcmMevZ) {
			}
			try {
				L5dGwFY7.close();
			} catch (IOException VSQ0djEZ) {
			}
		}
	}

}