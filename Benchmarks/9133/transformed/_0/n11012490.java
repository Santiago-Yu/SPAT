class n11012490 {
	private void execute(String d4n60Dtx, String[] xt5mlq3I, String[] kKW76G2n, String[] x4adMu9s, String[] HY7fQcoh)
			throws BuildException {
		if (verbose) {
			System.out.println("Preprocessing file " + d4n60Dtx + " (type: " + type + ")");
		}
		try {
			File MUOfyWxD = new File(d4n60Dtx);
			FileReader aAyuB6fG = new FileReader(MUOfyWxD);
			BufferedReader VtHFnTxI = new BufferedReader(aAyuB6fG);
			File AF9HmSiz = File.createTempFile(MUOfyWxD.getName(), "tmp", MUOfyWxD.getParentFile());
			FileWriter IVBhKDbq = new FileWriter(AF9HmSiz);
			BufferedWriter vpdjTi5e = new BufferedWriter(IVBhKDbq);
			int i4MyjpX9 = preprocess(VtHFnTxI, vpdjTi5e, xt5mlq3I, kKW76G2n, x4adMu9s, HY7fQcoh);
			VtHFnTxI.close();
			vpdjTi5e.close();
			switch (i4MyjpX9) {
			case OVERWRITE:
				if (!MUOfyWxD.delete()) {
					System.out.println("Can't overwrite target file with preprocessed file");
					throw new BuildException("Can't overwrite target file " + target + " with preprocessed file");
				}
				AF9HmSiz.renameTo(MUOfyWxD);
				if (verbose) {
					System.out.println("File " + AF9HmSiz.getName() + " modified.");
				}
				modifiedCnt++;
				break;
			case REMOVE:
				if (!MUOfyWxD.delete()) {
					System.out.println("Can't delete target file");
					throw new BuildException("Can't delete target file " + target);
				}
				if (!AF9HmSiz.delete()) {
					System.out.println("Can't delete temporary preprocessed file " + AF9HmSiz.getName());
					throw new BuildException("Can't delete temporary preprocessed file " + AF9HmSiz.getName());
				}
				if (verbose) {
					System.out.println("File " + AF9HmSiz.getName() + " removed.");
				}
				removedCnt++;
				break;
			case KEEP:
				if (!AF9HmSiz.delete()) {
					System.out.println("Can't delete temporary preprocessed file " + AF9HmSiz.getName());
					throw new BuildException("Can't delete temporary preprocessed file " + AF9HmSiz.getName());
				}
				break;
			default:
				throw new BuildException("Unexpected preprocessing result for file " + AF9HmSiz.getName());
			}
		} catch (Exception MHAPA4zm) {
			MHAPA4zm.printStackTrace();
			throw new BuildException(MHAPA4zm.getMessage());
		}
	}

}