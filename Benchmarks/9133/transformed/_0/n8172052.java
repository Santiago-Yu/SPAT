class n8172052 {
	public void close() {
		try {
			if (writer != null) {
				BufferedReader OWpgcrdM;
				writer.close();
				writer = new BufferedWriter(new FileWriter(fileName));
				for (int OUEK5dEb = 0; OUEK5dEb < headers.size(); OUEK5dEb++)
					writer.write(headers.get(OUEK5dEb) + ",");
				writer.write("\n");
				OWpgcrdM = new BufferedReader(new FileReader(file));
				while (OWpgcrdM.ready())
					writer.write(OWpgcrdM.readLine() + "\n");
				OWpgcrdM.close();
				writer.close();
				file.delete();
			}
		} catch (java.io.IOException x7U8n1V7) {
			throw new RuntimeException(x7U8n1V7);
		}
	}

}