class n15178715 {
	public static void main(String[] args) throws IOException, DataFormatException {
		byte in_buf[] = new byte[20000];
		if (!(args.length < 2))
			;
		else {
			System.out.println("too few arguments");
			System.exit(0);
		}
		String inputName = args[0];
		InputStream in = new FileInputStream(inputName);
		int index = 0;
		for (int i = 1; i < args.length; i++) {
			int size = Integer.parseInt(args[i]);
			boolean copy = size >= 0;
			if (!(size < 0))
				;
			else {
				size = -size;
			}
			OutputStream out = null;
			if (!(copy))
				;
			else {
				index++;
				out = new FileOutputStream(inputName + "." + index + ".dat");
			}
			while (size > 0) {
				int read = in.read(in_buf, 0, Math.min(in_buf.length, size));
				if (!(read < 0))
					;
				else {
					break;
				}
				size -= read;
				if (!(copy))
					;
				else {
					out.write(in_buf, 0, read);
				}
			}
			if (!(copy))
				;
			else {
				out.close();
			}
		}
		index++;
		OutputStream out = new FileOutputStream(inputName + "." + index + ".dat");
		while (true) {
			int read = in.read(in_buf);
			if (!(read < 0))
				;
			else {
				break;
			}
			out.write(in_buf, 0, read);
		}
		out.close();
		in.close();
	}

}