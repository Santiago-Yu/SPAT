# SPAT
Semantic-and-Naturalness Preserving Auto Transformation

This project is developed in "Eclipse IDE for RCP and RAP Developers". If you want to play with the code, please use the same IDE. 

We have produced a runnable jar file already in "artifacts". 

To use this tool, simply type the followed command:

```consolo
java -jar SPAT.jar [RuleId] [RootDir] [OutputDir] [PathofJre] \& [PathofotherDependentJar]
```

*[RuleId]* is the transformation rule you want to adopt. 

*[RootDir]* is the root directory path in which you put all your code snippets to be transformed. each ".java'' file is regarded as a code snippet. Each file should contain one Java class. For method-level code snippets, users need to warp each method with a "foo'' class.

*[OutputDir]* is the directory path whre you want to store the transformed code snippets.

*[PathofJre]* is the path of *rt.jar* (usually placed in ".../jre1.x.x\_xxx/lib/''})

*[PathofotherDependentJar]* is optional, one can use it to specify additional dependent libraries.

### Benchmarks

##### Educoder

The Educoder code clone dataset. In the "records.txt" file, each record is a triple (file1,file2,label). For example, (file1,file2,-1) means that it is not a clone, otherwise it is a clone.

##### 9133 benchmark

The 9133 benchmark is selected from BCB benchmark, we use the 9133 instances to evaluate the syntax naturalness, applicability, and  speed of each transformation rule.