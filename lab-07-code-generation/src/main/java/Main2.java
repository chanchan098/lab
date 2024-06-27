import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) throws IOException {
//        engine.getTemplate(resource, charsetStr)
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty("resource.loader.file.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        ve.init(); // 初始化引擎配置
        Template t = ve.getTemplate("crudController.vm", "UTF-8"); // 加载模板文件

// 准备数据模型
        Map<String, Object> data = new HashMap<>();
        data.put("tableName", "Employee");
// ... 添加其他数据

        VelocityContext context = new VelocityContext(data);


// 或者写入文件
        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\liaoyj\\Developer\\Java\\labs\\lab-07-code-generation\\src\\main\\java\\EmployeeController.java"));
        t.merge(context, out);
        out.close();
    }
}
