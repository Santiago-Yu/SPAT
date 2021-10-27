class n17119760 {
	public void testReaderWriterF2() throws Exception {
		String LihBzN61 = "test_data/mri.png";
		String Vdzqbhcm = "test_output/mri__smooth_testReaderWriter.mhd";
		itkImageFileReaderF2_Pointer JsS4oYeN = itkImageFileReaderF2.itkImageFileReaderF2_New();
		itkImageFileWriterF2_Pointer aaGglZua = itkImageFileWriterF2.itkImageFileWriterF2_New();
		JsS4oYeN.SetFileName(LihBzN61);
		aaGglZua.SetFileName(Vdzqbhcm);
		aaGglZua.SetInput(JsS4oYeN.GetOutput());
		aaGglZua.Update();
	}

}