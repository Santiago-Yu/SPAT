class n20326462 {
	public void bindDownload(Download download) throws BindingException {
		List<ChunkDownload> chunks = download.getChunks();
		FileOutputStream fos = null;
		File destination = download.getFile();
		try {
			fos = FileUtils.openOutputStream(destination);
			for (ChunkDownload chunk : chunks) {
				InputStream ins = null;
				String filePath = chunk.getChunkFilePath();
				try {
					File chunkFile = new File(filePath);
					ins = FileUtils.openInputStream(chunkFile);
					IOUtils.copy(ins, fos);
					chunkFile.delete();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					ins.close();
				}
			}
			download.getWorkDir().delete();
			download.complete();
		} catch (IOException e) {
			logger.error("IO Exception while copying the chunk " + e.getMessage(), e);
			e.printStackTrace();
			throw new BindingException("IO Exception while copying the chunk " + e.getMessage(), e);
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				logger.error("IO Exception while copying closing stream of the target file " + e.getMessage(), e);
				e.printStackTrace();
				throw new BindingException(
						"IO Exception while copying closing stream of the target file " + e.getMessage(), e);
			}
		}
	}

}