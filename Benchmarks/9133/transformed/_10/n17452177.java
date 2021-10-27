class n17452177 {
	public Object apply(Context context, Object arg) {
		if (arg == null) {
			throw new NullArgument("Null argument to read().");
		}
		Object result = null;
		if (arg instanceof String) {
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
				BufferedReader input = new BufferedReader(new FileReader(file));
				StringBuffer buffer = new StringBuffer();
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
		} else if (arg instanceof URL) {
			URL url = (URL) arg;
			try {
				InputStreamReader isr = new InputStreamReader(url.openStream());
				StringBuffer buffer = new StringBuffer();
				String sep = System.getProperty("line.separator");
				BufferedReader input = new BufferedReader(isr);
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
		return result;
	}

}