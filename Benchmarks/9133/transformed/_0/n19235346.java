class n19235346 {
	public void convert(String Cy5TXwOt, URL AFy32Xc7) throws IOException {
		documentPath = createDirectoryStructure(this.destinationPath, Cy5TXwOt);
		try {
			Document zS5kxlNT = builder.build(AFy32Xc7.openStream());
			Element xRlzhZob = zS5kxlNT.getRootElement();
			convertElement(xRlzhZob);
			System.out.println("\n\n");
			XMLOutputter Teo1tDvE = new XMLOutputter(Format.getPrettyFormat());
			System.out.println("as file: " + AFy32Xc7.getFile());
			File yk4F4AMG = new File(AFy32Xc7.getFile());
			File JrOjEejX = new File(documentPath, renameFileExtention(yk4F4AMG, "-remaining.xml"));
			System.out.println("outputFile: " + JrOjEejX);
			Teo1tDvE.output(zS5kxlNT, new FileOutputStream(JrOjEejX));
		} catch (JDOMException KUIbksPd) {
			KUIbksPd.printStackTrace();
		} catch (IOException ViLHk93w) {
			ViLHk93w.printStackTrace();
		}
	}

}