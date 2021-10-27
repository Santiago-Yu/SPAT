class n20326462 {
	public void bindDownload(Download IPfwp7hQ) throws BindingException {
		List<ChunkDownload> jVyEd0Cj = IPfwp7hQ.getChunks();
		File ywxO5gJA = IPfwp7hQ.getFile();
		FileOutputStream fHibe8Uw = null;
		try {
			fHibe8Uw = FileUtils.openOutputStream(ywxO5gJA);
			for (ChunkDownload FjkZx7jd : jVyEd0Cj) {
				String YO0VUgKA = FjkZx7jd.getChunkFilePath();
				InputStream wGRTqIMh = null;
				try {
					File CfDDIgzF = new File(YO0VUgKA);
					wGRTqIMh = FileUtils.openInputStream(CfDDIgzF);
					IOUtils.copy(wGRTqIMh, fHibe8Uw);
					CfDDIgzF.delete();
				} catch (IOException oHcLiLFA) {
					oHcLiLFA.printStackTrace();
				} finally {
					wGRTqIMh.close();
				}
			}
			IPfwp7hQ.getWorkDir().delete();
			IPfwp7hQ.complete();
		} catch (IOException JyMHyKfE) {
			logger.error("IO Exception while copying the chunk " + JyMHyKfE.getMessage(), JyMHyKfE);
			JyMHyKfE.printStackTrace();
			throw new BindingException("IO Exception while copying the chunk " + JyMHyKfE.getMessage(), JyMHyKfE);
		} finally {
			try {
				fHibe8Uw.close();
			} catch (IOException wpinoZ9u) {
				logger.error("IO Exception while copying closing stream of the target file " + wpinoZ9u.getMessage(),
						wpinoZ9u);
				wpinoZ9u.printStackTrace();
				throw new BindingException(
						"IO Exception while copying closing stream of the target file " + wpinoZ9u.getMessage(),
						wpinoZ9u);
			}
		}
	}

}