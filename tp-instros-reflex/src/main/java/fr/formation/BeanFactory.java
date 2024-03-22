package fr.formation;

public class BeanFactory {
    public <T> T createBean(Class<T> clz) {
        try {
            return clz.getConstructor().newInstance();
        }
        
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
