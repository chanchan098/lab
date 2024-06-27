package com.example.elasticsearch;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.elasticsearch.bean.*;
import com.example.elasticsearch.repository.EmployeeRepository;
import com.example.starter_test.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

@SpringBootTest
@Slf4j
public class CrudTest {
    private final List<String> emailAppendixes = new ArrayList<>();
    private final List<String> hobbies = new ArrayList<>();
    private final List<Height> heights = new ArrayList<>();
    private final List<Weight> weights = new ArrayList<>();

    private final List<String> titles = new ArrayList<>();
    private final List<String> companies = new ArrayList<>();

    private final List<PastJob> pastJobs = new ArrayList<>();
    String r=  "D:\\liaoyj\\Developer\\Java\\labs\\lab-03-elasticsearch\\src\\test\\resources\\";
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private Environment env;

    @PostConstruct
    public void initData(){
        emailAppendixes.add("@gmail.com");
        emailAppendixes.add("@apple.com");
        emailAppendixes.add("@outlook.com");
        emailAppendixes.add("@mozilla.org");
        emailAppendixes.add("@tencent.cn");
        companies.add("google");
        companies.add("apple");
        companies.add("microsoft");
        companies.add("mozilla");
        companies.add("tencent");
        titles.add("App Developer");
        titles.add("Backend Developer");
        titles.add("Frontend Developer");
        titles.add("Finance intern");
        titles.add("Translator assistant");
        titles.add("Developer Leader");
        titles.add("Project manager Of Backend");
        hobbies.add("sport");
        hobbies.add("travel");
        hobbies.add("computer game");
        hobbies.add("food");
        hobbies.add("shopping");
        hobbies.add("painting");
        hobbies.add("cooking");
        hobbies.add("music");
        hobbies.add("horticulture");


        for (int i = 0; i < 50; i++) {
            int randomH = RandomUtil.randomInt(160, 190);
            heights.add(new Height(randomH, "cm"));

            int randomW = RandomUtil.randomInt(45, 150);
            weights.add(new Weight(randomW, "kg"));
        }

        for (String title : titles) {
            String company = RandomUtils.randomEle(companies);
            int randomY1 = RandomUtil.randomInt(2005, 2020);
            int randomY2 = RandomUtil.randomInt(randomY1, 2023);
            int[] yWorked = new int[]{randomY1, randomY2};
            pastJobs.add(new PastJob(title, company, yWorked));
        }
//        float randomH = RandomUtil.randomFloat();

    }

    @Test
    public void initEmployees() {
//        employeeRepository.deleteAll();

        List<Employee> employees = getEmployees();

        employeeRepository.saveAll(employees);

    }

    @Test
    public void deleteAllEmployees(){
        employeeRepository.deleteAll();
    }

    @Test
    public void queryAllEmployees(){
        Iterable<Employee> all = employeeRepository.findAll();
        for (Employee employee : all) {
            System.out.println(employee);
        }
    }


    @Test
    public void queryEmployeesInRange(){
        Iterable<Employee> all = employeeRepository.findAll();
        for (Employee employee : all) {
            System.out.println(employee);
        }
    }

    @Test
    public void dumpJson(){
        List<Employee> employees = getEmployees();

        String jsonString = JSON.toJSONString(employees, SerializerFeature.DisableCircularReferenceDetect);
        try (FileWriter fileWriter = new FileWriter(r+"employee.json")) { // "user.json"是目标文件路径
            fileWriter.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to write JSON string to the file.");
        }
        int a = 1;

    }


    @Test
    public void myTest(){
        int processors = Runtime.getRuntime().availableProcessors();
        int a= 1;
    }


    private List<Employee> getEmployees(){

        String p1 = r + "name_2022.json";
        String p2 = r + "name_2021.json";
        String des = r + "description.json";
        List<String> dess = getDess(des);
        List<String> names = getNames(p1);
        names.addAll(getNames(p2));
        int maxNameSize = names.size();
        int count = maxNameSize*2;
        List<Employee> employees = new ArrayList<Employee>();

        while (count > 0){
            int randomHobbies = RandomUtils.randomInteger(1, hobbies.size());

            String description = RandomUtils.randomEle(dess);
            String name = RandomUtils.randomEle(names);
            Integer age = RandomUtils.randomInteger(18,60);
            Boolean resigned = RandomUtils.randomBoolean();
            String email = name + RandomUtils.randomEle(emailAppendixes);
            ArrayList<String> employeeHobbies = new ArrayList<>();
            for (int i = 0; i < randomHobbies; i++) {
                String randomEle = RandomUtils.randomEle(hobbies);
                while(employeeHobbies.contains(randomEle)){
                    randomEle = RandomUtils.randomEle(hobbies);
                }
                employeeHobbies.add(randomEle);
            }

            Height h = RandomUtils.randomEle(heights);
            Weight w = RandomUtils.randomEle(weights);
            BodySize bodySize = new BodySize(h, w);

            List<PastJob> pbs = new ArrayList<>();
            for (int i = 0; i < RandomUtil.randomInt(1, pastJobs.size() - 1); i++) {
                int index = RandomUtils.randomInteger(0,pastJobs.size()-1);
                PastJob pastJob = pastJobs.get(index);
                pbs.add(pastJob);
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            employees.add(new Employee(count, name, age, resigned, email, description, employeeHobbies, bodySize, pbs));
            count--;
        }
        return employees;
    }


    public List<String> getNames(String path){
        String s1 = getJsonString(path);
        JSONObject jsonObject = JSON.parseObject(s1);
        JSONArray names = jsonObject.getJSONArray("names");
        ArrayList<String> strings = new ArrayList<String>();

        if (names != null) {
            for (Object name : names) {
                strings.add((String) name);
            }}
        return strings;
    }

    public List<String> getDess(String path){
        String s1 = getJsonString(path);
        JSONObject jsonObject = JSON.parseObject(s1);
        JSONArray names = jsonObject.getJSONArray("data");
        ArrayList<String> strings = new ArrayList<String>();

        if (names != null) {
            for (Object name : names) {
                strings.add((String) name);
            }}
        return strings;
    }


    public String getJsonString(String path) {
        BufferedReader bufferedReader = null;
        String len = null;
        StringBuilder de = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new FileReader(path));

            while ((len = bufferedReader.readLine()) != null) {
                de.append(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        assert de != null;
        return de.toString();
    }

}
