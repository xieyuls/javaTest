package bupt.zhang;

import java.io.FileReader;
import java.net.URL;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * 测试JAVA的脚本引擎接口
 * 
 * @author Xieyu
 *
 */

public class Demo01 {
	public static void main(String[] args) throws Exception {
		//1.建立接口
		ScriptEngineManager sem=new ScriptEngineManager();
		ScriptEngine engine=sem.getEngineByName("js");
		
		//2.建立变量,存储到引擎的上下文当中
		engine.put("msg", "Tom is a good man");
		System.out.println(engine.get("msg"));
		
		//定义JS脚本
		String order="var user={name:'zhang',age:22,school:['byr','bj']};";
		order+="println(user.school);";
		
		//3.执行脚本代码
		engine.eval(order);
		
		//4.定义脚本函数
		engine.eval("function add(a,b){var sum=a+b;return sum;}");
		
		//5.取得函数调用接口
		Invocable jsInvoke=(Invocable)engine;
		
		//6.通过接口,执行脚本函数
		Object result=jsInvoke.invokeFunction("add", new Object[]{13,20});
		System.out.println(result);
		
		//7.执行JS文件
		URL url=Demo01.class.getClassLoader().getResource("a.js");
		FileReader fr=new FileReader(url.getPath());
		engine.eval(fr);
		
	}
}
