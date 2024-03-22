package fr.formation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory();

        Photo photo = beanFactory.createBean(Photo.class);
        Application aa = beanFactory.createBean(Application.class);
        String str = beanFactory.createBean(String.class);
        
        System.out.println(photo);
    }

    public static void intro() {
        // Introspection : capacité à parcourir les informations (meta) d'une classe (attributs, méthodes, constructeurs, annotations, etc.)
        // > A partir d'un type / d'une classe / d'une interface
        
        // Pour récupérer le type :
        // > A partir d'une instance
        String str = "test";
        Class<?> clz = str.getClass();

        // > A partir du nom de la classe
        clz = String.class;

        // Lister les méthodes
        for (Method method : clz.getMethods()) {
            System.out.println(method.getName());
        }

        // Lister les attributs
        for (Field field : clz.getDeclaredFields()) {
            System.out.println(field.getName());
        }

        // Lister les constructeurs
        for (Constructor ctor : clz.getConstructors()) {
            System.out.println(ctor.getName());
        }


        // Réfléxivité : manipuler un objet à partir de son introspection
        Photo photo = new Photo();

        photo.setTitle("Démonstration");

        try {
            Method methodSet = Photo.class.getMethod("setTitle", String.class);

            methodSet.invoke(photo, "Démonstration 2");

            Method methodGet = Photo.class.getMethod("getTitle");

            Object value = methodGet.invoke(photo);

            System.out.println("Le title est : " + value);

            Field fieldTitle = Photo.class.getDeclaredField("title");

            fieldTitle.setAccessible(true);

            fieldTitle.set(photo, "Démonstration 3");
            value = fieldTitle.get(photo);

            System.out.println("Le title est : " + value);
        }
        
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        
        catch (SecurityException e) {
            e.printStackTrace();
        }
        
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        
        catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}