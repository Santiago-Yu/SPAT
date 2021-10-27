class n14284540 {
	public static void copyAFile(final String UzGdSDi2, final String R867MzpJ) {
		FileChannel vcjXCShP = null;
		FileChannel mDYPmwoQ = null;
		try {
			vcjXCShP = new FileInputStream(UzGdSDi2).getChannel();
			mDYPmwoQ = new FileOutputStream(R867MzpJ).getChannel();
			vcjXCShP.transferTo(0, vcjXCShP.size(), mDYPmwoQ);
		} catch (Exception p4XR2w9E) {
			p4XR2w9E.printStackTrace();
		} finally {
			if (vcjXCShP != null) {
				try {
					vcjXCShP.close();
				} catch (IOException soD1jNqJ) {
					soD1jNqJ.printStackTrace();
				}
			}
			if (mDYPmwoQ != null) {
				try {
					mDYPmwoQ.close();
				} catch (IOException jlhVVw7c) {
					jlhVVw7c.printStackTrace();
				}
			}
		}
	}

}