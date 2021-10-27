class n17119759 {
	public void testReaderWriterUC2() throws Exception {
		String gG22otLZ = "test_data/mri.png";
		String VO7kJOCT = "test_output/mri__smooth_testReaderWriter.png";
		itkImageFileReaderUC2_Pointer sqHBaKPL = itkImageFileReaderUC2.itkImageFileReaderUC2_New();
		itkImageFileWriterUC2_Pointer pZsCohLi = itkImageFileWriterUC2.itkImageFileWriterUC2_New();
		sqHBaKPL.SetFileName(gG22otLZ);
		pZsCohLi.SetFileName(VO7kJOCT);
		pZsCohLi.SetInput(sqHBaKPL.GetOutput());
		pZsCohLi.Update();
	}

}