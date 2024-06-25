package com.example.dataExpansion;


import com.example.dataExpansion.bean.Employee;
import com.example.dataExpansion.bean.Salary;
import com.example.dataExpansion.mapper.SystemMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class SystemTest {

    @Autowired
    private SystemMapper systemMapper;

    @Test
    public void systemTest() {
        List<Employee> employees = systemMapper.queryEmployees();

//        List<Salary> salaries = userMapper.querySalaries();

        int a = 1;
    }


    @Test
    public void insertEmployees() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Employee> employees = systemMapper.queryEmployees();
        ThreadLocalRandom localRandom = ThreadLocalRandom.current();
        int empNo = systemMapper.queryMaxNoOfEmployees() + 1;

//        int sizeOfWanted = 170 000 000;
        int sizeOfWantedMultiplierA = 1700;
        int sizeOfWantedMultiplierB = 1000;
        List<Employee> pending = new ArrayList<>();
        for (int i = 1; i <= sizeOfWantedMultiplierA; i++) {

            for (int j = 1; j <= sizeOfWantedMultiplierB; j++) {
                int ri = localRandom.nextInt(0, employees.size());
                String rBirthDate = employees.get(ri).getBirthDate();

                ri = localRandom.nextInt(0, employees.size());
                String rFirstName = employees.get(ri).getFirstName();

                ri = localRandom.nextInt(0, employees.size());
                String rLastName = employees.get(ri).getLastName();

                ri = localRandom.nextInt(0, employees.size());
                String rGender = employees.get(ri).getGender();

                ri = localRandom.nextInt(0, employees.size());
                String rHireDate = employees.get(ri).getHireDate();

                Employee e = new Employee(empNo, rBirthDate, rFirstName, rLastName, rGender, rHireDate);
                pending.add(e);
                empNo += 1;
            }
            systemMapper.insertEmployees(pending);
            pending.clear();
        }
        int a = 1;

    }

    @Test
    public void insertSalaries() throws ParseException {
        List<Integer> employees = systemMapper.queryEmployeeIds();

        ThreadLocalRandom localRandom = ThreadLocalRandom.current();
        int yearsWanted = 20;
        int monthsWanted = 12;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        2004-01-10-2004-02-10
//        Date from = sdf.parse("2003-01-10");
        Date from = sdf.parse("2007-01-10");
        boolean indexDeleted = false;
        for (int i = 1; i <= yearsWanted; i++) {

            for (int j = 1; j <= monthsWanted; j++) {
                String fromDate = sdf.format(from);

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(from);
                calendar.add(Calendar.MONTH, 1);
                Date time = calendar.getTime();
                from = time;

                String toDate = sdf.format(from);

                System.out.println(fromDate+"-"+toDate);

                ArrayList<Salary> pending = new ArrayList<>();
                for (Integer employee : employees) {

                    int rSalary = localRandom.nextInt(41231, 160000);

                    Salary salary = new Salary(employee, rSalary, fromDate, toDate);
//                    TODO checking existed?
//                    SELECT emp_no FROM employees WHERE emp_no = salary.employee and
                    pending.add(salary);

                    if (pending.size() == 10000) {
                        try {

                            if(!indexDeleted){
                                indexDeleted = true;
//                                TODO delete index
                            }

                            systemMapper.insertSalaries(pending);
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            pending.clear();
                        }
                    }
                }

                if(pending.size() > 0){
                    try {
                        systemMapper.insertSalaries(pending);
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        pending.clear();
                    }
                }



            }
        }

        if(indexDeleted){
//            recover index
        }
    }


}
