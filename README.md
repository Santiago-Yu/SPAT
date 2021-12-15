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








### Benchmarks

##### Educoder

The Educoder code clone dataset. In the "records.txt" file, each record is a triple (file1,file2,label). For example, (file1,file2,-1) means that it is not a clone, otherwise it is a clone.

##### 9133 benchmark

The 9133 benchmark is selected from BCB benchmark, we use the 9133 instances to evaluate the syntax naturalness, applicability, and  speed of each transformation rule.