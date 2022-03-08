package person.liuxx.learn.code.js;

import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

/**
 * @author 刘湘湘
 * 
 * @version 1.1.0<br>
 *          创建时间：2021年2月4日 上午9:50:31
 * 
 * @since 1.1.0
 */
@SuppressWarnings("restriction")
public class ListScriptEngines {
    public static void main(String args[]) {
        runES6();
        runES6_2();
    }

    static void showEngine() {
        ScriptEngineManager manager = new ScriptEngineManager();
        List<ScriptEngineFactory> factories = manager.getEngineFactories();
        for (ScriptEngineFactory factory : factories) {
            System.out.printf("Name: %s%n" + "Version: %s%n" + "Language name: %s%n"
                    + "Language version: %s%n" + "Extensions: %s%n" + "Mime types: %s%n"
                    + "Names: %s%n", factory.getEngineName(), factory.getEngineVersion(), factory
                            .getLanguageName(), factory.getLanguageVersion(), factory
                                    .getExtensions(), factory.getMimeTypes(), factory.getNames());
            ScriptEngine engine = factory.getScriptEngine();
            System.out.println(engine);
        }
    }

    static void runES6() {
        System.setProperty("nashorn.args", "--language=es6");
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("Nashorn");
        try {
            engine.eval("const a = 20;\n" + "print(a);");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    static void runES6_2() {
        ScriptEngine engine = new NashornScriptEngineFactory().getScriptEngine("--language=es6");
        try {
            engine.eval("const a = 20;\n" + "print(a);");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
