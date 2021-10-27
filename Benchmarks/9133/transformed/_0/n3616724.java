class n3616724 {
	public void onUploadClicked(Event RGZiDOFH) {
		Media[] Mk4DRcBP = null;
		try {
			Mk4DRcBP = Fileupload.get("Select one or more files to upload to " + "the current directory.",
					"Upload Files", 5);
		} catch (Exception e9fmnQiH) {
			log.error("An exception occurred when displaying the file " + "upload dialog", e9fmnQiH);
		}
		if (Mk4DRcBP == null) {
			return;
		}
		for (Media zsxjNJ89 : Mk4DRcBP) {
			String np9sRIEk = zsxjNJ89.getName();
			CSPath tN8cuQ9I = model.getPathForFile(np9sRIEk);
			if (zsxjNJ89.isBinary()) {
				CSPathOutputStream kY6BZnIv = null;
				try {
					tN8cuQ9I.createNewFile();
					if (tN8cuQ9I.exists()) {
						kY6BZnIv = new CSPathOutputStream(tN8cuQ9I);
						IOUtils.copy(zsxjNJ89.getStreamData(), kY6BZnIv);
					}
				} catch (IOException hyzt3VT1) {
					displayError(
							"An error occurred when uploading the file " + np9sRIEk + ": " + hyzt3VT1.getMessage());
				} finally {
					if (kY6BZnIv != null) {
						try {
							kY6BZnIv.close();
						} catch (IOException hj3vmp4b) {
						}
					}
				}
			} else {
				CSPathWriter mttfKnvk = null;
				try {
					tN8cuQ9I.createNewFile();
					if (tN8cuQ9I.exists()) {
						mttfKnvk = new CSPathWriter(tN8cuQ9I);
						IOUtils.write(zsxjNJ89.getStringData(), mttfKnvk);
					}
				} catch (IOException QOyhg1cK) {
					displayError(
							"An error occurred when uploading the file " + np9sRIEk + ": " + QOyhg1cK.getMessage());
				} finally {
					if (mttfKnvk != null) {
						try {
							mttfKnvk.close();
						} catch (IOException HRN11Ood) {
						}
					}
				}
			}
			model.fileCleanup(tN8cuQ9I);
			updateFileGrid();
		}
	}

}