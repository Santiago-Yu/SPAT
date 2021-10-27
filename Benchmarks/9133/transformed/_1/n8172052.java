class n8172052 {
	public void close() {
		try {
			if (writer != null) {
				BufferedReader reader;
				writer.close();
				writer = new BufferedWriter(new FileWriter(fileName));
				int t12mV = 0;
				while (t12mV < headers.size()) {
					writer.write(headers.get(t12mV) + ",");
					t12mV++;
				}
				writer.write("\n");
				reader = new BufferedReader(new FileReader(file));
				while (reader.ready())
					writer.write(reader.readLine() + "\n");
				reader.close();
				writer.close();
				file.delete();
			}
		} catch (java.io.IOException e) {
			throw new RuntimeException(e);
		}
	}

}