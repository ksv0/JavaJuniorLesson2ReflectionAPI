package ksv.task1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Задача 1:
 * Создайте абстрактный класс "Animal" с полями "name" и "age".
 * Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
 * Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
 * Выведите на экран информацию о каждом объекте.
 * Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
 * <p>
 * Дополнительная задача:
 * <p>
 * Доработайте метод генерации запроса на удаление объекта из таблицы БД (DELETE FROM <Table> WHERE ID = '<id>')
 * В классе QueryBuilder который мы разработали на семинаре.
 */
public class Program {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Animal[] animals = {
                new Dog("Dog", false),
                new Cat("Cat", 3),
                new Fox("Fox", 5)
        };
        for (Object animal : animals) {
            Class<?> clazz = animal.getClass();
            Field[] fields = clazz.getDeclaredFields();

            String name = clazz.getName().substring(clazz.getName().lastIndexOf(".") + 1);
            System.out.println("Class: " + name + ", fields: ");

            for (Field field : fields) {
                if (!field.canAccess(animal)) {
                    System.out.print("private/protected ");
                    field.setAccessible(true);
                } else {
                    System.out.print("public ");
                }

                System.out.println(field.getName() + ": " + field.get(animal));
            }
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if (!method.canAccess(animal)) {
                    System.out.print("private/protected ");
                    method.setAccessible(true);
                }else {
                    System.out.print("public ");
                }

                System.out.println("Method: " + method.getName());
                if (method.getName().equals("makeSound")) {
                    System.out.print(name +" says: ");
                    method.invoke(animal);
                }
            }

            System.out.println();
        }
    }
}