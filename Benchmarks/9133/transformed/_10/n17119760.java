class n17119760 {
	public void testReaderWriterF2() throws Exception {
		String inFile = "test_data/mri.png";
		itkImageFileReaderF2_Pointer reader = itkImageFileReaderF2.itkImageFileReaderF2_New();
		String outFile = "test_output/mri__smooth_testReaderWriter.mhd";
		itkImageFileWriterF2_Pointer writer = itkImageFileWriterF2.itkImageFileWriterF2_New();
		reader.SetFileName(inFile);
		writer.SetFileName(outFile);
		writer.SetInput(reader.GetOutput());
		writer.Update();
	}

}