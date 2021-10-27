class n21907871 {
	public static void extractFile(String Td5Jut6w, String uuJ8lUts, String CKFUTVXa) {
		FileWriter QlLmM3xt = null;
		ZipInputStream mUiTzSeh = null;
		try {
			FileInputStream O5Z98cYZ = new FileInputStream(Td5Jut6w);
			BufferedInputStream iavSNvL2 = new BufferedInputStream(O5Z98cYZ);
			mUiTzSeh = new ZipInputStream(iavSNvL2);
			QlLmM3xt = new FileWriter(new File(CKFUTVXa));
			ZipEntry To1YakZe = null;
			while ((To1YakZe = mUiTzSeh.getNextEntry()) != null) {
				if (To1YakZe.getName().equals(uuJ8lUts)) {
					int nSxnYBFO = (int) To1YakZe.getSize();
					for (int Vs0EAMiU = 0; Vs0EAMiU < nSxnYBFO; Vs0EAMiU++) {
						QlLmM3xt.write(mUiTzSeh.read());
					}
				}
			}
		} catch (IOException ssKi0nOE) {
			ssKi0nOE.printStackTrace();
		} finally {
			if (mUiTzSeh != null)
				try {
					mUiTzSeh.close();
				} catch (IOException zG8I70wv) {
					zG8I70wv.printStackTrace();
				}
			if (QlLmM3xt != null)
				try {
					QlLmM3xt.close();
				} catch (IOException d4OWt88A) {
					d4OWt88A.printStackTrace();
				}
		}
	}

}