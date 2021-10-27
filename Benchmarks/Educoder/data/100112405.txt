package chapter2.step7;
import java.util.Scanner;        //1.导入Scanner
public class HelloWorld{
    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);    //2.声明扫描仪
        System.out.println("请录入嫦娥个人信息：");
        System.out.println("请输入姓名：");
        String name = input.next();
        System.out.println("请输入年龄：");
        int age = input.nextInt();
        System.out.println("请输入性别：");
        String sex = input.next();
        System.out.println("请输入体重：");
        float weight = input.nextFloat();
        System.out.println("请输入地址：");
        String address = input.next();
        System.out.println("请输入是否已婚：");
        String isMarried = input.next();
        System.out.println("信息如下：");
        System.out.println("\t姓名：" + name);
        System.out.println("\t年龄：" + age + "岁");
        System.out.println("\t性别：" + sex);
        System.out.println("\t体重：" + weight + "kg");
        System.out.println("\t地址：" + address);
        System.out.println("\t婚否：" + isMarried);
    }
}