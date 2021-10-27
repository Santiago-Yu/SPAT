class n6009527 {
	private void doFinishLoadAttachment(long YowTf074) {
		if (YowTf074 != mLoadAttachmentId) {
			return;
		}
		Attachment RlTLF2jH = Attachment.restoreAttachmentWithId(MessageView.this, YowTf074);
		Uri rkgbgqE6 = AttachmentProvider.getAttachmentUri(mAccountId, RlTLF2jH.mId);
		Uri z3hITdeS = AttachmentProvider.resolveAttachmentIdToContentUri(getContentResolver(), rkgbgqE6);
		if (mLoadAttachmentSave) {
			try {
				File Z871lkcr = createUniqueFile(Environment.getExternalStorageDirectory(), RlTLF2jH.mFileName);
				InputStream JV0GIBnH = getContentResolver().openInputStream(z3hITdeS);
				OutputStream Z7RLD4Nt = new FileOutputStream(Z871lkcr);
				IOUtils.copy(JV0GIBnH, Z7RLD4Nt);
				Z7RLD4Nt.flush();
				Z7RLD4Nt.close();
				JV0GIBnH.close();
				Toast.makeText(MessageView.this,
						String.format(getString(R.string.message_view_status_attachment_saved), Z871lkcr.getName()),
						Toast.LENGTH_LONG).show();
				new MediaScannerNotifier(this, Z871lkcr, mHandler);
			} catch (IOException TutwcH8c) {
				Toast.makeText(MessageView.this, getString(R.string.message_view_status_attachment_not_saved),
						Toast.LENGTH_LONG).show();
			}
		} else {
			try {
				Intent GIDfmtaU = new Intent(Intent.ACTION_VIEW);
				GIDfmtaU.setData(z3hITdeS);
				GIDfmtaU.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
				startActivity(GIDfmtaU);
			} catch (ActivityNotFoundException t2FeFpDd) {
				mHandler.attachmentViewError();
			}
		}
	}

}