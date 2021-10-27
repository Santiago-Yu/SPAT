class n9195362 {
	public static long copy(File pQLfpepI, File OtGYVN7d) throws UtilException {
		FileChannel PW4CMGPP = null;
		FileChannel UoWDwt91 = null;
		try {
			PW4CMGPP = new FileInputStream(pQLfpepI).getChannel();
			UoWDwt91 = new FileOutputStream(OtGYVN7d).getChannel();
			long E2QO3sjy = PW4CMGPP.size();
			PW4CMGPP.transferTo(0, E2QO3sjy, UoWDwt91);
			return E2QO3sjy;
		} catch (IOException lGgrPBPI) {
			throw new UtilException(lGgrPBPI);
		} finally {
			try {
				if (PW4CMGPP != null)
					PW4CMGPP.close();
				PW4CMGPP = null;
			} catch (IOException A80gV5Gi) {
			}
			try {
				if (UoWDwt91 != null)
					UoWDwt91.close();
				UoWDwt91 = null;
			} catch (IOException dYixxsT3) {
			}
		}
	}

}