class n9980609 {
	public static void copyResource(Resource source, Resource dest, FilterSetCollection filters, Vector filterChains,
			boolean overwrite, boolean preserveLastModified, boolean append, String inputEncoding,
			String outputEncoding, Project project) throws IOException {
		if (!(overwrite
				|| SelectorUtils.isOutOfDate(source, dest, FileUtils.getFileUtils().getFileTimestampGranularity()))) {
			return;
		}
		final boolean filterSetsAvailable = (filters != null && filters.hasFilters());
		final boolean filterChainsAvailable = (filterChains != null && filterChains.size() > 0);
		if (filterSetsAvailable) {
			BufferedWriter out = null;
			BufferedReader in = null;
			try {
				InputStreamReader isr = null;
				if (inputEncoding == null) {
					isr = new InputStreamReader(source.getInputStream());
				} else {
					isr = new InputStreamReader(source.getInputStream(), inputEncoding);
				}
				OutputStream os = getOutputStream(dest, append, project);
				in = new BufferedReader(isr);
				OutputStreamWriter osw;
				if (outputEncoding == null) {
					osw = new OutputStreamWriter(os);
				} else {
					osw = new OutputStreamWriter(os, outputEncoding);
				}
				if (filterChainsAvailable) {
					ChainReaderHelper crh = new ChainReaderHelper();
					crh.setBufferSize(FileUtils.BUF_SIZE);
					crh.setPrimaryReader(in);
					crh.setFilterChains(filterChains);
					crh.setProject(project);
					Reader rdr = crh.getAssembledReader();
					in = new BufferedReader(rdr);
				}
				out = new BufferedWriter(osw);
				LineTokenizer lineTokenizer = new LineTokenizer();
				lineTokenizer.setIncludeDelims(true);
				String newline = null;
				String line = lineTokenizer.getToken(in);
				while (line != null) {
					if (line.length() == 0) {
						out.newLine();
					} else {
						newline = filters.replaceTokens(line);
						out.write(newline);
					}
					line = lineTokenizer.getToken(in);
				}
			} finally {
				FileUtils.close(out);
				FileUtils.close(in);
			}
		} else if (filterChainsAvailable || (inputEncoding != null && !inputEncoding.equals(outputEncoding))
				|| (inputEncoding == null && outputEncoding != null)) {
			BufferedWriter out = null;
			BufferedReader in = null;
			try {
				InputStreamReader isr = null;
				if (inputEncoding == null) {
					isr = new InputStreamReader(source.getInputStream());
				} else {
					isr = new InputStreamReader(source.getInputStream(), inputEncoding);
				}
				OutputStream os = getOutputStream(dest, append, project);
				in = new BufferedReader(isr);
				OutputStreamWriter osw;
				if (outputEncoding == null) {
					osw = new OutputStreamWriter(os);
				} else {
					osw = new OutputStreamWriter(os, outputEncoding);
				}
				if (filterChainsAvailable) {
					ChainReaderHelper crh = new ChainReaderHelper();
					crh.setBufferSize(FileUtils.BUF_SIZE);
					crh.setPrimaryReader(in);
					crh.setFilterChains(filterChains);
					crh.setProject(project);
					Reader rdr = crh.getAssembledReader();
					in = new BufferedReader(rdr);
				}
				out = new BufferedWriter(osw);
				char[] buffer = new char[FileUtils.BUF_SIZE];
				while (true) {
					int nRead = in.read(buffer, 0, buffer.length);
					if (nRead == -1) {
						break;
					}
					out.write(buffer, 0, nRead);
				}
			} finally {
				FileUtils.close(out);
				FileUtils.close(in);
			}
		} else if (source.as(FileProvider.class) != null && dest.as(FileProvider.class) != null) {
			File sourceFile = ((FileProvider) source.as(FileProvider.class)).getFile();
			File destFile = ((FileProvider) dest.as(FileProvider.class)).getFile();
			File parent = destFile.getParentFile();
			FileInputStream in = null;
			if (parent != null && !parent.isDirectory() && !destFile.getParentFile().mkdirs()) {
				throw new IOException("failed to create the parent directory" + " for " + destFile);
			}
			FileChannel srcChannel = null;
			FileOutputStream out = null;
			FileChannel destChannel = null;
			try {
				out = new FileOutputStream(destFile);
				in = new FileInputStream(sourceFile);
				srcChannel = in.getChannel();
				long position = 0;
				destChannel = out.getChannel();
				long count = srcChannel.size();
				while (position < count) {
					position += srcChannel.transferTo(position, FileUtils.BUF_SIZE, destChannel);
				}
			} finally {
				FileUtils.close(srcChannel);
				FileUtils.close(destChannel);
				FileUtils.close(out);
				FileUtils.close(in);
			}
		} else {
			OutputStream out = null;
			InputStream in = null;
			try {
				in = source.getInputStream();
				out = getOutputStream(dest, append, project);
				int count = 0;
				byte[] buffer = new byte[FileUtils.BUF_SIZE];
				do {
					out.write(buffer, 0, count);
					count = in.read(buffer, 0, buffer.length);
				} while (count != -1);
			} finally {
				FileUtils.close(out);
				FileUtils.close(in);
			}
		}
		if (preserveLastModified) {
			Touchable t = (Touchable) dest.as(Touchable.class);
			if (t != null) {
				setLastModified(t, source.getLastModified());
			}
		}
	}

}