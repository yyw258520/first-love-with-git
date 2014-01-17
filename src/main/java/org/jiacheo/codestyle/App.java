/*
 * license 声明,如果有的话
 */

//包信息
//上面要空出一行跟这里分开, 每一块声明之间都要空出一行, 下同.
//包名一般是全小写的字母+数字, 不要用大写, 也不要下划线
package org.jiacheo.codestyle; //包引入

//import信息
//import信息不能换行, 每一行的长度不受下面的最大代码行字符数(column limits)的限制,该有多长就多长
//不要能使用通配符(.*)一次引入一整个包
//分组与排序:
//分组规则:
//1. 所有static import单独存放一组
//2. com.google 下的放一组
//3. 第三方引用, 一个顶级域名一个分组
//   比如 com, junit, android, org 等等
//4. java包下的分为一组
//5. javax包下的分为一组
//6. 每组之间用一个空行分隔开
//排序规则
//每个分组内的排序方式按照ascii码升序排序
//每一个组内不再有空行分隔

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.sun.beans.ObjectHandler;
import com.sun.beans.WeakCache;

import static java.lang.Class.forName;
import static java.lang.String.valueOf;

//顶级公开类(跟java文件名一致)
//类描述
//类名一般是首字母大写的骆驼字符UpperCamelCase, 可以加数字, 不要下划线
//如果是测试用例的类, 这类名是以要测试的类名开头, 以Test结尾. 比如: AppTest
/**
 * 本规范出自: http://google-styleguide.googlecode.com/svn/trunk/javaguide.html
 * 唯一不同是的google要求代码的缩进是2个字符,而我用的是tab
 * 
 * 类的javadoc
 * javadoc和注释不一样, javadoc开头是斜杆加两颗*, 结尾是一颗*加斜杆. 注释一般是双斜杠 或者/* comment * / 这种 
 * 每起新的一行用一个*号开头
 * 如果要分段可以在句首加一个
 * <p>标签, 后面不用加空格
 * 内容一般写在@ 语句之前, 如果有的话
 * javadoc一般用于所有的公开类, public或者protected的成员和方法上
 * 另外一些方法的名称如果已经很明显而且处理过程很简单的话, 可以不用写javadoc, 
 * 像getter setter方法, 还有测试用例的testXXX方法
 * 如果是Override了一个父类的方法, 如果父类已经有详尽的文档了, 也可以不需要写javadoc
 * 私有变量和非公开的类也是有必要写javadoc的, 因为你的代码不可能一直由你来维护
 * 
 * @author jiacheo
 * @since 2014-1-15 15:02:33
 * @see String
 * @see System
 * 
 */
//泛型的变量的命名规范一般用一个大写字母表示一种类型, 如果有多个类型参数则分别用多个单一的大写字母表示, 有时候后面可以跟数字
public strictfp class App<T, E1, E2> implements Cloneable{

	// 成员排序, 目前没有好的方法可以度量类成员的排放顺序
	// 一般可以按照成员之间的逻辑关系相近的放在一起
	// 新加字段和方法也不要直接按时间先后直接放在后面, 放在跟逻辑相关联的地方
	
	// 常量必须声明为 static final 的
	// 常量的命名要求是全全大写，单词之间用下划线_隔开
	// 像集合/数组/map类的对象由于可以随时改变其内容，可以不认为是常量，也就是不用遵循上面的命名规范而是使用一般变量的规范
	// 日志也可以不认为是常量，可以用小写
	private static final String TEXT = "hello git@oschina !";
	
	// 非常量的变量命名规范一律使用小写字母开头的lowerCamelCase
	// 一般来说变量的名称是个名词或者名词词组, 比如这里的appName, 是值app名称
	private String appName;

	// 静态初始化块
	static {
		System.out.println("class loaded");
	}

	// 初始化块
	{
		if (appName == null) {
			appName = "UnNamed";
		}
		System.out.println("object inited");
	}

	// 重载的方法都放在一起, 不要分开.如果一个方法有多重重载的话, 必须把这些多个重载都放在一块
	// 这样方便阅读和学习
	public App() {

	}

	// 参数名称的命名规范也使用 小写字母开头的 lowerCamelCase, 一定要避免出现单字符的变量(除了for循环)
	public App(String appName) {
		this.setAppName(appName);
	}

	public static void main(String[] args) throws ClassNotFoundException {
		// google 编码风格提倡缩进使用2个空字符,不要用tab,不知道是出于什么考虑.
		// 也许tab用惯了的人很难改过来吧?
		System.out.println(TEXT);
		System.out.println(new Date());
		// 每行代码的字符数限制在80或者100以内.这个是为了一阅读代码的时候不需要拖动下面的滚动条, 我觉得下面这行90个字
		// 已经很长了, 可以试试80字.然后再加上缩进, 差不多了.当然还有一个是跟你IDE的字体大小有关系
		// 另外一些无法避免的情况可以不遵循次规定, 比如注释中的长URL,或者一个webservice的长URI
		// 还有就是上面提到的 package 和 import 语句, 还有一些注释中的命令, 为了方便给其他人复制粘贴, 不许要换行
		// 自动换行之后, 第二行开始必须针对第一行缩进至少4个字符.
		System.out
				.println(new HashMap<String, List<Set<WeakCache<ObjectHandler, Calendar>>>>());
		System.out.println(valueOf(123));
		System.out.println(forName("java.lang.String"));
		System.out.println(new App<String, Integer, Long>("google code style").getAppName());
		// if else for do while 等语句都要使用大括号, 即使里面的内容是空的或者只有一行的时候
		// 当括号内的内容为空的时候, 可以直接把大伙好的开始和结束写在一起, 例如:
		// void doNothing() {}
		// 不要出现例如
		// if(xxx)
		//   doXXX();
		// else
		//   doYYY();
		// 这样的写法, 经常写python的同学要注意了.
		// 大括号的写法统一使用埃及括号写法, 也就是开始括号在句子的末尾, 结束的括号在句子的最前面
		// 类初始化块除外
		// 一句指令代码采用一行,不要多行挤在同一行
		// 比如不要
		// int i=0; int b=0;

		// 变量的定义要求每个变量都分开定义, 不要使用 int i = 1, j = 2; 这样的句式
		// 本地变量(local variables)最好在定义的时候就初始化值, 或者是后面紧接着就初始化值
		// 本地变量的命名规范一律使用 lowerCamelCase, 不能使用大写, 不能出现单字符变量(除了循环中的零时变量, 比如for(int i=0;i<n;i++))
		int i = 1;
		int j = 2;
		// 所有保留字/关键字后面都要加个空格, 即使像if/for/do/catch/while这种后面要跟条件的句式
		// 另外像 else catch finally do..while中的while 这种句式要在保留字/关键字前加个空格
		// 所有大左括号之前也要加空格除了二维数组的初始化的写法和annotation的参数不需要之外
		// 比如 String[][] arr = {{"abc"}};
		// 运算符前后也要加空格
		// 小括号的开始和结束也都需要加上空格, 除非连续出现(( ))
		// 在一句代码最后加注释的时候, 必须在双斜杠的前后加上空格
		// 类型和变量之间必须加空格
		// 空格不必加载句子的前面和结尾处(满足缩进的条件下)
		if (i > 0 && (true && j > 0)) { // some comments
			System.out.println("yes");
		} else {
			System.out.println("no");
		}

		// google code style 不要求水平对齐, 水平对齐是指如下代码:
		// int thisIsVar1 = 1023;
		// String thisIsVar24 = "1024";
		// 变成
		// int thisIsVar1 = 1023;
		// String thisIsVar24 = "1024";
		// 这种写法是可以接受的,但是没有必要
		// 另外要用好括号, 尽量把一句运算的句子放在括号里面,特别是在做逻辑判断的时候, 并不是所有人都对运算符的有相机了如指掌的
		// if ( a || (b && c))
		System.out.println(EnumTest.A);
		// 数组初始化可以有好多种定义格式,
		// 比如
		int[] arr1 = new int[]{
				1, 2, 3, 4
		};
		
		int[] arr2 = new int[] {2, 3, 4, 5};
		
		int[] arr3 = new int[]
		                 {5, 6, 8};
		                    
		int[] arr4 = new int[] {
				1,
				2,
				3,
				4,
				5
		};
		//以上都可以, 另外数组的声明不要使用c语言的声明风格 比如: int a[] ; 这种要改成 int[] a;
		System.out.println(arr1+"|"+arr2+"|"+arr3+"|"+arr4);
		
		// switch 语句, 一个大的块里面跟着各种小块, case xxx: doXXX ; 
		// 每一个switch语句必须要加上default: 块, 即使里面没有内容
		// 如果一个case语句执行完没有break/continue/return等中断式的关键字, 必须在执行的结尾加上注释
		int label = 1;
		switch(label){
			case 0:{
				System.out.println("0");
				//继续往下
			};
			case 1: {
				System.out.println("1");
				break;
			}
			default :{
				System.out.println("none");
				break;
			}
		}
		
	}
	
	/*
	 * 关于如何把一个日常生活中的短语转换成camelCase名称, 可以参考下面的转换方法
	 * 	源短语						正确方式				错误方式
		"XML HTTP request"			XmlHttpRequest		XMLHTTPRequest
		"new customer ID"			newCustomerId		newCustomerID
		"inner stopwatch"			innerStopwatch		innerStopWatch
		"supports IPv6 on iOS?"		supportsIpv6OnIos	supportsIPv6OnIOS
	 * 
	 */

	//枚举定义,如果每个变量都没有注释和参数的话, 可以直接写成一行. 其他的方法类的要求跟class一样.
	private static enum EnumTest { A, B, C, D }

	//方法名一般是小字母开头的骆驼体, lowerCamelCase
	//最好不要用下划线啦.(在jUnitTest的方法中可以使用)
	//方法名一般是动词或者动词短语的组合
	//比如这个setAppName就知道是 设置app的名称
	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppName() {
		return appName;
	}
	
	public T getType(T input){
		return input;
	}

	//anotation的位置一般是一行一个, 不用缩进, 加上他自己的参数
	//如果该annotation没有参数的话, 可以跟被声明的对象同一行
	//比如:
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	/*
	 * 一些编程惯例
	 * 1. @Override 这个annotation一定要出现在任何重载/实现父类方法的地方.
	 * 2. 异常不能忽略, 如果要忽略一定要写清楚原因作为注释(这也是一种处理方式).  
	 * 3. 静态成员必须使用类名来调用, 不要用对象.
	 * 4. 永远不要重载finalize()方法, 想知道为什么可以阅读 Effect Java 第七条 Avoid Finalizers
	 */
}
