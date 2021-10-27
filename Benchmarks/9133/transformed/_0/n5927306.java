class n5927306 {
	boolean createSessionArchive(String cxyOKNKU) {
		byte[] JDUZeoE9 = new byte[1024];
		try {
			ZipOutputStream yPqXaXAy = new ZipOutputStream(new FileOutputStream(cxyOKNKU));
			for (mAnnotationsCursor.moveToFirst(); !mAnnotationsCursor.isAfterLast(); mAnnotationsCursor.moveToNext()) {
				FileInputStream IwQG2haQ = new FileInputStream(mAnnotationsCursor.getString(ANNOTATIONS_FILE_NAME));
				yPqXaXAy.putNextEntry(new ZipEntry("audio" + (mAnnotationsCursor.getPosition() + 1) + ".3gpp"));
				int KJgleXvg;
				while ((KJgleXvg = IwQG2haQ.read(JDUZeoE9)) > 0)
					yPqXaXAy.write(JDUZeoE9, 0, KJgleXvg);
				yPqXaXAy.closeEntry();
				IwQG2haQ.close();
			}
			yPqXaXAy.close();
		} catch (IOException esPM9nLB) {
			Toast.makeText(mActivity, mActivity.getString(R.string.error_zip) + " " + esPM9nLB.getMessage(),
					Toast.LENGTH_SHORT).show();
			return false;
		}
		return true;
	}

}