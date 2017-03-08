package bupt.zhang;

import java.io.FileReader;
import java.net.URL;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * ����JAVA�Ľű�����ӿ�
 * 
 * @author Xieyu
 *
 */

public class Demo01 {
	public static void main(String[] args) throws Exception {
		//1.�����ӿ�
		ScriptEngineManager sem=new ScriptEngineManager();
		ScriptEngine engine=sem.getEngineByName("js");
		
		//2.��������,�洢������������ĵ���
		engine.put("msg", "Tom is a good man");
		System.out.println(engine.get("msg"));
		
		//����JS�ű�
		String order="var user={name:'zhang',age:22,school:['byr','bj']};";
		order+="println(user.school);";
		
		//3.ִ�нű�����
		engine.eval(order);
		
		//4.����ű�����
		engine.eval("function add(a,b){var sum=a+b;return sum;}");
		
		//5.ȡ�ú������ýӿ�
		Invocable jsInvoke=(Invocable)engine;
		
		//6.ͨ���ӿ�,ִ�нű�����
		Object result=jsInvoke.invokeFunction("add", new Object[]{13,20});
		System.out.println(result);
		
		//7.ִ��JS�ļ�
		URL url=Demo01.class.getClassLoader().getResource("a.js");
		FileReader fr=new FileReader(url.getPath());
		engine.eval(fr);
		
	}
}
