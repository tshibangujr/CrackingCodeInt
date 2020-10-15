import java.util.ArrayList;
public class MyClass {
    public static void main(String args[]) {
        System.out.println("TEST");
    }
    public static class Project{
        String title;
        boolean visited;
    }
    public static class Pair{
        Project first;
        Project second;
    }
  
    public static ArrayList<Project> orderProjects(ArrayList<Project> projects, ArrayList<Pair> dep){
        ArrayList<Project> result = new ArrayList<Project>();
        Project current = null;
        for(int i = 0; i < projects.size(); i++){
            current = projects.get(i);
            orderProjects(projects, dep, current, result);
        }
        return result;
    }
    public static void orderProjects(ArrayList<Project> projects, ArrayList<Pair> dep, Project current, ArrayList<Project> result){
        if(!current.visited){
            for(Pair d : dep){
                if(d.second == current)
                    orderProjects(projects, dep, d.first, result);
            }
            current.visited = true;
            result.add(current);
        }
    }
}