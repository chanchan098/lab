import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.engine.velocity.VelocityEngine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {


        Map<String, Object> data = new HashMap<>();
        data.put("tableName", "Employee");
        TemplateConfig config = new TemplateConfig();
        config.setResourceMode(TemplateConfig.ResourceMode.CLASSPATH);

        VelocityEngine templateEngine = new VelocityEngine(config);
        String res = templateEngine.getTemplate("crudController.vm").render(data);

        try (FileWriter writer = new FileWriter("D:\\liaoyj\\Developer\\Java\\labs\\lab-07-code-generation\\src\\main\\java\\EmployeeController.java")) {
            writer.write(res);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }

    }

}
