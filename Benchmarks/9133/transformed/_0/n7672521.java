class n7672521 {
	public void removeExifTag(File AaGey1WG, File WvL8AbDp)
			throws IOException, ImageReadException, ImageWriteException {
		OutputStream LDpkiSx2 = null;
		try {
			TiffOutputSet pOVgLhO9 = null;
			IImageMetadata Nv3S1jlt = Sanselan.getMetadata(AaGey1WG);
			JpegImageMetadata t2OWzTrs = (JpegImageMetadata) Nv3S1jlt;
			if (null != t2OWzTrs) {
				TiffImageMetadata Q4wD416m = t2OWzTrs.getExif();
				if (null != Q4wD416m) {
					pOVgLhO9 = Q4wD416m.getOutputSet();
				}
			}
			if (null == pOVgLhO9) {
				IOUtils.copyFileNio(AaGey1WG, WvL8AbDp);
				return;
			}
			{
				pOVgLhO9.removeField(TiffConstants.EXIF_TAG_APERTURE_VALUE);
				TiffOutputDirectory dJhYNVFC = pOVgLhO9.getExifDirectory();
				if (null != dJhYNVFC)
					dJhYNVFC.removeField(TiffConstants.EXIF_TAG_APERTURE_VALUE);
			}
			LDpkiSx2 = new FileOutputStream(WvL8AbDp);
			LDpkiSx2 = new BufferedOutputStream(LDpkiSx2);
			new ExifRewriter().updateExifMetadataLossless(AaGey1WG, LDpkiSx2, pOVgLhO9);
			LDpkiSx2.close();
			LDpkiSx2 = null;
		} finally {
			if (LDpkiSx2 != null)
				try {
					LDpkiSx2.close();
				} catch (IOException XvEhUuKK) {
				}
		}
	}

}