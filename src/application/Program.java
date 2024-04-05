package application;

import entities.Employee;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.println("Quantos funcionarios vão se registrar ? ");
        int N = sc.nextInt();

        for (int i=0 ; i<N ; i++){

            System.out.println("Funcionario #" + (i+1)+":");
            System.out.print("id :");
            Integer id = sc.nextInt();
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salario: ");
            Double salary = sc.nextDouble();

            Employee emp = new Employee(id,name, salary);

            list.add(emp);
        }
        System.out.println("Entre com o id do funcionario que vai ter o incremento de salario");
        int idSalary = sc.nextInt();
        Integer pos = position(list, idSalary);
        if (pos == null){
            System.out.println("Esse Id Não existe");
        }
        else{
            System.out.println("Entre com a porcentagem:  ");
            double percent = sc.nextDouble();
            list.get(pos).increaseSalary(percent);
        }
        System.out.println();
        System.out.println("Lista de funcionarios: ");
        for (Employee emp : list ){
            System.out.println(emp);
        }

        sc.close();
    }
    public static Integer position(List<Employee>list , int id){
        for (int i = 0; i<list.size();i++){
            if ( list.get(i).getId()==id){
                return i;
            }
        }
        return null;
    }
}
