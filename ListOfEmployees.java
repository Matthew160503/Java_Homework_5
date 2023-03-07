
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 Пусть дан список сотрудников: Иван, Пётр, Антон и так далее. Написать программу, 
 которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
 */
public class ListOfEmployees{
    public static void main(String[] args) {
        String[] employees = {"Александр","Матвей","Катя","Иван","Артем","Матвей","Иван","Маша","Александр","Артем","Матвей"};
        sortEmployees(employees);
    }

    private static void sortEmployees(String[] employees){
        Map<String, Integer> employeesPlusCount = new LinkedHashMap<>();
        for (String employee : employees){
            if(employeesPlusCount.containsKey(employee)){
                int count = employeesPlusCount.get(employee) + 1;
                employeesPlusCount.put(employee,count);
            }
            else employeesPlusCount.put(employee, 1);
        }
        System.out.println(employeesPlusCount);
        sortByPopularity(employeesPlusCount);
    }

    private static void sortByPopularity(Map<String, Integer> employeesPlusCount){
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>();
        Map<String, Integer> result = new LinkedHashMap<>();
        result.put("null", null);

        for (Map.Entry<String, Integer> employee : employeesPlusCount.entrySet()){
            values.add(employee.getValue());
            keys.add(employee.getKey());   
        }

        employeesPlusCount.clear();

        int temp_value = values.get(0);
        String temp_key  = keys.get(0);

        for(int i = 0; i < values.size() - 1; i++){
            if (values.get(i) < values.get(i+1)){
                temp_value = values.get(i);
                values.set(i, values.get(i+1));
                values.set(i+1, temp_value);

                temp_key = keys.get(i);
                keys.set(i, keys.get(i+1));
                keys.set(i+1, temp_key);
            }
        }

        for(int i = 0; i < values.size(); i++){
            employeesPlusCount.put(keys.get(i),values.get(i));
        }
        System.out.println(employeesPlusCount);
    }
}