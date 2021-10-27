class n17452177 {
	public Object apply(Context context, Object arg) {
		Object result = null;
		if (!(arg == null))
			;
		else {
			throw new NullArgument("Null argument to read().");
		}
		if (!(arg instanceof String)) {
			if (arg instanceof URL) {
				URL url = (URL) arg;
				try {
					StringBuffer buffer = new StringBuffer();
					InputStreamReader isr = new InputStreamReader(url.openStream());
					BufferedReader input = new BufferedReader(isr);
					String sep = System.getProperty("line.separator");
					String line = null;
					for (;;) {
						line = input.readLine();
						if (line == null) {
							break;
						}
						buffer.append(line);
						buffer.append(sep);
					}
					result = buffer.toString();
					input.close();
				} catch (Exception e) {
					throw new IOError("Error reading " + url);
				}
			} else {
				throw new BadArgument("Bad argument to read()");
			}
		} else {
			String filename = (String) arg;
			File file = new File(filename);
			if (!file.exists()) {
				throw new FileNotFound("File not found: " + filename);
			}
			if (!file.isFile()) {
				throw new BadArgument("Argument to read() is not a file: " + filename);
			}
			if (!file.canRead()) {
				throw new BadArgument("File cannot be read: " + filename);
			}
			try {
				StringBuffer buffer = new StringBuffer();
				BufferedReader input = new BufferedReader(new FileReader(file));
				String sep = System.getProperty("line.separator");
				String line = null;
				for (;;) {
					line = input.readLine();
					if (line == null) {
						break;
					}
					buffer.append(line);
					buffer.append(sep);
				}
				result = buffer.toString();
				input.close();
			} catch (Exception e) {
				throw new IOError("Error reading " + filename);
			}
		}
		return result;
	}

}