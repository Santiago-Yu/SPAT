# SPAT
Semantic-and-Naturalness Preserving Auto Transformation. This tool is a source-to-source transformation tool that can deal with partial code snippets (programs without dependency information). The transformed code will be semantic-equivalent to the original ones, as well as syntax-naturalness-preserving.

This project is developed in "Eclipse IDE for RCP and RAP Developers". If you want to play with the code, please use the same IDE. Starting with the "src/spat/RuleSelector.java" will bring you a nice view of the whole project.

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

For example, 
```consolo
java -jar SPAT.jar 5 .\Benchmarks\9133\Original .\Benchmarks\9133\transformed\_5 C:\Program Files\Java\jre1.8.0_221\lib\rt.jar
```
This command will transform all java files under the ".\Benchmarks\9133\Original" path by the transformation rule 5 "ConditionalExp2SingleIF" to the path ".\Benchmarks\9133\_5". The only dependency is the rt.jar (java runtime). 


## Supported Transformations

##### 	0. LocalVarRenaming:
Replace the local variables' identifiers with new non-repeated identifiers.
##### 	1. For2While
Replace the for statement with an semantic-equivalent while statement.
##### 	2. While2For
Replace the while statement with an semantic-equivalent for statement.
##### 	3. ReverseIfElse
Switch the two code blocks in the if statement and the corresponding else statement. 
##### 	4. SingleIF2ConditionalExp
Change a single if statement into a conditional expression statement.
##### 	5. ConditionalExp2SingleIF
Change a conditional expression statement into a single if statement.
##### 	6. PP2AddAssignment
Change the assignment $x++$ into $x\text{+=}1$.
##### 	7. AddAssignemnt2EqualAssignment
Change the assignment $x\text{+=}1$ into $x:=x+1$.
##### 	8. InfixExpressionDividing
Divide a infix expression into two expressions whose values are stored in temporary variables.
##### 	9. IfDividing
Divide a if statement with a compound condition ($\land$ , $\lor$, or $\lnot$)  into two nested if statements.
##### 	10. StatementsOrderRearrangement
Switch the places of two adjacent statements in a code block, where the former statement has no shared variable with the latter statement.
##### 	11. LoopIfContinue2Else
Replace the if-continue statement in a loop block with if-else statement.
##### 	12. VarDeclarationMerging
Merge the declaration statements into a single composite declaration statement.
##### 	13. VarDeclarationDividing
Divide the composite declaration statement into separated declaration statements.
##### 	14. SwitchEqualSides
Switch the two expressions on both sides of the infix expression whose operator is $=$.
##### 	15. SwitchStringEqual
Switch the two expressions of the String.equal function, such as '123'.equals(x) -> x.equals('123').
##### 	16. PrePostFixExpressionDividing
Divide the pre-or-post expression into two seperated expressions.
##### 	17. Case2IfElse
Change the Switch-Case statements into If-Else statements.




## Datasets

##### Educoder

The Educoder code clone dataset. In the "records.txt" file, each record is a triple (file1,file2,label). For example, (file1,file2,-1) means that it is not a clone, otherwise it is a clone.

##### 9133 benchmark

The 9133 benchmark is selected from BCB benchmark, we use the 9133 instances to evaluate the syntax naturalness, applicability, and  speed of each transformation rule.

##### Java Corpus

This dataset is used to train the Neural Probabilistic Language Model (see below). 

## Links to relevant repositories

1. The Neural Probabilistic Language Model 
	https://github.com/chiaminchuang/A-Neural-Probabilistic-Language-Model
2. Code2vec
	https://github.com/tech-srl/code2vec
3. DeepCom
	https://github.com/xing-hu/DeepCom
4. Hybrid-DeepCom
	https://github.com/xing-hu/EMSE-DeepCom
5. ASTNN
	https://github.com/zhangj111/astnn
6. TBCCD
	https://github.com/yh1105/datasetforTBCCD
7. Jobfuscate
	https://www.duckware.com/jobfuscate/index.html


## Papers

Shiwen Yu, Ting Wang, Ji Wang, "Data Augmentation by Program Transformation." Journal of Systems and Software (2022). (under JSS open science)

Deze Wang, Zhouyang Jia, Shanshan Li, Yue Yu, Yun Xiong, Wei Dong, Xiangke Liao, “Bridging Pre-trained Models and Downstream Tasks for Source Code Understanding.” 44th International Conference on Software Engineering (ICSE 2022)